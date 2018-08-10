package com.nettyServerSocket;

import java.net.InetAddress;
import java.util.Date;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServerHandler extends SimpleChannelInboundHandler<String> {
	/*
	 * �յ���Ϣʱ��������Ϣ
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// �յ���Ϣֱ�Ӵ�ӡ���
		System.out.println("����˽��ܵ���Ϣ : " + msg);
		if ("quit".equals(msg)) {// ����˶Ͽ�������
			ctx.close();
		}
		Date date = new Date();
		// ���ؿͻ�����Ϣ
		ctx.writeAndFlush(date + "\n");
	}

	/*
	 * ��������ʱ��������Ϣ
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("���ӵĿͻ��˵�ַ:" + ctx.channel().remoteAddress());
		ctx.writeAndFlush("�ͻ���" + InetAddress.getLocalHost().getHostName() + "�ɹ������˽������ӣ� \n");
		super.channelActive(ctx);
	}
}
