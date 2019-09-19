package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@ServletSecurity(@HttpConstraint(rolesAllowed="manager"))
@WebServlet(name="FormServlet",urlPatterns="/formServlet")
public class FormServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer=resp.getWriter();
		writer.print("<!DOCTYPE html><html><head><meta charset='utf-8' /><title></title></head><body><form method='post'>name:<input type='text' name='name'/><input type='submit' /></form></body></html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("name"));
		//System.out.println(req.getAttribute("name"));
		RequestDispatcher dispatcher=req.getRequestDispatcher("");
		dispatcher.forward(req, resp);
	}

}
