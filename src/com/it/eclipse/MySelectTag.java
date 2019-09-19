package com.it.eclipse;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySelectTag extends SimpleTagSupport{
	String[] countries={"A","B","C"};
	@Override
	public void doTag() throws JspException, IOException {
		JspContext jspContext=getJspContext();
		JspWriter out=jspContext.getOut();
		out.write("<select>");
		for(int i=0;i<countries.length;i++){
			jspContext.setAttribute("value", countries[i]);
			jspContext.setAttribute("text",  countries[i]);
			getJspBody().invoke(null);
		}
		out.write("</select>");
	}

}
