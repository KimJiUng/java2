
package Day03;

import java.util.Scanner;

public class Day03_4 { // c s

	public static void main(String[] args) { // m s
		
		// ��� : 1. if��  2. switch��
			// if : ���˻�(true or false) / ����Ǽ� ������ ���� ���� ���
				// >= <= > < == !=
			// switch : �����Ͱ˻�{��������}				/ ����Ǽ� ������ �ִ� ���
				// ������ case �̸� ���๮ó�� -> ���� case �̵�
			// ����
				// switch(�˻���){
				// case '��' : ���๮; break;
				// case '��' : ���๮; break;
				// case '��' : ���๮; break;
				// default : ���๮;
				// }
			
			// break; : ���� ����� switch Ȥ�� �ݺ��� Ż��[������] , switch �� ��Ʈ
		
		
		
		// ��1)
		int ���� = 80;
		if(����==90) System.out.println("A���");
		else if(����>=80) System.out.println("B���");
		else if(����>=70) System.out.println("C���");
		else System.out.println("Ż��");
		System.out.println("------------------------------");
		switch(����) {
			case 90 : System.out.println("A���"); break;
			case 80 : System.out.println("B���"); break;
			case 70 : System.out.println("C���"); break;
			default : System.out.println("Ż��"); break;
		}
		
		
		
		// ��2)
		int ��ư =3;
		switch(��ư) {
			case 1 : System.out.println("1������ �̵�"); break;
			case 2 : System.out.println("2������ �̵�"); break;
			case 3 : System.out.println("3������ �̵�"); break;
			case 4 : System.out.println("4������ �̵�"); break;
			default : System.out.println("����");
		}
		
		// ��3)
		char ��� = 'B';
		switch(���) {
			case 'A' :
			case 'B' : System.out.println("��� ȸ��"); break;
			case 'C' :
			case 'D' : System.out.println("�Ϲ� ȸ��"); break;
			default : System.out.println("�մ�");
		}
			
		// ��4)
		String ���� = "����";
		switch(����) {
			case "����" : System.out.println("700����"); break;
			case "����" : System.out.println("500����"); break;
			default : System.out.println("300����");
		}
		
		// ����1) switch ���) ����, ����, ���� ������ �Է¹޾� ����� 90�� �̻��̸� A���, 80�� �̻��̸� B���, ������ Ż��
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���� ���� : "); int ���� = scanner.nextInt();
		System.out.println("���� ���� : "); int ���� = scanner.nextInt();
		System.out.println("���� ���� : "); int ���� = scanner.nextInt();
		
		int ��� =(����+����+����)/3;
		
		switch(���/10) { // 1���ڸ��� ����
			case 9 : System.out.println("A���"); break;
			case 8 : System.out.println("B���"); break;
			default : System.out.println("Ż��");
		}
		
		
		
		
	} // m e
	
	
	
} // c e
