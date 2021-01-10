package com.nqhtour.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtil {
	
	
	public final String root = "";
	
	public void writeOrUpdate(byte[] bytes, String path, String nameFile) {
		File uploadRootDir = new File(path);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		try (FileOutputStream fos = new FileOutputStream(new File(path + File.separator + nameFile))) {
			fos.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(uploadRootDir);
	}

}
