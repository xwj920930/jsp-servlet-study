package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet(name="multipleUpload",urlPatterns="/multipleUpload")
@MultipartConfig
public class MultipleUploadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Collection<Part> parts=req.getParts();
		for (Part part : parts) {
			if(part.getContentType()!=null){
				String filename=getFilename(part);
				if(filename!=null&&!filename.isEmpty()){
					System.out.println(getServletContext().getRealPath("/WEB-INF")+File.separator+filename);
					part.write(getServletContext().getRealPath("/WEB-INF")+File.separator+filename);
				}
			}
		}
	}
	private String getFilename(Part part){
		//form-data; name="filename"; filename="easyloader.js"
		String header=part.getHeader("content-disposition");
		String[] eles=header.split(";");
		for (String ele : eles) {
			if(ele.trim().startsWith("filename")){
				return ele.substring(ele.indexOf("=")+1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
