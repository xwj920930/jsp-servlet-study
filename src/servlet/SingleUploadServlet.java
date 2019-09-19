package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="singleUpload",urlPatterns="/singleUpload")
@MultipartConfig
public class SingleUploadServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part=req.getPart("filename");
		String filename=getFilename(part);
		System.out.println(filename);
		if(filename!=null&&!filename.isEmpty()){
			System.out.println(getServletContext().getRealPath("/WEB-INF")+File.separator+filename);
			//part.write("D:\\xwj资料\\"+filename);
			part.write(getServletContext().getRealPath("/WEB-INF")+File.separator+filename);
		}
	}
	private String getFilename(Part part){
		String[] eles=part.getHeader("content-disposition").split(";");
		for (String ele : eles) {
			if(ele.trim().startsWith("filename")){
				return ele.substring(ele.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
