package com.shgx.factory.engine;

import com.shgx.factory.model.Request;
import com.shgx.factory.model.Result;

/**
 * 核心引擎
 *
 * @author: guangxush
 * @create: 2020/07/18
 */
public interface CoreEngine {

    Result execute(Request request);
}
