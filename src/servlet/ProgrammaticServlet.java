package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/prog")
public class ProgrammaticServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.authenticate(resp)){
			resp.setContentType("text/html");
			PrintWriter writer=resp.getWriter();
			writer.print("welcome");
		}else{
			System.out.println("error");
		}
	}
}
