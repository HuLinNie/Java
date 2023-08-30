package net;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class BinarySaver1 {

	public static void main(String[] args) throws IOException {
		URL u = new URL("http://www.lolcats.com/images/logo.png");

		URLConnection uc = u.openConnection();
		String contentType = uc.getContentType();
		int contentLength = uc.getContentLength();
		if (contentType.startsWith("text/") || contentLength == -1) {
			throw new IOException("Not a binary file!");
		}
		
		try (InputStream raw = uc.getInputStream()) {
			InputStream in = new BufferedInputStream(raw);
			byte[] data = new byte[contentLength];
			int offset = 0;
			while (offset < contentLength) {
				int bytesRead = in.read(data, offset, data.length - offset);
				if (bytesRead == -1)
					break;
				offset += bytesRead;
			}
			if (offset != contentLength) {
				throw new IOException("Only read " + 
						offset + " bytes; Expected " + contentLength + " bytes");
			}
			
			String filename = u.getFile();
			filename = filename.substring(filename.lastIndexOf('/') + 1);
			try (FileOutputStream fo = new FileOutputStream(filename)) {
				fo.write(data);
				fo.flush();
			}
		}
	}
}
