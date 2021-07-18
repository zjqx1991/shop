package com.lkty.shop.common.exception;

import com.lkty.shop.common.code.LKTYCodeEnum;
import lombok.Getter;

@Getter
public class LKTYException extends RuntimeException{

    // 异常
    private LKTYCodeEnum codeEnum;

    public LKTYException(LKTYCodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }
}
