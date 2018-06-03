package com.cdy.datasource.service;

import java.lang.annotation.*;

/**
 * 数据源注解
 * Created by 陈东一
 * 2018/6/3 9:45
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value() default "dataSource";
}
