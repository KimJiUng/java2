package Day09;

public class Car { // c s

	// 1. �ʵ�
	Tire frontLeftTire = new Tire("�տ���",6);
	Tire frontRightTire = new Tire("�տ�����",2);
	Tire backLeftTire = new Tire("�ڿ���",3);
	Tire backRightTire = new Tire("�ڿ�����",4);
	
	// 2. ������
	
	// 3. �޼ҵ�
	int run() { // �ڵ���ȸ�� [��� Ÿ�̾ü�� 1ȸ�� ȸ�� �޼ҵ�
		System.out.println("�ڵ����� �޸��ϴ�.");
		if(frontLeftTire.roll()==false) { // ������ 1�̸� �տ��� Ÿ�̾ ��ũ
			stop(); return 1;
		}
		// Ÿ�̾ ȸ���� �ߴµ� ����� false �̸� ��ũ
		// true �̸� ���� ����.
		if(frontRightTire.roll()==false) { // ������ 2�̸� �տ����� Ÿ�̾ ��ũ
			stop(); return 2;
		}
		if(backLeftTire.roll()==false) { // ������ 3�̸� �ڿ��� Ÿ�̾ ��ũ
			stop(); return 3;
		}
		if(backRightTire.roll()==false) { // ������ 4�̸� �ڿ����� Ÿ�̾ ��ũ
			stop(); return 4;
		}
		return 0; // ������ 0�̸� ��ũ x
	}

	void stop() {
		System.out.println("�ڵ����� ����ϴ�.");
	}
	
	
} // c e
