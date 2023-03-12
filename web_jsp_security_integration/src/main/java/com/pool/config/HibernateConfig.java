package com.pool.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.sf.ehcache.hibernate.EhCacheProvider;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.bank" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {
	@Autowired
	private Environment env;

	
	@Bean
	public DataSource securityDataSource() {
		 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  dataSource.setDriverClassName(env.getProperty("mysql.driverClassName"));
		  dataSource.setUrl(env.getProperty("mysql.url"));
		  dataSource.setUsername(env.getProperty("mysql.username"));
		  dataSource.setPassword(env.getProperty("mysql.password")); 
		  return dataSource;
		
		
		/*
		 * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		 * EmbeddedDatabase db = builder .setType(EmbeddedDatabaseType.H2) //.H2 or
		 * .DERBY .build(); return db;
		 */

	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(securityDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.bank.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		/*CACHE PROPERTIES*/
		properties.put(org.hibernate.cfg.Environment.USE_SECOND_LEVEL_CACHE, true);
		properties.put(org.hibernate.cfg.Environment.USE_QUERY_CACHE, true);
		properties.put(org.hibernate.cfg.Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.jcache.JCacheRegionFactory");
		properties.put("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
		//properties.put("hibernate.javax.cache.provider", EhcacheCachingProvider.class);
		/*CONNECTION POOL PROPERTIES*/
		properties.put(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, 5);
		properties.put(org.hibernate.cfg.Environment.C3P0_MAX_SIZE, 10);
		properties.put(org.hibernate.cfg.Environment.C3P0_ACQUIRE_INCREMENT,1);
		properties.put(org.hibernate.cfg.Environment.C3P0_TIMEOUT,2000);
		properties.put(org.hibernate.cfg.Environment.C3P0_MAX_STATEMENTS, 150);
		properties.put(org.hibernate.cfg.Environment.C3P0_CONFIG_PREFIX+".initialPoolSize", 8);
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}
