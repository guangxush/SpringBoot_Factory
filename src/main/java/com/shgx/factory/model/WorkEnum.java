package com.shgx.factory.model;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
public enum WorkEnum {

    /**
     * 测试任务
     */
    TEST_WORK("test", "test", "test"),

    /**
     * 正式任务
     */
    PROD_WORK("prod", "prod", "prod");

    /**
     * work编码
     */
    private String workCode;

    /**
     * work名称
     */
    private String workName;

    /**
     * work描述
     */
    private String workDescription;

    WorkEnum(String workCode, String workName, String workDescription) {
        this.workCode = workCode;
        this.workName = workName;
        this.workDescription = workDescription;
    }

    public String getCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }
}
