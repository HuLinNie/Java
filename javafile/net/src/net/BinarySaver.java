package net;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class BinarySaver {

	public static void main(String[] args) throws IOException {
		URL u = new URL("http://www.lolcats.com/images/logo.png");
		
		URLConnection uc = u.openConnection();
		//��ȡ���Ӷ�������ݳ���
		int contentLength = uc.getContentLength();
		//ʹ�ô���Դ��try��䣬�����Զ��ر�
		try (InputStream raw = uc.getInputStream()) {
			InputStream in = new BufferedInputStream(raw);
			//����byte���飬�洢��ȡ��������
			byte[] data = new byte[contentLength];
			int offset = 0;
			while (offset < contentLength) {
				//���� ��ȡdata.length-offset ���ֽڣ��������offset��ʼ��λ��
				//bytesReadΪʵ�ʶ�ȡ���ֽ�����
				int bytesRead = in.read(data, offset, data.length - offset);
				//bytesRead==-1���ѵ����Ľ�β����ȡ����
				if (bytesRead == -1)
					break;
				//��ƫ�ƺ���bytesRead��ת��in.read ������ȡ��������
				offset += bytesRead;
			}
			//δ�ܶ�ȡ��ȫ���������ݣ��׳��쳣
			if (offset != contentLength) {
				throw new IOException("Only read " + 
						offset + " bytes; Expected " + contentLength + " bytes");
			}
			//��ȡ�ļ�·��������
			String filename = u.getFile();
			//ȥ��·����ֻ�����ļ���
			filename = filename.substring(filename.lastIndexOf('/') + 1);
			//д����̣���������Ŀ¼��
			try (FileOutputStream fo = new FileOutputStream(filename)) {
				fo.write(data);
				fo.flush();
			}
		}
	}
}


