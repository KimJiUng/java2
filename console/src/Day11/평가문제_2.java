package Day11;

import java.util.Scanner;

public class �򰡹���_2 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		Student[] students = new Student[100];
		Student[] students2 = new Student[100];
		
		while(true) {
			try {
				System.out.println("-------------------------------------------");
				System.out.println("\t\t��\t��\tǥ");
				System.out.println("-------------------------------------------");
				System.out.println(" ��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				int a=0;
				for(Student temp : students) {
					if(temp!=null) {
						double avg = (double)temp.getSum()/3;
						System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n", temp.getNum(),temp.getName(),temp.getKor(),temp.getEng(),temp.getMath(),temp.getSum(),avg,a+1 );
					}
					a++;
				}
				
				System.out.println("-------------------------------------------");
				System.out.println();
				System.out.println("�޴� : 1. �л����� ��� 2. �л����� ����");
				int ch = scanner.nextInt();
				
				if(ch==1) { // �л����� ���
					
					System.out.println("��ȣ : "); int num = scanner.nextInt();
					System.out.println("�̸� : "); String name = scanner.next();
					System.out.println("���� : "); int kor = scanner.nextInt();
					System.out.println("���� : "); int eng = scanner.nextInt();
					System.out.println("���� : "); int math = scanner.nextInt();
					int i=0;
					for(Student temp : students) {
						if(temp==null) {
							int sum = kor+eng+math;
							Student student = new Student(name, kor, eng, math,num,sum);
							students[i] = student;
							
							break;
						}
						i++;
					}
					
				} // if end
				else if(ch==2) {
					System.out.println("������ �л� ��ȣ �Է� : ");
					int num = scanner.nextInt();
					int i=0;
					for(Student temp : students) {
						if(temp!=null && temp.getNum()==num) {
							students[num]=null;
							for(int j=i; j<students.length; j++) {
								if(j==students.length-1) {
									students[students.length-1]=null;
								}
								else {
									students[j]=students[j+1];
								}
							}
						}
						i++;
						
					}
					
					
				} // else if end
				else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
			}catch(Exception e) {
				System.out.println("�˸�)) �߸��� �����Դϴ�.");
				scanner = new Scanner(System.in);
			}
		} // while end
		
		
		
		
		
		
	} // m e
	
	
	
} // c e
