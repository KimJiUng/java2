package Day15;

public class ThreadA extends Thread {

	// �ʵ�
	public boolean stop = false; // ���� �÷���
	public boolean work = true; // �۾����࿩�� �÷���
	
	
	
	// ����ó��
	@Override
	public void run() {
		while(!stop) { // stop�� true�̸� ���ѷ��� false�̸� ����
			if(work) { // work�� true�̸�
				System.out.println("ThreadA �۾� ����");
			}else { // work�� false�̸�
				Thread.yield(); // �ٸ� �����忡�� �纸
			}
		} // while end
		System.out.println("ThreadA ����");
	} // run end
	
	
}
