package Day09;

public class Day09_5 { // c s

	public static void main(String[] args) { // m s
		
		// 1. ��ü ���� [�ڵ��� 1�� ����]
		Car myCar = new Car();
			// Ŭ���� �� Ÿ�̾ü�� 4�� -> myCar ����
		// 2. �޼ҵ� ȣ��
		for(int i=1; i<=5; i++) {
			int problemLocation = myCar.run(); // �ڵ��� ȸ�� �޼ҵ� ȣ�� => 5��
			
			switch(problemLocation) {
			case 1:
				System.out.println("�տ��� �ѱ�Ÿ�̾� ��ü");
				myCar.frontLeftTire = new HankookTire("�տ���", 15);
				// ����Ŭ���� ��ü�� = new ����Ŭ����();
				// ����� ������ ����
				break; // switch Ż��
			case 2:
				System.out.println("�տ����� ��ȣŸ�̾� ��ü");
				myCar.frontRightTire = new KumhoTire("�տ�����", 13);
				break;
			case 3:
				System.out.println("�ڿ��� �ѱ�Ÿ�̾� ��ü");
				myCar.backLeftTire = new HankookTire("�ڿ���", 14);
				break;
			case 4:
				System.out.println("�ڿ����� ��ȣŸ�̾� ��ü");
				myCar.backRightTire = new KumhoTire("�ڿ�����", 17);
				break;
			} // switch end
			System.out.println("---------------------------------------");
		} // for end
		
		
		
		
		
	} // m e
	
	
	
} // c e
