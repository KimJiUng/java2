package Day06;

import java.util.Scanner;

public class Day06_3 { // c s

	public static void main(String[] args) { // m s
		
		// ȸ���� ���α׷� [Ŭ���� ����]
			// 0. ȸ�� ���� => ȸ�� Ŭ���� �����
				// 1. �ʵ�
					// 1. ���̵� 2. ��й�ȣ 3. �̸� 4. ��ȭ��ȣ
			// 1. �ʱ�޴� [1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��]
				// 1. ȸ�����Խ� �Է¹޾� ����
				// 2. �α��ν� ���̵�� ��й�ȣ�� �����ϸ� �α���ó��
				// 3. ���̵�ã��� �̸��� ��ȭ��ȣ�� �����ϸ� ���̵� ���
				// 4. ��й�ȣã��� ���̵�� ��ȭ��ȣ�� �����ϸ� ��й�ȣ ���
		
		// ���� �����ϴ� ���� : main �޼ҵ� �������� ����ϱ� ���ؼ�
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];
		// ���࿡ Ŭ������ ������ ��쿡�� String [][] memberlist = new String[100][4];
		// Member Ŭ������ ������� ��ü(id,pw,name,phone) 100�� ������ �� �ִ� �迭 ����
		
		while(true) { // ���α׷� ���� ���ѷ��� [�������� x]
			
			System.out.println("-----------ȸ����[Ŭ��������]------------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��");
			System.out.println("���� : "); int ch = scanner.nextInt();
			
			if(ch==1) {
				// 1. id, pw, name, phone �Է¹ޱ� => ���� 4��
				System.out.println("-------------ȸ������ ������-----------");
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("��й�ȣ : "); String pw = scanner.next();
				System.out.println("�̸� : "); String name = scanner.next();
				System.out.println("����ó : "); String phone = scanner.next();
				
				// 2. ��ü ����
				Member member = new Member();
				
				// 3. �Է¹��� ���� 4�� -> ��ü�� ����
				member.id = id;
				member.pw = pw;
				member.name = name;
				member.phone = phone;
				
				// 4. ���̵� �ߺ��� ���� ��� ������ ��ü�� �迭�� ����
					// 1. ���� �ε��� ã�� [������ �ƴϸ� ����ȸ���� �����ϱ� ����]
					// 2. ���� �ε����� ��ü ����
				int i = 0; // �ε��� ��ġ ����
				
				for(Member temp : memberlist) { // memberlist �迭�� member ��ü �ϳ��� �����ͼ� temp�� ���� �ݺ�
					boolean idcheck=true;
					// * ���̵� �ߺ�üũ
						// 1. �迭�� ��ü�� �Է��� ���̵�� ������ ���̵� ã��
					if(temp!=null && temp.id.equals(id)) {
						System.out.println("�˸�)) ������� ���̵� �Դϴ�.[ȸ������ ����]");
						idcheck=false;
						break;
					}
					else if(idcheck==true && temp==null) { 
						memberlist[i] = member; // �ش� �ε����� ���� ������� ��ü ����
						System.out.println("�˸�)) ȸ������ ����");
						break; // for ������ [�ȳ����� ��� ���鿡 ������ ��ü �����ϱ� ����]
					} // else if end
					i++; // �ε��� ��ȣ ����
				} // for end
				
			} // if ȸ������ end
			
			else if(ch==2) {
				
				// 1. �Է¹ޱ�
				System.out.println("--------------�α��� ������---------------");
				System.out.println("���̵� : "); String loginid = scanner.next();
				System.out.println("��й�ȣ : "); String loginpw = scanner.next();
				// 2. ���� �迭[memberlist] �� �Է¹��� ���� ��
				boolean logincheck=false; // true : �α��� ���� false : �α��� ����
				for(Member temp : memberlist) {
					// * memberlist�� 0�� �ε������� �� �ε������� �ϳ��� temp�� ����
					// �迭/����Ʈ �� ��� ��ü ȣ��
					if(temp != null && (temp.id.equals(loginid)) && (temp.pw.equals(loginpw))) {
						// * ��ü�� null �϶��� .equals() �Ұ� [null �ƴ� ���¿����� .equals() ����]
						System.out.println("�˸�)) �α��� ����");
						logincheck=true; // �α��� �����ߴٴ� ǥ�� �����
					}
				}
				
				// 3. �α��� ���� ���� �Ǵ�
				if(logincheck==false) { // �α��� �����ÿ��� �Ʒ� �ڵ� ���� �Ұ�
					System.out.println("�˸�)) ������ ȸ�������� �����ϴ�.");
				}
				
			} // else if �α��� end
			
			else if(ch==3) { // ���̵�ã��� �̸��� ��ȭ��ȣ�� �����ϸ� ���̵� ���
				// 1. �̸��� ����ó�� �Է¹޴´�.
				System.out.println("------------���̵� ã�� ������------------");
				System.out.println("�̸� : "); String name = scanner.next();
				System.out.println("����ó : "); String phone = scanner.next();
						
				// 2. �迭�� ������ �̸��� ����ó�� �ִ��� Ȯ���Ѵ�.
				boolean findcheck = false;
				for(Member temp : memberlist) {
					
					if(temp!=null && temp.name.equals(name) && temp.phone.equals(phone)) {
						System.out.println("�˸�)) ���̵� ã�� ����");
						System.out.println("ȸ�� ID : "+temp.id);
						findcheck = true;
						break;
					}
					
				} // for end
				if(findcheck==false) System.out.println("�˸�)) ������ ȸ�������� �����ϴ�.");
				// 3. ������ ��ü�� ������ �ش� ���̵� ���
				// 4. ������ ���ٰ� ���
				
			} // else if ���̵�ã�� end
			
			else if(ch==4) { // ��й�ȣã��� ���̵�� ��ȭ��ȣ�� �����ϸ� ��й�ȣ ���
				System.out.println("------------���̵� ã�� ������------------");
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("����ó : "); String phone = scanner.next();
				boolean findcheck = false;
				for(Member temp : memberlist) {
					
					if(temp!=null && temp.id.equals(id) && temp.phone.equals(phone)) {
						System.out.println("�˸�)) ��й�ȣ ã�� ����");
						System.out.println("ȸ�� PASSWORD : "+temp.pw);
						findcheck = true;
						break;
					}
					
				} // for end
				if(findcheck==false) System.out.println("�˸�)) ������ ȸ�������� �����ϴ�.");
			} // else if ��й�ȣã�� end
			else {
				System.out.println("�˸�)) �� �� ���� ��ȣ�Դϴ�.");
			} // else �׿� end
			
			
			
		} // while end
		
		
		
		
	} // m e
	
} // c e
