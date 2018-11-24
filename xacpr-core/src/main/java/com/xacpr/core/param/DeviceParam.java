package com.xacpr.core.param;

/**
 * Create by kangxiongwei on 2018/11/24 下午1:18
 */
public class DeviceParam extends PagerParam {

    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DeviceParam{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                "} " + super.toString();
    }
}
