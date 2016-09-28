package com.lidong.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.lidong.biz.BaseBiz;
import com.lidong.dao.BaseDao;
import com.lidong.entity.Luser;


public class BaseBizImpl implements BaseBiz {

	private BaseDao baseDaoImpl;
	
	@Override
	public void save(Object obj) {
		baseDaoImpl.save(obj);
	}

	@Override
	public void delete(Object obj) {
		baseDaoImpl.delete(obj);
	}

	@Override
	public void update(Object obj) {
		baseDaoImpl.update(obj);
	}

	@Override
	public List getAll(Class clss) {
		return baseDaoImpl.getAll(clss);
	}

	@Override
	public List getByProperty(Class clss, String propertyName, Object value) {
		return baseDaoImpl.getByProperty(clss, propertyName, value);
	}

	@Override
	public Object getById(Class clss, Serializable id) {
		return baseDaoImpl.getById(clss, id);
	}
	
	public BaseDao getBaseDaoImpl() {
		return baseDaoImpl;
	}

	public void setBaseDaoImpl(BaseDao baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}

}
