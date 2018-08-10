package com.nettyServerSocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServerFilter extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline ph = ch.pipeline();
		// ��("\n")Ϊ��β�ָ�� ������
		ph.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		// ����ͱ��룬Ӧ�Ϳͻ���һ��
		ph.addLast("decoder", new StringDecoder());
		ph.addLast("encoder", new StringEncoder());
		ph.addLast("handler", new NettyServerHandler());// �����ҵ���߼�
	}
}
