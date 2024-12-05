package com.algonquincollege.oop_final_backend.servlets;

import com.algonquincollege.oop_final_backend.config.ResponseWrapper;
import com.algonquincollege.oop_final_backend.dto.ResponseObject;
import com.algonquincollege.oop_final_backend.service.NotificationService;
import com.algonquincollege.oop_final_backend.service.impl.NotificationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/notification")
public class NotificationServlet extends HttpServlet {
    private final NotificationService notificationService = new NotificationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(notificationService.getNotificationsByUserId(Integer.parseInt(req.getAttribute("userId").toString()))));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parsedBody = (Map) req.getAttribute("parsedBody");
        String notificationId = parsedBody.get("notificationId").toString();
        ResponseWrapper rw = (ResponseWrapper)resp;
        rw.setResponseDTO(ResponseObject.success(notificationService.markAsRead(Integer.parseInt(notificationId))));

    }
}
