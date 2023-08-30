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
			// ͨ����ַ��˿ںţ����ӷ�����
			conn = new Socket("127.0.0.1", 8999);
			// ����������������Ϣ�����߳�
			OutputStream out_skt = conn.getOutputStream();
			Channel kb2skt = new Channel(System.in, out_skt,latch);
			kb2skt.setDaemon(true);
			kb2skt.start();
			

			// ����socket��ȡ �� ��Ļ��� �߳�
			InputStream in_skt = conn.getInputStream();
			Channel skt2sc = new Channel(in_skt, System.out,latch);
			skt2sc.start();
			
			latch.await();//���߳� �ȴ��������߳̽�����ż���ִ��

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
