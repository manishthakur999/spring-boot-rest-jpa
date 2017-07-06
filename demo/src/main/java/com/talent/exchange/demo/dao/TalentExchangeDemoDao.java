package com.talent.exchange.demo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;

import com.talent.exchange.demo.model.MoBase;

public interface TalentExchangeDemoDao {
	void sampleData();
	String save(MoBase moBase);

	void update(MoBase moBase);

	void merge(MoBase moBase);

	void saveOrUpdate(MoBase moBase);
	
	<T> T findById(Class<T> className, Serializable id);

	List findBy(Class classObj, Map propertyMap, String orderKey, boolean asc);

	List findBy(Class classObj, Map propertyMap, String orderKey, boolean asc, int pageSize, int pageNum);

	List findByQuery(String queryStr);

	Query createQuery(String queryStr);

	List findByNamedQuery(String namedQuery, Map<String, Object> params);

	List findByNamedQuery(String namedQuery, Map<String, Object> params, int pageSize, int pageNumber);

	MoBase findUniqueByCriteria(Class classObj, Map<String, Object> params);

	MoBase findUniqueByNamedQuery(String namedQuery, Map<String, Object> params);

	int updateByNamedQuery(String namedQuery, Map<String, Object> params);

	long countByNamedQuery(String namedQuery, Map<String, Object> params);

	double calculateByNamedQuery(String namedQuery, Map<String, Object> params);

	void delete(MoBase moBase);

	Criteria createCriteria(Class class1);

	void flush();

	Object executeNamedQueryAndGetFirstResult(String queryString, Map<String, Object> params);
}
