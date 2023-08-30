package net.socket.talk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.CountDownLatch;

public class Channel extends Thread {
	InputStream in;
	OutputStream out;
	CountDownLatch latch = null;
	public Channel(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}
	public Channel(InputStream in, OutputStream out,CountDownLatch latch) {
		this(in,out);
		this.latch = latch;
	}

	public void run() {
		try {
			if (out != null && in != null) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
				BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				String line = null;
				while ((line = br.readLine())!=null) {
					bw.write(line);
					bw.newLine();
					bw.flush();
//					if(line.compareToIgnoreCase("exit")==0)
//						break;
				}
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if(latch!=null)
				latch.countDown();
		}
	}
}
