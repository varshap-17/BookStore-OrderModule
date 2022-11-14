package com.example.ordermodule.exception;

import com.example.ordermodule.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMsg=errorList.stream().map(ObjErr->ObjErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto responseDto=new ResponseDto("Exception while processing REST request",errMsg);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderDataException.class)
    public ResponseEntity<ResponseDto> handleBookstoreNotFound(OrderDataException exception){
        ResponseDto responseDto=new ResponseDto("invalid id input",exception);
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.BAD_REQUEST);
    }
}
