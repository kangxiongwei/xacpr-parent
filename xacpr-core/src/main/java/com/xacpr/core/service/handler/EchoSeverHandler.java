package com.xacpr.core.service.handler;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhanghuaxin on 2018/11/12.
 */
public class EchoSeverHandler extends IoHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(EchoSeverHandler.class);
    public static final CharsetDecoder decoder = (Charset.forName("UTF-8")).newDecoder();


    // 抛出异常触发的事件
    @Override
    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {
        logger.error("[IMCORE]exceptionCaught捕获到错了，原因是："+throwable.getMessage(), throwable);
        ioSession.close(true);
    }

    // Server接收UDP请求触发事件
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        //*********************************************** 接收数据
        // 读取收到的数据
        IoBuffer buffer = (IoBuffer) message;
        String body = buffer.getString(decoder) + ":" + reFormatNowDate();
//        body = body + reFormatNowDate();
        // 注意：当客户使用不依赖于MINA库的情况下，以下官方推
        // 荐的读取方法会在数据首部出现几个字节的未知乱码
        // message.toString()

        logger.debug("【NOTE】>>>>>> 收到客户端的数据：" + body);

        writeToText(body);

    }

    private void writeToText(String body) throws IOException {
        body = body + '\n';
        FileOutputStream fos = new FileOutputStream("/root/data.txt",true);
        FileChannel fc = fos.getChannel();
        byte[] datas = body.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        buffer.put(datas);
        buffer.flip();
        fc.write(buffer);
        //buffer.clear();

        fc.close();
        fos.flush();
        fos.close();
    }

    // 建立关闭事件
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("session close ");
    }

    // 建立接触事件
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("Session created...");
        SocketAddress remoteAddress = session.getRemoteAddress();
        System.out.println(remoteAddress);
    }
    // 会话空闲
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("Session idle...");
    }

    public String reFormatNowDate() {
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat();
        return sdFormatter.format(nowTime);
    }

}
