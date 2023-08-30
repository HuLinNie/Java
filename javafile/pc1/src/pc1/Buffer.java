package pc1;
public class Buffer {
	private int[] dArray;
	/**
	 * ����������������
	 */
	private int count = 0;
	/**
	 * ���ڼ�¼��һ���ɷ������ݵ�λ��
	 */
	int next_pos_set = 0;
	/**
	 * ���ڼ�¼��һ������ȡ���ݵ�λ��
	 */
	int next_pos_get = 0;
	/**
	 * 
	 * @param len �趨���鳤�ȣ����������Ĵ�С
	 */
	public Buffer(int len) {
		dArray = new int[len];
	}

	public synchronized void setValue(int val) throws InterruptedException {
		
		while (isFull()) 
			wait();

		dArray[next_pos_set] = val;
		System.out.println(Thread.currentThread().getName() + " put value: " + val + "@" + next_pos_set);
		
		next_pos_set = (next_pos_set + 1) % dArray.length;
		count++;
		display();

		notifyAll();
	}

	public synchronized int getValue() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		int val = dArray[this.next_pos_get];
		System.out.println(Thread.currentThread().getName() + " take value: " + val + "@" + next_pos_get);
		
		next_pos_get = (next_pos_get + 1) % dArray.length;
		count--;
		display();

		notifyAll();
		
		return val;
	}
	/**
	 * �жϻ������Ƿ�Ϊ��
	 * @return
	 */
	private boolean isEmpty() {
		return count == 0;
	}
	/**
	 * �жϻ������Ƿ�Ϊ��
	 * @return
	 */
	private boolean isFull() {
		return count == dArray.length;
	}
	/**
	 * ����������������Ļ��ʾ�������е�����
	 */
	private void display() {
		System.out.print("{");
		
		for (int pos = this.next_pos_get,i = 0; i < count; i++,pos = (pos+1) % dArray.length) {
			
			System.out.print(dArray[pos]);
			if (i < count - 1)
				System.out.print(",");
		}
		
		System.out.println("}");
	}
}

