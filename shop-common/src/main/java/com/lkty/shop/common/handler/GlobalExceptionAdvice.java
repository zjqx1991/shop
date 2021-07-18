package com.lkty.shop.common.handler;

import com.lkty.shop.common.exception.LKTYException;
import com.lkty.shop.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {


    @ExceptionHandler(LKTYException.class)
    public R error(LKTYException e) {
        log.error(e.getCodeEnum().getCode() + " --- " + e.getCodeEnum().getMessage());
        return R.error(e.getCodeEnum().getCode(), e.getCodeEnum().getMessage());
    }


    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        log.error(e.getMessage());
        return R.error(e.getMessage());
    }
}
