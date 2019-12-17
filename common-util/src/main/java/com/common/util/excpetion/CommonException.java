package com.common.util.excpetion;

import com.common.util.response.ResultCode;

/**
 * @Author: xiongwei
 * @Date: 2019/8/8
 * @why：自定义异常
 */
public class CommonException extends RuntimeException {

    ResultCode resultCode;

    public CommonException(ResultCode resultCode1){
         this.resultCode = resultCode1;
    }

    public ResultCode getCommonCode(){
        return resultCode;
    }

}