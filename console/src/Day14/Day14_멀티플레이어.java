package Day14;

import java.util.Scanner;

public class Day14_��Ƽ�÷��̾� { // c s

	// ���� [ 1.�Ҹ����/���� 2.�������/���� ]
	
	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		// ���� ��� ���� ����
		boolean soundsw = true;
		boolean moviesw = true;
		
		while(true) {
			System.out.print("1.�Ҹ���� 2.������� :");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				
				Sound sound = new Sound(); // �� ��ü ����
				
				if(soundsw) { // �Ҹ����
					sound.soundstop(true);
					sound.start();
					
					soundsw = false; // �Ҹ� ����
				}
				else {
					sound.soundstop(false);
					soundsw = true; // ��������

				}
				
			} 
			else if(ch==2) {
				
				Movie movie = new Movie();
				
				if(moviesw) {
					movie.moviestop(true);
					movie.start();
					moviesw = false;
				}
				else {
					movie.moviestop(false);
					moviesw = true;
				}
				
				
			}
			
		}
		
		
	} // m e
	
} // c e
