package com.nettyServerSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
	static int i = 0;
	private static final int port = 6789; // ���÷���˶˿�
	private static EventLoopGroup group = new NioEventLoopGroup(); // ͨ��nio��ʽ���������Ӻʹ�������
	private static ServerBootstrap b = new ServerBootstrap();

	/**
	 * Netty����ȫ������ʵ����AbstractBootstrap�� �ͻ��˵���Bootstrap������˵����� ServerBootstrap��
	 **/
	public static void main(String[] args) throws InterruptedException {
		System.out.println("��" + (++i) + "̨�ͻ���");
		try {
			b.group(group);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new NettyServerFilter()); // ���ù�����
			// �������󶨶˿ڼ���
			ChannelFuture f = b.bind(port).sync();
			System.out.println("����������ɹ�...");
			// �����������رռ���
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully(); //// �ر�EventLoopGroup���ͷŵ�������Դ�����������߳�
		}
	}
}
