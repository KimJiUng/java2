package Day05;

import java.util.Scanner;

public class Day05_4 { // c s

	public static void main(String[] args) { // m s
		
		// ���� �뿩 console ���α׷�
		
			// 1. �迭
				// 1. ȸ��[���̵�(�ߺ�x), ��й�ȣ]
				// 2. ����[������(�ߺ�x), �����뿩����, �뿩��]
		
			// 2. �ʱ�޴�
				// 1. ȸ������ 2. �α���
					// 1. ȸ�����Խ� ���̵� �ߺ�üũ
					// 2. �α��� ������ �α��θ޴�, �α��� ���н� �α��ν��� ���
		
			// 3. �α��ν� �޴�
				// 1. �����˻� 2. ������� 3. �����뿩 4. �����ݳ� 5. �α׾ƿ�
					// 1. �����˻��� �������� ��ġ�ϸ� ��� �ƴϸ� ���� ���
					// 2. ������Ͻ� ��� ������ ���
					// 3. �����뿩�� �����뿩���ΰ� �����Ҷ� �����뿩
					// 4. �����ݳ��� ������ �뿩�� ������ �ݳ� ó��
					// 5. �α׾ƿ��� �ʱ�޴���
		
			// 4. �α��ν� ���̵� admin �̸� �����ڸ޴�
				// 1. ������� 2. ������� 3.�α׾ƿ�
					// 1. ������Ͻ� �������� �Է¹޾� ���� ���ó��
					// 2. ������Ͻ� ��� ������ ���
					// 3. ���������� ������ �������� �Է¹޾� ������ ������ ����[null]
					// 4. �α׾ƿ��� �ʱ�޴���
		
		//��������
		Scanner scanner = new Scanner(System.in);
		String[][] memberlist = new String[2][2]; // ȸ�� ���̵�, ��й�ȣ
		String[][] book = new String[100][3]; // ������, �뿩����, �뿩��
		memberlist[0][0] = "admin";
		memberlist[0][1] = "1234";
	
		//�ʱ�޴�
		while(true) { // ���ѷ��� [�������� : x]
			System.out.println("-------------���� �뿩 ���α׷�----------------");
			System.out.println("1.ȸ������ 2.�α���");
			System.out.println(">���� : "); int select = scanner.nextInt();
			if(select==1) {
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("��й�ȣ : "); String pw = scanner.next();
				
				for(int i=0; i<memberlist.length; i++) {
					boolean idcheck = true;
					//id �ߺ�üũ
					if(memberlist[i][0]!=null && memberlist[i][0].equals(id)) {
						System.out.println("�˸�)) ������ ���̵� �����մϴ�.");
						idcheck = false;
						break;
					}
					else if(idcheck==true) {
						if(memberlist[i][0]==null) {
							memberlist[i][0]=id; memberlist[i][1]=pw; 
							System.out.println("�˸�)) ȸ�������� �Ϸ�Ǿ����ϴ�.");
							break;
						}
					}
				}	
			} // if 1.ȸ������ ����
			else if(select==2) {
				System.out.println("-------------�α��� ������-------------");
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("��й�ȣ : "); String pw = scanner.next();
				
				boolean logincheck = false;
				for(int i=0; i<memberlist.length; i++) {
					if(id.equals("admin") && pw.equals("1234")) {
						System.out.println("�˸�)) ������ �α��� ����");
///////////////////////////////////////////////////////������ �α��� ������ �޴�/////////////////////////////////////////////////////////
						while(true) {
							System.out.println("------------------������ �޴�---------------");
							System.out.println("1. ������� 2. ������� 3.�α׾ƿ� 4.�����뿩 5.�����˻� 6. �����ݳ�"); int admin = scanner.nextInt();
							
							if(admin==1) { // �������
								System.out.println("����� ������ �Է� : "); String book3 = scanner.next();
								
							for(int j=0; j<book.length; j++) {
									boolean admincheck = true;
									// ������ �ߺ�üũ
									if(book[j][0]!=null && book[j][0].equals(book3)) {
										System.out.println("�˸�)) ������ �������� �����մϴ�.");
										admincheck = false;
										break;
									}
									else if(admincheck==true) {
										if(book[j][0]==null) {
											book[j][0]=book3; book[j][1] = "�뿩����";
											System.out.println("�˸�)) ���� ����� �Ϸ�Ǿ����ϴ�.");
											break;
										}
									}
								}
							} // if ������� end
							
							else if(admin==2) { // �������
								System.out.println("------------------���� ���---------------");
								System.out.println("��ȣ\t������\t\t\t�뿩����");
								for(int j=0; j<book.length; j++) {
									if(book[j][0]!=null) {
										System.out.printf("%d\t%s\t\t%s \n", j, book[j][0], book[j][1]);
										
									}
									else break;
								} // for end
								
							} // else if ������� end
							
							else if(admin==3) {
								System.out.println("�˸�)) �α׾ƿ� �Ǿ����ϴ�.");
								id = "0"; pw = "0";
								logincheck = true;
								break;
							} // else if �α׾ƿ� end
							
							else if(admin==4) {
								System.out.println("------------------���� �뿩----------------");
								System.out.println("�뿩�� ������ : "); String borrow = scanner.next();
								for(int j=0; j<book.length; j++) {
									if(book[j][0].equals(borrow) && book[j][0]!=null && book[j][1].equals("�뿩����")) {
										System.out.println("�˸�)) �뿩 ������ å�Դϴ�.");
										System.out.println("1.�뿩 2.���"); int select_3 = scanner.nextInt();
										if(select_3==1) {
											System.out.println("�˸�)) �뿩�� �Ϸ�Ǿ����ϴ�.");
											book[j][1] = "�뿩�Ұ���"; book[j][2]=id;
											break;
										}
										if(select_3==2) {
											System.out.println("�˸�)) ���� ȭ������ ���ư��ϴ�.");
											break;
										}
									}
									else if(book[j][0].equals(borrow) && book[j][0]!=null && book[j][1].equals("�뿩�Ұ���")) {
										System.out.println("�˸�)) �̹� �뿩�� å�Դϴ�.");
										break;
									}

									
								}
							}
							else if(admin==5) {
								System.out.println("----------------------���� �˻�-------------------");
								System.out.println("������ �˻� : "); String bookname = scanner.next();
								for(int j=0; j<book.length; j++) {
									
									if(book[j][0]!=null && book[j][0].equals(bookname)) {
										System.out.println("�˻� ��� : "+bookname+"\t"+book[j][1]);
									}
								}
							
							}
							
							else if(admin==6) {
								System.out.println("----------------------���� �ݳ�-------------------");
								System.out.println("�ݳ� ������ ���� ���");
								for(int j=0; j<book.length; j++) {
									if(book[j][2]!=null) {
										if(book[j][2].equals(id)) {
											System.out.println(book[j][0]);
											System.out.println("�ݳ��� ������ �Է� : "); String book_2 = scanner.next();
											if(book[j][0].equals(book_2)) {
												System.out.println("�˸�)) �ݳ��� �Ϸ�Ǿ����ϴ�.");
												book[j][1] = "�뿩����"; book[j][2] = null;
												break;
											}
											else System.out.println("�˸�)) �߸��� �Է��Դϴ�.");
										}
									}
								}
							}
							
						} // while �����ڸ޴� end						
///////////////////////////////////////////////////////������ �α��� ������ �޴� end/////////////////////////////////////////////////////////
						
					}
					else if(memberlist[i][0]!=null && memberlist[i][0].equals(id) && memberlist[i][1].equals(pw)){
						System.out.println("�˸�)) �α��� ����");
						logincheck = true;
////////////////////////////////////////////////////////�α��� ������ �޴�////////////////////////////////////////////////////////		
						
						while(true) { // �α��� ������ [���� ���� : �α׾ƿ�]
							
								
									System.out.println("--------------------�޴�-----------------------");
									System.out.println("1. �����˻� 2. ������� 3. �����뿩 4. �����ݳ� 5. �α׾ƿ�");
									int select_2 = scanner.nextInt();
									boolean se = true;
									
									
										if(select_2==1) { // �����˻�
											System.out.println("----------------------���� �˻�-------------------");
											System.out.println("������ �˻� : "); String bookname = scanner.next();
											for(int j=0; j<book.length; j++) {
												
												if(book[j][0]!=null && book[j][0].equals(bookname)) {
													System.out.println("�˻� ��� : "+bookname+"\t"+book[j][1]);
												}
											}
										
										}		// if �����˻� ����
										else if(select_2==2) { // �������
											if(se==true) {
												System.out.println("------------------���� ���---------------");
												System.out.println("��ȣ\t������\t\t\t�뿩����");
												for(int k=0; k<book.length; k++) {
													if(book[k][0]!=null) {
														System.out.printf("%d\t%s\t\t%s \n", k, book[k][0], book[k][1]);
													}
													else se=false;
												} // for end
											} // if end
										} // else if ������� ����
										else if(select_2==3) { // �����뿩
											System.out.println("------------------���� �뿩----------------");
											System.out.println("�뿩�� ������ : "); String borrow = scanner.next();
											for(int j=0; j<book.length; j++) {
												if(book[j][0].equals(borrow) && book[j][0]!=null && book[j][1].equals("�뿩����")) {
													System.out.println("�˸�)) �뿩 ������ å�Դϴ�.");
													System.out.println("1.�뿩 2.���"); int select_3 = scanner.nextInt();
													if(select_3==1) {
														System.out.println("�˸�)) �뿩�� �Ϸ�Ǿ����ϴ�.");
														book[j][1] = "�뿩�Ұ���"; book[j][2]=id;
														break;
													}
													if(select_3==2) {
														System.out.println("�˸�)) ���� ȭ������ ���ư��ϴ�.");
														break;
													}
												}
												else if(book[j][0].equals(borrow) && book[j][0]!=null && book[j][1].equals("�뿩�Ұ���")) {
													System.out.println("�˸�)) �̹� �뿩�� å�Դϴ�.");
													break;
												}

												
											}
										} // else if �����뿩 ����
										else if(select_2==4) { // �����ݳ�
											System.out.println("----------------------���� �ݳ�-------------------");
											System.out.println("�ݳ� ������ ���� ���");
											for(int j=0; j<book.length; j++) {
												if(book[j][2]!=null) {
													if(book[j][2].equals(id)) {
														System.out.println(book[j][0]);
														System.out.println("�ݳ��� ������ �Է� : "); String book_2 = scanner.next();
														if(book[j][0].equals(book_2)) {
															System.out.println("�˸�)) �ݳ��� �Ϸ�Ǿ����ϴ�.");
															book[j][1] = "�뿩����"; book[j][2] = null;
															break;
														}
														else System.out.println("�˸�)) �߸��� �Է��Դϴ�.");
													}
												}
											}
										
										} // else if �����ݳ� ����
										else if(select_2==5) { // �α׾ƿ�
										System.out.println("�˸�)) �α׾ƿ� �Ǿ����ϴ�.");

										break;
										} // else if �α׾ƿ� ����
								
							
							
							
						} // while end
						
////////////////////////////////////////////////////////�α��� ������ �޴�////////////////////////////////////////////////////////
						
					}
					
				}
				if(logincheck==false) System.out.println("�˸�)) �α��� ����");
			} // else if 2.�α��� ������ ����
		} // while �ʱ�޴� ����
		
		
		
		
		
	} // m e
	
} // c e
// �����Ϸ�