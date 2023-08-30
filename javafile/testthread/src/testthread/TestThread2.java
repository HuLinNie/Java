package testthread;
import java.util.Date;

public class TestThread2 extends Thread {
	private String flag;
	public TestThread2(String flag) {
		this.flag = flag;
	}
	public void run() {
		int i = 0;
		while (i < 10) {
			System.out.println(flag + ":" + i + " @ " + new Date().getTime());
			try {
				sleep(1000);
			} catch (InterruptedException ie) {}
			i++;
		}
	}
	public static void main(String[] args) {
		new TestThread2("A").start();
		new TestThread2("B").start();
		for (int i = 0; i < 10; i++) {
			System.out.println("M:" + i + " @ " + new Date().getTime());
			try {
				sleep(2000);
			} catch (InterruptedException ie) {}
		}
	}
}

