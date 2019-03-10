package com.southwind.community.config;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.southwind.community.config.bean.DruidConfBean;
import com.southwind.community.config.bean.MyBatisConfBean;
import com.southwind.community.config.bean.SaggerConfBean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ServiceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.druid")
	public DruidConfBean druidConf() {
		return new DruidConfBean();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.mybatis")
	public MyBatisConfBean myBatisConf() {
		return new MyBatisConfBean();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.swagger")
	public SaggerConfBean saggerConf() {
		return new SaggerConfBean();
	}

	@Bean
	@Primary
	public DataSource druidDataSource() throws IOException {

		DruidDataSource druidDataSource = new DruidDataSource();
		
		DruidConfBean conf = druidConf();

		try {

			druidDataSource.setValidationQuery(conf.getValidationQuery());
			druidDataSource.setMaxActive(conf.getMaxActive());
			druidDataSource.setMinIdle(conf.getMinIdle());
			druidDataSource.setMaxWait(conf.getMaxWait());

			druidDataSource.setTestOnBorrow(conf.getTestOnBorrow());
			druidDataSource.setTestOnReturn(conf.getTestOnReturn());
			druidDataSource.setTestWhileIdle(conf.getTestWhileIdle());

			druidDataSource.setPoolPreparedStatements(conf.getPoolPreparedStatements());
			druidDataSource
					.setMaxPoolPreparedStatementPerConnectionSize(conf.getMaxPoolPreparedStatementPerConnectionSize());

			druidDataSource.setDriverClassName(conf.getDriverClassName());
			druidDataSource.setUrl(conf.getUrl());
			druidDataSource.setUsername(conf.getUsername());
			druidDataSource.setPassword(conf.getPassword());

			Properties config = conf.getConnectionPropertiesConf();

			druidDataSource.setConnectProperties(config);
			druidDataSource.setFilters(conf.getFilters());

			List<Filter> filters = new ArrayList<>();
			//
			//// druidDataSource.
			//
			//
			WallFilter wallFilter = new WallFilter();

			WallConfig wallConfig = new WallConfig();

			wallConfig.configFromProperties(config);

			wallFilter.setConfig(wallConfig);
			//

			filters.add(wallFilter);
			System.out.println( druidDataSource.getProxyFilters());

			druidDataSource.setProxyFilters(filters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}

	/**
	 * 根据数据源创建SqlSessionFactory
	 */
	@Bean("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(ds);
		MyBatisConfBean conf = myBatisConf();
		fb.setTypeAliasesPackage(conf.getTypeAliasesPackage());

		/*
		 * Resource[] resources = new PathMatchingResourcePatternResolver()
		 * .getResources(conf.getMapperLocations());
		 * fb.setMapperLocations(resources);
		 */

		fb.setConfigLocation(new DefaultResourceLoader().getResource(conf.getConfigLocation()));
		fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(conf.getMapperLocations()));
		
		return fb.getObject();
	}
	
	/**
     * Create object to hold information about the API.
     * Note that the version property is automatically updated when the project is released.
     *
     * @return
     */
    ApiInfo apiInfo() {
    	SaggerConfBean saggerConf = saggerConf();
        return new ApiInfoBuilder()
            .title(saggerConf.getTitle())
            .description(saggerConf.getDescription())
//            .license("")
//            .licenseUrl("")
//            .termsOfServiceUrl("")
            .version(saggerConf.getVersion())
            .build();
    }

    /**
     * Setup swagger tester page
     *
     * @return
     */
    @Bean
    public Docket customImplementation() {
    	SaggerConfBean saggerConf = saggerConf();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(saggerConf.getBasePackage()))
                .build().useDefaultResponseMessages(saggerConf.getUseDefaultResponseMessages())
                .enable(saggerConf.getEnable())
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
        return docket;
    }
}
