package Day03;

public class Day03_1 { // c s

	public static void main(String[] args) { // m s
		
		// 1���� : ��� , �Է�
		// 2���� : ����(����) , ���(����)
		
		// ���
			// ��ǻ���� �Ǵܷ��� Ű���ִ°� => ����Ǽ�(=if)
			// ���ǽ��� true �̸� ���๮ ó��
			// ����
				// 1. IF(���ǽ�[true/flase]) ���๮;
				// 2. IF(���ǽ�) ���๮;
				//    ELSE ���๮[����];
				// 3. ���๮�� 2�� �̻�( ; 2�� �̻��̸�) { } �� ����ó��
				// 4. ����Ǽ� �ټ��϶� [������ �ټ��϶�]
				// 	  IF(����1){���๮[��1];}
				//    ELSE IF(����2){���๮[��2];}
				//	  ELSE IF(����3){���๮[��3];}
				//	  ELSE IF(����4){���๮[��4];}
				//	  ELSE IF(����5){���๮[��5];}
				//	  ELSE {���๮[����];}
				// 5. IF ��ø
				// 		IF(���ǽ�){
				//			IF(���ǽ�){���๮;}
				//			ELSE{���๮;}
				//		}ELSE{
				//			IF(���ǽ�){���๮;}
				//			ELSE{���๮;}
				//			}
		// ����1
		if(3>1) System.out.println("��1) 3�� 1���� ũ��.");
			// ���࿡ 3�� 1���� ũ�� ���o �ƴϸ� ���x
			// true �̸� ���� �ƴϸ� ����x
		
		// ����2
		if(3>5) System.out.println("��2) 3�� 5���� ũ��.");
			// ���࿡ 3�� 5���� ũ�� ���o �ƴϸ� ���x
		
		// ����3
		if(3>1) System.out.println("��3_1) 3�� 1���� ũ��.");
		else System.out.println("��3_2) 3�� 1���� �۴�");
			// ���࿡ 3�� 1���� ũ�� ��3_1 ���
			// �ƴϸ� ��3_2 ���
		
		// ����4
		if(3>2) { // true ���๮ ����
			System.out.println("true");
			System.out.println("3�� 2���� ũ��");
		} // true ���๮ ��
		else { // false ���๮ ����
			System.out.println("false");
			System.out.println("3�� 2���� �۴�.");
		} // false ���๮ ��
		
		// ����5
		if(3>5) System.out.println("��5) 3�� 5���� ũ��."); // ����x
		else if(3>4) System.out.println("��5) 3�� 4���� ũ��."); // ����x
		else if(3>3) System.out.println("��5) 3�� 3���� ũ��."); // ����x
		else if(3>2) System.out.println("��5) 3�� 2���� ũ��."); // ����o
		else System.out.println("true ����."); // ����x
			// ���� 1�� ��� = ��� 1��
		
		
		if(3>5) System.out.println("��5) 3�� 5���� ũ��."); // ����x
		if(3>4) System.out.println("��5) 3�� 4���� ũ��."); // ����x
		if(3>3) System.out.println("��5) 3�� 3���� ũ��."); // ����x
		if(3>2) System.out.println("��5) 3�� 2���� ũ��."); // ����o
		if(3<2) System.out.println("true ����."); // ����x
			// ���� ó�� = ��� �ټ�
		
		
	} // m e
	
	
} //c e
