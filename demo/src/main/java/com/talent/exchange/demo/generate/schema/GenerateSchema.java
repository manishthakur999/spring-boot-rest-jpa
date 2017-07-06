package com.talent.exchange.demo.generate.schema;

import java.io.IOException;

import org.hibernate.MappingException;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenerateSchema {
	public static void main(String[] args) throws MappingException, IOException {
		ServiceRegistry serviceRegistry = buildCfg();
		MetadataImplementor metadata = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport(metadata);
		schemaExport.setOutputFile("src/main/resources/database/model.sql");
		schemaExport.setDelimiter(";");
		schemaExport.create(true, false);
		System.exit(0);
	}

	public static StandardServiceRegistryImpl buildCfg() {
		return (StandardServiceRegistryImpl) new StandardServiceRegistryBuilder().configure("hibernate.xml")
				.build();
	}
}
