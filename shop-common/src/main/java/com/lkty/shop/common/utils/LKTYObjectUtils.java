package com.lkty.shop.common.utils;

import org.apache.commons.lang3.StringUtils;

public class LKTYObjectUtils {

    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static Boolean isBlank(Object obj) {
        if (null == obj) {
            return true;
        }
        // 处理字符串
        if (obj instanceof String) {
            String str = (String) obj;

            return StringUtils.isBlank(str);
        }
        return false;
    }
}
