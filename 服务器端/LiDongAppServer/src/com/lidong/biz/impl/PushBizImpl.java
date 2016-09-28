package com.lidong.biz.impl;

import com.lidong.biz.PushBiz;
import com.lidong.dao.PushDao;

public class PushBizImpl extends BaseBizImpl implements PushBiz {
	private PushDao pushDaoImpl;

	public PushDao getPushDaoImpl() {
		return pushDaoImpl;
	}

	public void setPushDaoImpl(PushDao pushDaoImpl) {
		this.pushDaoImpl = pushDaoImpl;
	}
	
	
}
