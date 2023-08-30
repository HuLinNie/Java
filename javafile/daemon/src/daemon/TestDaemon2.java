package daemon;
import java.util.Date;
public class TestDaemon2 implements Runnable {
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(new Date().getTime());
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		TestDaemon td = new TestDaemon();
		Thread t = new Thread(td);
		t.setDaemon(true);
		t.start();
		System.out.println("主线程结束");
	}
}
