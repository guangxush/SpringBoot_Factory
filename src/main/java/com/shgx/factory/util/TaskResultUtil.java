package com.shgx.factory.util;

import com.shgx.factory.model.Result;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
public class TaskResultUtil {
    public static Result buildSuccessResult() {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage("");
        return result;
    }

    public static Result buildFailedResult(String errorMsg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(errorMsg);
        return result;
    }
}
