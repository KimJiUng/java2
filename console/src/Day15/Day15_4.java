package Day15;

public class Day15_4 { // c s
 
	public static void main(String[] args) { // m s
		
		// 12�� : ������ : �ڵ带 �о��ִ� ����
			// �ڵ� -> ���� -> ���μ���[���α׷�]
			// ���� : ����ó��
				// main�޼ҵ忡 main������ ����
		
			// �����
				// 1. Thread Ŭ����		
				// 2. Runnable �������̽�
		
			// run �޼ҵ� : ��Ƽ�������� �����ڵ�
		
		// ��1) Thread Ŭ������ �̿��� ����ó�� �����
		
		���� m1 = new ����();
		m1.start(); // Runnable�� start() �޼ҵ带 ������ ���� ����
		
		// ��2) Runnable �������̽��� �̿��� ����ó�� ��ü �����
		ä�� c1 = new ä��();
		Thread thread = new Thread(c1);
		thread.start();
		
		while(true) { // main ������ ������
			System.out.println(" * ���α׷� �۵��� * ");
			try { Thread.sleep(500);}
			catch(Exception e) {}	
		}
		
		
		// p.591 ����ȭ
			// ��Ƽ������ ���� ����ȭ ���� [���Ͻ����� ���ÿ��� ����ȭx] 
			// * ������ ������ ������ �޼ҵ� ȣ��
			// ���ôٹ������� �ϳ��� �޼ҵ� ȣ��
		
		// ��1) ����ȭ ���� �޼ҵ� ����
		
		
		
		
	} // m e
	
	
} // c e
