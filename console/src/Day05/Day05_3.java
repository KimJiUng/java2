package Day05;

import java.util.Scanner;

public class Day05_3 { // c s

	public static void main(String[] args) { // m s
		
		// p.181
			// 7.
		int max = 0;
		int[] array = {1,5,3,8,2};
		
		for(int i=0; i<array.length; i++) {
			if(max<array[i]) max = array[i];
			// ���࿡ max���� i��° �ε����� ���� �� ũ�� max�� i��° �� ����
		}
		System.out.println("max : "+max);
			
			// 8.
		int[][] array2 ={ 
						{95, 86},
						{83, 92, 96},
						{78, 83, 93, 87, 88}
						};
		int sum =0;
		double avg = 0.0;
		
		int count = 0;
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				sum += array2[i][j]; // �����հ�
			}
			count += array2[i].length;
		}
		
		avg = (double)sum/count;
		System.out.println("count : "+count);
		System.out.println("sum : "+sum);
		System.out.println("avg : "+avg);
		
		
			// 9.
		boolean run = true; // while�� ����ġ ����
		int studentNum = 0; 
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
	
		
		while(run) { // 
			System.out.println("---------------------------------------------");
			System.out.println("1.�л��� | 2.�����Է� | 3.��������Ʈ | 4.�м� | 5.����");
			System.out.println("---------------------------------------------");
			System.out.println("����>");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1) { // �л��� �Է�
				System.out.println("�л���>"); studentNum = scanner.nextInt();
				// �Է¹��� �л��� ��ŭ �迭���� ����
				scores = new int[studentNum];
			}
			else if(selectNo==2) { // �л� ���� �Է�
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d] : \n",i); scores[i] = scanner.nextInt(); // �Է¹޾� i��° �ε����� ����
				}
			}
			else if(selectNo==3) { // �л� ���� ���
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d] : %d\n",i,scores[i]);
				}
			}
			else if(selectNo==4) {
				int max2 =0;
				int sum2 = 0;
				double avg2 =0.0;
				
				for(int i=0; i<scores.length; i++) {
					if(max2<scores[i]) max2=scores[i];
					sum2 += scores[i];
				}
				avg2 = sum2/scores.length;
				System.out.println("�ְ� ���� : "+max2);
				System.out.println("��� ���� : "+avg2);
			}
			else if(selectNo==5) {
				run = false; // break; // �ݺ��� Ż��
			}

		} // while end
		System.out.println("���α׷� ����");	
	} // m e
} // c e
 