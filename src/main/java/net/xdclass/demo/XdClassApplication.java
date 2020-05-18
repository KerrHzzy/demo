package net.xdclass.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author hdz
 */
@SpringBootApplication
@ServletComponentScan
public class XdClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdClassApplication.class, args);
	}

	/*@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大KB,MB
		factory.setMaxFileSize(DataSize.parse("10240KB"));
		/// 设置总上传数据总大小
		factory.setMaxRequestSize(DataSize.parse("1024000KB"));
		return factory.createMultipartConfig();
	}*/
}

/**
 * war打包
 */
/*public class XdClassApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(XdClassApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(XdClassApplication.class, args);
	}
}*/
