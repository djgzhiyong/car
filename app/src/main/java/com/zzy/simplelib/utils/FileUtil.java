package com.zzy.simplelib.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;

/** 文件读写 */
public class FileUtil {

	/**
	 * 获取应用根存储路径
	 * 
	 * @param context
	 *            上下文
	 * @return 根存储路径
	 */
	public static String getRootPath(Context context) {
		String pathString = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/" + context.getPackageName() + "/";
		File f = new File(pathString);
		if (!f.exists()) {
			f.mkdirs();
		}
		return pathString;
	}

	/***
	 * 写出字符串
	 * 
	 * @param context
	 *            上下文
	 * @param path
	 *            目标文件
	 * @param content
	 *            内容
	 */
	public static void writeContent(Context context, String path, String content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(getRootPath(context) + path), false);
			fw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
