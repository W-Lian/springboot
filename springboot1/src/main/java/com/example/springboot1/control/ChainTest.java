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

  
}
