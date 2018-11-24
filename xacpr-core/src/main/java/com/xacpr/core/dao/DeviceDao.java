package com.xacpr.core.dao;

import com.xacpr.core.model.DeviceModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 添加设备的数据库操作
 * Create by kangxiongwei on 2018/11/19 下午9:34
 */
@Repository
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

    /**
     * 查询总数量
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("select count(id) from t_device" +
            " where add_time >= #{startTime}" +
            " and add_time < #{endTime}")
    Long getDeviceTotal(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 查询数据明细
     *
     * @param startTime
     * @param endTime
     * @param index
     * @param pageSize
     * @return
     */
    @Select("select * from t_device" +
            " where add_time >= #{startTime}" +
            " and add_time < #{endTime}" +
            " limit #{index}, #{pageSize}")
    List<DeviceModel> findDeviceModel(@Param("startTime") String startTime, @Param("endTime") String endTime,
                                      @Param("index") Integer index, @Param("pageSize") Integer pageSize);
}
