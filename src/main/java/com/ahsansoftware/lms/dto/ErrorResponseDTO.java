package com.ahsansoftware.lms.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponseDTO {
private LocalDateTime timeStamp;
private int status;
private String message;
private String error;
private Map<String , String> validationErrors;

public ErrorResponseDTO(){
    this.timeStamp = LocalDateTime.now();
}

public ErrorResponseDTO(int status , String message , String error){
    this();
    this.status = status;
    this.message = message;
    this.error = error;
}

public ErrorResponseDTO(int status , String error, Map<String , String> validationErrors){
    this();
    this.status = status;
    this.error = error;
    this.validationErrors = validationErrors;
}

public LocalDateTime getTimeStamp(){ return timeStamp; }
public void setTimeStamp(LocalDateTime timeStamp){
    this.timeStamp = timeStamp;
}

public int getStatus(){ return status; }
public void setStatus(int status){
    this.status = status;
}

public String getMessage(){ return message; }
public void setMessage(String message){
    this.message = message;
}

public String getError(){ return error; }
public void setError(String error){
    this.error = error;
}

public Map<String , String> getValidationErrors(){ return validationErrors; }
public void setValidationErrors(Map<String , String> validationErrors){
    this.validationErrors = validationErrors;
}
}
