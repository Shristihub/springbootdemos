package com.bookapp.client;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class DbConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(getDataSource());
	      em.setPackagesToScan(new String[] {"com.bookapp.model"});
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(hibernateProperties());
	      
	      return em;
	   }
	@Bean
	public DataSource getDataSource() {
		MysqlDataSource datasource = new MysqlDataSource();
		datasource.setURL(environment.getProperty("datasource.url"));
		datasource.setUser(environment.getProperty("datasource.username"));
		datasource.setPassword(environment.getProperty("datasource.password"));
		return datasource;
		
	}
	@Bean
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

	    return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.ddl"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.showsql"));
		return properties;
	}
}
