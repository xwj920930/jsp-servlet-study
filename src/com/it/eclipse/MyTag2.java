package com.it.eclipse;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag2 extends SimpleTagSupport{
	String header;
	String items;
	@Override
	public void doTag() throws JspException, IOException {
		JspContext jspContext=getJspContext();
		JspWriter out =jspContext.getOut();
			out.write("<table><th>"+header+"</th>");
			String[] s=items.split(",");
			for (String string : s) {
				out.write("<tr><td>"+string+"</td></tr>");
			}
			out.write("</table>");
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}

}
