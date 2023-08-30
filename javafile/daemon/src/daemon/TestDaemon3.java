package daemon;
import java.util.Date;
class Runnable1 implements Runnable {
	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println("TestDaemon1@"+i +" @" + new Date().getTime());
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			} catch (Exception e) {
			}
		}
	}
}
class Runnable2 implements Runnable {
	public void run() {
		for (int i = 0; i <= 20; i++) {
			System.out.println("TestDaemon2@"+i +" @" + new Date().getTime());
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			} catch (Exception e) {
			}
		}
	}
}
public class TestDaemon3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable1());
		Thread t2 = new Thread(new Runnable2());
		t1.setDaemon(true);
		t1.start();
		t2.start();
		System.out.println("主线程结束");
	}
}
