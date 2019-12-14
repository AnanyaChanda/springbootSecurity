package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecuredWithDataBaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(SecuredWithDataBaseApplication.class, args);
		
		DataSource ds = ctx.getBean(DataSource.class);
		try {
			System.out.println(ds.getConnection().toString());
			
			DatabaseMetaData metadata =ds.getConnection().getMetaData();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
