package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

public class WriteToURL {

	public static void main(String[] args) throws IOException {
		URL u = new URL("http://localhost:8080/Web192001/ResponseServlet");
		URLConnection uc = u.openConnection();
		uc.setDoOutput(true);
		
		try(Writer out = new OutputStreamWriter(uc.getOutputStream(),"UTF-8")){
			QueryString qs = new QueryString();
			qs.add("name","gaojiao");
			qs.add("password", "123456");
			out.write(qs.toString());
			out.flush();
			out.close();
		}

		try(Reader r = new InputStreamReader(uc.getInputStream())) 
		{
			BufferedReader reader = new BufferedReader(r);
			String line= null;
			while ((line = reader.readLine()) != null)
				System.out.println(line);
		}
	}
}


