package Day15;

public class ���� extends Thread{

	@Override
	public void run() {
		// ����ó�� ����
		while(true) { // ����Ŭ������ �����尡 ������
			System.out.println("����");
			try { Thread.sleep(500);}
			catch(Exception e) {}
		}
	}
	
	
}
