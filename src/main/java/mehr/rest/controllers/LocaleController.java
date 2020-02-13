package mehr.rest.controllers;

import mehr.rest.beans.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocaleController {

    @Autowired
    private MessageSource messageSource;

/*
    @GetMapping (path ="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }
*/

    @GetMapping (path ="/hello-world-bean")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

        return new HelloWorldBean(String.format("Hello World, %s", name));
    }


    @GetMapping(path="/Hello-World-Internationalized")
    public String  helloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }



}
