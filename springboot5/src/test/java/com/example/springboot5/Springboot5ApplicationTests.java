package com.example.springboot5;

import com.sun.deploy.net.HttpResponse;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.net.www.http.HttpClient;

@SpringBootTest
class Springboot5ApplicationTests {

    private String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://127.0.0.1:8080/hello";

    private String DEFAULT_USER = "jamal";

    private String DEFAULT_PASS = "123456";

    @Test
    void contextLoads() {

        // 创建用户信息
//        CredentialsProvider provider = new BasicCredentialsProvider();
//        UsernamePasswordCredentials credentials
//                = new UsernamePasswordCredentials(DEFAULT_USER, DEFAULT_PASS);
//        provider.setCredentials(AuthScope.ANY, credentials);
//
//        // 创建客户端的时候进行身份验证
//        HttpClient client = HttpClientBuilder.create()
//                .setDefaultCredentialsProvider(provider)
//                .build();
//
//        HttpResponse response = client.execute(
//                new HttpGet(URL_SECURED_BY_BASIC_AUTHENTICATION));
//        int statusCode = response.getStatusLine()
//                .getStatusCode();
//        Assert.assertEquals(statusCode,200);
    }

}
