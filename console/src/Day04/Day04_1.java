package Day04;

import java.util.Scanner;

public class Day04_1 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		
		// ��� : if, switch
		// �ݺ��� : for[], while[���ѷ���]
			// 1. �ʱⰪ 2. ���ǽ�(���ϰ�� ����) 3. ������ 4. ���๮
			// while ����
			//		1.�ʱⰪ;
			//		while(2.���ǽ�){
			//
			//			3.���๮;
			//			4.������;
			//		}
		
		
		
		// for ��1)
		for(int i = 1; i<=10; i++) { // f s
			System.out.print(i+" ");
		} // f e
		
		System.out.println();
		
		// while ��1)
		int i = 1; // 1. �ʱⰪ
		while(i<=10) { // 2. ���ǽ� w s
			System.out.print(i+" "); // 4. ���๮
			i++; // 3. ������
		} // w e
		
		// for ��2) 1~100 �����հ�
		int sum = 0;
		for(int j = 1; j<=100; j++) {
			sum += j; // sum = sum + j
		}
		System.out.println("\nfor 1~100���� ������ : "+sum);
		
		
		// while ��2) 1~100 �����հ�
		
		int j = 1; // 1. �ʱⰪ
		int sum2 = 0; 
		while(j<=100) { // 2. ���ǽ�[true�̸� ���� �ƴϸ� ����x]
			sum2 += j; // 4. ���๮;
			j++; // 3. ������
		} // while end : j�� 101�϶� ����
		
		System.out.println("while 1~100���� ������ : "+sum2);
		
		// while ��3) ���ѷ���
		while(true){ // ���ǽ��� ture ���� // true ��� => ���ѷ���
			System.out.println("���ѷ���");
			int exit = scanner.nextInt();
			if(exit == 3)
				break; // ���� ����� �ݺ���(while, switch) Ż��[if ����]
		}
		
		
	} // m e
	
} // c e
