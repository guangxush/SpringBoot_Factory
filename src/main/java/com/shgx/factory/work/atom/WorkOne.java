package com.shgx.factory.work.atom;

import com.shgx.factory.model.Request;
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
    protected boolean validate(Request request) {
        if ("prod".equals(request.getEnv())) {
            return true;
        }
        return false;
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
