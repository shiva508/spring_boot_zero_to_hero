package com.pool.conditional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
@Configuration
@ComponentScan
public class ConditionalConfig {
	@Bean(name="userDAO")
	//@Conditional(value=MySQLDatabaseTypeCondition.class)
	@DatabaseType("MYSQL")
	public UserDAO jdbcUserDAO() {

		return new JdbcUserDAO();
	}
	@Bean(name="userDAO")
	@DatabaseType("MONGO")
	//@Conditional(value=MongoDBDatabaseTypeCondition.class)
	public UserDAO mongoUserDAO() {
		return new MongoUserDAO();
	}
	
	@Bean
	@Conditional(MySqlDriverPresentsCondition.class)
	@Primary
	public DriverBean mySqlDriverBean() {
		return new MySqlDriverBean();
	}
	
	@Bean
	@Conditional(H2DriverPresentsCondition.class)
	public DriverBean h2DeiverBean() {
		return new H2DriverBean();
	}
}
