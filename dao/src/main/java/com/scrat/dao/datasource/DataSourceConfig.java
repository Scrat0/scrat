package com.scrat.dao.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class DataSourceConfig {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.hikari")
	public HikariConfig dataSourceProperties() {
		return new HikariConfig();
	}

	@Bean
	@Primary
	public HikariDataSource dataSource(HikariConfig hikariConfig) {
		log.info("数据库连接池创建中.......");
		return new HikariDataSource(hikariConfig);
	}
}
