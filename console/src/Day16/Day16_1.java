package Day16;

public class Day16_1 {

	public static void main(String[] args) {
		
		// ���׸�
		
		// p.656 �����׸� ��1)
		
		// 1. Box ��ü ����
		Box box = new Box();
		// 2. Box ��ü�� �޼ҵ� ȣ��
		box.set("ȫ�浿");
		// 3. ��ü�� �޼ҵ� ȣ��
		String name = (String)box.getObject();
		
			// �ڽİ�ü -> �θ�ü [ �ڵ�����ȯ ]
			// �θ�ü -> �ڽİ�ü [ �ڵ�x ����o ]
		
		// 4.
		box.set(new Apple()); // [�μ� : Apple]
		Apple apple = (Apple)box.getObject();
		
		
	}
}
