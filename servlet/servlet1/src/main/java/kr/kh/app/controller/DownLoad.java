package kr.kh.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoad
 */
@WebServlet("/downLoad")
public class DownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String uploadPath = "D:\\uploads";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("fileName"); // detail.jsp 코드 중 url 설정한 것을 보고 적어야한다.
		String filePath = uploadPath + filename.replace('/', File.separatorChar);
		File file = new File(filePath);
		try(FileInputStream fis = new FileInputStream(file);
				OutputStream os = response.getOutputStream()) {
			
			// 파일의 MIME 타입을 가져온다.
			String mimeType = getServletContext().getMimeType(filePath);
			// 응답 객체의 컨텐츠 타입을 설정
			response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
			// 응답 객체의 컨텐츠 길이를 설정
			response.setContentLength((int)file.length());
			// 응답 객체 헤더에 파일명을 전달
			response.setHeader("Content-Disposition", "attachment : filename=\"" + filename + "\"");
			
			byte [] buffer = new byte [1024 * 4];
			int readCount = 0;
			while((readCount - fis.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
