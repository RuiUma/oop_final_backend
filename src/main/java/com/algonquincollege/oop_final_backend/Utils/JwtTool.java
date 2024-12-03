package com.algonquincollege.oop_final_backend.Utils;

import com.algonquincollege.oop_final_backend.Exception.UnAuthorizedException;
import com.algonquincollege.oop_final_backend.dto.UserDTO;
import com.algonquincollege.oop_final_backend.service.impl.AuthServiceImpl;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Claims;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JwtTool {

    private final static String SECRET_KEY = "ALGONQUINCOLLEGEOBJECTORIENTEDPROGRAMMINGFINALPROJECTSECRETKEY";
    private static final Logger logger = LogManager.getLogger(JwtTool.class);

    public static String sign(UserDTO userDTO) {

        Map claims = new HashMap();

        claims.put("name", userDTO.getName());
        claims.put("email", userDTO.getEmail());
        claims.put("role", userDTO.getUserType());
        claims.put("userId",userDTO.getUserID());

        return Jwts.builder()
                .setSubject(userDTO.getEmail())
                .setIssuer("algonquincollege.com")
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static UserDTO parser(String jwt) {

        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        UserDTO userDTO = new UserDTO();
        try {
            userDTO.setName(claims.get("name").toString());
            userDTO.setEmail(claims.get("email").toString());
            userDTO.setUserType(claims.get("role").toString());
            userDTO.setUserID(Integer.valueOf(claims.get("userId").toString()));
        } catch (Exception e) {

        }
        if (userDTO.getEmail() == null) {
            throw new UnAuthorizedException("Not Valid Token");
        }




        return userDTO;
    }

//    public static Boolean Validate(String jwt) {
//        try {
//            Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .build()
//                .parseClaimsJws(jwt)
//                .getBody();
//
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
}
