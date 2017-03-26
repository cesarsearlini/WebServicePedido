package br.com.eicon;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
@SpringBootApplication
public class ExecuteApplication extends SpringBootServletInitializer {

    @Bean
    protected DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(PropertiesConfig.DB_DRIVER);
        dataSource.setUrl(PropertiesConfig.DB_HOST_NAME);
        dataSource.setUsername(PropertiesConfig.DB_USER);
        dataSource.setPassword(PropertiesConfig.DB_PASS);
        return dataSource;
    }   

    public static void main(String[] args) {
        SpringApplication.run(ExecuteApplication.class, args);
        rotinaBancoDeDados();
    }

    private static void rotinaBancoDeDados() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(PropertiesConfig.DB_HOST_NAME, PropertiesConfig.DB_USER, PropertiesConfig.DB_PASS);
        flyway.setBaselineOnMigrate(true);
        flyway.migrate();
    }

}
