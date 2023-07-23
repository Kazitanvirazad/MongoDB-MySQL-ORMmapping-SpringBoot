package com.employee.employeespringbootapp.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.employee.employeespringbootapp.util.ResponseObject;

@RestControllerAdvice
public class HandleException {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseObject> handleValidationErrors(MethodArgumentNotValidException ex) {
                List<Map<String, String>> fieldErrorList = new ArrayList<>();
                Map<String, List<Map<String, String>>> errorMap = new HashMap<>();

                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        Map<String, String> errors = new HashMap<>();
                        String fieldName = ((FieldError) error).getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put("field_name", fieldName);
                        errors.put("field_error_description", errorMessage);
                        fieldErrorList.add(errors);
                });

                errorMap.put("fields", fieldErrorList);
                return new ResponseEntity<>(ResponseObject.builder().setError(true)
                                .setMessage("Form Field error")
                                .setData(errorMap)
                                .build(),
                                new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<ResponseObject> handleHttpMessageNotReadableErrors(HttpMessageNotReadableException ex) {
                return new ResponseEntity<>(ResponseObject.builder()
                                .setError(true)
                                .setMessage("Invalid/Not Acceptable JSON format in service request body")
                                .build(),
                                new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(TransientPropertyValueException.class)
        public ResponseEntity<ResponseObject> handleTransientPropertyValueExceptionErrors(
                        TransientPropertyValueException ex) {
                return new ResponseEntity<>(ResponseObject.builder()
                                .setError(true)
                                .setMessage("Missing request body JSON attributes")
                                .build(),
                                new HttpHeaders(), HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<ResponseObject> handleMethodArgumentTypeMismatchExceptionErrors(
                        MethodArgumentTypeMismatchException ex) {
                return new ResponseEntity<>(ResponseObject.builder()
                                .setError(true)
                                .setMessage("Query parameter value type mismatch error")
                                .build(),
                                new HttpHeaders(), HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(MissingServletRequestParameterException.class)
        public ResponseEntity<ResponseObject> handleMissingServletRequestParameterExceptionErrors(
                        MissingServletRequestParameterException ex) {
                return new ResponseEntity<>(ResponseObject.builder()
                                .setError(true)
                                .setMessage("Invalid required request parameter")
                                .build(),
                                new HttpHeaders(), HttpStatus.BAD_REQUEST);

        }
}