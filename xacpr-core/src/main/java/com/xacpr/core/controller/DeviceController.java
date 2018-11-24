package com.xacpr.core.controller;

import com.xacpr.core.enums.HttpCodeEnum;
import com.xacpr.core.model.DeviceModel;
import com.xacpr.core.model.HttpBaseModel;
import com.xacpr.core.model.PagerModel;
import com.xacpr.core.param.DeviceParam;
import com.xacpr.core.service.IDeviceService;
import com.xacpr.core.util.HttpHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Create by kangxiongwei on 2018/11/24 下午12:20
 */
@RestController
@CrossOrigin
@RequestMapping("/cpr/device")
public class DeviceController {

    @Resource
    private IDeviceService deviceService;

    /**
     * 分页查询设备信息
     *
     * @return
     */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public HttpBaseModel findDeviceModel(@RequestBody DeviceParam param) {
        try {
            PagerModel<DeviceModel> model = deviceService.find(param);
            return HttpHelper.buildHttpModel(HttpCodeEnum.SUCCESS, null, model);
        } catch (Exception e) {
            return HttpHelper.buildHttpModel(HttpCodeEnum.ERROR, e.getMessage(), null);
        }
    }


}
