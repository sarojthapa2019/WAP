package edu.mum.cs.wap.presentation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/xssTest"})
public class CoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     *  Just doGet - No Post - so keeps submitting to doGet
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("inputTest", request.getParameter("test"));

        request.getRequestDispatcher("xssResult.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
