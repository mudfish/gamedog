package com.laoxu.gamedog.util;

import com.laoxu.gamedog.config.UploadConfig;

import java.io.*;
import java.util.*;

/**
 * 文件工具类
 * 
 * @author ACER
 *
 */
public class FileUtil {
	/**
	 * 获取文件扩展名
	 * @param filename
	 * @return
	 */
	public static String getExtFromFileName(String filename) {
		int t = filename.lastIndexOf("\\");
		if (t != -1) {
			filename = filename.substring(t + 1);
		}
		t = filename.lastIndexOf("/");
		if (t != -1) {
			filename = filename.substring(t + 1);
		}
		t = filename.lastIndexOf(".");
		if (t != -1) {
			return filename.substring(t + 1).toLowerCase();
		}
		return "";
	}

	/**
	 * 获取上传路径
	 * @param uploadConfig
	 * @return
	 */
	public static String getUploadPath(UploadConfig uploadConfig) {
		String basePath = uploadConfig.getPath();
		Calendar today = Calendar.getInstance();
		String year = String.valueOf(today.get(1));
		String month = String.valueOf(today.get(2) + 1);
		String uploadPath = basePath + File.separator + year + File.separator + month + File.separator;
		//不存在就创建目录
		File filePath = new File(uploadPath);
		if(!filePath.exists()){
			filePath.mkdirs();
		}
		return uploadPath;
	}

	/**
	 * 生成随机文件名
	 * @param fileExtensionName
	 * @return
	 */
	public static String createRandomFileName(String fileExtensionName) {
		return new StringBuffer(UUID.randomUUID().toString().replace("-", "")).append(".").append(fileExtensionName)
				.toString();
	}


}
