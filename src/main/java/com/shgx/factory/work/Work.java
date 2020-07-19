package com.shgx.factory.work;

import com.shgx.factory.model.Request;
import com.shgx.factory.model.Result;
import com.shgx.factory.model.WorkEnum;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
public interface Work {
    /**
     * 执行任务
     *
     * @param request
     * @return
     */
    Result doTask(Request request);

    /**
     * 获取当然任务的code
     *
     * @return
     */
    WorkEnum getWorkCode();

    /**
     * 获取过滤条件
     *
     * @return
     */
    String getFilterCondition();

}
