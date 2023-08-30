package net.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TestServerSocket {
	public static void main(String[] args) {
		//使用端口号9999 创建ServerSocket
		try (ServerSocket server = new ServerSocket(8999)) {
			while (true) {
				System.out.println("waiting……");
				//等待客户端建立连接，如果无接入，则阻塞
				try (Socket conn = server.accept()) {
					//客户端接入后执行， 从连接得到输出流，准备向客户端发送信息
					Writer out = new OutputStreamWriter(conn.getOutputStream());
					LocalDateTime dt = LocalDateTime.now();
					//将本地时间发给客户端
					out.write(dt.toString() + "\r\n");
					out.flush();
					System.out.println("client had disconnected");
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

