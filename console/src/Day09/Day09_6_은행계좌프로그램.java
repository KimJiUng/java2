package Day09;

import java.util.Scanner;

public class Day09_6_����������α׷� { // c s

	// ����������α׷� [���]
		// ����[super]
		// ��������[sub], ��������[sub], �ϳ�����[sub]
		// �� ��� : 1.���»��� 2.�Ա� 3.��� 4.��ü 5.�����¸�� 6.����
	
	
	//  ** main �ۿ��� �����ϴ� ����
		// * ��� Ŭ�������� ����ϱ� ���� static �迭�� ����
		// static ������ ���α׷� ���۽� �޸� �Ҵ� 
	public static ����[] ���¸���Ʈ = new ����[100]; 
	
	public static void main(String[] args) { // m s
	
		Scanner scanner = new Scanner(System.in);
		
		while(true) { // ���ѷ��� [ �������� x ] 
			System.out.println("------------------���� �ý���------------------");
			System.out.println("1.���»��� 2.�Ա� 3.��� 4.��ü 5.���¸�� 6.����");
			int ���� = scanner.nextInt();
			// ��Ʈ�ѷ� �޼ҵ� ȣ��� ��ü
			������Ʈ�ѷ� ��Ʈ�� = new ������Ʈ�ѷ�(); // ��Ʈ�ѷ� �޼ҵ� ȣ��� ��ü
			
			if(����==1) {
				System.out.println("+++ ���µ�� ������ +++");
				System.out.println("��й�ȣ : "); String ��й�ȣ = scanner.next();
				System.out.println("������ : "); String ������ = scanner.next();
				System.out.println("���� ���� : 1.�������� 2.�������� 3.�ϳ�����"); int �����ȣ = scanner.nextInt();
				if(�����ȣ<1 || �����ȣ>3) {
					System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
				}
				else {
					// ��Ʈ�ѷ� ����
					String ���¹�ȣ = ��Ʈ��.���»���(��й�ȣ, ������, �����ȣ); // �޼ҵ� ȣ��[�μ� 3��]
					// �޼ҵ� ��ȯ ���� = ���¹�ȣ or null ��ȯ
					// �޼ҵ� ���� �� �޽��� ���
					if(���¹�ȣ!=null) { // ���¹�ȣ�� null�� �ƴϸ� ����
						System.out.println("** ���� ���� **");
						System.out.println("������ ���¹�ȣ : "+���¹�ȣ);
					}
					else System.out.println("�˸�)) ���µ�� ����(�����ڿ��� ����)"); // ���¹�ȣ�� null�̸� ����
				}
					
			}
			else if(����==2) {
				System.out.println("+++ �Ա� ������ +++");
				System.out.println("���� ��ȣ �Է� : "); String ���¹�ȣ = scanner.next();
				System.out.println("�Ա��� �ݾ� �Է� : "); int �Աݾ� = scanner.nextInt();
				boolean result = ��Ʈ��.�Ա�(���¹�ȣ, �Աݾ�);
				
				if (result) {
					System.out.println("** �Ա� ���� **");
				}
				else System.out.println("�˸�)) �Ա� ����(������ ���°� �����ϴ�.)");
				
			}
			else if(����==3) {
				System.out.println("+++ ��� ������ +++");
				System.out.println("���� ��ȣ �Է� : "); String ���¹�ȣ = scanner.next();
				System.out.println("��й�ȣ �Է� : "); String ��й�ȣ = scanner.next();
				System.out.println("����� �ݾ� �Է� : "); int ��ݾ� = scanner.nextInt();
				int result = ��Ʈ��.���(���¹�ȣ,��й�ȣ,��ݾ�);
				
				if (result == 1) {
					System.out.println("** �ܾ� ���� **");
				}
				else if (result == 2) {
					System.out.println("** ��� ���� **");
				}
				else if (result == 3) {
					System.out.println("** �ùٸ� ������ �ƴմϴ�. **");
				}
			}
			else if(����==4) {
				System.out.println("+++ ��ü ������ +++");
				System.out.println("���� ��ȣ �Է� : "); String ���¹�ȣ = scanner.next();
				System.out.println("��й�ȣ �Է� : "); String ��й�ȣ = scanner.next();
				System.out.println("��ü ���� ���� ��ȣ �Է� : "); String ���¹�ȣ2 = scanner.next();
				System.out.println("��ü�� �ݾ� �Է� : "); int ��ü�� = scanner.nextInt();
				
				int result = ��Ʈ��.��ü(���¹�ȣ, ��й�ȣ, ���¹�ȣ2, ��ü��);
				
				if (result == 1) {
					System.out.println("** �ܾ� ���� **");
				}
				else if (result == 2) {
					System.out.println("** ��ü ���� **");
				}
				else if (result == 3) {
					System.out.println("** �޴� ���� ������ �����ϴ�. **");
				}
				else if (result == 4) {
					System.out.println("** ������ ���� ������ �����ϴ�. **");
				}
				
			}
			else if(����==5) {
				System.out.println("+++ ���¸�� ������ +++");
				System.out.println("�̸� �Է� : "); String ������ = scanner.next();
				����[] �����¸�� = ��Ʈ��.���¸��(������);
				
				System.out.println("*** �˻��� "+������+"���� ���� ��� ***");
				int i=1;
				for(���� temp : �����¸��) {
					if(temp!=null) {
					System.out.println(i+"�� ���¹�ȣ : "+temp.get���¹�ȣ()+"\t\t���ݾ� : "+temp.get���ݾ�()+"\t����� : "+(int)temp.get�����());
					}
					i++;
				}
			}
			else if(����==6) {
				System.out.println("+++ ���� ������ +++");
				System.out.println("1.���� 2.�����ȯ 3.�ڷΰ���"); int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("������� ���� �Է� : "); String ������� = scanner.next();
					System.out.println("��й�ȣ �Է� : "); String ��й�ȣ = scanner.next();
					System.out.println("������� �ݾ� �Է� : "); int ����� = scanner.nextInt();
 					boolean result = ��Ʈ��.����(�����,�������,��й�ȣ);
 					if (result) {
 						System.out.println("*** ���� ���� ***");
 					}
 					else System.out.println("*** �ùٸ� ������ �ƴմϴ�. ***");
				}
				else if(ch==2) {
					System.out.println("��ȯ�� ���� �Է� : "); String ������� = scanner.next();
					System.out.println("��й�ȣ �Է� : "); String ��й�ȣ = scanner.next();
					System.out.println("��ȯ�� �ݾ� �Է� : "); int ��ȯ�� = scanner.nextInt();
					int result = ��Ʈ��.�����ȯ(�������,��й�ȣ,��ȯ��);
					
					if(result==1) {
						System.out.println("** �ܾ� ���� **");
					}
					else if(result==2) {
						System.out.println("*** ��ȯ �Ϸ� ***");
					}
					else if(result==3) {
						System.out.println("*** �ùٸ� ������ �ƴմϴ�. ***");
					}
				}
				else if(ch==3) {}
			}
			else System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
			
		} // while end
		
		
		
		
	} // m e
	
	
} // c e
