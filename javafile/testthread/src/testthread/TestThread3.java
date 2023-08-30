package testthread;
public class TestThread3 extends Thread {
	private String flag;
	public TestThread3(String flag) {
		this.flag = flag;
	}
	public void run() {
		int i = 0;
		while (i < 10) {
			System.out.println(flag + ":" + i++ + " ");
			yield();
		}
	}
	public static void main(String[] args) {
		new TestThread3("A").start();
		new TestThread3("B").start();
		for (int i = 0; i < 10; i++) {
			System.out.println("M:" + i + " ");
			Thread.yield();
		}
	}
}
