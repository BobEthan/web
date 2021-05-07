package com.caoy.web.common.support;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * MvcResult: MvcResult
 *
 * @author chenjunan 2018/11/27
 */
public class MvcResult  {


    private final String code;

    private final String message;

    private final Object data;


    public MvcResult(@Nonnull String code,
                     @Nullable String message,
                     @Nullable Object data) {
        this.code = code;
        this.message = message;
        this.data = data;

    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

}
