package net.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TestServerSocket {
	public static void main(String[] args) {
		//ʹ�ö˿ں�9999 ����ServerSocket
		try (ServerSocket server = new ServerSocket(8999)) {
			while (true) {
				System.out.println("waiting����");
				//�ȴ��ͻ��˽������ӣ�����޽��룬������
				try (Socket conn = server.accept()) {
					//�ͻ��˽����ִ�У� �����ӵõ��������׼����ͻ��˷�����Ϣ
					Writer out = new OutputStreamWriter(conn.getOutputStream());
					LocalDateTime dt = LocalDateTime.now();
					//������ʱ�䷢���ͻ���
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

