package com.common.util.request;

import com.common.util.response.ResponseResult;
import com.common.util.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * 数据返回json
 * @param <T>
 */
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
