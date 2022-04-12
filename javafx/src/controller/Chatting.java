package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.RoomDao;
import dto.Room;
import dto.Roomlive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Chatting implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtmsg.setDisable(true);  // ä���Է�â ������
		txtcontent.setDisable(true); // ä�ù� ������
		btnsend.setDisable(true); // ���۹�ư ������
		txtmsg.setText("ä�ù� ���� �� ��밡���մϴ�.");
		btnconnect.setDisable(true); // �����ư ������
		txtmidlist.setDisable(true); // ����ȸ�� ��� ������
		show();
	}
	
	public static Room room;
	
    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private Button btnsend;

    @FXML
    private TableView<Room> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnadd;

    @FXML
    private TextArea txtmidlist;

    @FXML
    private Label lblselect;

    // �������� ���� [ ��� �޼ҵ忡�� ��� ]
    public Server server;
    
    @FXML
    void add(ActionEvent event) { // �� ���� ��ư�� ��������
    	Alert alert = new Alert(AlertType.INFORMATION);
    	// 1. ��Ʈ�ѿ� �Էµ� �� �̸� ��������
    	String roomname = txtroomname.getText();
    	if(roomname.length()<4) {
    		alert.setHeaderText("�� ���� ����");
    		alert.setContentText("�� �̸��� 4~20���� ���̿��� �մϴ�.");
    		alert.showAndWait();
    		return;
    	}
    	// 2. �� ��ü �����
    	Room room = new Room(0, roomname, "127.0.0.1", 0);
    	// 3. DB ó��
    	boolean result = RoomDao.roomDao.roomadd(room);
    	if(result) {
    		// 4. �ش� �� ���� ����
        	server = new Server(); // �޸� �Ҵ�
        	int result2 = RoomDao.roomDao.getroomnum();
        	// ���� ���� [�μ��� ip,port��ȣ �ѱ��]
        	server.serverstart(room.getRoomip(), result2);
        	
        	alert.setHeaderText("�� ������ �Ϸ�Ǿ����ϴ�. �� ��ȣ : "+result2);
        	alert.showAndWait();
        	txtroomname.setText("");
        	Home.instance.loadpage("/view/chatting.fxml");
    	}else {
    		System.out.println("add DB ����");
    	}
    	

    }



    @FXML
    void roomname(ActionEvent event) {

    }

    // 1. Ŭ���̾�Ʈ ���� ����
    Socket socket;
    
   
    
    // 2. Ŭ���̾�Ʈ ���� �޼ҵ�
    public void clientstart(String ip, int port) {
    	// ��Ƽ ������
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				socket = new Socket(ip,port);
    				send(Login.member.getMid()+"���� �����ϼ̽��ϴ�.\n");
    				recive(); // ���Ӱ� ���ÿ� �ޱ� �޼ҵ�� ���ѷ���
    			} catch(Exception e) { System.out.println("Ŭ���̾�Ʈ ���� ���� : "+e);}
    		}
    	}; // ��Ƽ������ ���� ��
    	thread.start();		
    }
    
    // 3. Ŭ���̾�Ʈ ���� �޼ҵ�
    public void clientstop() {
    	try{
    		socket.close(); 
    	}catch(Exception e) { System.out.println("Ŭ���̾�Ʈ ���� ���� : "+e);} }
    
    // 4. �޼��� �۽� �޼ҵ�
    public void send(String msg) {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream();
    				outputStream.write(msg.getBytes());
    				outputStream.flush(); // ��Ʈ�� �ʱ�ȭ
    			} catch(Exception e) { System.out.println("�޼��� �۽� ���� : "+e);}
    		}
    	}; // ��Ƽ������ ���� ��
    	thread.start();
    }
    
    // 5. �޼��� ���� �޼ҵ�
    public void recive() {
    	try {
    		while(true) {
    			InputStream inputStream = socket.getInputStream(); // �Է½�Ʈ��
    			byte[] bytes = new byte[1000]; // ����Ʈ�迭����
    			inputStream.read(bytes); // �о����
    			String msg = new String(bytes); // ����Ʈ�迭->���ڿ� ��ȯ
    			txtcontent.appendText(msg); // �Է¹��� ������ ä��â�� �߰��ϱ�
    		}
    	} catch(Exception e) { System.out.println("�޼��� ���� ���� : "+e);}
    }    
    @FXML
    void connect(ActionEvent event) {
    	if(btnconnect.getText().equals("ä�ù� ����")) { // ����
    		clientstart(room.getRoomip(), room.getRoomnum());
    		btnconnect.setText("ä�ù� ����");
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		txtmsg.setText("");
    		txtmsg.setDisable(false);
    		txtcontent.setDisable(false);
    		btnsend.setDisable(false);
    		txtmsg.requestFocus();
    		
    		// ���� �� ���Ӹ�� �߰�
    		Roomlive roomlive = new Roomlive(0, room.getRoomnum(), Login.member.getMid());
    		RoomDao.roomDao.addroomlive(roomlive);
    		midshow();
    		show();
    		
    		txtroomname.setDisable(true); // ä�ù��̸� �Է�â ������
    		btnadd.setDisable(true); // ä�ù� ���� ��ư ������
    		roomtable.setDisable(true); // ä�ù� ��� ������
    		
    	}else { // ����
    		btnconnect.setText("ä�ù� ����");
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		clientstop();
    		txtmsg.setDisable(true);
    		txtcontent.setDisable(true);
    		btnsend.setDisable(true);
    		btnconnect.setDisable(true); // �����ư ������
    		txtmidlist.setDisable(true); // ����ȸ�� ��� ������
    		txtmsg.setText("ä�ù� ���� �� ��밡���մϴ�.");

    		txtroomname.setDisable(false); // ä�ù��̸� �Է�â ��밡��
    		btnadd.setDisable(false); // ä�ù� ���� ��ư ��밡��
    		roomtable.setDisable(false); // ä�ù� ��� ��밡��
    		
    		// 1. �� ���� ��ܿ��� ����[����]�ϱ�
    		RoomDao.roomDao.roomlivedelete(Login.member.getMid());
    		// 2. ���࿡ �� ���� ����� 0���̸� �����
    		boolean result = RoomDao.roomDao.roomdelete(room.getRoomnum());
    		if(result) {
    			show();
    			// * �������� ����
    			server.serverstop();
    			
    		}
    		// * ���̺�信�� ���õ� �� ��ü �ʱ�ȭ
    		room = null;
    		// * ���õ� �� ���̺� �ʱ�ȭ
    		lblselect.setText("���� ���õ� �� : ");
    		show();
    		
    		// �� ������ �������ϳ� ���ӵ� ���� ����Ʈ���� ���� ����
    		
    	}
    }

    @FXML
    void msg(ActionEvent event) { // �޼��� �Է��ϰ� ���� ������
    	String msg =Login.member.getMid()+" : "+ txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus(); // ������ �� �޼��� �Է�â���� ��Ŀ��(Ŀ��) �̵�
    	midshow();
    }
    
    @FXML
    void send(ActionEvent event) { // ���� ��ư ��������
    	String msg =Login.member.getMid()+" : "+ txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus(); // ������ �� �޼��� �Է�â���� ��Ŀ��(Ŀ��) �̵�
    	midshow();
    
    }
    
    public void midshow() {
	ArrayList<Roomlive> roomlivelist = RoomDao.roomDao.getRoomlivelist(room.getRoomnum());
    	
    	txtmidlist.setText("");
    	int i=0;
    	for(Roomlive temp : roomlivelist) {
    		txtmidlist.appendText(i+"�� "+temp.getMid()+"\n");
    		i++;
    	}
    }
	
    public void show() {
    	
    	ObservableList<Room> roomlist = RoomDao.roomDao.roomlist();
	
		TableColumn tc = roomtable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("roomnum"));
		
		tc = roomtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("roomname"));
		
		tc = roomtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
		
		roomtable.setItems(roomlist);
		
		roomtable.setOnMouseClicked(e->{
			room = roomtable.getSelectionModel().getSelectedItem();
			lblselect.setText("���� ���õ� �� : "+room.getRoomname());
			btnconnect.setDisable(false);
		});
    }
    
}
