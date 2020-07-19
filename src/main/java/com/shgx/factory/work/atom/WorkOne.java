package com.shgx.factory.work.atom;

import com.shgx.factory.model.Request;
import com.shgx.factory.model.Result;
import com.shgx.factory.model.WorkEnum;
import com.shgx.factory.work.AbstractWork;
import org.springframework.stereotype.Component;

/**
 * @author: guangxush
 * @create: 2020/07/19
 */
@Component
public class WorkOne extends AbstractWork {
    @Override
    protected Result validate(Request request) {
        Result result = new Result();
        if ("prod".equals(request.getEnv())) {
            result.setMessage("prod");
            result.setSuccess(true);
        }
        return result;
    }

    @Override
    public WorkEnum getWorkCode() {
        return WorkEnum.TEST_WORK;
    }

    @Override
    public String getFilterCondition() {
        return "\"1\"==\"1\"";
    }
}
