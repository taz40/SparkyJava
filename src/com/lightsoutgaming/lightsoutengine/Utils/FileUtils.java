package com.lightsoutgaming.lightsoutengine.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FileUtils {

	public static String readFile(String filePath){
		URL path = FileUtils.class.getResource(filePath);
		if(path == null)
			return null;
		File file = new File(path.getPath());
		//System.out.println(path.getPath());
		if(file != null && file.exists() && file.isFile()){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				StringBuffer contents = new StringBuffer();
				String line = br.readLine();
				while(line != null){
					contents.append(line+"\n");
					line = br.readLine();
				}
				return contents.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}else{
			return null;
		}
	}
	
}
