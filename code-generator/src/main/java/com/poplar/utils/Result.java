package com.poplar.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create BY poplar ON 2020/3/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static  <T> Result<T> success(T data) {
        return new Result<T>(0, "success", data);
    }
    public static  <T> Result<T> success() {
        return new Result<T>(0, "success", null);
    }
    public static  <T> Result <T> success(String message, T data) {
        return new Result <T>(0, message, data);
    }

    public static  <T> Result <T> fail(String message) {
        return new Result <T>(-1, message, null);
    }
}
