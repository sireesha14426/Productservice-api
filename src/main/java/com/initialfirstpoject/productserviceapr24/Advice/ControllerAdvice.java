package com.initialfirstpoject.productserviceapr24.Advice;

import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.CategoryNotFoundException;
import com.initialfirstpoject.productserviceapr24.Exception.ProductNotFoundException;
import com.initialfirstpoject.productserviceapr24.dto.ErrorDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDTO error = new ErrorDTO();
        error.setMessage("Please try after sometime");
        error.setCode(" some error occured");
        return error;
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorDTO handleCategoruNotFoundException(ProductNotFoundException exception) {
        ErrorDTO error = new ErrorDTO();
        error.setMessage("Please try after sometime");
        error.setCode(" some error occured");
        return error;
    }
}
