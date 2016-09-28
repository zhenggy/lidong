package com.lidong.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lidong.dao.BaseDao;


public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{

	@Override
	public void save(Object obj) {
		try {
			this.getHibernateTemplate().save(obj);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Object obj) {
		try {
			this.getHibernateTemplate().delete(obj);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object obj) {
		try {
			this.getHibernateTemplate().update(obj);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List getAll(Class clss) {
		List list = null;
		
		try {
			list = this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clss));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getByProperty(Class clss, String propertyName, Object value) {
		List list = null;
		
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(clss);
			dc.add(Restrictions.eq(propertyName, value));
			list = this.getHibernateTemplate().findByCriteria(dc);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Object getById(Class clss, Serializable id) {
		Object obj = null;
		try {
			obj = this.getHibernateTemplate().get(clss, id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
