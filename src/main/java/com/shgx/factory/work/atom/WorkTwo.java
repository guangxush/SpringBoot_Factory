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
public class WorkTwo extends AbstractWork {
    @Override
    protected boolean validate(Request request) {
        if(request.getId() > 100L){
            return false;
        }
        return true;
    }

    @Override
    public WorkEnum getWorkCode() {
        return WorkEnum.PROD_WORK;
    }

    @Override
    public String getFilterCondition() {
        return "\"1\"==\"2\"";
    }
}
