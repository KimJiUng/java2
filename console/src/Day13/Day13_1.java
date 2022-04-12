package Day13;

import java.util.Random;

public class Day13_1 { // c s

	public static void main(String[] args) { // m s
		
		// p.534 : Math Ŭ���� (java.lang ��Ű��) [ ���� ���� �޼ҵ� ���� ] ��ü���� ��밡��
		
		// 1. Math.abs(��) : �ش� ���� ���밪
		System.out.println("���밪 : "+Math.abs(-5));
		System.out.println("���밪 : "+Math.abs(-3.14));
		
		// 2. Math.ceil(��) : ����� ������ �ø�
		System.out.println("�ø��� : "+Math.ceil(5.3)); // ������ �ø�
		System.out.println("�ø��� : "+Math.ceil(-5.3));  // -5
		
		// 3. Math.floor(��) : ����� ������ ����
		System.out.println("������ : "+Math.floor(5.3)); 
		System.out.println("������ : "+Math.floor(-5.3));
		
		// 4. Math.max(��1, ��2) : �� �� �� �� ū�� ���
		System.out.println("�ִ� : "+Math.max(5, 9));
		System.out.println("�ִ� : "+Math.max(5.3, 2.5));
		
		// 5. Math.min(��1, ��2) : �� �� �� �� ������ ���
		System.out.println("�ּڰ� : "+Math.min(5, 9));
		System.out.println("�ּڰ� : "+Math.min(5.3, 2.5));
		
		// 6. Math.random() : 0~1 ������ double�� ���� �߻�
		System.out.println("���� : "+Math.random()); // 0~1 ������ ���� �߻�
		// vs 
		Random random = new Random();
		System.out.println("���� : "+random.nextInt()); 
		
		// 7. Math.rint(��) : ����� ������ �Ǽ������� �ݿø�
		System.out.println("����� ������ �Ǽ��� : "+Math.rint(5.3)); // �ݿø� �Ǽ���
		System.out.println("����� ������ �Ǽ��� : "+Math.rint(5.7));

		// 8. Math.round(��) : ����� ������ ���������� �ݿø�
		System.out.println("����� ������ ������ : "+Math.round(5.3)); // �ݿø� ������
		System.out.println("����� ������ ������ : "+Math.round(5.7));
		
		// 9. Ư�� �Ҽ��� ��ġ���� �ݿø� [ round() : �Ҽ��� ù°�ڸ����� �ݿø� ]
		double value = 12.3456;
		double temp = value*100; // 1234.56
		long temp2 = Math.round(temp); // 1235
		double v16 = temp2/100.0;
					// temp2/100 -> long/int -> �⺻������ : int
					// temp2/100.0 -> long/double -> �⺻�Ǽ��� : double
		System.out.println("v16 : "+v16);
		
		
		
		// 10. p.536 : �ֻ��� [1~6]
		int num = (int)(Math.random()*6)+1;
		System.out.println(num);
		///////////////////////////////////////////////////////////
		System.out.println(random.nextInt(6)+1); 
		
		
		
	} // m e
	
	
	
	
} // c e
