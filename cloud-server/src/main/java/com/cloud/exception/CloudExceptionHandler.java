package com.cloud.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * @author Administrator
 */
@ControllerAdvice
public class CloudExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exception(Exception e){
        System.out.println("程序出现异常------------");
        return e.getMessage();
    }

    /**
     * 全局处理Sentinel异常
     */
    @ExceptionHandler(value = BlockException.class)
    @ResponseBody
    public String blockExceptionHandler(BlockException e){
        System.out.println("程序出现BlockException------------");
        return e.getMessage();
    }
}
