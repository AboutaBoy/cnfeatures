package cn.features.core.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Date;

/**
 * 配置 Swagger2.
 * API 浏览、测试工具, 访问页面 <code>http://{host:port}/swagger-ui.html</code>
 * https://yq.aliyun.com/articles/181435
 *
 * @Configuration 让spring加载此配置
 * @EnableSwagger2 启动swagger2
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${system.version.number}")
    private String versionNumber;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cnFeature")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.features"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDate.class, Date.class)
                .useDefaultResponseMessages(false);
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Programming Makes Us Happy")
                .description("Show Home Features")
                .contact(new Contact("AboutaBoy",
                        "https://github.com/AboutaBoy",
                        "601918780@qq.com"))
                .version(versionNumber)
                .build();
    }
}
