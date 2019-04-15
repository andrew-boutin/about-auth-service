package bakingbitsstudios.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings("unused")
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(NotFoundException ex, WebRequest request) {
        String errMsg = String.format("%s with id '%s' not found.", ex.getEntityType(), ex.getId());
        ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND.value(), errMsg);
        return handleExceptionInternal(ex, errMsg, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(ExistingEntity.class)
    protected ResponseEntity<Object> handleAlreadyExists(ExistingEntity ex, WebRequest request) {
        String errMsg = String.format("%s already exists.", ex.getEntityType());
        ErrorResponse err = new ErrorResponse(HttpStatus.CONFLICT.value(), errMsg);
        return handleExceptionInternal(ex, err, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
