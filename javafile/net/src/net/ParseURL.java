package net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.net.MalformedURLException;
import java.net.URL;

public class ParseURL {
	public static void main(String [] args) throws IOException {
		URL aurl = new URL("https://mp.weixin.qq.com/s/gfiakFFRc6oKpsnFVr_uEg");
//		URL aurl=new URL("https://www.eyepetizer.net/detail.html?vid=179389&utm_campaign=routine&utm_medium=share&utm_source=others&uid=302931074&resourceType=video&udid=471b8fb4cad54eb1b6fd554c8b68274654565af7&vc=561&vn=5.10.1&size=1080X1920&deviceModel=vivo%20X9Plus%20L&first_channel=eyepetizer_vivo_market&last_channel=eyepetizer_vivo_market&system_version_code=25");
//		System.out.println("protocal= "+ aurl.getProtocol());
//		System.out.println("authority= "+ aurl.getAuthority());
//		System.out.println("host= "+ aurl.getHost());
//		System.out.println("port= "+ aurl.getPort());
//		System.out.println("path= "+ aurl.getPath());
//		System.out.println("query= "+ aurl.getQuery());
//		System.out.println("filename= "+ aurl.getFile());
//		System.out.println("ref= "+ aurl.getRef());
		try(InputStream in=aurl.openStream()) {
			int c;
			FileOutputStream fos=new FileOutputStream("C:\\Users\\harry\\Desktop\\nnnnnn.txt");	
			while((c=in.read())!=-1)
				fos.write(c);	
			fos.close();
			
		}catch(IOException e) {
			System.out.println("Ò»²è¹Ý");
			e.printStackTrace();
		}
		
	}

}
