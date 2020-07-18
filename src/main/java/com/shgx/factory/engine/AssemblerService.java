package com.shgx.factory.engine;

import com.shgx.factory.model.Request;
import com.shgx.factory.util.JexlUtils;
import com.shgx.factory.work.Work;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
@Slf4j
@Service
public class AssemblerService {

    /**
     * 任务列表
     */
    private List<Work> workList = new LinkedList<>();

    public List<Work> getWorkList() {
        return workList;
    }

    public List<Work> assemble(Request request){
        List<Work> doWorkList = new LinkedList<>();

        JexlContext context = toJexlContent(request);
        for(Work work:workList){
            if(parseValue(work.getFilterCondition(), context)){
                doWorkList.add(work);
            }
        }
        return doWorkList;
    }

    private JexlContext toJexlContent(Request request){
        JexlContext context = new MapContext();
        context.set("taskType", request.getType());
        return context;
    }

    private boolean parseValue(String express, JexlContext jexlContext){
        try{
            if(StringUtils.isEmpty(express)){
                return false;
            }
            return JexlUtils.executeBoolean(express, jexlContext);
        }catch (Exception e){
            log.error("jexl表示解释错误",e);
            return false;
        }
    }
}
