package com.shgx.factory.util;

import com.shgx.factory.model.Request;
import com.shgx.factory.model.Result;
import com.shgx.factory.work.Work;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.text.MessageFormat;

/**
 * @author: guangxush
 * @create: 2020/07/19
 */
@Slf4j
public class LoggerInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Request request = (Request) methodInvocation.getArguments()[0];
        Work work = (Work) methodInvocation.getThis();

        Result result = (Result) methodInvocation.proceed();
        printLog(request, result, work.getWorkCode().getWorkCode());
        return result;
    }

    public static void printLog(Request request, Result result, String code) {
        String digest = MessageFormat.format("{0},{1},{2},{3}", request.getEnv(), code, request.getName(), result.getMessage());
        log.info(digest);
    }
}
