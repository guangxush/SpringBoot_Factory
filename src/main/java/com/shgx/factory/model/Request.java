package com.shgx.factory.model;

/**
 * @author: guangxush
 * @create: 2020/07/18
 */
public class Request {

    private long id;

    private String name;

    private String env;

    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", env='" + env + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
