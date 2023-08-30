package testthread;
public class TestThreadR2 {
	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			try {
				System.out.println("Hello Thread!");
				for (int i = 0; i < 100; i++) {
					System.out.println("Runnable: " + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("Main " + i);
			Thread.sleep(1000);
		}
	}
}

