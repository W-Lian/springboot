package com.example.springboot5.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping
@Slf4j
public class LoginTest {

    @RequestMapping(path = "/hello")
    public String hello() {
        return "验证通过";
    }
}
