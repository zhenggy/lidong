package com.lidong.biz.impl;

import java.util.List;

import com.lidong.biz.UserBiz;
import com.lidong.constant.LiDongConstant;
import com.lidong.dao.UserDao;
import com.lidong.entity.LoginResultAndUser;
import com.lidong.entity.Lrundata;
import com.lidong.entity.Luser;

public class UserBizImpl extends BaseBizImpl implements UserBiz {
	private UserDao userDaoImpl;

	@Override
	public LoginResultAndUser login(String username, String password) {

		LoginResultAndUser result = new LoginResultAndUser();

		List<Luser> userList = userDaoImpl.getByProperty(Luser.class, "uname",
				username);

		if (userList != null && userList.size() > 0) {
			if (userList.get(0).getUpassword().equals(password)) {
				result.setLoginResult(LiDongConstant.LOGIN_SUCCESS);
				result.setUser(userList.get(0));
			} else {
				result.setLoginResult(LiDongConstant.LOGIN_WRONG_PASSWORD);
			}

		} else {
			result.setLoginResult(LiDongConstant.LOGIN_NO_USER);
		}

		return result;
	}

	@Override
	public int register(String username, String password) {
		int resultCode = LiDongConstant.REGISTER;
		List<Luser> userList = userDaoImpl.getByProperty(Luser.class, "uname",
				username);
		if (userList != null && userList.size() > 0) {
			resultCode = LiDongConstant.REGISTER_SAME_USERNAME;
		} else {
			Luser newUser = new Luser();
			newUser.setUname(username);
			newUser.setUpassword(password);
			userDaoImpl.save(newUser);

			resultCode = LiDongConstant.REGISTER_SUCCESS;
		}

		return resultCode;
	}

	@Override
	public Luser getUserByUsername(String username) {
		List<Luser> userList = userDaoImpl.getByProperty(Luser.class, "uname",
				username);
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

}
