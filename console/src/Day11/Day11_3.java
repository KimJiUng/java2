package Day11;

public class Day11_3 { // c s

	// p.422 ���� ������
		// ���� : ��� �޼ҵ忡�� try{}catch(){} ���� �ڵ� ������ -> �Ѱ����� ���� �̵� 
	
	public static void main(String[] args) { // m s
		try {findclass();} 
		catch(Exception e) {}
		try {withdraw(100110);}
		catch(Exception e) { System.out.println(e);}
		
		
	} // m e
	
	public static void findclass() throws Exception {
		
		// 1. try ~ catch
//		try { // ���ܰ� �߻��� �� ���� �ڵ�(���࿹��) or �Ϲݿ���[������]
//		Class clazz = Class.forName("java.lang.String2");
//		} catch(Exception e) { // ���ܰ� �߻��ϸ� ����Ǵ� �ڵ�
//			// Exception : ����Ŭ������ ����Ŭ���� �̹Ƿ� ��� ���ܸ� ���� ����
//			System.out.println(e);
//		}
		// 2. ���� ������ [�޼ҵ��() throws ����Ŭ������]
		Class clazz = Class.forName("java.lang.String2");
	}
	
	// p. 444~445 : ���� �����
	
	public static void withdraw(int money) throws Exception {
		if(money>20000) {
			throw new Exception("�ܰ����");
		}
	}
	
	
} // c e
