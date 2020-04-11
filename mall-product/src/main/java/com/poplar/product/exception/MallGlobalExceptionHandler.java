package com.poplar.product.exception;

import com.poplar.common.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Create BY poplar ON 2020/4/11
 * 全局异常处理器
 */

@RestControllerAdvice(basePackages = "com.poplar.product.controller")
public class MallGlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MallGlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result<Object> handleValidException(MethodArgumentNotValidException ex) {
        logger.error("参数校验 {}，{}", ex.getMessage(), ex.getClass());
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return Result.fail(400, "参数校验有误", errorMap);
    }
}
