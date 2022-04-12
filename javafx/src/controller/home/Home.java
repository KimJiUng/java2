package controller.home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable {
	
	public static Home instance;
	
	public static String category;
	
	public Home() {instance=this;}
	
	@FXML
	private Label lblloginid;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lbllogout;
	
	@FXML
	private Label lbldelete;
	
    @FXML
    private Label lblsendmail;

    @FXML
    private Label lblrecivemail;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid());
		lblpoint.setText("���� ����Ʈ : "+Login.member.getMpoint());
	}
	
	@FXML // �α׾ƿ� ���̺��� Ŭ�������� �̺�Ʈ
	public void logout(MouseEvent e) {
		// 1. �α��� ���� �����
		Login.member = null;
		Main.instance.loadpage("/view/login/login.fxml");
	}
	
	@FXML
	public void delete(MouseEvent e) {
		// 1. �޼���
		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ�� ��� ��ư
		alert.setHeaderText("���� Ż���Ͻðڽ��ϱ�?");
		// 2. ���p Ȯ�� [Optional Ŭ����]
		Optional<ButtonType> optional = alert.showAndWait(); // ����
		if(optional.get()==ButtonType.OK) { // Ȯ�� ��ư�� ��������
			// ȸ��Ż�� ����
			boolean result = MemberDao.memberDao.delete(Login.member.getMnum());
			if(result) { // Ż�� ����
				// �α׾ƿ� [Login Ŭ������ member ��ü null�� ����]
				Login.member=null;
				// ��������ȯ
				Main.instance.loadpage("/view/login/login.fxml");
			}else { // Ż�� ����
				
			}
		}
	}
    @FXML
    private BorderPane borderpane;
    
    public void loadpage(String page) {
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource(page));
    		borderpane.setCenter(parent);
    	} catch(Exception e) {
    		System.out.println("Home ������ �ҷ����� ���� : "+e);
    	}
    }
	@FXML
	private Label lblinfo;
	
	@FXML
	public void accinfo(MouseEvent e) {
		loadpage("/view/home/info.fxml");
		
	}
	
	@FXML
	private Label lblmodify;
	
	@FXML
	public void accmodify(MouseEvent e) {
		loadpage("/view/home/modify.fxml");
	}
	
	@FXML
	private Label lblboard;
	
	@FXML void accboard(MouseEvent e) {
		loadpage("/view/board/board.fxml");
	}
	@FXML
	private Label lblproduct1;
	
	@FXML
	private Label lblproduct2;
	
	@FXML
	private Label lblproduct3;
	
	@FXML
	private Label lblproduct4;

	@FXML
	private Label lblmyboard;
	
	@FXML
	public void accproduct1(MouseEvent e) {
		category="�����Ƿ�";
		loadpage("/view/product/product.fxml");
		
	}
	
	@FXML
	public void accproduct2(MouseEvent e) {
		category="�����Ƿ�";
		loadpage("/view/product/product.fxml");
		
	}
	
	@FXML
	public void accproduct3(MouseEvent e) {
		category="��Ȱ��ǰ";
		loadpage("/view/product/product.fxml");
		
	}
	
	@FXML
	public void accproduct4(MouseEvent e) {
		category="������ǰ";
		loadpage("/view/product/product.fxml");
		
	}
	
	@FXML
	public void accmyboard(MouseEvent e) {
		loadpage("/view/home/myboard.fxml");
	}
	
	@FXML
	private Label lblchatting;
	
	@FXML
	public void accchatting(MouseEvent e) {
		loadpage("/view/chatting.fxml");
	}
	
	@FXML
	private Label lblrecord;
	
	@FXML
	public void accrecord(MouseEvent e) {
		loadpage("/view/record.fxml");
	}
	
	@FXML
	public void sendmail(MouseEvent e) {
		loadpage("/view/home/sendmail.fxml");
	}
	
	@FXML
	public void recivemail(MouseEvent e) {
		loadpage("/view/home/recivemail.fxml");
	}
}
