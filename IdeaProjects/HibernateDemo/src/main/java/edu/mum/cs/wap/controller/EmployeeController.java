package edu.mum.cs.wap.controller;

import edu.mum.cs.wap.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/emp")
public class EmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        int salary = Integer.valueOf(request.getParameter("salary"));


        HttpSession session = request.getSession(true);
        try {
            EmployeeDao userDAO = new EmployeeDao();
            userDAO.addEmployee(name, salary);
            response.sendRedirect("success.jsp");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
