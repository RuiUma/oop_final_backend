/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.dto;

/**
 *
 * @author mzr_u
 */
public class ResponseObject<T> {
    
    private boolean success;
    private int code;
    private T data;
    private String errmsg;
    
    public ResponseObject(boolean success, int code, T data, String errmsg) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.errmsg = errmsg;
    }
    
    public static <T> ResponseObject<T> success(T data) {
        return new ResponseObject<>(true, 0, data, null);
    }
    
    public static <T> ResponseObject<T> failure(String errmsg) {
        return new ResponseObject<>(false, 1, null, errmsg);
    }
    
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    
}
