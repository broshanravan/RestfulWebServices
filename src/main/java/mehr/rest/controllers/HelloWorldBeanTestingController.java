package mehr.rest.controllers;

import mehr.rest.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Behrooz
 * on 20/09/2018
 */

@RestController
public class HelloWorldBeanTestingController {

    /**
     * This will determine the contents of the
     * destination page .
     * It also gives thee URI for the page
     * @return
     */

    @RequestMapping(method = RequestMethod.GET, path = "/hello_world")
    public String helloWorld() {

        return "This is the fist message for my controller";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello_bean")
    public HelloWorldBean helloWorldBeanHandler() {

        return  new HelloWorldBean("My Message for the Bean");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello_bean/PathVariable/{name}")
    public HelloWorldBean helloWorldBeanHandlerathVatiable(@PathVariable String name) {

        return  new HelloWorldBean(String.format("My Message the Bean for: %s" , name));
    }



}
