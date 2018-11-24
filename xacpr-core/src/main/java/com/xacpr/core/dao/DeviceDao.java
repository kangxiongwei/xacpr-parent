package com.xacpr.core.dao;

import com.xacpr.core.model.DeviceModel;
import org.apache.ibatis.annotations.Insert;

/**
 * 添加设备的数据库操作
 * Create by kangxiongwei on 2018/11/19 下午9:34
 */
public interface DeviceDao {

    String COLUMNS = "device_id, client_ip, server_ip, voltage_value, signal_value, " +
            "battery_value, exception, valid, report_time, add_time";

    /**
     * 添加数据到数据库
     *
     * @param device
     * @return
     */
    @Insert("insert into t_device" +
            " (" + COLUMNS + ")" +
            " values" +
            " (#{deviceId}, #{clientIp}, #{serverIp}, #{voltageValue}, #{signalValue}," +
            " #{batteryValue}, #{exception}, #{valid}, #{reportTime}, #{addTime})")
    int insert(DeviceModel device);


}
