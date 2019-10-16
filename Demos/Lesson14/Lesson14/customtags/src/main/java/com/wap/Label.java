package com.wap;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Label extends SimpleTagSupport {
	String foreColor;
	String text;
	String backColor;

	// render custom tag
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (foreColor != null) {
			out.write("<div style=\"color:"+foreColor+"; background-color: "+backColor+"\">"+text+"</div>");
		} else {
			out.write(String.format("<span>%s</span>", text));
		}
	}

	// Need a setter for each attribute of custom tag
	public void setForeColor(String foreColor) {
		this.foreColor = foreColor;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}
}