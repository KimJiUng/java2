package Day12;

import java.util.Scanner;

public class ���α׷��־��Ȱ��_������ { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		int[][] student = new int[100][6];
		String[] names = new String[100];
		double[] avg = new double[100];
		
		while(true) {
			try {
				System.out.println("---------------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ");
				System.out.println("---------------------------------------------------------------");
				System.out.println(" ��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				System.out.println("---------------------------------------------------------------");
				
				for(int j=0; j<student.length; j++) {
					student[j][5]=0;
				}
				for(int j=0; j<student.length; j++) {
					for(int k=0; k<student.length; k++) {
						if(student[j][4]<student[k][4]) {
							student[j][5] = student[j][5]+1;
						}
					}
				}
				
				for(int i=0; i<student.length; i++) {
					for(int j=i+1; j<student.length; j++) {
						if(student[i][4]<student[j][4]) {
							int temp = student[i][0]; student[i][0] = student[j][0]; student[j][0] = temp;
							temp = student[i][1]; student[i][1] = student[j][1]; student[j][1] = temp;
							temp = student[i][2]; student[i][2] = student[j][2]; student[j][2] = temp;
							temp = student[i][3]; student[i][3] = student[j][3]; student[j][3] = temp;
							temp = student[i][4]; student[i][4] = student[j][4]; student[j][4] = temp;
							temp = student[i][5]; student[i][5] = student[j][5]; student[j][5] = temp;
							String temp2 = names[i]; names[i] = names[j]; names[j] = temp2;
							double temp3 = avg[i]; avg[i] = avg[j]; avg[j] = temp3;
							
						}
					}
				}
				
				
				for(int i=0; i<student.length; i++) {
					if(names[i]!=null) {
						System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n",
								student[i][0],names[i],student[i][1],student[i][2],student[i][3],student[i][4],avg[i],(student[i][5]+1) );
					}
				}
				
				
				System.out.println("---------------------------------------------------------------");
				System.out.println();
				System.out.println("�޴� : 1. �л����� ��� 2. �л����� ����");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("------------------------�л� ���� ���-----------------------------");
					System.out.println("�л� ��ȣ �Է� : "); int num = scanner.nextInt();
					boolean numcheck = true;
					for (int a=0; a<student.length; a++) {
						if(student[a][0]==num) {
							System.out.println("�˸�)) �̹� ��ϵ� �л� ��ȣ�Դϴ�.");
							numcheck = false;
							break;
						}
						
					}
					if(numcheck) {
						System.out.println("�л� �̸� �Է� : "); String name = scanner.next();
						System.out.println("���� ���� �Է� : "); int kor = scanner.nextInt();
						System.out.println("���� ���� �Է� : "); int eng = scanner.nextInt();
						System.out.println("���� ���� �Է� : "); int math = scanner.nextInt();
						boolean full = false;
						for(int i=0; i<student.length; i++) {
							if(student[i][0]==0) {
								student[i][0] = num;
								student[i][1] = kor;
								student[i][2] = eng;
								student[i][3] = math;
								student[i][4] = kor+eng+math;
								avg[i] = (double)(kor+eng+math)/3;
								names[i] = name;
								full = true;
								System.out.println("�˸�)) ����� �Ϸ�Ǿ����ϴ�.");
								break;
							} // if end
						} // for end
						if(full==false) System.out.println("�˸�)) �� �̻� ����� �� �����ϴ�.[��Ͻ���]");
					}
					
					
					
				} // �л� ���� ��� ����
				else if(ch==2) {
					System.out.println("------------------------�л� ���� ����-----------------------------");
					System.out.println("������ �л� ��ȣ �Է� : "); int num = scanner.nextInt();
					boolean delete = false;
					for(int i=0; i<student.length; i++) {
						if(student[i][0]!=0 && student[i][0]==num) {
							student[i][0] = 0;
							student[i][1] = 0;
							student[i][2] = 0;
							student[i][3] = 0;
							student[i][4] = 0;
							student[i][5] = 0;
							names[i] = null;
							avg[i] = 0.0;
							for(int j=i; j<student.length; j++) {
								if(j==student.length-1) {
									student[j][0] = 0;
									student[j][1] = 0;
									student[j][2] = 0;
									student[j][3] = 0;
									student[j][4] = 0;
									student[j][5] = 0;
									names[j] = null;
									avg[j] = 0.0;
								}else {
									student[j]=student[j+1];
									names[j]=names[j+1];
									avg[j]=avg[j+1];
								}
							}
							delete = true;
							break;	
						}
					}
					if(delete==false) System.out.println("�˸�)) ��ġ�ϴ� �л� ��ȣ�� �����ϴ�.[��������]");
				}
				else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
			}catch(Exception e) {
				System.out.println("�˸�)) �߸��� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}
			
			
			
		} // while end
		
	} // m e
	
	
} // c e
