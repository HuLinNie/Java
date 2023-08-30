package net.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

class DateTimeThread extends Thread {
	private Socket conn;
	DateTimeThread(Socket conn) {
		this.conn = conn;
	}
	public void run() {
		try {
			Writer out = new OutputStreamWriter(conn.getOutputStream());
			LocalDateTime dt = LocalDateTime.now();
			out.write(dt.toString() + "\r\n");
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TestMultiThreadServerSocket {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999)) {
			while (true) {
				try {
					Socket conn = server.accept();
					Thread task = new DateTimeThread(conn);
					task.start();
				} catch (IOException ex) {

				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
