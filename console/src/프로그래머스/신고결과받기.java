package ���α׷��ӽ�;

import java.util.Scanner;

public class �Ű����ޱ� {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        return answer;
    }
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String[] id_list = new String[1000];
		String[] report = new String[200000];
		
		while(true) {
			///////////////////////////ID ����/�α���////////////////////////////
			System.out.println("1.ȸ������ 2.�α���"); int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("ID �Է� : ");
				String id = scanner.next();
				if(id.length()>0 && id.length()<11) {
					for(int i=0; i<id_list.length; i++) {
						if(i==id_list.length-1) {
							System.out.println("���̻� ID ������ �Ұ����մϴ�.");
						}else {
							if(id_list[i]!=null && id_list[i].equals(id)) {
								System.out.println("�̹� �����ϴ� ID�Դϴ�.");
								break;
							}
							else {
								id_list[i]=id;
								System.out.println("ȸ�����Լ���");
								break;
							}
						}
						
					}
				
				} // if end
				else System.out.println("ID�� ���̴� 1~10���̿��� �մϴ�.");
			}
			else if(ch==2) {
				System.out.println("ID �Է� : "); String id = scanner.next();
				boolean idcheck = false;
				boolean rpidcheck = false;
				for(int i=0; i<id_list.length; i++) {
					if(id_list[i]!=null && id_list[i].equals(id)) {
						System.out.println("�α��� ����");
						idcheck = true;
						while(true) {
							System.out.println("�Ű��� ���̵� �Է� : "); String rpid = scanner.next();
							if(rpid.length()>0 && rpid.length()<11) {
								for(int j=0; j<id_list.length; j++) {
									if(id_list[j]!=null && id_list[j].equals(rpid)) {
										
										if(report[j]==null) {
											report[j]=id+" "+rpid;
											System.out.println(rpid+"�Ű� �Ϸ�Ǿ����ϴ�.");
											rpidcheck=true;
											break;
										}
									
									} // if end
									
									
								} // for end
							} // if end
							
					
							if(rpidcheck==false) {
								System.out.println("��ġ�ϴ� ID�� �����ϴ�.");
							}
							break;
						}
					}
				} // for end
				if(idcheck==false) {
					System.out.println("�α��� ����");
				}
				
			}
			
			/////////////////////////////////////////////////////////
			
		} // while end
		
		
		
		
		
		
		
		
	} // m e
	
} // c e
