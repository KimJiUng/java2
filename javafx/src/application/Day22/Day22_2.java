package application.Day22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Day22_2 {

	// 1. �ʵ�
		private Connection connection; // ���� ��ü
	// 2. ������
		public Day22_2() {
			try { // JAVA�� ����� ������ �Ϲݿ��� �߻�
				// 1. DB ����̺� Ŭ���� ȣ�� [ DB ȸ�縶�� �ٸ� ]
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. DB ����
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC", "root","1234");
					// JDBC : JAVA DATABASE CONNECTION
					// jdbc:mysql://IP�ּ�(����[����PC]�̸� localhost):port��ȣ/DB�̸�?DB�ð�����
					// "������", "DB��й�ȣ"
				// 3. Ȯ��
				System.out.println("DB ���� ����");
			}catch(Exception e) {
				System.out.println("DB ���� ����");
			}
			
			
		}
	// 3. �޼ҵ�
		// ������ ���� �޼ҵ�
		public boolean write(String writer, String content) {
			try {
				// 1. SQL �ۼ� [DB�� ����]
				// db�� ���̺� ������ ���� : insert into ���̺��(�ʵ��1,�ʵ��2) values(�ʵ��1�� ��, �ʵ��2�� ��)
			String sql = "insert into test(writer,content) values(?,?)";
			// 2. SQL ���� [����� DB�� SQL����]
			PreparedStatement ps = connection.prepareStatement(sql);
				// PreparedStatement : ����� DB���� ���̺� ����(����, ����, ����, ����)�Ҷ� ���� �������̽�
			ps.setString(1, writer); // sql�� �ۼ��� ù��° ? �� ���� �ֱ� [ 1 : ù��° ? ]
			ps.setString(2, content); // [ 2 : �ι�° ? ]
			// 3. SQL ����
			ps.executeUpdate(); // sql ���� ����
			// * ������ true
			return true;
			
			} catch(Exception e) {
				System.out.println("SQL ���� ���� ���� : "+e);
			}
			
			
			
			// * ���н� false
			
			return false;
		}
	
		// ������ ȣ�� �޼ҵ�
		public ArrayList<data> get(){
			try {
				// DB���� ������ �����͸� ������ ����Ʈ ����
				ArrayList<data> datalist = new ArrayList<>();
				
				// 1. SQL �ۼ� [������ ȣ��]
					// select *(����ʵ�)from ���̺�� : ��� �����͸� ��������
				String sql ="select*from test";
				// 2. SQL ���� [DB�� ����� ��ü�� �����������̽� ����]
				PreparedStatement ps = connection.prepareStatement(sql);
				// 3. SQL ���� [ ResultSet �������̽� java.sql ��Ű�� ]
			    ResultSet rs = ps.executeQuery(); // ����� [���پ�=���ڵ�] ��������
			    
			    // * ����� �ϳ��� �ƴϰ� �������̹Ƿ� �ݺ��� ����ؼ�
			    	// ���پ� ��üȭ -> ����Ʈ�� ����
			    while(rs.next() ) { // ���� ��[���ڵ�]�� ������
			    	// 1. ���پ�[���ڵ�]���� ��üȭ
			    	data temp = new data(
			    	rs.getInt(1), // �ش� ��[���ڵ�]�� ù��° �ʵ�[����]
			    	rs.getString(2),
			    	rs.getString(3)
			    	);
			    	
			    	// 2. ��ü�� ����Ʈ�� ���
			    	datalist.add(temp);
			    }
			    // �ݺ��� ����Ǹ� ����Ʈ ��ȯ
			    return datalist;
				
			} catch(Exception e) {
				System.out.println("sql ���� ���� ���� : "+e);
			}
			// * ���н�
			System.out.println("����");
			return null;
		}
		
	
}
