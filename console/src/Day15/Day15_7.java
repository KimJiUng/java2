package Day15;

import java.awt.Toolkit;

public class Day15_7 {

	public static void main(String[] args) {
	// p.601 ������ ����
			// 1. sleep() : �־��� �ð����� �Ͻ� ����
				// �ð����� : �и���(1/1000��)
				// �Ϲ� ���� �߻� : �Ͻ��������ֿ��� �־��� �ð��� �Ǳ����� ����
			// 2. Thread.yield() : �ٸ� �����忡�� ���� �纸 [ ������ ]
			// 3. Thread.join() : �ٸ� �������� ���Ḧ ��ٸ� [ �ٸ� �����尡 ���������� ��ٸ� ]
		// p.602 sleep ����
			
			
			
//		Toolkit toolkit = Toolkit.getDefaultToolkit(); // �Ҹ� ���� Ŭ����
//		for(int i=0; i<10; i++) {
//			toolkit.beep(); // �Ҹ����� [�Ҹ��� 1�� �۵��߿� for�� ����]
//			try {Thread.sleep(3000);} catch(Exception e) {} // 3�ʰ� �Ͻ�����
//		}
//		
//		
//			// p.604~606 yield()
//			// 1. ��ü����
//			ThreadA threadA = new ThreadA();
//			// 2. ��ü����
//			ThreadB threadB = new ThreadB();
//			// 3. ������ ����
//			threadA.start();
//			threadB.start();
//			// 4. ������ 3�ʰ� �Ͻ�����
//			try {Thread.sleep(3000);}catch(Exception e) {}
//			// 5. ������A�� work�� ����
//			threadA.work = false;
//				
//			// 6. ������ 3�ʰ� �Ͻ�����
//			try {Thread.sleep(3000);}catch(Exception e) {}
//			// 7. ������A�� work�� ����
//			threadA.work = true; 
//			
//			// 8. ������ 3�ʰ� �Ͻ�����
//			try {Thread.sleep(3000);}catch(Exception e) {}
//			// 9. ������ A,B ����
//			threadA.stop = true;
//			threadB.stop = true;
//			threadA.stop(); // �������� �ʴ� �޼ҵ� [��������
//			
			
		// p.607 : join()
			
			// 1. ��ü ����
			SumThread sumThread = new SumThread();
			// 2. ������ ����
			sumThread.start();
			// 3. ������ join
			try {
			sumThread.join(); // �Ϲ� ����ó�� �߻�
			} catch(Exception e) {}
			
			// 4. ���
			System.out.println("1~100 �հ� : "+sumThread.getSum());
			
			// * main�����尡 join �������� : 0
				// SumThread�� ���ϱ⸦ ������ ���� main ������ sum ���
			// * main�����尡 join ������ : 5050
			
	} // m e
	

	
	
	
	
} // c e
