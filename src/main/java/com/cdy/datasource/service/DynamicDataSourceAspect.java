package com.cdy.datasource.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * aop
 * Created by 陈东一
 * 2018/6/3 9:47
 */
@Aspect
@Order(-10)//保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {
    
    @Before("@annotation(TargetDataSource)")
    public void changeDataSource(JoinPoint point) {
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DynamicDataSourceContextHolder.dataSourceIds.get(0); //主库
        try {
            Method method = className.getMethod(methodName, argClass);
            if (method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource annotation = method.getAnnotation(TargetDataSource.class);
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果不在我们注入的所有的数据源范围之内，那么输出警告信息，系统自动使用默认的数据源。
//        if (!DynamicDataSourceContextHolder.containsDataSource(dataSource)) {
//            System.err.println("数据源[{}]不存在，使用默认数据源 > {}"+targetDataSource.value()+point.getSignature());
//        } else {
        System.out.println(point.getSignature()+" 使用的数据源是 "+dataSource);
        DynamicDataSourceContextHolder.setDataSourceType(dataSource);
    }
    
    
    @After("@annotation(TargetDataSource)")
    public void restoreDataSource(JoinPoint point) {
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
    
}