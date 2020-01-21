package com.rick.paez.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/**
 * Clase de configuracion del contexto de Spring FrameWork
 * @author Ricardo Paez
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rick.paez.spring")
public class ApplicationConfig extends WebMvcConfigurerAdapter  {
	/**
	 * ViewResolver para la resolucion de vistas jsp 
	 * @return
	 */
	@Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	 
	        return viewResolver;
	    }
	/**
	 * Manejador de recursos internos
	 */
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/resources/**")
	          .addResourceLocations("/resources/"); 
	    }
	 /**
	  * Negociador de contenido que permite que un servicio REST
	  * conteste con JSON o XML
	  */
	 @Override
	 public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	    configurer.favorPathExtension(true).
	    favorParameter(true).
	    ignoreAcceptHeader(true).
	    useJaf(false).
	    defaultContentType(MediaType.APPLICATION_JSON).
	    mediaType("xml", MediaType.APPLICATION_XML).
	    mediaType("json", MediaType.APPLICATION_JSON);
	 }

}
