package Day11;

import java.util.Scanner;

public class �򰡹���_1 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		int[][] �л����� = new int[100][5];
		String[] �̸� = new String[100];
		int[] ���� = new int[100];
		double[] ��� = new double[100];
		
		while(true) {
			try {
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ");
				System.out.println("-----------------------------------------------------------");
				System.out.println(" ��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				System.out.println("-----------------------------------------------------------");
				
				for(int i=0; i<�л�����.length; i++) {
					if(�л�����[i][0]!=0) {
						
						
						
						System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n",
								�л�����[����[i]][0], �̸�[����[i]], �л�����[����[i]][1], �л�����[����[i]][2], �л�����[����[i]][3], �л�����[����[i]][4], ���[����[i]], i+1) ;
					}
				}
				System.out.println("�޴� : 1. �л����� ��� 2. �л����� ����");
				int ch = scanner.nextInt();
				if(ch==1) { // �л����� ���
					
					System.out.println("��ȣ : "); int num = scanner.nextInt();
					System.out.println("�̸� : "); String name = scanner.next();
					System.out.println("���� : "); int korean = scanner.nextInt();
					System.out.println("���� : "); int english = scanner.nextInt();
					System.out.println("���� : "); int math = scanner.nextInt();
					
					for(int i=0; i<�л�����.length; i++) {
						if(�л�����[i][0]==0) {
							�л�����[i][0] = num;
							�̸�[i] = name;
							�л�����[i][1] = korean;
							�л�����[i][2] = english;
							�л�����[i][3] = math;
							�л�����[i][4] = �л�����[i][1]+�л�����[i][2]+�л�����[i][3];
							
							���[i] = (double)�л�����[i][4]/3;
							break;
						}
					}
					for(int i=0; i<����.length; i++) {
						����[i]=0;
					}
					for(int i=0; i<����.length; i++) {
						for(int j=0; j<����.length; j++) {
							if(�л�����[i][4]<�л�����[j][4]) {
								����[i]=����[i]+1;
							}
						}
					}
					
				} // if end
				else if(ch==2) { // �л����� ����
					System.out.println("������ �л� ��ȣ �Է� : "); int num = scanner.nextInt();
					
					for(int i=0; i<�л�����.length; i++) {
						if(�л�����[i][0]!=0 && �л�����[i][0]==num) {
							�л�����[i][0]=0;
							�л�����[i][1]=0;
							�л�����[i][2]=0;
							�л�����[i][3]=0;
							����[i]=0;
							�̸�[i]=null;
							���[i]=0.0;
							for(int j=i; j<�л�����.length; j++) {
								if(j==�л�����.length-1) {
									�л�����[j][0]=0;
									�л�����[j][1]=0;
									�л�����[j][2]=0;
									�л�����[j][3]=0;
									����[j]=0;
									�̸�[j]=null;
									���[j]=0.0;
									break;
								}
								else {
									�л�����[j]=�л�����[j+1];
									����[j]=����[j+1];
									�̸�[j]=�̸�[j+1];
									���[j]=���[j+1];
								}
							} // for2 end
						} // if end
					} // for end
					
					
					
				} // else if end
				else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
			} catch(Exception e) {
				System.out.println("�˸�)) �߸��� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}
			
			
			
			
		} // while end
		
		
		
		
		
		
		
		
	} // m e
	
	
	
} // c e
