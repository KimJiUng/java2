package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_3 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		int com;
		int win = 0; int draw = 0; int lose = 0;
		
		while(true) { // ���α׷� ���� [ ���ѷ��� �������� : 4�� �Է½� ����(break;)]
			System.out.println("-------���������� ����--------");
			System.out.println("1.���� 2.���� 3.��      4.����"); int player = scanner.nextInt();
			if(0<player && player<4) {
				System.out.println("�÷��̾ �� �� : "+player);
				
				Random random = new Random(); // ���� ��ü ����
				com = random.nextInt(3)+1; // ������ int��(����)���� ��������
						// random.nextInt() : int�� ǥ���� �� �ִ� ������ ���� �߻�
						// random.nextInt(��) : 0~�� ������ ������ ���� �߻�
						// random.nextInt(10) : 0~9 �� ���� �߻�
						// random.nextInt(10)+10 : 10~19 �� ���� �߻�
						// random.nextInt(����ȣ)+���۹�ȣ
				System.out.println("��ǻ�Ͱ� �� �� : "+com);
				
				if(player==1) {
					if(com==1) {
						System.err.println("�˸�)) ���º�");
						draw++;
					}
					if(com==2) {
						System.err.println("�˸�)) �й�");
						lose++;
					}
					if(com==3) {
						System.err.println("�˸�)) �¸�");
						win++;
					}
				}
				else if(player==2) {
					if(com==1) {
						System.err.println("�˸�)) �¸�");
						win++;
					}
					if(com==2) {
						System.err.println("�˸�)) ���º�");
						draw++;
					}
					if(com==3) {
						System.err.println("�˸�)) �й�");
						lose++;
					}
				}
				else if(player==3) {
					if(com==1) {
						System.err.println("�˸�)) �й�");
						lose++;
					}
					if(com==2) {
						System.err.println("�˸�)) �¸�");
						win++;
					}
					if(com==3) {
						System.err.println("�˸�)) ���º�");
						draw++;
					}
				}
				
			} // if end
			else if(player==4){ // ����
				System.out.println("---------���� ����-----------");
				System.out.println("�� ���� �� : "+(win+draw+lose));
				System.out.printf("�¸� : %d ���º� : %d �й� : %d\n",win,draw,lose);
				if(win>lose) {
					System.err.println("player win");
				}
				else if(win<lose) {
					System.err.println("computer win");
				}
				else System.err.println("draw");
				break;
			}
			else System.out.println("�˸�)) �߸��� �Է��Դϴ�.");
			

		} // while end
		
		
		
		
	} // m e
	
	
} // c e
