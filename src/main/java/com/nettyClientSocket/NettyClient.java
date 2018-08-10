package com.nettyClientSocket;

import java.io.IOException;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
	public static String host = "127.0.0.1"; // ip��ַ
	public static int port = 6789; // �˿�
	/// ͨ��nio��ʽ���������Ӻʹ�������
	private static EventLoopGroup group = new NioEventLoopGroup();
	private static Bootstrap b = new Bootstrap();
	private static Channel ch;

	/**
	 * Netty����ȫ������ʵ����AbstractBootstrap�� �ͻ��˵���Bootstrap������˵����� ServerBootstrap��
	 **/
	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("�ͻ��˳ɹ�����...");
		b.group(group);
		b.channel(NioSocketChannel.class);
		b.handler(new NettyClientFilter());
		// ���ӷ����
		ch = b.connect(host, port).sync().channel();
		star();
	}

	public static void star() throws IOException {
		String str = "Hello Netty����";
		ch.writeAndFlush(str + "\r\n");
		System.out.println("�ͻ��˷�������:" + str);
	}
}
