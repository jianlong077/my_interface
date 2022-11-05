package com.haichao.dbconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author Wei.Zeng
 * @Description  数据源配置
 * @Date 2022/10/27 09:40
 */
@Configuration
@MapperScan(basePackages = {"com.haichao.blog.*.mapper"},sqlSessionFactoryRef = "blogSqlSessionFactory")
public class BlogConfig {

    @Value("${blog.datasource.url}")
    private String url;

    @Value("${blog.datasource.username}")
    private String user;

    @Value("${blog.datasource.password}")
    private String password;

    @Value("${blog.datasource.driverClassName}")
    private String driverClassName;
    @Value("${blog.datasource.type}")
    private String dbType;
    @Primary
    @Bean(name = "blogDataSource")
    public DataSource blogDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setDbType(dbType);
        return dataSource;
    }

    /**
     * 配置事务管理器
     */

    @Primary
    @Bean(name = "blogTransactionManager")
    public DataSourceTransactionManager blogTransactionManager(@Qualifier("blogDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "blogSqlSessionFactory")
    public SqlSessionFactory blogSqlSessionFactory(@Qualifier("blogDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/blog/*/*.xml"));
        return sqlSessionFactoryBean.getObject();

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}