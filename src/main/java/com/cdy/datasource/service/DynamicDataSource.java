package com.cdy.datasource.service;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源选择器
 * Created by 陈东一
 * 2018/6/3 9:45
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
