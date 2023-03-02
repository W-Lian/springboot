package com.example.springboot1.control;

import com.example.springboot1.common.api.CommonResult;
import com.example.springboot1.control.vo.UmsAdminLoginLogVO;
import com.example.springboot1.convert.UmsAdminLoginLogConvert;
import com.example.springboot1.model.UmsAdminLoginLog;
import com.example.springboot1.service.UmsAdminLoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/loginLog")
@Slf4j
public class UmsAdminLoginLogController {

    @Resource
    UmsAdminLoginLogService umsAdminLoginLogService;

    @PostMapping("/convert")
    public CommonResult refreshToken(@RequestBody UmsAdminLoginLogVO param) {

        UmsAdminLoginLog umsAdminLoginLog = UmsAdminLoginLogConvert.INSTANCE.convert(param);
        umsAdminLoginLog.setId(111L);

        return CommonResult.success(umsAdminLoginLog);
    }


    @PostMapping("/umsAdminLogin/{id}")
    public CommonResult refreshToken(@PathVariable Long id) {
        UmsAdminLoginLog umsAdminLoginLog = umsAdminLoginLogService.getAdminLoginLogById(id);

        return CommonResult.success(umsAdminLoginLog);
    }

}
