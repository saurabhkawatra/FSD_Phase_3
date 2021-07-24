package com.spring.DAO;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class config {
	
	private final String URL = "jdbc:mysql://localhost:3306/sportyshoes";
	private final String USER = "root";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String PASSWORD = "dattago1";
	
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(URL);
		driverManagerDataSource.setUsername(USER);
		driverManagerDataSource.setPassword(PASSWORD);
		driverManagerDataSource.setDriverClassName(DRIVER);
		return driverManagerDataSource;
	}

}
