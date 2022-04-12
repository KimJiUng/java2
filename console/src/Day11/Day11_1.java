package Day11;

public class Day11_1 { // c s

	// p.386 Ȯ�ι���
		// 1. 3 [�������̽��� ��� : 1.����ʵ� 2.�߻�޼ҵ� 3.����Ʈ�޼ҵ� 4.�����޼ҵ�]
		// 2. 4 [�������̽� ���� = ������ü]
			// ������ü = Ŭ������ implements�� ��ü
		
	private static void printSound(Soundable soundable) {
// 	����������	����		��ȯŸ��	�޼ҵ��(�μ�[����,�迭,��ü,�������̽�])
		System.out.println(soundable.sound());
	}
	
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.delete();
		dao.insert();
		dao.update();
	}
	
	public static void main(String[] args) {
		// 3.
		printSound(new Cat());
		printSound(new Dog());
		
		// 4. 
			// Dao : DB ���ٰ�ü		Dto : ������ �̵���ü
		
		
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
		
		
		// 5. �͸�ü [�������̽��� ���� ����]
			// ������ü : �������̽��� ��ü�� = new Ŭ������();
			// �͸�ü : �������̽��� ��ü�� = new �������̽�() { ���� } ; // 1ȸ�� �����ϰ� �� ��
		Action action = new Action() {
			
			@Override
			public void work() {
				System.out.println("���縦 �մϴ�.");
				
			}
		}; // ���� ��
		action.work();
		
		
	} // m e
	
	
	
	
} // c e
