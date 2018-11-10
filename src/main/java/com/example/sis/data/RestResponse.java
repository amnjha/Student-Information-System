package com.example.sis.data;

public class RestResponse {
    private String message;
    private Object result;
    private int statusCode;

    public String getMessage() {
        return message;
    }

    public Object getResult() {
        return result;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static RestResponse buildRestResponse(int statusCode, Object result, String message){
        RestResponse restResponse = new RestResponse();
        restResponse.message = message;
        restResponse.result = result;
        restResponse.statusCode = statusCode;
        return  restResponse;
    }
}
