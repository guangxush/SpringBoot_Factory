package com.shgx.factory.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
@Slf4j
public class ResultContextHolder {
    private static ThreadLocal<ResultContext> threadLocal = new ThreadLocal<>();

    public static ResultContext get() {
        return threadLocal.get();
    }

    public static ThreadLocal<ResultContext> getThreadLocal() {
        return threadLocal;
    }

    public static void setThreadLocal(ThreadLocal<ResultContext> threadLocal) {
        ResultContextHolder.threadLocal = threadLocal;
    }

    public static void clear() {
        try {
            threadLocal.remove();
        } catch (Exception e) {
            log.error("上下文变量清理失败", e);
        } finally {
            threadLocal.set(null);
        }
    }
}
