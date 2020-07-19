package com.shgx.factory.work;

import com.shgx.factory.engine.AssemblerService;
import com.shgx.factory.model.Request;
import com.shgx.factory.model.Result;
import com.shgx.factory.model.ResultContext;
import com.shgx.factory.model.ResultContextHolder;
import com.shgx.factory.util.TaskResultUtil;
import com.sun.javafx.binding.StringFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
@Slf4j
public abstract class AbstractWork implements Work, InitializingBean, ApplicationContextAware {

    protected ApplicationContext applicationContext;

    @Override
    public Result doTask(Request request) {
        Result result = TaskResultUtil.buildSuccessResult();
        ResultContext resultContext = ResultContextHolder.getResultContext();
        try {
            result = validate(request);
            if (!result.isSuccess()) {
                result = TaskResultUtil.buildFailedResult(resultContext.getErrorMsg());
            }
        } catch (Exception e) {
            log.error("任务执行异常", e);
        } finally {
            ResultContextHolder.clear();
            log.error(request.toString(), result, getWorkCode().getWorkCode());
        }
        return result;
    }

    /**
     * 验证任务是否执行成功
     * @param request
     * @return
     */
    protected abstract Result validate(Request request);

    @Override
    public void afterPropertiesSet() throws Exception {
        AssemblerService assemblerService = applicationContext.getBean("assemblerService", AssemblerService.class);

        synchronized (AssemblerService.class){
            boolean existWork = assemblerService.getWorkList().stream().anyMatch(work -> work.getWorkCode().equals(this.getWorkCode()));
            if(existWork){
                log.error(String.valueOf(StringFormatter.format("任务列表已经加载过， workCode={0}, 任务列表={1}", this.getWorkCode(), assemblerService.getWorkList())));
                throw new Exception("任务已经注入过");
            }
            if(this.getWorkCode() == null){
                log.error("任务code为空");
                throw new Exception("任务code为空");
            }
            assemblerService.getWorkList().add(this);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
