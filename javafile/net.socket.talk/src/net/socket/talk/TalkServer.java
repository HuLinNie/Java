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
		try {// ʹ�ö˿ں�8999 ����ServerSocket
			server = new ServerSocket(8999);
			// �ȴ��ͻ��˽������ӣ�����޽��룬������
			Socket conn = server.accept();

			// ����������������Ϣ�����߳�
			OutputStream out_skt = conn.getOutputStream();
			Channel kb2skt = new Channel(System.in, out_skt,latch);
			kb2skt.setDaemon(true);
			kb2skt.start();

			// ����socket��ȡ �� ��Ļ��� �߳�
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
