package mehr.rest.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object>  handleAllExceptions(Exception ex, WebRequest wr){
        ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean( new Date(), ex.getMessage(), wr.getDescription(false));
        ResponseEntity responseEntity = new ResponseEntity(exceptionResponseBean, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object>  handleUserNotFoundException(UserNotFoundException unfx, WebRequest wr){
        ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean( new Date(), unfx.getMessage(), wr.getDescription(false));
        ResponseEntity responseEntity = new ResponseEntity(exceptionResponseBean, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(InvalidUserDetailsException.class)
    public final ResponseEntity<Object>  handleInvalidUserDetailsException(InvalidUserDetailsException invUx, WebRequest wr){
        ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean( new Date(), invUx.getMessage(), wr.getDescription(false));
        ResponseEntity responseEntity = new ResponseEntity(exceptionResponseBean, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    /**
     * This method is overriden from a higher abstract class to
     * handle te POST request field
     * validations.So the custom messages could be passed to user
     * according to the validation error thrown
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponseBean exceptionResponse = new ExceptionResponseBean(
                new Date(),
                "validation failed",//ex.getMessage(),
                ex.getBindingResult().toString()
        );

        ResponseEntity responseEntity = new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }



}
