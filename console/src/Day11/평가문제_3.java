package Day11;

import java.util.Scanner;

public class �򰡹���_3 { // c s

	public static void main(String[] args) { // m s
		Scanner scanner = new Scanner(System.in);
		int[][] student = new int[100][6];
		String[] names = new String[100];
		double[] avg = new double[100];
		
		while(true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ");
				System.out.println("------------------------------------------------------------");
				System.out.println(" ��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				
				for (int i=0; i < student.length ; i++ ){
					for (int j =i+1; j <student.length ; j++ ){
						if (avg[j] > avg[i]){
							//�̸�, ����, ����, ����, ����, ��� �� �ٲ����
							String temp = names[i];
							names[i] = names[j];
							names[j] = temp;

							int temp2 = student[i][1];
							student[i][1] = student[j][1];
							student[j][1] = temp2;

							temp2 = student[i][2];
							student[i][2] = student[j][2];
							student[j][2] = temp2;

							temp2 = student[i][3];
							student[i][3] = student[j][3];
							student[j][3] = temp2;

							temp2 = student[i][4];
							student[i][4] = student[j][4];
							student[j][4] = temp2;

							double temp3 = avg[i];
							avg[i] = avg[j];
							avg[j] = temp3;
							
							temp2 = student[i][0];
							student[i][0] = student[j][0];
							student[j][0] = temp2;

							temp2 = student[i][5];
							student[i][5] = student[j][5];
							student[j][5] = temp2;
						}
					}
				}

				for(int i=0; i<student.length; i++) {
					if(student[i][0]!=0) {
						System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n",
								student[i][0],names[i],student[i][1],student[i][2],student[i][3],student[i][4],avg[i],student[i][5]+1 );
					}
					
				
				}
				System.out.println("------------------------------------------------------------");
				System.out.println();
				System.out.println("�޴� : 1. �л����� ��� 2. �л����� ����");
				int ch = scanner.nextInt();
				if(ch==1) { // �л����� ���
					
					System.out.println("��ȣ : "); int num = scanner.nextInt();
					System.out.println("�̸� : "); String name = scanner.next();
					System.out.println("���� : "); int kor = scanner.nextInt();
					System.out.println("���� : "); int eng = scanner.nextInt();
					System.out.println("���� : "); int math = scanner.nextInt();
					
					for(int i=0; i<student.length; i++) {
						if(student[i][0]==0) {
							student[i][0] = num;
							student[i][1] = kor;
							student[i][2] = eng;
							student[i][3] = math;
							student[i][4] = kor+eng+math;
							avg[i] = (double)(kor+eng+math)/3;
							names[i] = name;
							System.out.println("�˸�)) ���� ����� �Ϸ�Ǿ����ϴ�.");
							break;
						} 
					} // for end
					for(int i=0; i<student.length; i++) {
						student[i][5]=0;
					}
					for(int i=0; i<student.length; i++) {
						for(int j=0; j<student.length; j++) {
							if(student[i][4]<student[j][4]) {
								student[i][5]=student[i][5]+1;
							}
						}
					}
				} // ������� ����
				else if(ch==2) {
					System.out.println("������ �л� ��ȣ �Է� : "); int num = scanner.nextInt();
					boolean delete = false;
					for(int i=0; i<student.length; i++) {
						if(student[i][0]!=0 && student[i][0]==num) {
							student[i][0]=0;
							student[i][1]=0;
							student[i][2]=0;
							student[i][3]=0;
							student[i][4]=0;
							names[i]=null;
							avg[i]=0.0;
							for(int j=i; j<student.length; j++) {
								if(j==student.length-1) {
									student[j][0]=0;
									student[j][1]=0;
									student[j][2]=0;
									student[j][3]=0;
									student[j][4]=0;
									names[j]=null;
									avg[j]=0.0;
									break;
								}
								else {
									student[j]=student[j+1];
									names[j]=names[j+1];
									avg[j]=avg[j+1];
								}
							} // for2 end
							System.out.println("�˸�)) ������ �Ϸ�Ǿ����ϴ�.");
							delete=true;
						} // if end
						
					} // for end
					if(delete==false) System.out.println("�˸�)) ��ġ�ϴ� ��ȣ�� �����ϴ�.");
					
				}
				else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
			}catch(Exception e) {
				System.out.println("�˸�)) �߸��� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}
		} // while end
	} // m e
	
	
} // c e
