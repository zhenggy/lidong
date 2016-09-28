package com.lidong.biz.impl;

import java.util.List;

import com.lidong.biz.RunningDataBiz;
import com.lidong.dao.RunningDataDao;
import com.lidong.dao.impl.RunningDataDaoImpl;
import com.lidong.entity.Lrundata;
import com.lidong.entity.Luser;

public class RunningDataBizImpl extends BaseBizImpl implements RunningDataBiz {
	RunningDataDao runningDataDaoImpl;

	@Override
	public void savaData(Lrundata data) {
		if (data == null) {
			return;
		}
		Luser user = new Luser();
		user.setUid(data.getLuser().getUid());
		List<Lrundata> list = runningDataDaoImpl.getByProperty(Lrundata.class,
				"Luser", user);
		if (list != null && list.size() > 0) {
			for (Lrundata rundata : list) {
				runningDataDaoImpl.delete(rundata);
			}
		}
		runningDataDaoImpl.save(data);
	}

	@Override
	public Lrundata getData(int uid) {

		List<Lrundata> list = runningDataDaoImpl.getByProperty(Lrundata.class,
				"luser.uid", uid);
		// System.out.println("list.size() = " + list.size());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void creatRunningData(int uid) {
		Lrundata data = new Lrundata();
		Luser user = new Luser();
		user.setUid(uid);
		data.setLuser(user);
		data.setBest10km(0);
		data.setBestDistance(0.0);
		data.setBestHalfma(0);
		data.setBestMa(0);
		data.setBestPace(0.0);
		data.setBestTime(0);
		data.setTotalDistance(0.0);
		data.setTotalFrequency(0);
		data.setTotalTime(0);
		runningDataDaoImpl.save(data);
	}

	@Override
	public void deleteRunningData(Lrundata data) {
		System.out.println("deleteRunningData");
		List<Lrundata> dataList = runningDataDaoImpl.getByProperty(
				Lrundata.class, "luser.uid", data.getLuser().getUid());
		if (dataList != null && dataList.size() > 0) {
			System.out.println("dataList != null && dataList.size() > 0");
			for (Lrundata rundata : dataList) {
				runningDataDaoImpl.delete(rundata);
			}
		}
	}

	public RunningDataDao getRunningDataDaoImpl() {
		return runningDataDaoImpl;
	}

	public void setRunningDataDaoImpl(RunningDataDao runningDataDaoImpl) {
		this.runningDataDaoImpl = runningDataDaoImpl;
	}

}
