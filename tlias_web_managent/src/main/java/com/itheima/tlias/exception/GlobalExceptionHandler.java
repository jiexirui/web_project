package com.itheima.tlias.exception;

import com.itheima.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j// 日志
@RestControllerAdvice// 全局异常处理
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//这段代码使用@ExceptionHandler注解指定处理Exception.class类型的异常。
    public Result doException(Exception ex) {
        log.error("异常信息：{}", ex.getMessage(),ex);
        return Result.error("服务器异常");
    }
}
