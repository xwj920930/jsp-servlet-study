package com.it.eclipse;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyTag implements SimpleTag{
	JspContext jspContext;
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("this is my tag");
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}

	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println("setJspContext");
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

}
