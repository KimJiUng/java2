package Day07;

public class Car2 { // c s

	// 1. �ʵ�
	int speed;
	// 2. ������
		// ������ ������ �⺻������ �߰�
	// 3. �޼ҵ�
	
		// 1. ���� �ʵ尪 ��ȯ���ִ� �޼ҵ�
	int getSpeed() { // �μ� x ��ȯ o
		return speed;
	}
		// 2. ��� �޼ҵ�
	void keyTurnOn() { // �μ�x ��ȯx
		System.out.println("Ű�� �����ϴ�.");
	}
		// 3. ���ǵ� ���� �޼ҵ�[10���� 50���� 10�� ���� �ݺ�]
	void run() { // �μ�x ��ȯ��
		for(int i=10; i<=50; i+=10) {
			speed=i; // i�� speed�� ����
			System.out.println("�޸��ϴ�.(�ü�:"+speed+"km/h)");
		}
	}
	
} // c e
