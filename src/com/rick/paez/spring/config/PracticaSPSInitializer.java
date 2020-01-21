package com.rick.paez.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class PracticaSPSInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { SpringConfig.class };
	    }
	  
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return null;
	    }
	  
	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }
	 

	
		
	

}
