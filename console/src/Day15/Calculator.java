package Day15;

public class Calculator {
	
	// �ʵ�
	private int memory;
	
	// �޼ҵ�
	public int getMemory() {
		return memory;
	}
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		// 2�ʰ� �Ͻ�����;
		try {Thread.sleep(2000);}
		catch(Exception e) {}
		System.out.println(Thread.currentThread().getName()+":"+this.memory);
	}
	
	
	
}
