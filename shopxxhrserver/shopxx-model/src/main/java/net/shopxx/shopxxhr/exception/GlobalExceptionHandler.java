package net.shopxx.shopxxhr.exception;

import net.shopxx.shopxxhr.bean.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HrException.class)
    public RespBean sqlException(HrException e) {
        return RespBean.ofError(e.getExceptionEnum().getMessage());
    }

}
