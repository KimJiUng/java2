package Day07;

import java.util.Scanner;

public class Day07_5_BookApplication { // c s
	
	
		
		// BookApplication Ŭ���� : ����� �����ڵ�
		// Book Ŭ���� : ���� ���� �ڵ�
		// Member Ŭ���� : ȸ�� ���� �ڵ�
		
		// * ���� �뿩 console ���α׷� [Ŭ��������]
			// 1. Ŭ����
				// 1. Book
					// �ʵ� : ISBN(������ȣ), ������, �۰�, �����뿩����, �뿩ȸ��
					// �޼ҵ� : 1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.������� 6.��������
				// 2. Member
					// �ʵ� : ��ȣ, ���̵�, ��й�ȣ, �̸�, ����ó
					// �޼ҵ� : 1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��
			// 2. ȭ�� ����
				// 1. �ʱ� �޴� [1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��]
				// 2. �Ϲ�ȸ���޴� [1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.�α׾ƿ�]
				// 3. �����ڸ޴� [1.������� 2.������� 3.�������� 4.�뿩����(����) 5.�α׾ƿ�]
		
		
		
	// * main �ۿ� ������ �����ϴ� ���� : ��� �޼ҵ忡�� ����ϱ� ���ؼ�
			// �������� : { �������� } ��ȣ������ ����� ������ { } ���� ������
				// ���� �ٸ� { } ��ȣ ������ ���� -> ��������
			// static : ���α׷� ���۽� �޸� �Ҵ� / ���α׷� ����� �޸� �ʱ�ȭ
				// ���α׷� ���������� ��� ���� ���Ǵ� �޸�[����]
	static Scanner scanner = new Scanner(System.in); // static : ��� ������ ��� ����
	static Member1[] members = new Member1[1000];
	static Book[] books = new Book[1000];
	
	// 0. �ڵ带 �о��ִ� ���� �޼ҵ�[������]
	public static void main(String[] args) { // m s
		// �޼ҵ� ȣ��
			//menu(); // ����ȣ�� �Ұ���
				// 1. menu(); // ����ȣ�� �Ұ���
					// static : �޸� �켱�Ҵ��̱� ������ static �� �޼ҵ�, �ʵ� x
					// main �޼ҵ�� static �޼ҵ��̱� ������ static �޼ҵ常 ����ȣ�� ����
				// 2. �ܺ�ȣ��
					// 1. ��ü ����(�޸��Ҵ�) -> �޼ҵ� ȣ��
			Day07_5_BookApplication application = new Day07_5_BookApplication();
			application.menu();
	} // m e
		
	
	// 1. �ʱ� �޴� �޼ҵ�
	void menu() {
		while(true) { // ���ѷ��� [�������� x]
			System.out.println("----------------���� �뿩 ���α׷�----------------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��");
			int ch = scanner.nextInt();
			Member1 member = new Member1();
			
			if(ch==1) {
				// ȸ������ �޼ҵ� ȣ��
				boolean result = member.ȸ������();
				if(result) System.out.println("�˸�)) ȸ������ ����");
				else System.out.println("�˸�)) ȸ������ ����");
				
			} // if end 
			else if(ch==2) {
				// �α��� �޼ҵ� ȣ��
				String result = member.�α���();
					
				if(result == null) {
					System.out.println("�˸�)) ������ ȸ�������� �����ϴ�.");
				}
				else if(result.equals("admin")){ // 2. ������ �޴� �޼ҵ� ȣ��
					System.out.println("�˸�) �ȳ��ϼ���~"+result+"��");
					adminmenu(); // ���� �޼ҵ� ȣ��
				}
				else { // 1. �Ϲ�ȸ�� �޴� �޼ҵ� ȣ��
					System.out.println("�˸�) �ȳ��ϼ���~"+result+"��");
					membermenu(result); // �μ�1�� [�α��� ������ id]
				}  	
			} // else if end
			else if(ch==3) {
				// ���̵�ã�� �޼ҵ� ȣ��
				member.���̵�ã��();
			} // else if end
			else if(ch==4) {
				// ��й�ȣã�� �޼ҵ� ȣ��
				member.��й�ȣã��();
			} // else if end
			else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
		}
	}
	// 2. �Ϲ�ȸ�� �޴� �޼ҵ�
	void membermenu(String loginid) { // �μ��� �������� �޶� ������ �ڷ��� ����
		while(true) { // ���ѷ��� [�������� : �α׾ƿ�]
			Book book = new Book();
			System.out.println("----------------ȸ�� �޴�------------------");
			System.out.println("1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.�α׾ƿ� ���� : ");
			int ch = Day07_5_BookApplication.scanner.nextInt();
			
			if(ch==1) book.�����˻�(); 
			else if(ch==2) book.�������();
			else if(ch==3) book.�����뿩(loginid);
			else if(ch==4) book.�����ݳ�(loginid);
			else if(ch==5) return; // �Ϲ�ȸ�� �޼ҵ� ���� [�α׾ƿ�]
			else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
		} // while end
	}
	// 3. ������ �޴� �޼ҵ�
	void adminmenu() {
		while(true) {
			Book book = new Book();
			System.out.println("----------------������ �޴�------------------");
			System.out.println("1.������� 2.������� 3.�������� 4.�α׾ƿ� ���� : ");
			int ch = Day07_5_BookApplication.scanner.nextInt();
			
			if(ch==1) book.�������();	
			else if(ch==2) book.�������();
			else if(ch==3) book.��������();
			else if(ch==4) return;
			else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
		} // while end
	}
} // c e
