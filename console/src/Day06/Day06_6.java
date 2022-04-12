package Day06;

import java.util.Scanner;

public class Day06_6 { // c s

	public static void main(String[] args) { // m s
		
		// ��ȸ���� �Խ��� [Ŭ���� ����]
			// 0. �Խù� ���� => Ŭ���� ����
				// �ʵ� : ����, ����, �ۼ���, ��й�ȣ
				// ������ : ������� ����
		
			// 1. ùȭ�� [��� �Խù�(��ȣ, �ۼ���, ����) ���]
			// 2. �޴� [1.�۾��� 2.�ۺ���]
				// 1. �۾��� [����, ����, �ۼ���, ��й�ȣ => 4������ => ��üȭ]
				// 2. �ۺ��� [�ش� �۹�ȣ�� �Է¹޾� �ش� �� ��������(��ȣ, �ۼ���, ����, ����) ǥ��]
					// �۹�ȣ�� �迭�� ����Ǵ� ���� [�ε���]
					// �ۺ��� �޴�
			// 3. �ۺ��� �޴� [1.��Ϻ��� 2.���� 3.����]
				// 1. ������ : ��й�ȣ �Է¹޾� �����ϸ� ����
				// 2. ������ : ��й�ȣ �Է¹޾� �����ϸ� ����� ���븸 ����
		
		// �غ� [��������(����{ }���� ���Ǵ� ����) ����]
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
			// * Board ��ü 100���� ������ �� �ִ� 1���� �迭 ����
		
		// ���α׷� ����
		while(true) { // ���α׷� ���� ���ѷ��� [�������� x]
			System.out.println("-----------------Ŀ�´�Ƽ---------------");
//////////////////////////////////////////////////////// ��� �Խù� ��ȸ/////////////////////////////////////////////
			System.out.printf("%3s\t%10s\t%20s \n", "��ȣ", "�ۼ���", "����");
				// �迭�� ��� ��ü(�Խù�) ��� �ݺ���
				int index = 0; // �ε��� ���� [�迭�� ��ü �� üũ]
				for(Board board : boardlist) {
					if(board!=null) {
						System.out.printf("%3d\t%10s\t%20s \n", index, board.writer, board.title );
						index++; // �ε��� ����
					}
				}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("1.�۾��� 2.�ۺ���");
			int ch = scanner.nextInt();
			if(ch==1) { // �۾��� [����, ����, �ۼ���, ��й�ȣ => 4������ => ��üȭ]
//////////////////////////////////////////////�۾���///////////////////////////////////////////////////////////////////
				// 1. 4�� ������ �Է¹޴´�.
				System.out.println("---------------------�� ���� ������----------------------");
				System.out.println("title : "); String title = scanner.next();
				System.out.println("contet : "); String content = scanner.next();
				System.out.println("writer : "); String writer = scanner.next();
				System.out.println("password : "); String password = scanner.next();
				
				// 2. 4�� ������ ��üȭ [��ü�� ���� 4�������� ��ü�� �ʵ忡 ����]
				Board board = new Board(title, content, writer, password);
					// 4�� �ʵ带 ���� ������ ���
				
				// 3. �迭�� ������� ã�Ƽ� ������� ��ü ����
				int i=0;
				for(Board temp : boardlist) {
					if(temp==null) {
						boardlist[i] = board;
						break; // �ѹ� ���������� �ݺ��� ����
					} // if end
					i++;
				} // for end
////////////////////////////////////////////////////////////////////////////////////////////////////////
			} // if �۾��� end
			else if(ch==2) { // �ۺ��� [�ش� �۹�ȣ�� �Է¹޾� �ش� �� ��������(��ȣ, �ۼ���, ����, ����) ǥ��]
//////////////////////////////////////////////////////�ۺ���//////////////////////////////////////////////
				
					System.out.println("�Խù� ��ȣ ���� : "); int number = scanner.nextInt();
					System.out.println("-------------------�Խù� ��������---------------------");
					// �ݺ��� ��� ���� x -> �������ġ[�ε���] �Է� �޾ұ� ������ -> �Է¹��� �ε��� ��ġ�� ��ü ���
					System.out.printf("�ۼ��� : %s\t���� : %s \n", boardlist[number].writer, boardlist[number].title);
					System.out.printf("���� : %s \n", boardlist[number].content);
					System.out.println("----------------------------------------------------");
					System.out.println("1.��Ϻ���(�ڷΰ���) 2.�ۻ��� 3.�ۼ���"); 
					int ch2 = scanner.nextInt();
					
					if(ch2==1) { // ��Ϻ���
						
					} // if ��Ϻ��� end
					else if(ch2==2) { // �ۻ���
//////////////////////////////////////////////////////�ۻ���//////////////////////////////////////////////
						System.out.println("�˸�)) �� �Խù� ��й�ȣ : "); String pw = scanner.next();
						if(boardlist[number].password.equals(pw)) {
							System.out.println("�˸�)) ���� ����");
							boardlist[number]=null;
							
							
							for(int i=number; i<boardlist.length; i++) {
								
								if(i==boardlist.length-1) {
									boardlist[boardlist.length-1]=null;
								}
								else boardlist[i]=boardlist[i+1];
							}
						} // if end
						else System.out.println("�˸�)) ��й�ȣ�� �ٸ��ϴ�.[���� ����]");
///////////////////////////////////////////////////////////////////////////////////////////////////////////
					}	 // else if �ۻ��� end
					else if(ch2==3) { // �ۼ���
///////////////////////////////////////////////////�ۼ���///////////////////////////////////////////////////
						System.out.println("�˸�)) �� �Խù� ��й�ȣ : "); String pw_2 = scanner.next();
						if(boardlist[number].password.equals(pw_2)) {
							// �ش� �Խù��� ����� ������ ���� �Է¹޾� �� �Խù� ��ü�� ����� ���� ����
							System.out.println("������ ���� : "); boardlist[number].title = scanner.next();
							System.out.println("������ ���� : "); boardlist[number].content = scanner.next();
						}
						else System.out.println("�˸�)) ��й�ȣ�� �ٸ��ϴ�.[���� ����]");
//////////////////////////////////////////////////////////////////////////////////////////////////////////
					} // else if �ۼ��� end
					else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
				
////////////////////////////////////////////////////////////////////////////////////////////////////////				
			} // else if �ۺ��� end
			else {
				System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
			}
			
			
			
		} // while ���α׷� ���� end
		
	} // m e
	
} // c e
