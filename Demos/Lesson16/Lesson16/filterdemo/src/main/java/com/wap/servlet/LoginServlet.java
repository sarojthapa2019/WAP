package com.wap.servlet;

import com.wap.model.UserAccount;
import com.wap.util.AppUtils;
import com.wap.util.DataDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        UserAccount userAccount = DataDAO.findUser(userName, password);

        if (userAccount == null) {
            String errorMessage = "Invalid userName or Password";
            request.setAttribute("errorMessage", errorMessage);

            request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
            return;
        }

        AppUtils.storeLoginedUser(request.getSession(), userAccount);

        //
        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(request.getParameter("redirectId"));
        } catch (Exception e) {
        }
        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
        if (requestUri != null) {
            response.sendRedirect(requestUri);
        } else {
            // Default after successful login
            // redirect to /userInfo page
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }

    }

}
