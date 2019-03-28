package com.cfets.cms.configuration;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.cfets.cms.common.Constant;
import com.cfets.cms.util.AESUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class MyBatisConfig {
	@Autowired
	private Environment env;
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
		props.put("url", env.getProperty("jdbc.url"));
		byte[] usernamedecryptFrom = AESUtil.parseHexStr2Byte(env.getProperty("jdbc.username"));
		byte[] usernamedecryptResult = AESUtil.decrypt(usernamedecryptFrom, Constant.AESKEY);
		props.put("username",new String(usernamedecryptResult));
		byte[] passworddecryptFrom = AESUtil.parseHexStr2Byte(env.getProperty("jdbc.password"));
		byte[] passworddecryptResult = AESUtil.decrypt(passworddecryptFrom, Constant.AESKEY);
		props.put("password",  new String(passworddecryptResult));
		return DruidDataSourceFactory.createDataSource(props);
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(env.getProperty("mybatis.mapperLocations")));
		sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));

		return sqlSessionFactoryBean.getObject();
	}



}
