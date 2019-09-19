package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/imgDownload")
public class ImgDownloadServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String refer=req.getHeader("referer");
	if(refer!=null){
		String id=req.getParameter("id");
		File file=new File("D:\\BeclipseWorkSpace\\helloEclipse\\WebContent\\WEB-INF\\"+id+".jpg");
		resp.setContentType("img/jpg");
		InputStream is=new FileInputStream(file);
		OutputStream os=resp.getOutputStream();
		byte[] data=new byte[1024];
		int len=0;
		while((len=is.read(data, 0, data.length))!=-1){
			os.write(data, 0, len);
		}
		is.close();
		os.close();
	}
}
}
