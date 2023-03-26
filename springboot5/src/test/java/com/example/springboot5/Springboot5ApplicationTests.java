package com.example.springboot5;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot5ApplicationTests {

    private String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://127.0.0.1:8080/hello";

    private String DEFAULT_USER = "jamal";

    private String DEFAULT_PASS = "123456";

    @Test
    void contextLoads() {
    }

}
