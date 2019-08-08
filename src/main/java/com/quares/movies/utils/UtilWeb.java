package com.quares.movies.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UtilWeb {

    private UtilWeb(){
        throw new IllegalStateException("Utility class");
    }
    /**
     * Retorna la uri del request que hizo la peticion
     *
     * @return
     */
    public static String getRequestUri() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request.getRequestURI();
    }
}
