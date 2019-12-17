package com.common.util.excpetion;

import com.common.util.response.ResultCode;

/**
 * @Author: xiongwei
 * @Date: 2019/8/8
 * @why： 简化抛出异常
 */
public class ExceptionCommon {


    public static void cast(ResultCode commonCode){
        throw new CommonException(commonCode);
    }


}
