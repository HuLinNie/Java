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
			//ͨ����ַ��˿ںţ����ӷ�����
			Socket socketConn = new Socket("127.0.0.1",8999);
			//�������д����������������Ҫ�����������Ϣ������������
			InputStream in = socketConn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			//��ȡ���ݣ�������
			String line = null;
			while((line = reader.readLine())!=null) 
				System.out.println(line);
			//�ر�����
			socketConn.close();
			//����2��
			Thread.sleep(2000);
		}
	}
}


