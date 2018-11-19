package com.zhx.demo.model;

import java.util.Date;

/**
 * Create by kangxiongwei on 2018/11/19 下午9:23
 */
public class DeviceModel {

    private Long id;
    private String deviceId;        //设备标识
    private String clientIp;        //本地IP端口
    private String serverIp;        //转发IP端口
    private Double voltageValue;    //电压
    private String signalValue;     //信号
    private Double batteryValue;    //电池
    private String exception;       //异常
    private String valid;           //校验
    private String reportTime;      //上报时间
    private Date addTime;           //数据库数据生成时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public Double getVoltageValue() {
        return voltageValue;
    }

    public void setVoltageValue(Double voltageValue) {
        this.voltageValue = voltageValue;
    }

    public String getSignalValue() {
        return signalValue;
    }

    public void setSignalValue(String signalValue) {
        this.signalValue = signalValue;
    }

    public Double getBatteryValue() {
        return batteryValue;
    }

    public void setBatteryValue(Double batteryValue) {
        this.batteryValue = batteryValue;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "DeviceModel{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", serverIp='" + serverIp + '\'' +
                ", voltageValue=" + voltageValue +
                ", signalValue='" + signalValue + '\'' +
                ", batteryValue=" + batteryValue +
                ", exception='" + exception + '\'' +
                ", valid='" + valid + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}
