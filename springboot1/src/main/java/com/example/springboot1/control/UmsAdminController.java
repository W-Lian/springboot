package com.example.springboot1.control;

import com.example.springboot1.common.annotation.Log;
import com.example.springboot1.common.api.CommonResult;
import com.example.springboot1.common.enums.BusinessType;
import com.example.springboot1.common.utils.JwtTokenUtil;
import com.example.springboot1.control.vo.UmsAdminLoginLogVO;
import com.example.springboot1.convert.UmsAdminLoginLogConvert;
import com.example.springboot1.model.UmsAdmin;
import com.example.springboot1.model.UmsAdminLoginLog;
import com.example.springboot1.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/user/operate")
@Slf4j
public class UmsAdminController {

    @Autowired
    UmsAdminService umsAdminService;
    
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    @Log(title = "注册", businessType = BusinessType.REGISTER)
    public CommonResult register(@RequestBody UmsAdmin umsAdminParam){
        return umsAdminService.register(umsAdminParam);
    }

    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdmin umsAdminParam){
        return umsAdminService.login(umsAdminParam);
    }

    @GetMapping("/getAdminByUsername")
    public CommonResult getAdminByUsername(@RequestBody UmsAdmin umsAdminParam){
        return CommonResult.success(umsAdminService.getAdminByUsername(umsAdminParam.getUsername()));
    }

    @PostMapping("/refreshToken")
    public String refreshToken(@RequestParam String token){
        return jwtTokenUtil.refreshToken(token);
    }

    

}
