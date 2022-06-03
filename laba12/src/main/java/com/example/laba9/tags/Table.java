package com.example.laba9.tags;

import com.example.laba9.classes.Database;
import com.example.laba9.classes.Gamers;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Table extends TagSupport {
    private String tableName;

    @Override
    public int doStartTag() throws JspException {
        JspWriter jspWriter = pageContext.getOut();
        if (tableName == "Command table") {
            try {
                jspWriter.print("<h3>" + tableName + "</h3>");
                jspWriter.print("        " +
                        "<table style=\"{border-collapse: collapse; border: 1px;}\">\n" +
                        "    <tr>\n" +
                        "        <td>Number</td>\n" +
                        "        <td>Name</td>\n" +
                        "    </tr>");


                Database database = new Database();
                ArrayList<Gamers> gamers = database.GetGamers();
                for (Gamers gamer : gamers) {
                    jspWriter.print("<tr> <td>" + gamer.getNumber());
                    jspWriter.print("</td> <td>" + gamer.getName());
                    jspWriter.print("</td> </tr>");
                }
                jspWriter.print("</table>");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                jspWriter.print("Table name is not correct");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doStartTag();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
