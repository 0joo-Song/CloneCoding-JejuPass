package com.jejupass.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages={"com.withere"})
@EnableTransactionManagement
@Configuration
public class BaseDatabaseConfig {

	@Qualifier("transactionManager.withere")
	DataSourceTransactionManager transactionManager;
	
    @Bean(name="dataSource.withere")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.withere")
    public DataSource dataSourceSKIct(){
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name="sqlSessionFactory.withere")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource.withere") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*Mapper.xml"));
        sessionFactory.setTypeAliasesPackage("com.withere"); // Alias 어노테이션 경로 설정
        return sessionFactory.getObject();
    }

    @Bean(name="sqlSessionTemplate.withere")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory.withere")SqlSessionFactory sqlSessionFactory) throws Exception {
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);	// camel 표기법 변경
        return sqlSessionTemplate;
    }

    @Bean(name="transactionManager.withere")
    @Primary
    public DataSourceTransactionManager transactionManager (@Qualifier("dataSource.withere") DataSource dataSource) throws Exception {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }
    
    
}