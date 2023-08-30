package testthread;
public class TestThread extends Thread {
	public void run() {
		int i = 0;
		while (i<100) {
			System.out.println("T:" + i);
			i++;
		}
	}

	public static void main(String[] args) {
		TestThread tt = new TestThread();
		tt.start();
		
		for (int i = 0; i <= 100; i++) {
			System.out.println("M:" + i);
		}
	}
}


