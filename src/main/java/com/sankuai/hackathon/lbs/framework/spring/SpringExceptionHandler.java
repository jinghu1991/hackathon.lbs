package com.sankuai.hackathon.lbs.framework.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: FortuneExceptionResolver
 * Author: liuzhao
 * Create: 2014-09-19 10:57
 */
public class SpringExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error(ex.getMessage(), ex);

        StringBuilder sb = new StringBuilder();
        for (StackTraceElement traceElement : ex.getStackTrace()) {
            if (traceElement.getClassName().startsWith("com.sankuai.")) {
                sb.append(String.format("%s\t%s.%s\t%s<br/>", traceElement.getFileName(), traceElement.getClassName(), traceElement.getMethodName(), traceElement.getLineNumber()));
            }
        }
        request.setAttribute("ex", ex);
        request.setAttribute("message", ex.getClass().getName() + ":" + ex.getMessage());
        request.setAttribute("stackTrace", sb.toString());
        response.setStatus(500);
        return new ModelAndView("forward:/500");
    }
}
