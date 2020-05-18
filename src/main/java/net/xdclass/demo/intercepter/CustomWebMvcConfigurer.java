package net.xdclass.demo.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hdz
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer  {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api2/*/**");
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/api2/*/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
