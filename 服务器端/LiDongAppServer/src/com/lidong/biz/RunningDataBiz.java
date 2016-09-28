package com.lidong.biz;

import com.lidong.entity.Lrundata;

public interface RunningDataBiz extends BaseBiz {

	public void savaData(Lrundata data);
	public Lrundata getData(int id);
	public void creatRunningData(int uid);
	public void deleteRunningData(Lrundata data);
}
