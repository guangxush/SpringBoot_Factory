package com.shgx.factory.model;

/**
 * 引擎执行返回值
 *
 * @author: guangxush
 * @create: 2020/07/18
 */
public class Result {

    /**
     * 执行结果
     */
    private boolean isSuccess;

    /**
     * 返回消息
     */
    private String message;


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isSuccess=" + isSuccess +
                ", message='" + message + '\'' +
                '}';
    }
}
