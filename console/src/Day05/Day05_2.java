package Day05;

import java.util.Scanner;

import javax.swing.BoundedRangeModel;

public class Day05_2 { // c s

	public static void main(String[] args) { // m s
		
		// ȸ���� �湮�� ���α׷� [2�����迭]
			// 1. �ʱ�޴�[1. ȸ������ 2.�α���]
				// 1. ȸ������ [���̵�, ��й�ȣ, �̸�]
				// 2. �α��� [���̵�, ��й�ȣ �����ϸ� �α���ó��]
			// 2. �α��ν� �޴� [1.�湮�Ͼ��� 2.�α׾ƿ�]
				// 1. �湮�Ͼ��� [����, ����, �ۼ���(�α��εȾ��̵�)]
				// 2. �α׾ƿ� [�α׾ƿ��� �ʱ�޴��� ���ư���]
		
		// �غ�[��������]
		Scanner scanner = new Scanner(System.in);
			// ȸ�� 100��[id,pw,name] �����ϴ� �迭
		String[][] memberlist = new String[100][3]; // 100�� 3�� => ȸ���� 1�� [1��=id][2��=pw][3��=�̸�]
			// �湮�� 100��[title, contents, writer] �����ϴ� �迭
		String[][] boardlist = new String[100][3]; // �Խù��� 1��
		
		// �ʱ�޴�
		while(true) { // ���ѷ��� [���� x]
			System.out.println("------------------------------------");
			System.out.println("-------------ȸ���� �湮��--------------");
			System.out.println("------------------------------------");
			System.out.println("1.ȸ������ 2.�α��� 		���� : ");
			int ch = scanner.nextInt();
			
			if(ch==1) { // ȸ������
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("��й�ȣ : "); String pw = scanner.next();
				System.out.println("�̸� : "); String name = scanner.next();
				// String 3�� ������ �Է¹޾� memberlist 2���� �迭�� ����
					// 1. �� ����[��ü(���ڿ�)=null, ����=0, �Ǽ�=0.0]�� ã�Ƽ� ���� [���࿡ �� ������ ������ ȸ�� 100�� �ʰ� ���ԺҰ�]
					// 2. ���̵� �ߺ�üũ
				
				// ����κ�
				for(int i=0; i<memberlist.length; i++) {
					
					// ���̵� �ߺ�üũ [���� ȸ���� id�� �����ϸ� ȸ������ �Ұ�]
					boolean idcheck = true;
					if(memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						// ==null : ȸ�� ����. // != null : ȸ�� �ִ�
					 System.out.println("�˸�)) ������ ���̵� �����մϴ�.");
					 idcheck = false; // ����x
					 break;
					}
					else if(idcheck==true) {
						if(memberlist[i][0]==null) {
							// ���࿡ memberlist i��° �࿡ id�� ������ = �����
							memberlist[i][0] = id; memberlist[i][1] = pw; memberlist[i][2] = name;
							// i��° �� ���� ������ ����
							System.out.println("�˸�)) ȸ�������� �Ǿ����ϴ�.");
							break; // ���������� ��[1�� ����]
						}
						else System.out.println("�˸�)) �� �̻� ȸ�������� �Ұ����մϴ�.");
					
					}
				}
				
			} // ȸ������ ����
			
			else if(ch==2) { // �α���
				System.out.println("-------------�α��� ������-------------");
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("��й�ȣ : "); String pw = scanner.next();
				
				// �迭�� �����Ͱ� �Է¹��� id�� pw �� �����ϸ� �α���ö��
				boolean login = false;
				for(int i=0; i<memberlist.length; i++) {
					
					if(memberlist[i][0] != null && memberlist[i][0].equals(id) && memberlist[i][1].equals(pw)) {
						// i��° �࿡ id�� pw�� �Է¹��� ���� ������(equals)
							// null�� ��ü�� �ƴϱ� ������ equals�� �Ұ��� => �񱳿����� ���(== != ...)
						System.out.println("�˸�)) �α��� ����"); 
												
						login = true; // �α��� ���� �� ����
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
						while(true) { // �α��ν� �޴� ���ѷ��� [�������� : 2.�α׾ƿ�]
							System.out.println("-----------------------------------");
							System.out.println("----------------�湮��---------------");
							System.out.println("��ȣ\t�ۼ���\t����\t����");
								// ��� �湮�� ���
								for(int j=0; j<boardlist.length; j++) {
									if(boardlist[j][0]!=null) { // �Խù��� ���� �ε����� ����
									System.out.printf("%d\t%s\t%s\t%s \n",
											j+1, boardlist[j][2],boardlist[j][0],boardlist[j][1]);
									}
								}
							
							System.out.println("---------------ȸ�� �޴�--------------");
							System.out.println("1.�湮�� �ۼ� 2.�α׾ƿ�   ���� : "); int ch2 = scanner.nextInt();
							if(ch2==1) { // �湮�� �ۼ�
								System.out.println("-------------�۾���----------------");
								System.out.println("���� : "); String title = scanner.next();
								System.out.println("���� : "); String contents = scanner.next();
								// �迭 �� ����ã�Ƽ� ����
								for(int j = 0; j<boardlist.length; j++) {
									if(boardlist[j][0]==null) { // �迭�� j��° �ε��� �Խù��� �����̸�
										boardlist[j][0] = title; 
										boardlist[j][1] = contents; 
										boardlist[j][2] = id; // �α��ν� ���� id�� ����
										System.out.println("�湮���� �ۼ��Ǿ����ϴ�.");
										break;
									}
								}
							} // �湮�� ��
							else if(ch2==2) {
								System.out.println("�˸�)) �α׾ƿ�");
								break; // ���� ����� �ݺ��� Ż��
							}
							else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
						} // while2 end
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					} // if end	 
				} // for end
				
				// �α��� ���н�
				if(login==false) System.out.println("�˸�)) ȸ�������� ���ų� �ٸ��ϴ�.");				
			} // �α��� ����
			else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
		} // while end
		
		
		
		
		
		
	} // m e
	
	
} // c e
