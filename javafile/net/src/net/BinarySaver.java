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
		//获取连接对象的内容长度
		int contentLength = uc.getContentLength();
		//使用带资源的try语句，让流自动关闭
		try (InputStream raw = uc.getInputStream()) {
			InputStream in = new BufferedInputStream(raw);
			//创建byte数组，存储读取到的数据
			byte[] data = new byte[contentLength];
			int offset = 0;
			while (offset < contentLength) {
				//尝试 读取data.length-offset 个字节，并存入从offset开始的位置
				//bytesRead为实际读取的字节数量
				int bytesRead = in.read(data, offset, data.length - offset);
				//bytesRead==-1，已到流的结尾，读取结束
				if (bytesRead == -1)
					break;
				//将偏移后移bytesRead，转到in.read 继续读取后续内容
				offset += bytesRead;
			}
			//未能读取到全部流内数据，抛出异常
			if (offset != contentLength) {
				throw new IOException("Only read " + 
						offset + " bytes; Expected " + contentLength + " bytes");
			}
			//获取文件路径及名称
			String filename = u.getFile();
			//去掉路径，只保留文件名
			filename = filename.substring(filename.lastIndexOf('/') + 1);
			//写入磁盘（程序运行目录）
			try (FileOutputStream fo = new FileOutputStream(filename)) {
				fo.write(data);
				fo.flush();
			}
		}
	}
}


