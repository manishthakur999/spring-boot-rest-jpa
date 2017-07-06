package com.talent.exchange.demo.hibernate.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.talent.exchange.demo.dao.TalentExchangeDemoDao;
import com.talent.exchange.demo.dao.impl.TalentExchangeDemoDaoImpl;

@Configuration
@EnableTransactionManagement
public class HibernateConfig<TalentExchangeDao> {

	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.talent.exchange.demo.model").persistenceUnit("primaryDb")
				.build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	@Primary
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory(EntityManagerFactory factory) {
		SessionFactory sessionFactory = factory.unwrap(SessionFactory.class);
		if (sessionFactory == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return sessionFactory;
	}

	@Primary
	@Bean(name = "daoService")
	public TalentExchangeDemoDao persistenceService(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		TalentExchangeDemoDao service = new TalentExchangeDemoDaoImpl(sessionFactory);
		return service;
	}

}
