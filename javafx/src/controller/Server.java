package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controller.login.Login;



public class Server { // fxml ������� �ʴ� Ŭ���� [���� ��Ʈ�� ���]

/////////////////////////////////////////////////////////////////////
	// ��øŬ����
	public class Client{
		// ������ ���ӵ� Ŭ���̾�Ʈ�� Ŭ����
		// 1. �ʵ� [����]
		public Socket socket;
		// 2. ������
		public Client(Socket socket) {
			this.socket=socket;
			recive(); // ������ ����� Ŭ���̾�Ʈ ��ü�� �����ɶ�
		}
		// 3. ���� �޼ҵ�
		public void recive() {
			// ��Ƽ������ [Thread Ŭ���� vs Runnable �������̽�]
			Runnable runnable = new Runnable() {
				// �������̽��� �߻�޼ҵ尡 �����ϱ� ������ run �޼ҵ带 �ʼ������� �����ؾ���
				@Override
				public void run() {
					// ��������� �޼��� �޴� ����
					try {
						while(true) {
							// 1. �Է� ��Ʈ��
							InputStream inputStream = socket.getInputStream();
							byte[] bytes = new byte[1000];
							inputStream.read(bytes);
							String msg = new String(bytes);
							
							// * ������ ���� �޼����� ���� ������ ������ ��� Ŭ���̾�Ʈ���� ���� �޼��� ������
							for(Client client : clientlist) {
								client.send(msg); // ���� �޼����� ������ ���ӵ� Ŭ���̾�Ʈ�鿡�� ������
							}
						}
					} catch(Exception e) { System.out.println("���� �޼ҵ� ���� : "+ e);}
				}
			}; // ��Ƽ������ ���� ��
			
			// �ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ�
			threadpool.submit(runnable);
		}
		// 4. �۽� �޼ҵ�
		public void send(String msg) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try{
						OutputStream outputStream =socket.getOutputStream();
						outputStream.write(msg.getBytes() ); 
					} catch(Exception e) {
						serverstop();
						System.out.println("�۽� �޼ҵ� ���� : "+ e);
						}
				}
			}; // ��Ƽ������ ���� ��
			threadpool.submit(runnable);
		}
	} // ��øŬ���� ����
///////////////////////////////////////////////////////////////////////
	
	

    
    // * ������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ
    public Vector<Client> clientlist = new Vector<>();
    		// Vector ����ϴ� ���� : ����ȭo 
    			// ����ȭ : �������� �����尡 �ϳ��� �޼ҵ忡 ������ ��� ��� ���� �������
    // * ��Ƽ�����带 �������ִ� ������Ǯ
    public ExecutorService threadpool;
    		// ExecutorService : �����带 ���� �������̽�
    // 1. �������� ����
    ServerSocket serverSocket;
    
    // 2. �������� �޼ҵ�
    public void serverstart(String ip, int port) { // �μ��� ip�� port �޾Ƽ� ���� ip�� port �� �������� ���ε�(����)
    	try {
    		// 1. �������� �޸��Ҵ�
        	serverSocket = new ServerSocket();
        	// 2. �������� ���ε�
        	serverSocket.bind(new InetSocketAddress(ip,port));
        	
    	} catch(Exception e) {serverstop(); System.out.println("���� ���� �޼ҵ� ���� : "+ e);}
    		// 3. Ŭ���̾�Ʈ�� ��û ��� [��Ƽ������ ����ϴ� ���� : 1.Ŭ���̾�Ʈ���� 2.������ 3.�ޱ� ����ó���ϱ� ���ؼ�]
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept(); // 1. ��û �����Ŀ� ������ ������ ����
						clientlist.add(new Client(socket)); // 2. ����� Ŭ���̾�Ʈ(����ȼ���) ���� �Ŀ� ����Ʈ�� Ŭ���̾�Ʈ �߰�
					}	
				} catch(Exception e) {serverstop(); System.out.println("������ Ŭ���̾�Ʈ ���� ���� : "+ e);}
				
				
			}
		}; // ��Ƽ������ ���� ��
		// ������Ǯ �޸� �ʱ�ȭ
		threadpool = Executors.newCachedThreadPool();
    	threadpool.submit(runnable);
    }
    
    // 3. �������� �޼ҵ�
    public void serverstop() {
    	try {
    		// 1. ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �ݱ�
        	for(Client client : clientlist) {
        		client.socket.close();
        	}
        	// 2. �������� �ݱ�
        	serverSocket.close();
        	// 3. ������Ǯ �ݱ�
        	threadpool.shutdown();
    	} catch(Exception e) { System.out.println("���� ���� �޼ҵ� ���� : "+ e);}
    	
    }
	
}
