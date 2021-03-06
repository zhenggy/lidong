package com.lidong.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {
	public void save(Object obj);
	public void update(Object obj);
	public void delete(Object obj);
	
	public List getAll(Class clss);
	public Object getById(Class clss, Serializable id);
	public List getByProperty(Class clss, String propertyName, Object value);
}
