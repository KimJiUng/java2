package Day09;

public class Tire { // c s
// ����Ŭ������ ����� ����
	
	
	// 1. �ʵ�
	public int maxRotation; // �ִ� ȸ����[ȸ�� ���ɼ�]
	public int accumlatedRotation; // ���� ȸ����
	public String location; // Ÿ�̾��� ��ġ
	
	// 2. ������
	public Tire(String location, int maxRotation) {
		this.location=location; // �ܺηκ��� ���޹��� �μ��� ���κ����� ����
		this.maxRotation=maxRotation;
				
	}
	
	// 3. �޼ҵ�
	public boolean roll() { // Ÿ�̾� ȸ�� ���� �޼ҵ�
		accumlatedRotation++;
		if(accumlatedRotation<maxRotation) {
			// ���࿡ ����ȸ������ �ִ�ȸ�������� ������[���� ����]
			System.out.println(location+"Tire ���� : "+(maxRotation-accumlatedRotation)+"ȸ");
			return true;
		}
		else {
			System.out.println("***"+location+"Ÿ�̾� ��ũ ***");
			return false;
		}
	}
	
	
	
} // c e
