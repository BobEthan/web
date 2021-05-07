package com.caoy.web.common.support;

import com.google.common.base.Throwables;
import com.sun.org.apache.xml.internal.security.utils.I18n;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * MvcResultBuilder: MvcResultBuilder
 *
 * @author chenjunan 2018/11/27
 */
public class MvcResultBuilder {
    /**
     * 代码
     */
    private String code;

    /**
     * 消息（本地化）
     */
    private String message;

    /**
     * 数据
     */
    private Object data;


    public static MvcResultBuilder instance() {
        return new MvcResultBuilder();
    }


    public MvcResultBuilder code(String code) {
        this.code = code;
        return this;
    }

    public MvcResultBuilder message(String message) {
        this.message = message;
        return this;
    }

    public MvcResultBuilder data(Object data) {
        this.data = data;
        return this;
    }


    public MvcResult build() {
        return new MvcResult(code, message, data);
    }
}
