package com.app.mvc.common;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by wenheng on 2017/7/15.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DBRepository {

    String value() default "";
}
