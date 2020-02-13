package mehr.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Bruce Roshanravan","www.mehrcomputers.com","broshanravan@hotmail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("API for Testing Swagger",
                                                        "API Documentation",
                                                        "1.0",
                                                        "These are my terms of service",
                                                         DEFAULT_CONTACT,
                                                        "Apache 2.0",

                                                        "http://www.pache.org/LICENSE-2.0"
    );

    public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/xml","application/json"));

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }



}
