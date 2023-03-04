package com.example.springboot1.common.utils;

import cn.hutool.core.convert.Convert;
import com.example.springboot1.model.UmsAdmin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 安全服务工具类
 * 
 * @author ruoyi
 */
@Component
public class SecurityUtils {

    /**
     * 获取用户
     **/
//    public static UmsAdmin getLoginUser() {
    public static String getLoginUser() {
        try {
            //TODO 暂时登录后内存中只存了名字，后续优化存用户对象
//            if(null != getAuthentication()){
//                if(getAuthentication().getPrincipal() instanceof UmsAdmin){
//                    return (UmsAdmin) getAuthentication().getPrincipal();
//                }
//            }

            if(null != getAuthentication()){
                    return (String) getAuthentication().getPrincipal();
            }
            
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息异常");
        }
        return null;
    }

//    public static String getBusinessLicense() {
//        YdtbLoginUser loginUser = getLoginUser();
//        if(null == loginUser){
//            return null;
//        }
//        if(loginUser.getUserType().equals(UserTypeEnum.ENTERPRISE.getCode())){
//            return loginUser.getEnterpriseInfo().getBusinessImgUrl();
//        }
//        return null;
//    }

//    public static String getEntSignatureImg() {
//        YdtbLoginUser loginUser = getLoginUser();
//        if(null == loginUser){
//            return null;
//        }
//        if(loginUser.getUserType().equals(UserTypeEnum.ENTERPRISE.getCode())){
//            return loginUser.getEnterpriseInfo().getEntSignatureImgUrl();
//        }
//        return null;
//    }


    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public static void main(String[] args) {
        System.out.println(Convert.digitToChinese(1508155000));
    }
}
