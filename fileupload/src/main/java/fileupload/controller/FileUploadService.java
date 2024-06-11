package fileupload.controller;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/fileupload-files";
	
	public String restore(MultipartFile file) {
		System.out.println("===========" + file);
		String url = null;
		
		File uploadDirectory = new File(SAVE_PATH);
		if(uploadDirectory.exists()) {
			uploadDirectory.mkdirs();  // 없으면 만들어준다. 
			
 		}
		
		if(file.isEmpty()) {
			return url;
		}
		
		String originFileName = file.getOriginalFilename();  // 사용자가 올린 파일이름
		Long fileSize = file.getSize();
		System.out.println("#########" + originFileName);
		System.out.println("#########" + fileSize);
		
		return url;
	}
	
	
	
}
