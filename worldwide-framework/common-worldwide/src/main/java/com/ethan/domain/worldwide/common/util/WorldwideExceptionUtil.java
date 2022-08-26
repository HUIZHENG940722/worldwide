package com.ethan.domain.worldwide.common.util;

import com.ethan.domain.worldwide.common.exception.WorldwideException;
import org.springframework.http.HttpStatus;

/**
 * @Author zhenghui
 * @Description 全局异常处理工具类
 * @Date 2022/8/26
 */
public class WorldwideExceptionUtil {
    
    public static void asserts(HttpStatus code, String message) {
        throw new WorldwideException(code, message);
    }
}
