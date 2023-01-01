package tech.x31415926535.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * date: 2022/12/28 11:31
 * author: 31415926535x
 */
@ServletComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"tech.x31415926535"})
public class ServiceInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceInitializer.class);
    }

}
