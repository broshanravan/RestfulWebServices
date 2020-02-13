package mehr.rest.Exceptions;

import java.util.Date;

public class ExceptionResponseBean {
    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponseBean(Date date, String message, String details) {
        super();
        this.timeStamp = date;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponseBean(){

    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
