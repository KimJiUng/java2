package Day08_4;

import Day08_3.A;

public class C {
	// A Ŭ������ ��Ű�� �ٸ� Ŭ������ �ٸ�
		// public �� ����
	
	// 1. �ʵ�
	A a1 = new A(true);
	// A a2 = new A(1); // �Ұ���
	// A a3 = new A("���ڿ�"); // �Ұ���
	// 2. ������
	public C() {
		A a = new A(true);
	//	a.field1;
		// a.field2; // �Ұ���
		// a.field3; // private �̱� ������ ��� �Ұ���
		
		a.method1();
		// a.method2(); // �Ұ���
		// a.method3(); // �Ұ���
	}
	// 3. �޼ҵ�
	
	
}
