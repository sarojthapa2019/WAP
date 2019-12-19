package edu.mum.cs.wap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamsServlet
 */
public class InitParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletConfig config = this.getServletConfig();
		if ("config".equals(request.getParameter("type"))) {
			Enumeration<String> e = config.getInitParameterNames();
			String str = "";
			while (e.hasMoreElements()) {
				str = e.nextElement();
				out.print("<br />Name: " + str);
				out.print(" value: " + config.getInitParameter(str));
			}
		} else {
			Enumeration<String> e = config.getServletContext().getInitParameterNames();
			String str = "";
			while (e.hasMoreElements()) {
				str = e.nextElement();
				out.print("<br />Name: " + str);
				out.print(" value: " + config.getServletContext().getInitParameter(str));
			}
		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
