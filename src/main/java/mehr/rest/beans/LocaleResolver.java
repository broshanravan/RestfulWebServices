package mehr.rest.beans;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

public class LocaleResolver {

    public LocaleResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.UK);
    }

}

