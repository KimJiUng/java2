package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_5 { // c s

	public static void main(String[] args) { // m s
		
		
		//����) �ζ� �Ǻ���
		// 1. ����� 6�� �� �Է¹ޱ�
		//		1. 1~45 ���� �� �� �Է¹ޱ� �ƴϸ� ���Է�
		//		2. �ߺ��̸� ���Է�
		// 2. ��÷��ȣ : ��ǻ�� ���� 6�� �߻�
		//		1. 1~45 ����
		//		2. �ߺ�x
		// 3. ����� ��÷��ȣ�� ��ǻ�� ��÷��ȣ�� ���� ���� ����
		
		
		// �غ�
		int[] num = new int[6]; // ����ڰ� ������ ��ȣ ���
		int[] com = new int[6]; // ��ǻ���� ���� ��ȣ ���
		Scanner scanner = new Scanner(System.in);
		
		// 1. ����ڿ��� �Է¹ޱ�
		for(int i=0; i<6; i++) {
			System.out.println("1~45 ���� �Է� : ");
			int ��ȣ = scanner.nextInt();
			
			boolean pass = true; // ����Ǵ� ���� ����
			
			// ����1 : ��ȿ���˻�
			if(��ȣ<=0 || ��ȣ>=46) {
				System.out.println("�˸�))������ �� ���� ��ȣ�Դϴ�.");
				// 1���� �۰ų� 45���� ũ�� ������ �� ���� ��ȣ �Է½� ���Է�
				i--; // ���� i�� �����Է� x
				pass = false; // ���� x
			} // if end
		
			// ����2 : �ߺ�üũ
				// 1. �迭�� ��� �ε��� ȣ��
			for(int j=0; j<6; j++) {
				if(��ȣ == num[j]) {
					// 2. �Է¹��� ���� ������ ��
					System.out.println("�˸�)) �̹� ������ ��ȣ�Դϴ�.[���Է�]");
					i--; // ���� i�� �����Է� x
					pass = false; // ���� x
				} // if end
			} // for2 end
			
			// �����Է� �̸� �迭�� �����ϱ�
			if(pass==true) num[i] = ��ȣ;
			
			
		} // for end
		
		System.out.print("\n����ڰ� ������ ��ȣ : ");
		// * ����� �迭�� ��� �ε��� ���
		 for(int temp : num)
			 System.out.print(temp+"\t");
		// 2. ��ǻ�Ͱ� ���� ����
		 for(int i = 0; i<6; i++) {
			 
			 Random random = new Random(); // 1. ������ü
			 int ��÷ = random.nextInt(45)+1; // 2. ������ int������ ��������
			 						// random.nextInt() : +-20�� ������ ���� �߻�
			 						// random.nextInt(��) : 0~�� ������ ���� �߻�
			 						// random.nextInt(��)+���۹�ȣ : ���۹�ȣ~�� ������ ���� �߻�
			 // ���� : �ߺ�üũ
			 boolean pass = true;
			 for(int temp : com) {
				 if(��÷==temp) {
					 i--; // �ߺ��� ������� ���� i ����
					 pass = false;
				 }
			 }
			 if(pass) com[i]=��÷;
			 
		 } // for end
		 
		 System.out.print("\n\t��÷��ȣ : ");
			// * ����� �迭�� ��� �ε��� ���
			 for(int temp : com)
				 System.out.print(temp+"\t");
		 
		// 3. �� = �� �迭�� ������ �� ã��
		//��� 1
		int sum = 0;
		for(int i=0; i<6; i++) { // i : �� ������
			for(int j=0; j<6; j++) { // j : �� ���
				if(num[i]==com[j]) { // ����� �迭�� i��° �ε����� j��° �ε����� ���� �����ϸ�
					sum++;
				}
				
			} // for2 end
			
		} // for1 end
		
		
		// ��� 2
//		for(int �񱳱��� : num) {
			// ����ڹ�ȣ �迭�� �ϳ��� �񱳱��� ����
//			for(int �񱳴�� : com) {
				// ��÷��ȣ �迭�� �ϳ��� �񱳴�� ����
//				if(�񱳱��� == �񱳴��) sum++;
//			}
//		}
		System.out.println("\n��ġ�ϴ� ���� : "+sum);
		
		if(sum==6) {
			System.out.println("1��");
		}
		else if(sum==5) {
			System.out.println("2��");
		}
		else if(sum==4) {
			System.out.println("3��");
		}
		else if(sum==3) {
			System.out.println("4��");
		}
		else System.out.println("�̴�÷"); 
		
		
	} // m e
	
} // c e
