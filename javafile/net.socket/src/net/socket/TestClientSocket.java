package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClientSocket {

	public static void main(String[] args) 
			throws  IOException, InterruptedException {
		for(int i = 0 ; i < 10 ; i ++) {
			//通过地址与端口号，连接服务器
			Socket socketConn = new Socket("127.0.0.1",8999);
			//从连接中打开输入流（有如果需要向服务器发信息，则打开输出流）
			InputStream in = socketConn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			//读取数据，并处理
			String line = null;
			while((line = reader.readLine())!=null) 
				System.out.println(line);
			//关闭连接
			socketConn.close();
			//休眠2秒
			Thread.sleep(2000);
		}
	}
}


