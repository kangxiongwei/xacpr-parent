package com.xacpr.core.service;

import com.xacpr.core.model.DeviceModel;
import com.xacpr.core.model.PagerModel;
import com.xacpr.core.param.DeviceParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Create by kangxiongwei on 2018/11/24 下午1:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceTest {

    @Resource
    private IDeviceService deviceService;

    @Test
    public void testFind() {
        DeviceParam param = new DeviceParam();
        param.setStartTime("2018-11-01 00:00:00");
        param.setEndTime("2018-12-01 00:00:00");
        PagerModel<DeviceModel> model = this.deviceService.find(param);
        System.out.println(model);
    }

}
