package �򰡿���;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class �򰡿���_1 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		

		while(true) {
			Date date = new Date();
			try {
				System.out.println("-----------------------------���� ��Ȳ ǥ-------------------------------");
				System.out.println("\t\t���� �ð� : "+sdf.format(date));
				System.out.println();
				System.out.println(" \t��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�");
				for(Car temp : Controller.carlist) {
					
					System.out.println(temp.getIntimeymd()+"\t\t"+temp.getCarnum()+"\t\t"+temp.getIntimehm()+
					"\t\t"+temp.getOuttime()+"\t\t"+temp.getPay() );
				}
				
				System.out.println("---------------------------------------------------------------------");
				System.out.println("1. ����   2. ����");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("������ȣ �Է� : ");
					String carnumber = scanner.next();
					boolean result = Controller.incar(date,carnumber);
					
					if(result) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}else {
						System.out.println("�̹� �������� �����Դϴ�.");
					}
				}
				else if(ch==2) {
					System.out.println("������ȣ �Է� : ");
					String carnumber = scanner.next();
					int result = Controller.outcar(carnumber);
					
					if(result==1) {
						System.out.println("��ġ�ϴ� ������ȣ�� �����ϴ�.");
					}
					else if(result==2) {
						System.out.println("�̹� �����Ϸ��� �����Դϴ�.");
					}
					else if(result==3) {
						
						for(int i=0; i<Controller.carlist.size(); i++) {
							if(Controller.carlist.get(i).getCarnum().equals(carnumber)) {
								System.out.println("�����ݾ� : "+Controller.carlist.get(i).getPay());
								System.out.println("�����Ϸ�");
								break;
							}
							
						}
					}
					
				}
				else System.out.println("�� �� ���� ��ȣ�Դϴ�.");
		
			}catch(Exception e) {
				e.printStackTrace();
				scanner = new Scanner(System.in);
			}
					
		}
		
		
	} // m e
	
	
	
} // c e
