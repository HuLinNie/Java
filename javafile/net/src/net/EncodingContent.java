package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class EncodingContent {
	public static void main(String[] args) throws IOException {
		URL u = new URL("http://mail.neuq.edu.cn");
		URLConnection uc = u.openConnection();
		String contentType = uc.getContentType();
		String encoding = getEncoding(contentType);
		Reader reader = new InputStreamReader(uc.getInputStream(), encoding);
		BufferedReader r = new BufferedReader(reader);
		String line;
		while ((line = r.readLine()) != null)
			System.out.println(line);
		r.close();
	}

	private static String getEncoding(String contentType) {
		int encodingStart = contentType.indexOf("charset=");
		if (encodingStart != -1) {
			return contentType.substring(encodingStart + 8);
		}
		return "ISO-8859-1";// 设置默认编码，没从头信息获取编码时使用
	}
}
