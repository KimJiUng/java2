package application.Day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_client {

	public static void main(String[] args) {
		
		// 1. ���� �����
		Socket socket = new Socket();
		

		while(true) {
			try {
				// 2. ������������ �����ϱ� [ ���������� ip�� port��ȣ �־��ֱ� ]
				socket.connect(new InetSocketAddress("192.168.17.38",1234));
				System.out.println("[[������ ���� ����]]");
				
				Scanner scanner = new Scanner(System.in);
				// 3. �������� ������ �۽��ϱ�[������]
					// 1. ������ �Է¹ޱ�
				System.out.println("�������� ���� �޼��� : "); String msg = scanner.next();
					// 2. ������ ��� ��Ʈ��(��Ŵ���:����Ʈ) ��������
				OutputStream outputStream = socket.getOutputStream();
					// 3. �������� [ ���ڿ� -> ����Ʈ�� ]
				outputStream.write(msg.getBytes());
				// 4. �������� ������ ����[�ޱ�]
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[1000];
				inputStream.read(bytes);
				System.out.println("������ ���� �޼��� : "+new String(bytes));
						
				
			} catch (IOException e) {}
		}
		
	}
	
}
