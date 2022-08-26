package com.ethan.domain.worldwide.common.exception.handler;

import com.ethan.domain.worldwide.common.exception.WorldwideException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author zhenghui
 * @Description 全局异常处理类
 * @Date 2022/8/26
 */
@RestControllerAdvice
public class WorldwideExceptionHandler {

    @ExceptionHandler(value = WorldwideException.class)
    public ResponseEntity handleWorldwideException(WorldwideException e) {
        return new ResponseEntity<>(e.getMessage(), e.getCode());
    }
}
