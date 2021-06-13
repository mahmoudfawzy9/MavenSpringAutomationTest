package com.si;

import java.io.File;

import org.apache.commons.lang.SystemUtils;

public class Configration {	
	
	public static String getGeckoDriverPath() {
		StringBuilder jrePath = new StringBuilder();
		jrePath =getDriverPath();		
		if (SystemUtils.IS_OS_WINDOWS) {
			jrePath.append("geckodriver.exe");
			
		} else if (SystemUtils.IS_OS_LINUX) {
			jrePath.append("geckodriver");
		}

		System.out.println("java    ===  " + jrePath);
		return jrePath.toString();
	}

	public static StringBuilder getDriverPath() {

		StringBuilder driverPath = new StringBuilder();

		driverPath.append(getPath());
		driverPath.append("src");
		driverPath.append(File.separator);
		driverPath.append("test");
		driverPath.append(File.separator);
		driverPath.append("resources");
		driverPath.append(File.separator);
		System.out.println("Driver path    ===  " + driverPath);
		return driverPath;

	}
	public static String getPath() {

		File f = new File(".");
		String path = f.getAbsolutePath();
		path = path.substring(0, path.length() - 1);

		System.err.println("path===========" + path);
		return path;
	}
	


}
