package ���α׷��־������;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				System.out.println("------------------------------���� ��Ȳ ǥ--------------------------------");
				System.out.println("\t\t���� �ð� : "+sdf.format(date)+"\n");
				System.out.println(" ��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�");
				for(Car temp : Controller.carlist) {
					System.out.println(temp.getIntimeymd()+"\t"+temp.getCarnum()+"\t"+temp.getIntimehm()+"\t\t"+
				temp.getOuttime()+"\t\t"+temp.getPay());
				}
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("1.���� 2.����");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("������ȣ �Է� : "); String carnum = scanner.next();
					boolean result = Controller.incar(date,carnum);
					if(result) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}
					else System.out.println("�̹� �������� �����Դϴ�.");
				}
				else if(ch==2) {
					System.out.println("������ȣ �Է� : "); String carnum = scanner.next();
					int result = Controller.outcar(carnum);
					if(result == 1) {
						Controller.count(carnum);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}
					else if(result == 2) {
						System.out.println("�̹� ������ �����Դϴ�.");
					}
					else if(result == 3) {
						System.out.println("��ġ�ϴ� ������ȣ�� �����ϴ�.");
					}
					
				}
				else System.out.println("�� �� ���� ��ȣ�Դϴ�.");
			}catch(Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}
			
			
		} // while end
			
		
		
		
		
	} // m e
	
} // c e
