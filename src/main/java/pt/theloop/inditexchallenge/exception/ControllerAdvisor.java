package pt.theloop.inditexchallenge.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<Object> handleBrandNotFoundException(
            ProductNotFoundException ex,
            WebRequest request) {

        HttpHeaders headers = new HttpHeaders();
        return this.handleExceptionInternal(ex, null, headers, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(
            ProductNotFoundException ex,
            WebRequest request) {

        HttpHeaders headers = new HttpHeaders();
        return this.handleExceptionInternal(ex, null, headers, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(
            ProductNotFoundException ex,
            WebRequest request) {

        HttpHeaders headers = new HttpHeaders();
        return this.handleExceptionInternal(ex, null, headers, HttpStatus.NOT_FOUND, request);
    }

}
