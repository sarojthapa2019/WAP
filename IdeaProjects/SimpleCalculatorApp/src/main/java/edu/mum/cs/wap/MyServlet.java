package edu.mum.cs.wap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        PrintWriter pw =response.getWriter();
        pw.println("<h1>No the page you're looking for??</h1>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String num3 = request.getParameter("num3");
        String num4 = request.getParameter("num4");
        String sum = "";
        String mul = "";
        if(num1 != "" && num2 != ""){
            Integer resultSum = Integer.valueOf(num1) + Integer.valueOf(num2);
            sum = resultSum.toString();
        }
       if(num3 != "" && num4 != ""){
           Integer resultMul = Integer.valueOf(num3) * Integer.valueOf(num4);
           mul = resultMul.toString();
       }

        PrintWriter printWriter = response.getWriter();
       // printWriter.println(num1 + "+" + num2 + "=" +
         //       (Integer.valueOf(num1) + (Integer.valueOf(num2))));
        response.setContentType("text/html");
        printWriter.println("<form action=\"calculate\" method=\"post\">");
        printWriter.println(" <input name =\"num1\" value= " +num1 + " > + <input name=\"num2\" value= "+num2 +"> =  " +
                "<input name=\"resultSum\" value = "+sum +">");
        printWriter.println(" <br /> <br />");
        printWriter.println("<input name =\"num3\" value="+ num3+ " > * <input name=\"num4\" value= "+num4 +"> = " +
                " <input name=\"resultMul\" value = " +mul + " >");
        printWriter.println(" <br /> <br />");
        printWriter.println(" <input type=\"submit\" value=\"Submit\">");
        printWriter.println("</form>");
    }
}
