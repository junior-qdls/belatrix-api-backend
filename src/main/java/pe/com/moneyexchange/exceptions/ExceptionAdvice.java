package pe.com.moneyexchange.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.com.moneyexchange.model.api.ResponseError;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(DataNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ResponseError getResponseDataNotFoundException(DataNotFoundException ex) throws Exception {

    return buildResponseError(ex.getMessage());

  }

  @ExceptionHandler(BadCredentialsException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  public ResponseError getResponseDataNotFoundException(BadCredentialsException ex) throws Exception {

    return buildResponseError(ex.getMessage());

  }

  private  ResponseError buildResponseError(String message) {
    ResponseError error = new ResponseError();
    error.setErrorMessage(message);
    return error;
  }


}
