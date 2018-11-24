package com.xacpr.core.dao;

import com.xacpr.core.model.DeviceModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Create by kangxiongwei on 2018/11/19 下午10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceDaoTest {

    @Resource
    private DeviceDao deviceDao;

    @Test
    public void testInsert() {
        DeviceModel model = new DeviceModel();
        model.setDeviceId("987654321");
        model.setClientIp("2.2.2.2:65523");
        model.setServerIp("1.1.1.1:12");
        model.setVoltageValue(4.24);
        model.setSignalValue("099");
        model.setBatteryValue(3.57);
        model.setException("345");
        model.setValid("62");
        model.setReportTime("20181130999");
        model.setAddTime(new Date());
        int rows = this.deviceDao.insert(model);
        System.out.println("插入" + rows + "条记录");
    }

}
