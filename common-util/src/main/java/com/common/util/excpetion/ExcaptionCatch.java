package com.common.util.excpetion;

import com.common.util.response.CommonCode;
import com.common.util.response.ResponseResult;
import com.common.util.response.ResultCode;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xiongwei
 * @Date: 2019/8/8
 * @why：统一异常处理类
 * ControllerAdvice: 控制器增强注解
 */
@ControllerAdvice
@Slf4j
public class ExcaptionCatch {

    /**
     * 谷歌的一个map，线程安全，并且map的值不能更改，用法如下
     */
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    static {
        //在这里加入一些基础的异常类型判断,之后可以继承这个类来指定个性化异常处理
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
    }

    /**
     * 捕获自定义异常
     * @param CommonException
     * @return
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public ResponseResult CommonException(CommonException CommonException){
        log.error("catch exception: {}",CommonException.getMessage(),CommonException);
        ResultCode commonCode = CommonException.getCommonCode();
        return new ResponseResult(commonCode);
    }

    /**
     * 捕获不可控异常
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        log.error("catch exception: {}",exception.getMessage(),exception);
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseResult(resultCode);
        } else {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }
}
