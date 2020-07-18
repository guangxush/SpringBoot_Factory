package com.shgx.factory;

import com.shgx.factory.model.Request;
import com.shgx.factory.work.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryApplication.class, args);
//        Request request = new Request();
//        request.setEnv("prod");
//        request.setId(123456L);
//        request.setName("hello");
//        request.setType("world");
    }

}
