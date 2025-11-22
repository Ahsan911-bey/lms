package com.ahsansoftware.lms.dto;

public class AuthResponseDTO {

    private String token;
    private String message;
    private String userName;

    AuthResponseDTO(){}

    AuthResponseDTO(String token , String message , String userName){
        this.token = token;
        this.message = message;
        this.userName = userName;
    }

    public String getToken(){ return token; }
    public void setToken(String token){
        this.token = token;
    }

    public String getMessage(){ return message; }
    public void setMessage(String message){
        this.message = message;
    }

    public String getUsername(){ return userName; }
    public void setUsername(String userName){
        this.userName = userName;
    }
}
