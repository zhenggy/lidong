package com.chestnut.lidong.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.chestnut.lidong.R;
import com.chestnut.lidong.callback.Service2ActivitiyCallback;
import com.chestnut.lidong.entity.RunningStatusData;
import com.chestnut.lidong.ui.RunningActivity;
import com.chestnut.lidong.utils.LogUtil;
import com.chestnut.lidong.utils.RunningDataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocationService extends Service {

    private LocationServiceBinder myBinder = new LocationServiceBinder();

    // 定位相关
    private LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();

    //运动状态
    private int runningStatus = RunningActivity.STOP;

    //运动数据
    private RunningStatusData runningStatusData;

    //运动时坐标记录
    private List<LatLng> runningLatLngList;

    private Service2ActivitiyCallback callback = null;

    //计时器
    private Handler timerHandler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (runningStatus == RunningActivity.RUNNING) {
                callback.updateRunningData(runningStatusData);
                runningStatusData.addTime();
                setNotificationData();
            }
            timerHandler.postDelayed(this, 1000);
        }
    };

    private Notification notification;
    private NotificationManager mNotificationManager;

    public LocationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initLocation();
        setNotification();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setNotification() {
        notification = new Notification.Builder(this)
                .setAutoCancel(false)
                .setTicker("栗动：正在跑步中")
                .setSmallIcon(R.mipmap.lidong)
                .build();
//        startForeground(1, notification);

        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.location_service_notification);
        notification.contentView = contentView;

        Intent notificationIntent = new Intent(this, RunningActivity.class);

        notification.contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, notification);
    }

    private void setNotificationData() {

        notification.contentView.setTextViewText(R.id.location_service_notification_tv1
                , RunningDataUtil.timeToTextView(runningStatusData.getTime()));
        notification.contentView.setTextViewText(R.id.location_service_notification_tv2
                , RunningDataUtil.distanceToTextView(runningStatusData.getDistance()));
        notification.contentView.setTextViewText(R.id.location_service_notification_tv3
                , RunningDataUtil.calculateSpeed(runningStatusData.getDistance(), runningStatusData.getTime()));
        mNotificationManager.notify(1, notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    /**
     * 初始化定位相关
     */
    public void initLocation() {

        runningLatLngList = new ArrayList<>();
        runningStatusData = new RunningStatusData(0, 0, 0);

        // 定位初始化
        mLocClient = new LocationClient(getApplicationContext());
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(2000);
        mLocClient.setLocOption(option);

    }

    @Override
    public void onDestroy() {

        if (mLocClient != null) {
            mLocClient.stop();
        }
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public class LocationServiceBinder extends Binder {

        public void registerCallBack(Service2ActivitiyCallback myCallback) {
            callback = myCallback;
        }

        public void startLocation() {
            if (mLocClient != null) {
                mLocClient.start();
            }
        }

        public void updateRunningStatus(int status) {
            runningStatus = status;
        }

        public int getRunningStatus() {
            return runningStatus;
        }

        public RunningStatusData getRunningStatusData() {
            return runningStatusData;
        }

        public List<LatLng> getLocationList() {
            return runningLatLngList;
        }

        public void startRunning() {
            //开启计时器
            timerHandler.postDelayed(runnable, 0);
        }

        public void finishRunning() {
            runningLatLngList.clear();
            runningStatusData.setTime(0);
            runningStatusData.setDistance(0);
            timerHandler.removeCallbacks(runnable);
            mNotificationManager.cancel(1);
        }

        public void destroyService() {
            mNotificationManager.cancel(1);
            onDestroy();
        }
    }

    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {

            if (location == null) {
                return;
            }
            //模拟跑步时坐标
//            double x1, x2;
//            x1 = Math.random() * 0.001;
//            x2 = Math.random() * 0.001;

            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();

            if (callback != null) {
                callback.setLocation(locData);
            }
            if (runningStatus == RunningActivity.RUNNING) {
                LatLng locationLatLng = new LatLng(locData.latitude, locData.longitude);
                runningLatLngList.add(locationLatLng);
                //计算两点的距离
                if (runningLatLngList.size() > 1) {
                    double distance = DistanceUtil.getDistance(
                            runningLatLngList.get(runningLatLngList.size() - 1),
                            runningLatLngList.get(runningLatLngList.size() - 2));
                    runningStatusData.addToDistance(distance);
                    runningStatusData.setSpeed(distance / 2);
                }
            }

//            LogUtil.printLog(LocationService.class, "坐标是: " + locData.latitude + "   " + locData.longitude);
        }
    }
}
