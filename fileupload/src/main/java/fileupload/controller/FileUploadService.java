package fileupload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/fileupload-files";
	private static String URL_PATH = "/images";  // 내가 생각하는 가상의 url  - for resource mapping
	
	public String restore(MultipartFile file) {
		System.out.println("===========" + file);
		String url = null;
		
		try {
			File uploadDirectory = new File(SAVE_PATH);
			if(!uploadDirectory.exists()) {
				uploadDirectory.mkdirs();  // 없으면 만들어준다. 
				
	 		}
			
			if(file.isEmpty()) {
				return url;
			}
			
			String originFilename = file.getOriginalFilename();  // 사용자가 올린 파일이름
			String extName = originFilename.substring(originFilename.lastIndexOf(".") + 1);  // 파일의 확장자 
			String saveFilename = generateSaveFilename(extName);
			Long fileSize = file.getSize();
			System.out.println("# FileName: " + originFilename);
			System.out.println("# FileSize: " + fileSize);
			System.out.println("# SaveFilename: " + saveFilename);
			
			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();
			
			url = URL_PATH + "/" + saveFilename;
			
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
		return url;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}
	
	
}
