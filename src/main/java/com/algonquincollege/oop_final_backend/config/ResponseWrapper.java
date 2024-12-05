/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.config;

import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author mzr_u
 */
public class ResponseWrapper extends HttpServletResponseWrapper  {
    
    private ResponseObject<?> responseObject;
    private CharArrayWriter charArrayWriter = new CharArrayWriter();
    private PrintWriter writer = new PrintWriter(charArrayWriter);
    private Map<String, String> headers = new HashMap<>();

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() {
        return writer;
    }

    public String getCapturedResponse() {
        writer.flush();
        return charArrayWriter.toString();
    }

    @Override
    public void setHeader(String name, String value) {
        headers.put(name, value);
        super.setHeader(name, value);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public ResponseObject<?> getResponseDTO() {
        return responseObject;
    }
    
    public void setResponseDTO(ResponseObject<?> responseVO) {
        this.responseObject = responseVO;
    }





}
