package Day03;

import java.util.Scanner;

public class Day03_2 { // c s

	public static void main(String[] args) { // m s
		
		// ����1 : 2���� ������ �Է¹޾Ƽ� �� ū�� ���
		
		// �Է°�ü = { } �� 1�� ����
		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("����1 �Է� : "); int ����1_1 = scanner.nextInt();
//		System.out.println("����2 �Է� : "); int ����1_2 = scanner.nextInt();
//			// int�� ���� �����ϰ� �Է¹��� �����͸� ������ �����ͼ� ����
//		
//		// ����
//		if(����1_1>����1_2) System.out.println("�� ū �� : "+����1_1);
//		// ���࿡ �Է¹��� ����1_1 �� ����1_2 ���� ũ�� ���� �ƴϸ� ���� ����
//		else if(����1_1<����1_2) System.out.println("�� ū �� : "+����1_2);
//		// [��������] ����1_1 �� ����1_2 ���� ������ ���� �ƴϸ� �׿�
//		else System.out.println("����.");
//		// ������[�׿�] ����
//		
//		// ����2 : 3���� ������ �Է¹޾Ƽ� ���� ū �� ���
//		
//		System.out.println("����1 �Է� : "); int ����2_1 = scanner.nextInt(); // ������ �ߺ�x
//		System.out.println("����2 �Է� : "); int ����2_2 = scanner.nextInt();
//		System.out.println("����3 �Է� : "); int ����2_3 = scanner.nextInt();
//		
//		int max = ����2_1; // ���� ū���� �����ϴ� ����
//			// max�� ù��° �� �־�α�
//		if(max<����2_2) { // ���࿡ max���� ����2_2�� �� ũ�� ��ü
//			int temp = ����2_2; // �ӽú���[���ҿ�]
//			����2_2 = max;
//			max = temp;
//			// = max = ����2_2;
//		}
//		if(max<����2_3) {max=����2_3;}
//		System.out.println("���� ū �� : "+max);
//		
//		// ����3 : 4���� ������ �Է¹޾Ƽ� ���� ū �� ���
//		
//		System.out.println("����1 �Է� : "); int ����3_1 = scanner.nextInt();
//		System.out.println("����2 �Է� : "); int ����3_2 = scanner.nextInt();
//		System.out.println("����3 �Է� : "); int ����3_3 = scanner.nextInt();
//		System.out.println("����4 �Է� : "); int ����3_4 = scanner.nextInt();
//		
//		int max2 = ����3_1;
//		if (max2<����3_2) {max2=����3_2;}
//		if (max2<����3_3) {max2=����3_3;}
//		if (max2<����3_4) {max2=����3_4;}
//		System.out.println("���� ū �� : "+max2);
//		
//		
//		// ����4 : 3���� ������ �Է¹޾Ƽ� ��������
//		
//		System.out.println("����1 �Է� : "); int ����4_1 = scanner.nextInt(); 
//		System.out.println("����2 �Է� : "); int ����4_2 = scanner.nextInt();
//		System.out.println("����3 �Է� : "); int ����4_3 = scanner.nextInt();
//		
//		if(����4_1>����4_2) {
//			int temp = ����4_1; // �ӽú��� = ����1 ;
//			����4_1 = ����4_2; // ����1 = ����2 ;
//			����4_2 = temp; // ����2 = �ӽú���;
//			// ��ü[���� = 2�� ������ ������ ��ȯ���]		
//		}
//		if(����4_1>����4_3) { int temp = ����4_1; ����4_1 = ����4_3; ����4_3 = temp;}
//		if(����4_2>����4_3) { int temp = ����4_2; ����4_2 = ����4_3; ����4_3 = temp;}
//		System.out.printf("�Է��� �� �������� : %d  %d  %d\n", ����4_1, ����4_2, ����4_3);
//		System.out.println("�Է��� �� �������� : " + ����4_1 + ����4_2 + ����4_3);
//		
		// ����5 : 4���� ������ �Է¹޾Ƽ� ��������
		
		System.out.println("����1 �Է� : "); int ����5_1 = scanner.nextInt(); 
		System.out.println("����2 �Է� : "); int ����5_2 = scanner.nextInt();
		System.out.println("����3 �Է� : "); int ����5_3 = scanner.nextInt(); 
		System.out.println("����4 �Է� : "); int ����5_4 = scanner.nextInt();
		
		if(����5_1>����5_2) {int temp = ����5_1; ����5_1 = ����5_2; ����5_2 = temp;}
		if(����5_1>����5_3) {int temp = ����5_1; ����5_1 = ����5_3; ����5_3 = temp;}
		if(����5_1>����5_4) {int temp = ����5_1; ����5_1 = ����5_4; ����5_4 = temp;}
			// ����1�� ����2,3,4 �� �� �� ����1�� ���� ���� �� �ֱ�
		if(����5_2>����5_3) {int temp = ����5_2; ����5_2 = ����5_3; ����5_3 = temp;}
		if(����5_2>����5_4) {int temp = ����5_2; ����5_2 = ����5_4; ����5_4 = temp;}
			// ����2�� 3,4 �� �� �� ����2�� ���� ���� �� �ֱ�
		if(����5_3>����5_4) {int temp = ����5_3; ����5_3 = ����5_4; ����5_4 = temp;}
			// ����3�� 4 �� �� ����3�� ���� �� �ֱ�
		System.out.printf("�Է��� �� �������� : %d %d %d %d\n",����5_1,����5_2,����5_3,����5_4);
		
		
	} // m e
	
	
} // c e
