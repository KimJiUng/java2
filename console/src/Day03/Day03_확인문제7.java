package Day03;

import java.util.Scanner;

public class Day03_Ȯ�ι���7 { // c s

	public static void main(String[] args) { // m s
		
		// ���� ����[��� ������ ����� �� �ִ� ����]
		boolean run = true; // ���� ���� ���� / true=���� false=����
		
		int balance = 0; // ���ݾ�[����ȿ� �ִ� �ݾ�] ����
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) { // while(true) { } : ���ѷ���
			System.out.println("----------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("----------------------------");
			System.out.print("����> ");
			
			int ���� = scanner.nextInt();
			if( ���� == 1) {
				System.out.println("���ݾ� : "); int ���ݾ� = scanner.nextInt();
				// �Է¹��� ���ݾ��� ���忡 �߰� +
				balance += ���ݾ�;			
			}
			else if( ���� == 2) {
				System.out.println("��ݾ� : "); int ��ݾ� = scanner.nextInt();
				if(��ݾ�>balance)System.out.println("�˸�) �ܾ��� �����մϴ�.");
				else balance -= ��ݾ�;
				// �Է¹��� ��ݾ��� ���忡�� ���� -
				
			}
			else if( ���� == 3) {
				System.out.println("�ܰ� : "+balance);
			}
			else if( ���� == 4) {
				break; // while�� Ż��[���ѷ��� ����]
				
			}
			else System.out.println("�˸�) �� �� ���� ��ȣ�Դϴ�.");
		}
		
		System.out.println("���α׷� ����");
		
		
		
		
	} // m e
	
} // c e
