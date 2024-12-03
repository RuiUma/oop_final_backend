package com.algonquincollege.oop_final_backend.filters;

import com.algonquincollege.oop_final_backend.Exception.UnAuthorizedException;
import com.algonquincollege.oop_final_backend.Utils.JwtTool;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

public class SessionFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(SessionFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        logger.info("Requested URL: {}", url);


        if (matchUrl(url)) {
            logger.info("matched url: {}", url);
            chain.doFilter(request, response);
            return;
        }
        logger.info("not matched url");
        Cookie[] cookies = httpServletRequest.getCookies();
        String jwt = null;
        for (Cookie cookie: cookies) {
            if ("jwt".equals(cookie.getName())){
                jwt = cookie.getValue();
            }
        }
        if (jwt == null || jwt.isEmpty()) {
            throw new UnAuthorizedException("Not Logged In.");
        }
        UserDTO user;
        try {
            user = JwtTool.parser(jwt);

        } catch (Exception e) {
            e.printStackTrace();
            throw new UnAuthorizedException("Not Valid Token");
        }

        request.setAttribute("userName", user.getName());
        request.setAttribute("userEmail", user.getEmail());
        request.setAttribute("userType", user.getUserType());
        request.setAttribute("userId", user.getUserID());

        chain.doFilter(request, response);


    }

    private Boolean matchUrl(String url) {
        String cleanedURL = cleanURL(url);
        List<String> patterns = List.of("/login", "/register", "/getGeneralData");

        return patterns.stream().anyMatch(pattern -> Pattern.matches(pattern, cleanedURL));
    }

    private static String cleanURL(String requestURL) {
        String[] segments = requestURL.split("/", 3); // 限制分割为最多 3 部分
        return segments.length > 2 ? "/" + segments[2] : ""; // 返回第二段及其后部分
    }
}
