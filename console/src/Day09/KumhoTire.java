package Day09;

public class KumhoTire extends Tire { // c s

	// 1. �ʵ�
	
	
	// 2. ������
	public KumhoTire(String location, int maxRotation){
		super(location, maxRotation);
		// ����Ŭ���� �� ������[�ڵ� ���̱�]
	}
	// 3. �޼ҵ�
	@Override
		public boolean roll() {
			accumlatedRotation++;
			if(accumlatedRotation<maxRotation) {
				System.out.println(location+"��ȣŸ�̾� ���� : "+(maxRotation-accumlatedRotation)+"ȸ");
				return true;
			}
			else System.out.println("***"+location+"��ȣŸ�̾� ��ũ ***");
			return false;
		}
	
	
} // c e
