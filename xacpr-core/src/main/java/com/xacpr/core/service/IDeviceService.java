package com.xacpr.core.service;

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

}
