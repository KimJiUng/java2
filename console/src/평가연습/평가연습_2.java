package �򰡿���;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class �򰡿���_2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			System.out.println("---------���� ��Ȳ ǥ----------");
			System.out.println("���� �ð� : "+sdf.format(date));
			System.out.println("��¥\t������ȣ\t�����ð�\t�����ð�\t�ݾ�");
			System.out.println("-----------------------------");
			System.out.println("1.����     2.����");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("������ȣ �Է� : ");
				String carnum = scanner.next();
				Controller2.incar();
			}
			else if(ch==2) {
				System.out.println("������ȣ �Է� : ");
				String carnum = scanner.next();
				Controller2.outcar();
			}
			else System.out.println("�� �� ���� ��ȣ�Դϴ�.");
			
			
			
			
			
		}
		
		
	}
	
	
}
