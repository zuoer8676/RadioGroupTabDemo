/**
 * 
 */
package com.big.demo.util;

import java.io.File;

import android.content.Context;

/**
 * @author 刘赞 2015-6-13
 */
public class FileCacheHelper {
	private static final String DIR_NAME = "your_dir";
	private static File cacheDir;

	/**
	 * 如果有SD卡，则用SD卡进行缓存，如果没有，就用应用的缓存目录。
	 * @param context
	 * @return 
	 */
	public static boolean FileCache(Context context) {
		// Find the directory to save cached images
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			cacheDir = new File(
					android.os.Environment.getExternalStorageDirectory(),
					DIR_NAME);
		} else {
			cacheDir = context.getCacheDir();
		}

		if (!cacheDir.exists()) {
			cacheDir.mkdirs();
		}
		return true;
	}
	
	

	/**
	 * 根据缓存路径获取对应的文件
	 * @param url
	 * @return
	 */
	public static File getFile(String url) {
		// Identify images by url's hash code
		String filename = String.valueOf(url.hashCode());

		File f = new File(cacheDir, filename);

		return f;
	}
	/**
	 * 清除缓存目录中的所有文件
	 */
	public static void clear() {
		File[] files = cacheDir.listFiles();
		if (files == null) {
			return;
		} else {
			for (File f : files) {
				f.delete();
			}
		}
	}
}
