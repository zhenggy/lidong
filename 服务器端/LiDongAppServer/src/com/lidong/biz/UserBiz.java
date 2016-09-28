package com.lidong.biz;

import com.lidong.entity.LoginResultAndUser;
import com.lidong.entity.Luser;

public interface UserBiz extends BaseBiz {

	public LoginResultAndUser login(String username, String password);

	public int register(String username, String password);

	public Luser getUserByUsername(String username);
}
