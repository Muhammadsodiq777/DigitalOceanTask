package uz.digitalocean.com.exception;
//import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abbos_Akramov
 */

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleExceptionClass(Exception ex, WebRequest request) {
        ex.printStackTrace();
        String resBody;
        resBody = ex.getMessage() != null ? ex.getMessage() : "Kutilmagan nosozlik. Qayta urinib ko'ring!";
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(resBody);
    }

    @ExceptionHandler(NotFoundCustomException.class)
    public ResponseEntity handleNotFoundClass(NotFoundCustomException ex) {
        ex.printStackTrace();
        String resBody;
        resBody = ex.getMessage() != null ? ex.getMessage() : "Kutilmagan nosozlik. Qayta urinib ko'ring!";
        return ResponseEntity.ok(resBody);
    }

}
