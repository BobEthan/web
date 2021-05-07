package com.caoy.web.common.config;

import com.caoy.web.common.support.MvcResultAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.function.Predicate;

/**
 * RestResultAdviceAutoConfiguration: RestResultAdviceAutoConfiguration
 *
 * @author chenjunan 2018/12/03
 */
@Configuration
public class MvcResultAutoConfiguration {
    @Bean
    public ResponseBodyAdvice<Object> responseBodyAdvice() {
        MvcResultProperties properties = new MvcResultProperties();
        return new MvcResultAdvice(
            returnTypePredicate(properties),
            converterTypePredicate(properties),
            properties.getDefaultSuccessCode()
        );
    }

    private Predicate<MethodParameter> returnTypePredicate(MvcResultProperties properties) {
        return t -> properties.isAutoConversion();
    }

    private Predicate<Class<? extends HttpMessageConverter<?>>> converterTypePredicate(
        MvcResultProperties properties) {
        return t -> properties.isAutoConversion();
    }
}
