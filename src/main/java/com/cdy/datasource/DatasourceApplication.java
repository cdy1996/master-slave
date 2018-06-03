package com.cdy.datasource;

import com.cdy.datasource.service.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import({DynamicDataSourceRegister.class})
@EnableAspectJAutoProxy
public class DatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceApplication.class, args);
    }
}
