package daemon;
import java.util.Date;

public class TestDaemon implements Runnable {
	public void run() {
		Thread current = Thread.currentThread();
		for (int i = 0; i <= 10; i++) {
			System.out.println(current.getName() + " running @ " + new Date().getTime());
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		TestDaemon td = new TestDaemon();
		Thread t = new Thread(td,"TestDaemon");
		t.start();

		System.out.println("主线程结束");
	}
}
