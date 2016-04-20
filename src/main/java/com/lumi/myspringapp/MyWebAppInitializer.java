package com.lumi.myspringapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.lumi.myspringapp.worker.MasterDataLoader;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
	    appContext.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");

	    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
	    dispatcher.setLoadOnStartup(1);
	    dispatcher.addMapping("/");
	    //Start worker thread to receive JSON data every 30 sec.
	    new MasterDataLoader().start();

	}

}
