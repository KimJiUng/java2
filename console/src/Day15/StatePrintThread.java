package Day15;

public class StatePrintThread extends Thread{

	private Thread targetThread; // ������ ����
	
	public StatePrintThread(Thread targetThread) { // �ܺηκ��� ���� �����尴ü�� ���ο� ����
		this.targetThread = targetThread;
	}
	
	// ����ó��
	@Override
	public void run() { // ������ ���� : NEW : ��ü�����ǰ� ��Ƽ������ ������
		while(true) {
			// ������ ���� ȣ��
			Thread.State state = targetThread.getState(); // �� ������ ���� ȣ��
			System.out.println("Ÿ�ٽ����� ���� : "+state);
			
			// ������ ���� ����
			if(state == Thread.State.NEW) { // NEW : ������ ���� ����
				targetThread.start();
			}
			if(state == Thread.State.TERMINATED) { // TERMINATED : ������ ���� ����
				break;
			}
			try { Thread.sleep(500);}
			catch(Exception e) {}
		
		}
	}
	
	
}
