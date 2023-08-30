package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestURLConnection {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://mail.neuq.edu.cn");
			URLConnection uc = u.openConnection();
			try(InputStream in = uc.getInputStream())
			{
				int c ;
				while((c=in.read())!=-1) System.out.write(c);
			}//end try, no catch
		}catch(IOException ex) {
		}
	}
}


