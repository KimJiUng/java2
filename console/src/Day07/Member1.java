package Day07;

public class Member1 { // c s

	// 1. �ʵ�
	int mno;
	String id;
	String password;
	String name;
	String phone;
	
	// 2. ������
		// 1. ������� [�⺻������] : �޼ҵ� ȣ��� ��ü ������
	public Member1() { }
		// 2. ��� �ʵ带 �޴� ������ : ȸ�����Կ� ��ü ������
	public Member1(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. �޼ҵ�
	
		// 1. ȸ������ [�μ�x��ȯo] // ���Լ��� : true ���� : false
	boolean ȸ������() {
		System.out.println("---------------ȸ������ ������----------------");
		// 1. �Է¹޴´� [id, pw, name, phone]
		System.out.println("���̵� : "); String id = Day07_5_BookApplication.scanner.next();
		// * ���̵� �ߺ�üũ
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.id.equals(id)) {
			// ���࿡ ������ �ƴϸ鼭 �迭�� id�� �Է¹��� id�� �����ϸ�
				System.out.println("�˸�)) ���� ������� ���̵� �Դϴ�.");
				return false; // ���̵� �ߺ��Ǿ��� ������ false[���Խ���]
			}
		} // for end
		System.out.println("��й�ȣ : "); String password = Day07_5_BookApplication.scanner.next();
		System.out.println("�̸� : "); String name = Day07_5_BookApplication.scanner.next();
		System.out.println("����ó : "); String phone = Day07_5_BookApplication.scanner.next();
			// * scanner ��ü�� �ٸ� Ŭ������ static ����Ǿ�����
			// * Ŭ������.�ʵ��.�Լ���()
			// * static �ʵ�,�޼ҵ�� ��ü���� ȣ�Ⱑ�� [Ŭ������.�ʵ��/�޼ҵ��]
		
			// * ȸ����ȣ �ڵ����� [ ���� �ֱٿ� ������ ȸ���� ��ȣ +1 ]
		int bno = 0;
		int j = 0;
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp==null) {
				if(j==0) { // ù��° �ε���[0�� �ε���]�� null => ùȸ��
					bno = 1; break;
				}
				else {
					bno = Day07_5_BookApplication.members[j-1].mno+1;
					
					break;	
				}
				
			}
			j++;
		}
		
		// 2. 4������ -> ��üȭ -> 1��
		Member1 member = new Member1(bno, id, password, name, phone);
			// ��� �ʵ� �޴� �����ڷ� ��ü ����
		
		// 3. �迭�� �� ������ ã�Ƽ� ���ο� ȸ��[��ü] �ֱ�
		int i=0;
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp==null) {
				Day07_5_BookApplication.members[i]=member; // �� �ε����� ���ο� ȸ�� ����
				System.out.println("�˸�)) ȸ������ ȸ����ȣ : "+bno);
				return true; // ȸ������ �޼ҵ� ���� ~~~~ [ ��ȯ : true ]
			}
			i++;
		} // for end
		return false; // ȸ������ �޼ҵ� ���� ~~~~ [��ȯ : false ]
		// 4. ���� ������ true ��ȯ ���н� false ��ȯ
	}
	
		



	// 2. �α��� [�μ�x��ȯo]
			// �α��μ����� ������ ���̵��ȯ // ���н� null ��ȯ
	String �α���() {
		System.out.println("---------------�α��� ������----------------");
		// 1. �Ϲ�ȸ�� �α���
			// ���̵� ��й�ȣ �Է� ��ġ�ϸ� �α��� ���� �ƴϸ� �α��ν���
		System.out.println("���̵� : "); String id = Day07_5_BookApplication.scanner.next();
		System.out.println("��й�ȣ : "); String password = Day07_5_BookApplication.scanner.next();
		
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.id.equals(id) && temp.password.equals(password)) {
				return temp.id; // ������ id ��ȯ
			}
		} // for end
		return null; // ���н� null ��ȯ	
		// 2. ������ �α���
		
			// 1. �������
			// 2. �������
			// 3. ��������
			// 4. �뿩����
			// 5. �α׾ƿ�
		
	}
		// 3. ���̵�ã�� [�μ�x��ȯx] // �̸� , ����ó
	void ���̵�ã��() {
		System.out.println("---------------���̵�ã�� ������----------------");
		// 1. �Է¹ޱ�
		System.out.println("�̸� : "); String name = Day07_5_BookApplication.scanner.next();
		System.out.println("����ó : "); String phone = Day07_5_BookApplication.scanner.next();
		// 2. �Է¹��� ���� �迭�� ã��
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.name.equals(name) && temp.phone.equals(phone)) {
				System.out.println("�˸�)) ȸ������ ���̵� : "+temp.id);
				return; // ������ ���� ã������ �ش� �޼ҵ� ����
			}
			else System.out.println("�˸�)) ��ġ�ϴ� ������ �����ϴ�.");
			return;
		}
	} // ���̵� ã�� end
		// 4. ��й�ȣã�� [�μ�x��ȯx] // ���̵�, ����ó
	void ��й�ȣã��() {
		System.out.println("---------------��й�ȣã�� ������---------------");
		System.out.println("���̵� : "); String id = Day07_5_BookApplication.scanner.next();
		System.out.println("����ó : "); String phone = Day07_5_BookApplication.scanner.next();
		
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.id.equals(id) && temp.phone.equals(phone)) {
				System.out.println("�˸�)) ȸ������ ��й�ȣ : "+temp.password);
				return;
			}
			else System.out.println("�˸�)) ��ġ�ϴ� ������ �����ϴ�.");
			return;
		}
	}
		// 5. ȸ��Ż��
	void ȸ��Ż��() {
		
	}
		// 6. ȸ������
	
} // c e
