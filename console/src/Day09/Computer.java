package Day09;

public class Computer extends Calculator { // c s
			// ����Ŭ���� extends ����Ŭ����
	
	// 1. �ʵ�
	
	// 2. ������
	
	// 3. �޼ҵ�
		// * ���ٶ��̵� [�θ�Ŭ������ �޼ҵ� ������(����)]
		// ctrl + space bar
	
	@Override // ������� �θ�(����Ŭ����)�� ������ �ִ� �޼ҵ� ȣ��
	double areaCircle(double r) {
		System.out.println("Computer ��ü�� areaCircle() ����");
		return Math.PI * r * r;
	}
	
	
	
	
	
	
} // c e
