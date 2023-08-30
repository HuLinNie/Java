package net.socket.talk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class TalkServer {
	public static void main(String[] args) {
		  CountDownLatch latch = new CountDownLatch(2);
		
		ServerSocket server = null;
		try {// 使用端口号8999 创建ServerSocket
			server = new ServerSocket(8999);
			// 等待客户端建立连接，如果无接入，则阻塞
			Socket conn = server.accept();

			// 启动键盘输入与信息发送线程
			OutputStream out_skt = conn.getOutputStream();
			Channel kb2skt = new Channel(System.in, out_skt,latch);
			kb2skt.setDaemon(true);
			kb2skt.start();

			// 启动socket读取 与 屏幕输出 线程
			InputStream in_skt = conn.getInputStream();
			Channel skt2sc = new Channel(in_skt, System.out,latch);
			skt2sc.start();
			
			//skt2sc.join();
			latch.await();

		} catch (IOException|InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
