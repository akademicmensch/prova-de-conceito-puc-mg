package br.com.sigo.consultorias;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@org.springframework.context.annotation.Configuration
public class Configuration {

	/*@Bean
	public DataSource getDataSource() {

		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");

		dataSourceConfig.setJdbcUrl("jdbc:mysql://database-1.clifhmwelhzh.us-east-2.rds.amazonaws.com:3306/pucmg");

		dataSourceConfig.setUsername("admin");
		dataSourceConfig.setPassword("admin123");

		return new HikariDataSource(dataSourceConfig);
	}*/

}
