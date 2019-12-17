package com.common.util.request;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 返回数据接口
 * @param <T>
 */
@Data
@ToString
public class QueryResult<T> {
    /**
     * 数据
     */
    private List<T> list;
    /**
     * 数据总数
     */
    private long total;
}
