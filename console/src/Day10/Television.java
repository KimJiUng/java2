package Day10;

public class Television implements RemoteControl, Searchable {
			// Ŭ������ 	implements �������̽���
					// 	�����ϴ�

	// 1. �ʵ�
	private int volume;
	
	// 2. ������
	
	// 3. �޼ҵ�
		// ctrl + space bar
	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}
	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	}
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume=volume;
		}
		System.out.println("���� TV ���� : "+this.volume);
		
	}
	
	@Override
	public void search(String url) {
		System.out.println(url + "�� �˻��մϴ�.");
		
	}
	
	@Override // ����Ʈ �޼ҵ嵵 ������ ����
	public void setMute(boolean mute) {
		RemoteControl.super.setMute(mute);
	}
}
