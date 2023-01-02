package tech.x31415926535.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * date: 2023/1/2 20:11
 * author: 31415926535x
 */
@Configuration
@EnableSwagger2
public class OpenApiConfiguration {

    /**
     * 用于读取配置文件 application.properties 中 swagger 属性是否开启
     */
    @Value("${swagger.enabled}")
    private Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.x31415926535.web.controller")).paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Knowledge-Fragment-Index").description("").termsOfServiceUrl("")
                .version("1.0").build();
    }

    /**
     * @param
     * @Description: 设置swagger文档中全局参数
     * @Date: 2020/9/11 10:15
     * @return: java.util.List<springfox.documentation.service.Parameter>
     */

    // private List<Parameter> setHeaderToken() {
    //     ParameterBuilder userId = new ParameterBuilder();
    //     userId.name("token").description("用户TOKEN").modelRef(new ModelRef("string")).parameterType("header")
    //             .required(true).build();
    //     return Lists.newArrayList(userId.build());
    // }
}