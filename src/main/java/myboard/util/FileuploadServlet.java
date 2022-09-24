package myboard.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.RandomStringUtils;

import myboard.constants.CommonConstants;

public class FileuploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//업로드처리를 GET으로 요청해도 POST로 처리하겠다
		doPost(req, resp);
	}//doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Collection<Part> parts = req.getParts();
		List<String> sfnList = new ArrayList<String>();
		System.out.println("서블렛 안" + parts.toString());
		for(Part part : parts) {	
			System.out.println("파일 엘리먼트 이름:" + part.getName());
	         System.out.println("파일 바이트 수:" + part.getSize());
	         System.out.println("업로드한 파일의 이름:" + part.getSubmittedFileName());		
			if(part.getHeader("Content-Disposition").contains("filename=") && part.getSize()>0) {
				
				File uploadDir = new File(
						CommonConstants.props.getProperty("FILE_UPLOAD_DIR")
						+ new SimpleDateFormat("YYYYMMdd").format(new Date(System.currentTimeMillis()))
						);
				if(!uploadDir.exists()) {
					uploadDir.mkdir();
				
				String uploadedFileName = "";
				uploadedFileName = uploadDir.getPath() + "/" + RandomStringUtils.random(100, true, true);
					
				sfnList.add(uploadedFileName);
					
				part.write(uploadedFileName);
				part.delete();
				}	
			}

		}//for
		
		req.setAttribute("sfnList", sfnList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/writeBoardProc.jsp");
		dispatcher.forward(req, resp);
		
	}//doPost
}//class
