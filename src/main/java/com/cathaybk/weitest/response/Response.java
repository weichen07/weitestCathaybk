package com.cathaybk.weitest.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Response<T>{

    private int statusCode;
    @JsonProperty(value = "Message")
    private String Message;
    @JsonProperty(value = "Data")
    private T Data;
    public Response() {
    }

    public Response(String message, int statusCode, T data) {
        this.Message = message;
        this.statusCode = statusCode;
        this.Data = data;
    }


    public static <T> Response<T> success(T data) {
        return new Response<>("OK", 200, data);
    }

    public static <T> Response<T> success() {
        return new Response<>("OK", 200, null);
    }

    public static <T> Response<T> fail(String message){

        return new Response<>(message,-1,null);
    }
}
