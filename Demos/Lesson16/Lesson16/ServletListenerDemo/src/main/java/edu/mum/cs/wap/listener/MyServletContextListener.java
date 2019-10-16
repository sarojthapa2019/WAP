package edu.mum.cs.wap.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

	
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Context Destroyed");
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("Context Initialized");
		// get servlet context
		ServletContext context = servletContextEvent.getServletContext();
		// set attribute in context
		String attributeValue = "Context Param Value";
		String attributeName = "ContextParam";
		context.setAttribute(attributeName, attributeValue);

	}

}
