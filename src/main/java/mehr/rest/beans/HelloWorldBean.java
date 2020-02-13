package mehr.rest.beans;

import io.swagger.annotations.ApiModelProperty;


public class HelloWorldBean {

    @ApiModelProperty(notes = "String message coming from the bean")
    private String message ="message coming from the bean";

    public HelloWorldBean(String message) {
        message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
