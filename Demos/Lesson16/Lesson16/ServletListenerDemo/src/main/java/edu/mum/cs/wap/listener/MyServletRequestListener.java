package edu.mum.cs.wap.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletRequestListener
 *
 */
@WebListener
public class MyServletRequestListener implements javax.servlet.ServletRequestListener {

  
    public void requestDestroyed(ServletRequestEvent servletRequestEvent)  { 
    	ServletRequest request = servletRequestEvent.getServletRequest();
        System.out.println("Request Destroyed");
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent)  { 
    	ServletRequest request = servletRequestEvent.getServletRequest();
        System.out.println("Request initialized");
    }
	
}





