package Day07;

public class Day07_4 { // c s

	public static void main(String[] args) { // m s
		
		// 1. ��ü ����
		Car2 myCar = new Car2();
		// 2. �ڵ��� �õ� �ɱ�
		myCar.keyTurnOn(); // �μ�x ��ȯx
		// 3. �ڵ��� ����
		myCar.run(); // �μ� x ��ȯx
		// 4. ���� ���ǵ� Ȯ�� �޼ҵ� ȣ��
		int speed = myCar.getSpeed(); // �μ�x ��ȯo
		System.out.println("���� �ӵ�: "+speed+"km/h");
		
	} // m e
} // c e
