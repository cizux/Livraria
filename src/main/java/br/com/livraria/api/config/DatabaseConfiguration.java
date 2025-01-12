package br.com.livraria.api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;
 

    @Bean
    public DataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(1); // tamanho inicial do pool
        config.setPoolName("livraria-db-pool");
        config.setMaxLifetime(1800000);
        config.setConnectionTimeout(200000);
        config.setConnectionTestQuery("SELECT 1");


        // config.setIdleTimeout(200000);
        // config.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        // config.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        // config.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        // config.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
        // config.addDataSourceProperty("dataSource.useLocalSessionState", "true");
        // config.addDataSourceProperty("dataSource.rewriteBatchedStatements", "true");
        // config.addDataSourceProperty("dataSource.cacheResultSetMetadata", "true");
        // config.addDataSourceProperty("dataSource.cacheServerConfiguration", "true");
        // config.addDataSourceProperty("dataSource.elideSetAutoCommits", "true");
        // config.addDataSourceProperty("dataSource.maintainTimeStats", "false");


        return new HikariDataSource(config);
    }



}
