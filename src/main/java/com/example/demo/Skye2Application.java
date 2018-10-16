package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@SpringBootApplication 
@EnableJpaAuditing // Now, what we want is that these fields should automatically get populated
					// whenever we create or update an entity.
@EnableScheduling // enable scheduling service
//@EntityScan(basePackageClasses=City.class)
public class Skye2Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Skye2Application.class, args);
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/*.test").excludePathPatterns("/add");;
    }

	@Primary
	@Bean(name = "druid")
	public DataSource dataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	// transaction manager, hibernate sessionFactory, transactional...
	
}
