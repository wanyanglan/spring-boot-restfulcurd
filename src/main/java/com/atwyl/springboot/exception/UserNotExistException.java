package com.atwyl.springboot.exception;

/**
 * 自定义的用户不存在的页面
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException(){
        super("用户不存在");
    }
}
