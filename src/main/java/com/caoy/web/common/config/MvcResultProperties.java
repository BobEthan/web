package com.caoy.web.common.config;


import org.springframework.context.annotation.Configuration;

/**
 * MvcResultProperties: MvcResultProperties
 *
 * @author chenjunan 2018/12/03
 */
public class MvcResultProperties {
    /**
     * 自动转换controller结果为MvcResult
     */
    private boolean autoConversion = true;

    /**
     * 默认返回结果的code，
     * @see com.caoy.web.common.support.MvcResult#code
     */
    private String defaultSuccessCode = "0";


    public boolean isAutoConversion() {
        return autoConversion;
    }

    public MvcResultProperties setAutoConversion(boolean autoConversion) {
        this.autoConversion = autoConversion;
        return this;
    }

    public String getDefaultSuccessCode() {
        return defaultSuccessCode;
    }

    public MvcResultProperties setDefaultSuccessCode(String defaultSuccessCode) {
        this.defaultSuccessCode = defaultSuccessCode;
        return this;
    }

}
