package com.atwyl.springboot.controller;

import com.atwyl.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 该控制类用来处理异常机制
 */
@ControllerAdvice
public class MyExceptionHandler {

    //浏览器客户端返回的都是json
   /* @ResponseBody
    @ExceptionHandler
    public Map<String, Object> handlerException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        return map;
    }*/

   @ExceptionHandler(UserNotExistException.class)
   public String handlerException(Exception e, HttpServletRequest request){
       Map<String, Object> map = new HashMap<>();

       //传入我们自己的状态码 4xx 5xx
//       Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

       request.setAttribute("javax.servlet.error.status_code",500);
       map.put("code","user.notexist");
       map.put("message","用户出错啦!!!");

       request.setAttribute("ext",map);
       //转发到/error
       return "forward:/error";

   }
}
