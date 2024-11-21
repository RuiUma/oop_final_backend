/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.Config;

import com.algonquincollege.oop_final_backend.DTO.ResponseDTO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


/**
 *
 * @author mzr_u
 */
public class ResponseWrapper extends HttpServletResponseWrapper  {
    
    private ResponseDTO<?> responseDTO;

            
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }
    
    public ResponseDTO<?> getResponseDTO() {
        return responseDTO;
    }
    
    public void setResponseDTO(ResponseDTO<?> responseVO) {
        this.responseDTO = responseVO;
    }
    
}
