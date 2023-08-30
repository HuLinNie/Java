package testthread;
public class TestThread4 extends Thread {
	private String flag;
	public TestThread4(String flag) {
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
		TestThread4 tt1 = new TestThread4("A");
		TestThread4 tt2 = new TestThread4("B");
		tt2.setPriority(tt2.getPriority() + 2);
		TestThread4 tt3 = new TestThread4("C");
		tt3.setPriority(tt3.getPriority() - 2);
		tt1.start();
		tt2.start();
		tt3.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("M:" + i + " ");
			Thread.yield();
		}
	}
}
