package com.xacpr.core.service;

import com.xacpr.core.model.DeviceModel;
import com.xacpr.core.model.PagerModel;
import com.xacpr.core.param.DeviceParam;

import java.io.IOException;

/**
 * Create by kangxiongwei on 2018/11/20 下午10:36
 */
public interface IDeviceService {

    /**
     * 启动监听UDP协议传输的数据
     *
     * @param port
     */
    void start(int port) throws IOException;

    /**
     * 根据实际范围分页查询设备上报的信息
     *
     * @param param
     * @return
     */
    PagerModel<DeviceModel> find(DeviceParam param);


}
