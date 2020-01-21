package com.rick.paez.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Clase de inicializacion del contexto SpringFramework
 * @author Ricardo Paez
 *
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { ApplicationConfig.class };
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
