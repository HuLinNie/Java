package net.socket.talk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class TalkClient {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		Socket conn = null;
		try {
			// 通过地址与端口号，连接服务器
			conn = new Socket("127.0.0.1", 8999);
			// 启动键盘输入与信息发送线程
			OutputStream out_skt = conn.getOutputStream();
			Channel kb2skt = new Channel(System.in, out_skt,latch);
			kb2skt.setDaemon(true);
			kb2skt.start();
			

			// 启动socket读取 与 屏幕输出 线程
			InputStream in_skt = conn.getInputStream();
			Channel skt2sc = new Channel(in_skt, System.out,latch);
			skt2sc.start();
			
			latch.await();//主线程 等待两个子线程结束后才继续执行

		} catch (IOException|InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
