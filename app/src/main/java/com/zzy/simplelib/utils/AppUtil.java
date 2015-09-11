package com.zzy.simplelib.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/** 获取当前应用程序相关信息 */
public class AppUtil {

	/**
	 * 获取应用程序版本名称
	 * 
	 * @return 版本名称
	 */
	public static String getApplicationVersionName(Activity activity) {
		PackageManager packageManager = activity.getPackageManager();
		try {
			PackageInfo packageInfo = packageManager.getPackageInfo(
					activity.getPackageName(),
					PackageManager.GET_CONFIGURATIONS);
			return packageInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return "1";
	}

	/**
	 * 获取应用程序版本号
	 * 
	 * @return 版本号
	 */
	public static int getApplicationVersionCode(Activity activity) {
		PackageManager packageManager = activity.getPackageManager();
		try {
			PackageInfo packageInfo = packageManager.getPackageInfo(
					activity.getPackageName(),
					PackageManager.GET_CONFIGURATIONS);
			return packageInfo.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
