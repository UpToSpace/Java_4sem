package com.example.laba9.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Submit extends TagSupport {
    private String btnName;

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter jspWriter = pageContext.getOut();
        try {
            jspWriter.print("<input type=\"submit\" value=\"" + btnName + "\" />");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
