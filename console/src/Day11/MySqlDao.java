package Day11;

public class MySqlDao implements DataAccessObject {

	
	@Override
	public void delete() {
		System.out.println("����Ŭ MySql���� ����");
	}
	@Override
	public void insert() {
		System.out.println("����Ŭ MySql�� ����");
	}
	@Override
	public void select() {
		System.out.println("����Ŭ MySql���� �˻�");
	}
	
	@Override
	public void update() {
		System.out.println("����Ŭ MySql�� ����");
	}
	
}
