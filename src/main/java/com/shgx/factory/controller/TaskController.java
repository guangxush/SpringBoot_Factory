package com.shgx.factory.controller;


import com.shgx.factory.engine.CoreEngine;
import com.shgx.factory.model.Request;
import com.shgx.factory.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: guangxush
 * @create: 2020/07/19
 */

@RestController
public class TaskController {

    @Autowired
    private CoreEngine coreEngine;

    @PostMapping("/dotask")
    @ResponseBody()
    public Result doTask(@RequestBody Request request) {
        Result result = coreEngine.execute(request);
        return result;
    }
}
