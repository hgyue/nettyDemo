package com.nettyClientSocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientHandler extends SimpleChannelInboundHandler<String> {
	@Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {  
        System.out.println("�ͻ��˽��ܵ���Ϣ: " + msg);
    }

    //
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("��������... ");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("���ӹر�! ");
        super.channelInactive(ctx);
    }
}
