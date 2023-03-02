package com.example.springboot1.convert;

import com.example.springboot1.control.vo.UmsAdminLoginLogVO;
import com.example.springboot1.model.UmsAdminLoginLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UmsAdminLoginLogConvert {

    UmsAdminLoginLogConvert INSTANCE = Mappers.getMapper(UmsAdminLoginLogConvert.class);

    UmsAdminLoginLog convert(UmsAdminLoginLogVO param);
}
