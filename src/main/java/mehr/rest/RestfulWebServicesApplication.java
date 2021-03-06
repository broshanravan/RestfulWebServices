package mehr.rest;

/**
 * Created by Behrooz
 * on 20/09/2018
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }


    @Bean
    public LocaleResolver LocaleResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    /*
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){

        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("messages");

        return resourceBundleMessageSource;

    }
    */
}
