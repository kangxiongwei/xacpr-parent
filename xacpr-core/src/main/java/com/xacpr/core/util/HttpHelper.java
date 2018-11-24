package com.xacpr.core.util;

import com.xacpr.core.enums.HttpCodeEnum;
import com.xacpr.core.model.HttpBaseModel;
import org.springframework.util.StringUtils;

/**
 * Create by kangxiongwei on 2018/11/24 下午1:26
 */
public class HttpHelper {

    /**
     * 构建http返回结果
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static HttpBaseModel buildHttpModel(HttpCodeEnum code, String message, Object data) {
        HttpBaseModel httpBaseModel = new HttpBaseModel();
        httpBaseModel.setCode(code.getCode());
        httpBaseModel.setMessage(StringUtils.isEmpty(message) ? code.getMessage() : message);
        httpBaseModel.setData(data);
        return httpBaseModel;
    }


}
