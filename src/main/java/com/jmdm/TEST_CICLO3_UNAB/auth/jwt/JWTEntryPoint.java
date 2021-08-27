/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.auth.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author José M Dager Montoya
 */
@Component
public class JWTEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger =  LoggerFactory.getLogger(JWTEntryPoint.class);
    
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException ae) throws IOException, ServletException {
        logger.error("No autorizado, por favor verifique el TOKEN");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
    
}