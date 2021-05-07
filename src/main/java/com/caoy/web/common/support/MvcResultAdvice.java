package com.caoy.web.common.support;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

/**
 * RestResponseAdvice: 将Controller返回值转换成{@link MvcResult}
 * 只拦截被{@link RestController}标记的Controller
 *
 * @author chenjunan 2018/11/26
 */
@ControllerAdvice(annotations = RestController.class)
public class MvcResultAdvice implements ResponseBodyAdvice<Object> {
    @SuppressWarnings("Guava")
    private Predicate<MethodParameter> returnTypePredicate = methodParameter ->
        !methodParameter.hasMethodAnnotation(IgnoreMvcResultConversion.class);

    @SuppressWarnings("Guava")
    private Predicate<Class<? extends HttpMessageConverter<?>>> converterTypePredicate = Predicates.alwaysTrue();

    private String code;

    public MvcResultAdvice(@Nonnull String code) {
        this.code = Preconditions.checkNotNull(code, "code");
    }

    public MvcResultAdvice(
        Predicate<MethodParameter> returnTypePredicate,
        Predicate<Class<? extends HttpMessageConverter<?>>> converterTypePredicate,
        @Nonnull String code) {
        this(code);

        this.returnTypePredicate = returnTypePredicate.and(this.returnTypePredicate);
        this.converterTypePredicate = converterTypePredicate.and(this.converterTypePredicate);
    }

    @Override
    public boolean supports(@Nonnull MethodParameter returnType,
                            @Nonnull Class<? extends HttpMessageConverter<?>> converterType) {
        return returnTypePredicate.test(returnType)
            && converterTypePredicate.test(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  @Nonnull MethodParameter returnType,
                                  @Nonnull MediaType selectedContentType,
                                  @Nonnull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @Nonnull ServerHttpRequest request,
                                  @Nonnull ServerHttpResponse response) {
        if (body instanceof MvcResult) {
            return body;
        }
        return MvcResultBuilder.instance()
            .code(code)
            .data(body)
            .build();
    }
}
