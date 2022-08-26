package com.ethan.domain.worldwide.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @Author zhenghui
 * @Description 公共异常类
 * @Date 2022/8/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WorldwideException extends RuntimeException {

    /**
     * 业务错误码
     */
    private HttpStatus code;

    /**
     * 错误提示
     */
    private String message;

    public WorldwideException(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }
}
