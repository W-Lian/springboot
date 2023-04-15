package com.example.springboot1.control;

import com.example.springboot1.factory.chain.case1.common.ProductService;
import com.example.springboot1.factory.chain.case1.common.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/chainTest")
@Slf4j
public class ChainTest {
    
    @Resource
    ProductService productService;
    
    @GetMapping("/test1")
    public String hello(){
        ProductVO param = ProductVO.builder()
                .skuId(123L)
                .skuName("测试商品")
                .imgPath("http://..")
                .price(new BigDecimal(1))
                .stock(1)
                .build();
        productService.createProduct(param);
        return "success";
    }

    public static void main(String[] args) {
        List<String> nameInfo = new ArrayList<>();
        nameInfo.add("张三");
        nameInfo.add("李斯");
        nameInfo.add("王二");
        nameInfo.add("胡非");
        /********************************************/
        List<String> userName=new ArrayList<>();
        userName.add("张非");
        userName.add("李斯");
        userName.add("王非");
        userName.add("郑非");
//        userName.contains();
        List<String> info = nameInfo.stream()
                .filter(userName::contains)
                .collect(toList());
        
        System.out.println("两个集合的差集："+nameInfo.removeAll(userName));
        System.out.println("nameInfo："+nameInfo);
        System.out.println("两个集合的交集："+info);
    }

  
}
