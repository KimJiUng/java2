package Day17;

public class Day17_1 {

	public static void main(String[] args) {
		
		// p.658
			// ���׸� 
				// ���� : public class Ŭ������<���׸��̸�>
				// ���� : �ܺηκ��� ���� �ڷ������� ���ο� �ش� �ڷ��� ���
		
		// 1. ��ü ����
		Box<String> box1 = new Box<String>();
		// Ŭ������ String Ÿ�� �ֱ�
		box1.set("ȫ�浿");
		String str = box1.get();
		
		// 2. ��ü ����
		Box<Integer> box2 = new Box<>();
		// Ŭ������ Integer Ÿ�� �ֱ� 	// ��<>��������
		box2.set(6);
		int value = box2.get();
		
		
		
		// p.659
			// 1. ��ü �����ϴµ� ���׸�Ÿ�� �ֱ�
		Product<TV, String> product1 = new Product<>();
			// 2. ��ü�� �ʵ忡 �� ���׸�Ÿ������ �� �ֱ�
		product1.setKind(new TV());
		product1.setModel("����ƮTV");
			// 3. ȣ��
		TV tv = product1.getKind();
		String tvmodel = product1.getModel();
		
		// 1. ��ü �����ϴµ� ���׸�Ÿ�� �ֱ� [Car, String]
		Product<Car, String> product2 = new Product<>();
		// 2. ��ü�� �ʵ忡 �� ���׸�Ÿ������ �� �ֱ�
		product2.setKind(new Car());
		product2.setModel("����");
		// 3. ȣ��
		Car car = product2.getKind();
		String carmodel = product2.getModel();
		
		//
		Product<Integer, Double> product3 = new Product<>();
		
		
		
	}
	
	
	
	
}
