package com.chestnut.lidong.utils;

import java.text.DecimalFormat;

/**
 * Created by AshZheng on 2016/9/8.
 */
public class RunningDataUtil {

    /**
     * 计算速度
     *
     * @param distance 距离 单位：米
     * @param time     时间 单位：秒
     * @return 速度 单位：km/h
     */
    public static String calculateSpeed(double distance, int time) {

        if (time == 0) return "0.00";

        double speed = (distance / 1000) / (time * 1.0 / 3600);
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(speed);
    }

    /**
     * 计算配速 单位 分钟/km
     *
     * @param distance 距离 单位：米
     * @param time     时间 单位：秒
     * @return 99'99''
     */
    public static String calculatePace(double distance, int time) {
        if (Math.abs(distance) < 0.00000001) return "99'99''";

        int m, s;

        s = (int) (time / (distance / 1000.0));
        m = (s / 60) % 100;
        s = s % 60;

        return (m < 10 ? ("0" + m) : m) + "'"
                + ((s < 10 ? ("0" + s) : s)) + "''";
    }

    public static Double calculatePaceReturnDouble(double distance, int time) {
        if (Math.abs(distance) < 0.00000001) return 99.99;

        int m, s;

        s = (int) (time / (distance / 1000.0));
        m = (s / 60) % 100;
        s = s % 60;

        return m + (0.1 * s / 100);
    }

    /**
     * 计算卡路里
     *
     * @param distance
     * @return
     */
    public static String calculateCal(double distance) {
        return (int) (distance / 1000.0 * 75) + "";
    }

    public static String distanceToTextView(double distance) {

        distance /= 1000.0;
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(distance);

    }

    /**
     * 把时间转换成字符串 如 6s -> 00:00:06
     *
     * @param time 时间 单位：秒
     * @return 00:00:06
     */
    public static String timeToTextView(int time) {
        int h, m, s;
        s = time % 60;
        m = (time / 60) % 60;
        h = (time / 3600) % 60;

        return (h < 10 ? ("0" + h) : h) + ":"
                + (m < 10 ? ("0" + m) : m) + ":"
                + (s < 10 ? ("0" + s) : s);
    }

    /**
     * 把时间转换成字符串 如 3600s -> 1.00  h
     *
     * @param time
     * @return
     */
    public static String timeToTextViewH(int time) {
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(time / 3600.0);
    }


}
