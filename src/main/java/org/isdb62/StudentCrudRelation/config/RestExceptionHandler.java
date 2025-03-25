package org.isdb62.StudentCrudRelation.config;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
@ExceptionHandler ({IllegalAccessException.class, IllegalArgumentException.class})
protected ResponseEntity<Object> handleBadRequst(RuntimeException ex, WebRequest request) {
    return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, request);
}

@ExceptionHandler(Exception.class)
protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
}

private ResponseEntity<Object> buildErrorResponse(Exception ex, HttpStatus status, WebRequest request) {
    Map<String, Object> body = new LinkedHashMap<>();
body.put("timestamp", LocalDateTime.now                                        ());
body.put("status", status.value());
body.put("error", status.getReasonPhrase());
body.put("message", ex.getMessage());
body.put("path", request.getDescription(false));


return new ResponseEntity<>(body, new HttpHeaders(), status);
}
}
