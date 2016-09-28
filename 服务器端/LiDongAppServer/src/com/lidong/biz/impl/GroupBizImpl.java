package com.lidong.biz.impl;

import com.lidong.biz.GroupBiz;
import com.lidong.dao.GroupDao;

public class GroupBizImpl extends BaseBizImpl implements GroupBiz {
	
	private GroupDao groupDaoImpl;

	public GroupDao getGroupDaoImpl() {
		return groupDaoImpl;
	}

	public void setGroupDaoImpl(GroupDao groupDaoImpl) {
		this.groupDaoImpl = groupDaoImpl;
	}

}
