package testthread;
public class TestThread1 extends Thread {
	private String flag;
	public TestThread1(String flag) {
		this.flag = flag;
	}
	public void run() {
		int i = 0;
		while (i < 10) {
			System.out.println(flag + ":" + i++ + " ");
		}
	}
	public static void main(String[] args) {
		new TestThread1("A").start();
		new TestThread1("B").start();
		for (int i = 0; i < 10; i++) {
			System.out.println("M:" + i + " ");
		}
	}
}

