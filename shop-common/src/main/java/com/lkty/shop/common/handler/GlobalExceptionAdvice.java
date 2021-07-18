package com.lkty.shop.common.handler;

import com.lkty.shop.common.exception.LKTYException;
import com.lkty.shop.common.utils.LKTYObjectUtils;
import com.lkty.shop.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {


    /**
     * @param e 字段校验
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R error(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            if (!LKTYObjectUtils.isBlank(error.getField())) {
                map.put(error.getField(), error.getDefaultMessage());
            }
        });
        log.error("MethodArgumentNotValidException", map);

        return R.error().put(R.DATA_KEY, map);
    }

    @ExceptionHandler(LKTYException.class)
    public R error(LKTYException e) {
        log.error(e.getCodeEnum().getCode() + " --- " + e.getCodeEnum().getMessage());
        return R.error(e.getCodeEnum().getCode(), e.getCodeEnum().getMessage());
    }


    @ExceptionHandler(Throwable.class)
    public R error(Throwable e) {
        log.error("Throwable", e);
        return R.error(e.getMessage());
    }
}
