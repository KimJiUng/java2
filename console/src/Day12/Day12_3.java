package Day12;

import java.util.Arrays;

public class Day12_3 { // c s

	public static void main(String[] args) { // m s
		
		// ���� �˻� ���α׷�
			// [����]
			// 1. �Է¹ޱ� [ System.in.read() ]
			// 2. String �迭�� �̿��� �������� ������ ����
				// String[] ������� = {	
				//	"�ȴ�! ���̹� ��α�&����Ʈ",
				//	"������ ��Ʈ ���� Ȱ�� ������",
				//	"Tucker�� Go ��� ���α׷���",
				//	"ȥ�� �����ϴ� C ���"
			// 3. �˻���� , �������
				// �˻���� : Ư�� ���ڸ� �Է¹޾� ������ ���Ե� ���ڰ� ������ ��� ���
					// '���' �˻� -> "ȥ�� �����ϴ� C ���" , "Tucker�� Go ��� ���α׷���"
					// '����' ���� -> ���õ� �������� ������ ���ڿ� ���ο� ���� �Է¹޾� -> ���� �Ϸ�
		
		String[] book = new String[4];
		byte[] bytes = new byte[100];
		book[0] = "�ȴ�! ���̹� ��α�&����Ʈ";
		book[1] = "������ ��Ʈ ���� Ȱ�� ������";
		book[2] = "Tucker�� Go ��� ���α׷���";
		book[3] = "ȥ�� �����ϴ� C ���";
		
		while(true) {
			try {
				System.out.println("---------------------���� �˻� ���α׷�---------------------");
				System.out.println("������ȣ\t������");
				for(int i=0; i<book.length; i++) {
					
					System.out.println(i+"\t"+book[i]);
				}
				System.out.println("------------------------------------------------------");
				System.out.println("�޴� : 1. �����˻� 2. ��������");
				int count = System.in.read(bytes);
				String ch = new String(bytes,0,count-2);
				if(ch.equals("1")) {
					System.out.print("���� �˻� : "); int serch = System.in.read(bytes);
					
					String serchbook = new String(bytes,0,serch-2);
					
					System.out.println("---------------------�˻� ���---------------------------");
					
					System.out.println("������ȣ\t������");
					for( int i=0; i<book.length; i++) {
						
						if(book[i].indexOf(serchbook)!=-1) {
							
							System.out.println(i+"\t"+book[i]);
						}
					}
				} // if end
				else if(ch.equals("2")) {
					System.out.println("������ ���� ��ȣ �Է� : ");
					int update = System.in.read(bytes);
					String num = new String(bytes, 0, update-2);
					
					System.out.println("���� ���� �Է� : "); 
					int update2 = System.in.read(bytes);
					String oldbook = new String(bytes,0,update2-2);
					boolean check = false;	
						if(book[Integer.parseInt(num)].indexOf(oldbook)!=-1) {
							System.out.println("���ο� ���� �Է� : ");
							int update3 = System.in.read(bytes);
							String newbook = new String(bytes,0,update3-2);
							
							book[Integer.parseInt(num)] = book[Integer.parseInt(num)].replace(oldbook, newbook);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							check = true;
							
						}
					if(check==false) System.out.println("�Է��� ���ڰ� �������� �ʽ��ϴ�.");
					
					
				}
				else System.out.println("�߸��� �Է��Դϴ�.");
				
			
			} catch(Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
			
		} // while end
		
		
		
		
	} // m e
	
	
} // c e
