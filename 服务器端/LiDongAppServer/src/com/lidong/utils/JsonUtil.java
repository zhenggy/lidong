package com.lidong.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lidong.entity.LoginResultAndUser;
import com.lidong.entity.Lrundata;
import com.lidong.entity.Luser;
import com.lidong.entity.UserRunningData;

public class JsonUtil {

	public static String loginUser2Json(LoginResultAndUser user) {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("loginResult", user.getLoginResult());

		JsonObject userObject = new JsonObject();
		if (user.getUser() != null) {
			userObject.addProperty("uname", user.getUser().getUname());
			userObject.addProperty("uniname", user.getUser().getUniname());
			userObject.addProperty("usex", user.getUser().getUsex());
			userObject.addProperty("uicon", user.getUser().getUicon());
			userObject.addProperty("uid", user.getUser().getUid());
			userObject.addProperty("usign", user.getUser().getUsign());
			userObject.addProperty("ubirthday", user.getUser().getUbirthday()
					.toString());
		}
		jsonObject.add("user", userObject);

		return jsonObject.toString();
	}

	public static String registerResult2Json(int resultCode) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("registerResult", resultCode);
		return jsonObject.toString();
	}

	public static String Lrundata2Json(Lrundata data) {
		if (data == null) {
			return null;
		}
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("totalDistance", data.getTotalDistance());
		jsonObject.addProperty("totalFrequency", data.getTotalFrequency());
		jsonObject.addProperty("totalTime", data.getTotalTime());
		jsonObject.addProperty("bestDistance", data.getBestDistance());
		jsonObject.addProperty("bestTime", data.getBestTime());
		jsonObject.addProperty("bestPace", data.getBestPace());
		jsonObject.addProperty("best10km", data.getBest10km());
		jsonObject.addProperty("bestHalfma", data.getBestHalfma());
		jsonObject.addProperty("bestMa", data.getBestMa());
		jsonObject.addProperty("uid", data.getLuser().getUid());
		return jsonObject.toString();
	}

	public static Lrundata parserLrundata(String s) {
		Gson gson = new Gson();
		UserRunningData data = new UserRunningData();
		data = gson.fromJson(s, UserRunningData.class);

		Lrundata lrundata = new Lrundata();
		Luser user = new Luser();
		lrundata.setBest10km(data.getBest10KM());
		lrundata.setBestDistance(data.getBestDistance());

		lrundata.setBestHalfma(data.getBestHalfMa());
		lrundata.setBestMa(data.getBestMa());
		lrundata.setBestPace(data.getBestPace());
		lrundata.setBestTime(data.getBestTime());
		user.setUid(data.getUid());
		lrundata.setLuser(user);
		lrundata.setTotalDistance(data.getTotalDistance());
		lrundata.setTotalFrequency(data.getTotalFrequency());
		lrundata.setTotalTime(data.getTotalTime());

		return lrundata;
	}

	public static String postResult2Json(int resultCode) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("result", resultCode);
		return jsonObject.toString();
	}

}
