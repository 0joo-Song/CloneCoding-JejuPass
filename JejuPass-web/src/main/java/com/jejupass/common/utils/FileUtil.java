package com.jejupass.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	/**
	 * 파일 저장 
	 * @param file
	 * @return
	 */
	public String uploadFile(String dirPath, MultipartFile file) {

		File saveFolder = new File(dirPath);
		
        // 디렉토리 생성
        if (!saveFolder.exists() || saveFolder.isFile()) {
            saveFolder.mkdirs();
        }
        
		String filePath = "";
		//write uploaded file
    	byte fileData[];
    	FileOutputStream fos = null;
		try {
			String fsOrgFileName = file.getOriginalFilename();
            String fileExt = fsOrgFileName.substring(fsOrgFileName.lastIndexOf("."));	// ex ( .jpg , .png )
            fileExt = fileExt.toLowerCase();
            if(this.checkFileType(fileExt, file.getContentType())) {            
				UUID uuid = UUID.randomUUID();
		        String fsNewFileName = (uuid.toString()).replaceAll("-", "");
				fileData = file.getBytes();
				fos = new FileOutputStream(dirPath +"/"+ fsNewFileName + fileExt);
		        fos.write(fileData);
		        //filePath = dir_path +"/"+ fsNewFileName + fileExt;
		        filePath = fsNewFileName + fileExt;
            } else {
            	filePath = "extErr";
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {}
			}
       }        
	   return filePath;
	}

	// 파일 타입체크
	private boolean checkFileType(String fileExt, String contentType) {
		if(fileExt.equals(".jpg") || fileExt.equals(".png") || fileExt.equals(".jpeg") || fileExt.equals(".gif") || fileExt.equals(".mp3") || fileExt.equals(".mp4") || fileExt.equals(".zip")
			|| fileExt.equals(".avi") || fileExt.equals(".wmv")	|| fileExt.equals(".mov")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 파일 사이즈
	 * @param bytes
	 * @return
	 */
	public String getFileSize(long bytes) {
	   String s_bytes = bytes+"";
       String retFormat = "0";
       Double size = Double.parseDouble(s_bytes);

        String[] s = { "bytes", "KB", "MB", "GB", "TB", "PB" };

        if (s_bytes != "0") {
              int idx = (int) Math.floor(Math.log(size) / Math.log(1024));
              DecimalFormat df = new DecimalFormat("#,###.##");
              double ret = ((size / Math.pow(1024, Math.floor(idx))));
              retFormat = df.format(ret) + " " + s[idx];
         } else {
              retFormat += " " + s[0];
         }

         return retFormat;
	}
	

	/**
	 * 파일 다운로드 
	 * @param file
	 * @return
	 */
	public void downloadFile(String downPath, HttpServletResponse response) {
		try {
			// 다운로드 할 파일 가져오기
	  		File file = new File(downPath);
	
			// 일반 reponse 설정은 삭제.
	  		response.reset(); // reponse 초기화
	
	  		// reponse 재설정
	  		response.setContentType("application/octer-stream");
	  		response.setHeader("Content-Disposition", "attachment;filename="+file.getName()+";"); // 원본 파일 명으로 다운로드 
	  		response.setHeader("Content-Transper-Encoding", "binary");
	  		response.setContentLength((int)file.length());	// 파일 다운로드시 파일 사이즈 꼭 입력
	  		response.setHeader("Pargma", "no-cache");
	  		response.setHeader("Expires", "-1");
	  
	  		byte[] data = new byte[1024 * 1024];
	  		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
	  		BufferedOutputStream fos = new BufferedOutputStream(response.getOutputStream());
	  
	  		int count = 0;
	  		while((count = fis.read(data)) != -1){
	   			fos.write(data);
	  		}
	  
	  		if(fis != null) fis.close();
	  		if(fos != null) fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
	
