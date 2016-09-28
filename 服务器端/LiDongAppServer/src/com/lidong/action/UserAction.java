package com.lidong.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lidong.biz.RunningDataBiz;
import com.lidong.biz.UserBiz;
import com.lidong.constant.LiDongConstant;
import com.lidong.entity.Lrundata;
import com.lidong.entity.Luser;
import com.lidong.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private UserBiz userBizImpl;
	private RunningDataBiz runningDataBizImpl;
	private String username;
	private String password;

	public String login() {
		// System.out.println("username : "+username);
		returnResult(JsonUtil.loginUser2Json(userBizImpl.login(username,
				password)));
		return null;
	}

	public String register() {
		int result = userBizImpl.register(username, password);
		returnResult(JsonUtil.registerResult2Json(result));
		
		if(result == LiDongConstant.REGISTER_SUCCESS){
			Luser user = userBizImpl.getUserByUsername(username);
			runningDataBizImpl.creatRunningData(user.getUid());
		}
		return null;
	}

	public void returnResult(String s) {
		// System.out.println(s);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Cache-control", "no-cache");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(s);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public UserBiz getUserBizImpl() {
		return userBizImpl;
	}

	public void setUserBizImpl(UserBiz userBizImpl) {
		this.userBizImpl = userBizImpl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RunningDataBiz getRunningDataBizImpl() {
		return runningDataBizImpl;
	}

	public void setRunningDataBizImpl(RunningDataBiz runningDataBizImpl) {
		this.runningDataBizImpl = runningDataBizImpl;
	}

}
