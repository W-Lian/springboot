package com.example.springboot1.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/getTest")
@Slf4j
public class GetTest {
    
    @GetMapping("/test1")
    public String hello(@RequestParam String name){
        return "hello "+ name;
    }

    @GetMapping("test2")
    public void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession test2Session = req.getSession(true);
        log.info("test2Session id"+test2Session.getId());
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<br><a href="+ resp.encodeURL("test3")+">refresh</a>");
    }

    @GetMapping("test3")
    public void test3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession test3Session = req.getSession(true);
        log.info("test3Session id"+test3Session.getId());
        
    }
}
