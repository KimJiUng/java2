package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_3_�޷� { // c s
	
	
	public static void main(String[] args) { // m s
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("���� : "); int year = scanner.nextInt();
				System.out.println("�� : "); int month = scanner.nextInt();
				if(month<1 || month>12) {
					System.out.println("1~12�� ���̷� �Է����ּ���.");
				}else {
					boolean exit = �޷�(year, month); 
					if(exit==false) {
						break;
					}
				}
				
			}catch(Exception e){
				System.out.println("�߸��� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			} 
			
			
		} // while end
				
		
				
		
	} // m e
	
	// 1. �޷¸޼ҵ�
	public static boolean �޷�(int year, int month) {
		
		while(true) {
			try {
			// 1. Ķ���� Ŭ������ ���� ��¥/�ð� ��ü ȣ��
					Calendar calendar = Calendar.getInstance();
					
					// 2. ���� ����, ��, ��
	//				int year = calendar.get(Calendar.YEAR);
	//				int month = calendar.get(Calendar.MONTH)+1;
					int day = calendar.get(Calendar.DAY_OF_MONTH);
					// * �ش� ���� 1���� ���� ã��
						// 1. ����� ���� Ķ���� ����
					calendar.set(year, month-1, 1); // �� 3��1��
						// 2. 3��1���� ����
					int sweek = calendar.get(Calendar.DAY_OF_WEEK);
						// 3. 3���� ������ ��
					int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
										// �ش糯¥�� ������ �ϼ�
					// 3. ���
					System.out.println(" ********************* "+year+"��"+month+"�� **********************");
					System.out.println("��\t��\tȭ\t��\t��\t��\t��");
					
					// * ���� �� 1���� ��ġ �տ� ���� ä���
					for(int i=1; i<sweek; i++) {
						System.out.print("\t");
					}
					// 1�Ϻ��� ������ ��¥���� ���
					for(int i=1; i<=eday; i++) {
						
						System.out.print(i+"\t");
						// ����ϸ��� �ٹٲ�ó�� [ ����� = 7 ] ������ 7������� �ٹٲ�
						if(sweek%7==0) {
							System.out.println();
						}
						sweek++; // �Ϸ羿 ���� ����
					}
					
					// ��ư [ 1.��(������) 2.��(������) 3.�ٽð˻� ]
					Scanner scanner = new Scanner(System.in);
					System.out.println("\n1.��(������) 2.��(������) 3.�ٽð˻� 4.����");
					int ch = scanner.nextInt();
					
					if(ch==1) {
						if(month==1) {
							year -= 1; month = 12;
						}
						else month -= 1; 
					}
					else if(ch==2) {
						if(month==12) {
							year += 1; month = 1;
						}
						else month += 1; 
					}
					else if(ch==3) {
						System.out.println("���� : "); year = scanner.nextInt();
						System.out.println("�� : "); month = scanner.nextInt();
						if(month<1 || month>12) {
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					}
					else if(ch==4) {
						return false; // �޼ҵ� ����
					}
			} catch(Exception e) {
				
			}
		} // while end
					
				
				
				
	}
	
	
	
	
	
} // c e
