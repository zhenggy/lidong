package com.chestnut.lidong.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.chestnut.lidong.entity.UserInfo;
import com.chestnut.lidong.entity.UserRunningDataLocal;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AshZheng on 2016/9/9.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static DataBaseHelper dataBaseHelper;

    private Map<String, Dao> daos = new HashMap<>();


    private static String DATEBASE_NAME = "lidong.db";
    private static int DATEBASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATEBASE_NAME, null, DATEBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, UserRunningDataLocal.class);
            TableUtils.createTable(connectionSource, UserInfo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, UserRunningDataLocal.class, true);
            TableUtils.dropTable(connectionSource, UserInfo.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 单例获取该Helper
     *
     * @param context
     * @return
     */
    public static synchronized DataBaseHelper getDBHelper(Context context) {
        context = context.getApplicationContext();
        if (dataBaseHelper == null) {
            synchronized (DataBaseHelper.class) {
                if (dataBaseHelper == null) {
                    dataBaseHelper = new DataBaseHelper(context);
                }
            }
        }
        return dataBaseHelper;
    }

    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;

        String className = clazz.getSimpleName();
        if (daos.containsKey(className)) {
            dao = daos.get(className);
        }
        if (dao == null) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }

        return dao;
    }

    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}
