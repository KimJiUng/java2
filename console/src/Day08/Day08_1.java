package Day08;

public class Day08_1 { // c s

	public static void main(String[] args) { // m s
		
		// p.238 : static
			// ��������
			// �������� ������ = ���α׷� ����������
		
		// * Ŭ������ �ʵ�, �޼ҵ�(���) ���ٹ��
			// 1.(static ����� �ƴҶ�) ��ü ���� -> ��ü.���
				// ��ü�� �����ɶ� new �����ڷ� ��ü(�� �������) �޸� �Ҵ�
		Calculator calculator = new Calculator();
		System.out.println("��ü�� �̿��� ������� : "+calculator.pi);
			// 2.(static ����϶�) 1. Ŭ������.���
				// Ŭ���� �ε� �ǰ� �޼ҵ念���� static ������ ����
		System.out.println("��ü���� ������� : "+calculator.pi);
		
		double result = 10 * 10 * calculator.pi;
								// Ŭ������.����������
		int result2 = Calculator.plus(10, 5);
		
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result : "+result);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
		
		
		 
	} // m e
} // c e
