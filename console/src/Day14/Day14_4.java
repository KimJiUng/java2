package Day14;

import java.awt.Toolkit;

public class Day14_4 {

	public static void main(String[] args) {
		
		// p.576 ��Ƽ������ ����
			// ���μ��� : �ü�������� ���� ���� �ϳ��� ���ø����̼�
			// �ü��(������)�� ���μ������� �ʿ��� �޸� �Ҵ� [�ڹٿ��� �޸� ���� x]
			// �̱� ������ : �ڵ带 �о��ִ� �帧 1�� = main �޼ҵ�
			// ��Ƽ ������ : �ڵ带 �о��ִ� �帧 ������ = main �޼ҵ� �� ������
			// ���� : ����� �����帧������ �����尡 �ϳ��� ������(�ü���� �켱���� �Ҵ�) ó��
			// Thread Ŭ����(���ο� ������) vs Main �޼ҵ� (���ν����尡 ����)
				// 1. Thread Ŭ����
					// 1. ����Ŭ������ extends Thread
					// 2. run() �޼ҵ� �������̵�[������]
					// 3. ��ü ����
					// 4. ��ü.start()
					// * start() �޼ҵ� ȣ��� run�޼ҵ� ����
				// 2. Runnable �������̽�
					// 1. ����Ŭ������ implements Runnable
					// 2. run �޼ҵ� �����Ѵ�.
					// 3. �ܺο��� ������ü ����
					// 4. Thread Ŭ���� ��ü ������ �����ڿ� ������ü �־��ش�.
					// 5. thread Ŭ���� ��ü�� start() �޼ҵ� ����
					// * start() �޼ҵ�� run() �޼ҵ� ȣ��
					// * run() �޼ҵ�� main �����带 ������ ���ο� ������ �����
		
		// p.581 ����1
			// * �̱۽�����(main�޼ҵ�)
			// 0.5�� �������� �Ҹ� ���
			// 0.5�� �������� �� ���
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // �Ҹ� ���� �޼ҵ� ���� Ŭ����
		
		for(int i=0; i<5; i++) {
			toolkit.beep(); // .beep() : �Ҹ��޼ҵ�
			try {
			Thread.sleep(500); // ��������(main������)�� 0.5�ʰ� �Ͻ�����
			}catch(Exception e) {}
		}
		
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
			Thread.sleep(500); // ��������(main������)�� 0.5�ʰ� �Ͻ�����
			}catch(Exception e) {}
		}
		
	System.out.println("-----------------------------------------------");
		// p.582 ����2 : Runnable 
			// * ��Ƽ������(main������, beepTask��ü)
		// 1. �������̽� ������ü
		Runnable beepTask = new BeepTask();
		// 2. Thread Ŭ���� ��ü ������ �����ڿ� ������ü �ֱ�
		Thread thread = new Thread(beepTask);
		// 3. thread ��ü�� start() �޼ҵ� ȣ��
		thread.start();
		
		// ���
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
			Thread.sleep(500); // ��������(main������)�� 0.5�ʰ� �Ͻ�����
			}catch(Exception e) {}
		}
		
		System.out.println("-----------------------------------------------------");
		// p.584 : Thread Ŭ������ �̿��� ��Ƽ������
		// 1. Ŭ���� ��ü ����
		Thread thread2 = new BeepThread();
		// 		����Ŭ����	= �ڽ�Ŭ������ ������
		//			�θ� <- �ڽ� [�ڵ�����ȯ]
		//			�θ� -> �ڽ� [��������ȯ]
		// 2. ������ ��ü�� start() ȣ��
			// ������ Ŭ������ �̸� ������� �޼ҵ�
			// 1. run �޼ҵ� ȣ�� ���� [��Ƽ������ ����]
		thread2.start();
		
		// ���
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
		System.out.println("-----------------------------------------------------");
		
		// �������̽� �����
		 	// 1. Ŭ�������� implements �� �Ŀ� ���� => ������ü
			// 2. �������̽��� new �����ڸ� ���� �߻�޼ҵ� ���� => �͸�ü [Ŭ���� ����x]
		
		// * �͸� ������ ��ü
		Runnable runnable = new Runnable() {
			// * �������̽��� new (�޸��Ҵ�)
			// * �޸� �Ҵ��ϱ� ���ؼ� �߻�޼ҵ带 ���� ����
			// * �߻�޼ҵ带 ���� ���ҽÿ� �͸�ü ���� �Ұ�
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep(); // .beep() : �Ҹ��޼ҵ�
					try {
					Thread.sleep(500); // ��������(main������)�� 0.5�ʰ� �Ͻ�����
					}catch(Exception e) {}
				}
				
			}
		};
		Thread thread3 = new Thread(runnable);
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
			Thread.sleep(500); // ��������(main������)�� 0.5�ʰ� �Ͻ�����
			}catch(Exception e) {}
		}
		
	// p.590 
		
		for( int i = 1 ; i<=10 ; i++ ) {
					// 10ȸ �ݺ�ó��
			// i�� 1�϶� ���� ���� ������ ��ü ���� = thread1
			// * ���� �����Ǿ ��ȯ�Ҵ�[ �ü�� => �����ٸ� ]
			//   �̹Ƿ� ���� ���� ����x
			
			
			//1. i��° ������ ��ü ���� 
			Thread thread4 = new CalcThread("thread"+i);
			
			// * �켱���� 
				// ���࿡ 10�� �ƴϸ� �켱���� ���� 10�̸� �켱���� 10
			if( i !=10 ) { thread4.setPriority( Thread.MIN_PRIORITY );}
			else { thread4.setPriority( Thread.MAX_PRIORITY ); }
			
			//2. i��° ������ ���� 
			thread4.start();
			
		}
		
		
		
	} // m e
} // c e
