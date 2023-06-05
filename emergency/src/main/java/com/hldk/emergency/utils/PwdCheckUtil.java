package com.hldk.emergency.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mq
 * @date 2022/10/20
 */
public class PwdCheckUtil {


    //定义特殊字符
    public static String SPECIAL_CHAR = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    /**
     * @return 符合长度要求 返回true
     * @brief 检测密码中字符长度
     * @param[in] password            密码字符串
     */
    public static boolean checkPasswordLength(String password, String minNum, String maxNum) {
        boolean flag = false;
        if (StringUtils.isBlank(maxNum)) {
            minNum = StringUtils.isBlank(minNum) ? "0" : minNum;
            if (password.length() >= Integer.parseInt(minNum)) {
                flag = true;
            }
        } else {
            minNum = StringUtils.isBlank(minNum) ? "0" : minNum;
            if (password.length() >= Integer.parseInt(minNum) &&
                    password.length() <= Integer.parseInt(maxNum)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * @return 包含数字 返回true
     * @brief 检测密码中是否包含数字
     * @param[in] password            密码字符串
     */
    public static boolean checkContainDigit(String password) {
        char[] chPass = password.toCharArray();
        for (int i = 0; i < chPass.length; i++) {
            if (Character.isDigit(chPass[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return 包含字母 返回true
     * @brief 检测密码中是否包含字母（不区分大小写）
     * @param[in] password            密码字符串
     */
    public static boolean checkContainCase(String password) {
        char[] chPass = password.toCharArray();
        for (int i = 0; i < chPass.length; i++) {
            if (Character.isLetter(chPass[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * @return 包含小写字母 返回true
     * @brief 检测密码中是否包含小写字母
     * @param[in] password            密码字符串
     */
    public static boolean checkContainLowerCase(String password) {
        char[] chPass = password.toCharArray();
        for (int i = 0; i < chPass.length; i++) {
            if (Character.isLowerCase(chPass[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * @return 包含大写字母 返回true
     * @brief 检测密码中是否包含大写字母
     * @param[in] password            密码字符串
     */
    public static boolean checkContainUpperCase(String password) {
        char[] chPass = password.toCharArray();
        for (int i = 0; i < chPass.length; i++) {
            if (Character.isUpperCase(chPass[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * @return 包含特殊符号 返回true
     * @brief 检测密码中是否包含特殊符号
     * @param[in] password            密码字符串
     */
    public static boolean checkContainSpecialChar(String password) {
        char[] chPass = password.toCharArray();
        for (int i = 0; i < chPass.length; i++) {
            if (SPECIAL_CHAR.indexOf(chPass[i]) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return 符合长度要求 返回true
     * @brief 检测密码复杂度是否为 强
     * @param[in] password  密码字符串
     */
    public static boolean checkStrongPwd(String pwd) {
        return (!PwdCheckUtil.checkPasswordLength(pwd, "8", null)
                || !PwdCheckUtil.checkContainCase(pwd)
                || !PwdCheckUtil.checkContainDigit(pwd)
                || !PwdCheckUtil.checkContainSpecialChar(pwd)
        );
    }

}
