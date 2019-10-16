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
 * Servlet implementation class InitParamsAnnotationServlet
 */

// @WebServlet("/InitParamsServlet")
// @WebInitParam(name = "driver", value = "sun.jdbc.odbc.JdbcOdbcDriver") //This
// one doesn't work

// @WebServlet(
// urlPatterns = "/InitParamsServlet",
// initParams = @WebInitParam(name = "driver", value =
// "sun.jdbc.odbc.JdbcOdbcDriver")
// )

@WebServlet(urlPatterns = {"/InitParamsAnnotationServlet"}, initParams = {
		@WebInitParam(name = "location", value = "D:/Uploads"),
		@WebInitParam(name = "maxUploadSize", value = "9900000") })
public class InitParamsAnnotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletConfig config = getServletConfig();

		Enumeration<String> e = config.getInitParameterNames();
		String str = "";
		while (e.hasMoreElements()) {
			str = e.nextElement();
			out.print("<br />Name: " + str);
			out.print(" value: " + config.getInitParameter(str));
		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
