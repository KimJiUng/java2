package Day12;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day12_1 { // c s

	public static void main(String[] args) throws IOException { // m s
	
		// p.496
			// String ���ڿ� Ŭ����
				// 1. java.lang ��Ű�� [import x] �Ҽ�
				// 2. ��ü�ε� �ڵ� ���ͷ� [��ü�� �ڵ� ����]
				// 3. 13���� ������ [���ڿ�, ����Ʈ�� ��]
				// 4. �ܺ�[����,��Ʈ��ũ ��]�κ��� ���� �����ʹ� ���� ����Ʈ��
		
		// ����Ʈ -> ���� ��ȯ ���� ����
			// 1. ����Ʈ -> +-127 ǥ�� ����
			// 2. �ƽ�Ű�ڵ� => 0 or 1 ���յ� 7�ڸ� [0101011]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
			// ����Ʈ -> �ƽ�Ű�ڵ� ��ȯ [����/Ư������ 1����Ʈ , �ѱ� 2����Ʈ]
		
			// ���� : 0 or 1
			// 7�ڸ� ���� : �ƽ�Ű�ڵ� [ 1000001 -> A ]
		
		// p.497 ����
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		// 1. ������ ����Ʈ�� ������ �� �ִ� ����Ʈ �迭 ����
		String str1 = new String(bytes);
		// 2. ����Ʈ�迭 -> ���ڿ��� ��ȯ
		System.out.println("����Ʈ�迭 -> ���ڿ� ��ȯ : "+str1);
		
		// 3. Ư����ġ���� ��ȯ [ new String(�迭��, �����ε���, ����) ]
		String str2 = new String(bytes, 6 , 4);
		System.out.println("����Ʈ �迭�� 6��° �ε������� 4�� ��ȯ : "+str2);
		
		// p.498 ����
			
			// System.out : �ý��� Ŭ������ ��� �ʵ�
			// System.in : �ý��� Ŭ������ �Է� �ʵ�
		byte[] bytes2 = new byte[100]; // 100�� ����Ʈ�� �����Ҽ� �ִ� �迭
		
		System.out.println("�Է� : " ); // ����ʵ峻 print �޼ҵ� ȣ��
		// �޼ҵ带 ȣ���ϴ� ���
			// 1. ��ü�� �����Ŀ� . �����ڸ� ����Ͽ� ȣ��
			// 2. static �ʵ�/�޼ҵ�� ��ü���� Ŭ������.�ʵ�/�޼ҵ�
 		int readByteNo = System.in.read(bytes2);
 			// �ܺ���� : �ڹ����α׷��� [Ű����, ����, ��Ʈ��ũ ��] ����� �Ϲݿ���
 		
 		// Ű���� �Է� ---> ��Ʈ��[���:����Ʈ]---> ��ǻ��
 		// a -> 97 // a ���� -> 97, 13[\n:�ٹٲ�], 10[\r:Ŀ����������]
		System.out.println("�Է¹��� ����Ʈ : "+Arrays.toString(bytes2));
 		String str = new String(bytes2, 0, readByteNo-2);
 											// ���� ����Ʈ�� -2
 		System.out.println("�Է¹��� ����Ʈ -> ���ڿ� ��ȯ : "+str);
 		
 			// Scanner Ŭ���� [System.in ���κ��� �Է¹��� ����Ʈ�� ��ü�� ����]
 		Scanner scanner = new Scanner(System.in);
 			//
 		scanner.next(); // ����Ʈ -> ���ڿ� ��ȯ
 		scanner.nextInt(); // ����Ʈ -> ������ ��ȯ
 		scanner.nextDouble(); // ����Ʈ -> �Ǽ��� ��ȯ
 		
	} // m e
	
	
	
	
	
	
	
	
	
} // c e
