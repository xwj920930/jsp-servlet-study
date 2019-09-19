package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="Top10Servlet",urlPatterns="/top10")
public class Top10Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> londonAttractions=new ArrayList<>();
	private List<String> parisAttractions=new ArrayList<>();
	@Override
	public void init() throws ServletException {
		londonAttractions.addAll(Arrays.asList(new String[]{"london1","london2","london3","london4","london5"}));
		parisAttractions.addAll(Arrays.asList(new String[]{"paris1","paris2","paris3","paris4","paris5"}));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String city=req.getParameter("city");
		if(city!=null&&("london".equals(city)||"paris".equals(city))){
			showCity(req,resp,city);
		}else{
			showMainPage(req,resp);
		}
	}
	private void showCity(HttpServletRequest req, HttpServletResponse resp, String city) throws IOException {
		List<String> cities = null;
		if("london".equals(city)){
			cities=londonAttractions;
		}else if("paris".equals(city)){
			cities=parisAttractions;
		}
		StringBuilder sBuilder=new StringBuilder();
		for (String string : cities) {
			sBuilder.append("<h1>");
			sBuilder.append(string);
			sBuilder.append("</h1>");
		}
		PrintWriter writer=resp.getWriter();
		writer.append("<!DOCTYPE html><html><head><meta charset='utf-8' /><title></title></head><body>");
		writer.append(sBuilder);
		writer.append("</body></html>");
	}
	private void showMainPage(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		PrintWriter writer=resp.getWriter();
		writer.write("<!DOCTYPE html><html><head><meta charset='utf-8' /><title></title></head><body><a href='?city=london'>london</a><br/><a href='?city=paris'>paris</a></body></html>");
	}
}
