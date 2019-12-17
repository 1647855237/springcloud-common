package com.common.util.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description
 * @author  xiongwei
 * @date    2019/12/17 17:45
 * 通用返回格式信息
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseResult implements Response {

    /**
     * 操作是否成功
     */
    boolean success = SUCCESS;

    /**
     * 操作代码
     */
    int code = SUCCESS_CODE;

    /**
     * 提示信息
     */
    String message;

    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    /**
     * 操作成功
     * @return
     */
    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 操作失败
     * @return
     */
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }

}
