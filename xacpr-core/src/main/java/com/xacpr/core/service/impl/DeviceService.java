package com.xacpr.core.service.impl;

import com.xacpr.core.service.IDeviceService;
import com.xacpr.core.service.handler.EchoSeverHandler;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Create by kangxiongwei on 2018/11/20 下午10:30
 */
@Service
public class DeviceService implements IDeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);

    @Override
    public void start(int port) throws IOException {
        // ** Acceptor设置
        NioDatagramAcceptor acceptor = new NioDatagramAcceptor();
        // 此行代码能让你的程序整体性能提升10倍 建立线程池
        acceptor.getFilterChain()
                .addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
        // 设置MINA2的IoHandler实现类
        acceptor.setHandler(new EchoSeverHandler());
        // 设置会话超时时间（单位：毫秒），不设置则默认是10秒，请按需设置
        //acceptor.setSessionRecycler(new ExpiringSessionRecycler(15 * 1000));

        // ** UDP通信配置
        DatagramSessionConfig dcfg = acceptor.getSessionConfig();
        // 设置每一个非主监听连接端口可以重用
        dcfg.setReuseAddress(true);
        // 设置输入缓冲区的大小，压力测试表明：调整到2048后性能反而降低
        dcfg.setReceiveBufferSize(1024);
        // 设置输出缓冲区的大小，压力测试表明：调整到2048后性能反而降低
        dcfg.setSendBufferSize(1024);

        // ** UDP服务端开始侦听
        acceptor.bind(new InetSocketAddress(port));

        LOGGER.info("[IMCORE]UDP服务器正在端口 8899 上监听中...");
    }


}
