package Day12;

import java.util.Random;
import java.util.Scanner;

public class Day12_4 { // c s

	// ������ȣ ����
	// ����
		// 1. ���� 0000~9999 ������ ������ȣ ���� 10�� ����
		// 2. ��� ���� ��ȣ�� �迭�� ����
		// 3. ���ڸ� ��ȣ�� Ȧ��/¦�� ����
		// 4. ���� ���ڸ� ��ȣ�� Ȧ�� ���� �迭�� ����
		// 5. ���� ���ڸ� ��ȣ�� ¦�� ���� �迭�� ����
		// 6. Ȧ�� ���� �迭 ��� / ¦�� ���� �迭 ���
		
	public static void main(String[] args) { // m s
		String[] car = new String[10];
		String[] odd = new String[10];
		String[] even = new String[10];
		byte[] bytes = new byte[100];
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			try {
				// ��� ������ȣ ���
				System.out.println("\n** �������� ��� ���� ��ȣ **");
				for(String temp : car) {
					if(temp!=null) {
						System.out.print(temp+"\t");
					}	
				}
				// Ȧ�� ���� ��ȣ ���
				System.out.println("\n** �������� ��� Ȧ�� ���� **");
				for(String temp : odd) {
					if(temp!=null) System.out.print(temp+"[Ȧ]\t");
				}
				
				// ¦�� ���� ��ȣ ���
				System.out.println("\n** �������� ��� ¦�� ���� **");
				for(String temp : even) {
					if(temp!=null) System.out.print(temp+"[¦]\t");
				}
				System.out.println("\n1.��������"); int ch = scanner.nextInt();
				if(ch==1) {
					// ������ȣ ���� ����
					Random random = new Random(); // ���� ��ü
					int intnum = random.nextInt(10000); // 0~9999 �� ���� �߻�
					String strnum = String.format("%04d", intnum);
											// ���� 
												// %d : ����
												// %����d : ���ڸ�ŭ �ڸ��� [���� �ش� �ڸ����� ������ ����]
												// %0����d : ���ڸ�ŭ �ڸ��� [���� �ش� �ڸ����� ������ 0]
					// �迭�� ������ ã�� ������ȣ ����
					boolean save = false;
					for(int i=0; i<car.length; i++) {
						if(car[i]==null) {car[i]=strnum; save=true; break;}	
					}
					if(save==true) {

							if(Integer.parseInt(strnum)%2 == 0) {
								for(int i=0; i<even.length; i++) {
									if(even[i]==null) {even[i]=strnum; break;}
								}
							} else {
								for(int i=0; i<odd.length; i++) {
									if(odd[i]==null) {odd[i]=strnum; break;}
								}
							}
										
					}
					
					// ���࿡ ������� ������ ����
					if(save==false) System.out.println("���� [���� �Ұ�]");
				}
				
				
				
			}catch(Exception e) {
				
			}
		} // while end
		
		
		
		
		
		
		
		
		
		
	} // m e
	
	
	
	
} // c e
