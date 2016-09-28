package com.lidong.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.JsonObject;
import com.lidong.biz.RunningDataBiz;
import com.lidong.constant.LiDongConstant;
import com.lidong.entity.Lrundata;
import com.lidong.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class RunningDataAction extends ActionSupport {
	private RunningDataBiz runningDataBizImpl;
	private int uid;

	public String post() throws IOException {
		System.out.println("post");

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		ServletInputStream input = request.getInputStream();
		int len = request.getContentLength();
		if (len <= 0) {
			return "";
		}
		byte[] buffer = new byte[len];
		input.read(buffer);
		String message = new String(buffer, "UTF-8");

		Lrundata data = JsonUtil.parserLrundata(message);
		runningDataBizImpl.deleteRunningData(data);
		runningDataBizImpl.savaData(data);

		System.out.println("data  : " + data.toString());
		returnResult(JsonUtil.postResult2Json(LiDongConstant.SUCCESS));
		return null;
	}

	public String get() {
		System.out.println("·¢³ö " + JsonUtil.Lrundata2Json(runningDataBizImpl.getData(uid)));
		returnResult(JsonUtil.Lrundata2Json(runningDataBizImpl.getData(uid)));
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public RunningDataBiz getRunningDataBizImpl() {
		return runningDataBizImpl;
	}

	public void setRunningDataBizImpl(RunningDataBiz runningDataBizImpl) {
		this.runningDataBizImpl = runningDataBizImpl;
	}

}
