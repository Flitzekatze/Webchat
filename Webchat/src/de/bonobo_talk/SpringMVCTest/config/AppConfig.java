package de.bonobo_talk.SpringMVCTest.config;

<<<<<<< HEAD


=======
>>>>>>> origin/development
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
=======
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
>>>>>>> origin/development
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "de.bonobo_talk.SpringMVCTest")
<<<<<<< HEAD
public class AppConfig extends WebMvcConfigurerAdapter {
=======
public class AppConfig {
>>>>>>> origin/development
	   @Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/jsp/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	   @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        return messageSource;
<<<<<<< HEAD
	    }
	   @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	  registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
	    }
=======
	    } 
>>>>>>> origin/development

}
