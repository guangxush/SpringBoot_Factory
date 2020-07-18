package com.shgx.factory.engine;

import com.shgx.factory.model.Request;
import com.shgx.factory.model.Result;
import com.shgx.factory.util.TaskResultUtil;
import com.shgx.factory.work.Work;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
@Slf4j
@Service
public class CoreEngineImpl implements CoreEngine {

    @Autowired
    private AssemblerService assemblerService;

    @Override
    public Result execute(Request request) {
        if (request == null) {
            return TaskResultUtil.buildSuccessResult();
        }
        log.info("开始执行任务");
        List<Work> workList = assemblerService.assemble(request);

        if (CollectionUtils.isEmpty(workList)) {
            log.warn("当前没有要执行的任务");
        }
        Result result = TaskResultUtil.buildSuccessResult();
        Map<String, String> ruleMap = new HashMap<>(2);
        try {
            if (!CollectionUtils.isEmpty(workList)) {
                for (Work work : workList) {
                    Result workResult = work.doTask(request);
                    if (workResult.isSuccess()) {
                        result.setSuccess(true);
                    }
                    result.setMessage(result.getMessage() + "," + workResult.getMessage());
                    ruleMap.put(work.getWorkCode().getWorkCode(), workResult.toString());
                }
            }
            return result;
        } catch (Exception e) {
            log.error("引擎执行异常");
            return result;
        } finally {
            if (CollectionUtils.isEmpty(workList)) {
                log.info("任务未执行");
            } else {
                String loadWorks = workList.stream().map(w -> w.getWorkCode().getWorkCode()).collect(Collectors.joining(","));
                log.info("以上任务已经执行" + loadWorks);
            }
        }
    }
}
