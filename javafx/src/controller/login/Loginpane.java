package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Loginpane implements Initializable {


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtid.requestFocus();
		
		lblconfirm.setText(""); // ó�� ����� ���� �����
		
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML
    void accfindid(ActionEvent event) {
    	System.out.println("���̵�ã�� �������� �̵�");
    	Login.instance.loadpage("/view/login/findidpane.fxml");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	Login.instance.loadpage("/view/login/findpwpane.fxml");
    	System.out.println("��й�ȣã�� �������� �̵�");
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("ȸ������ �������� �̵�");
    	Login.instance.loadpage("/view/login/signuppane.fxml");
    }

    @FXML
    void login(ActionEvent event) {
    	// 1. ��Ʈ��[fxid]�� �Էµ� �� ��������
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	// 2. DB ��ü�� �޼ҵ� ȣ��
    	boolean result = MemberDao.memberDao.login(id, password);
    	// 3. ��� Ȯ��
    	if(result) {
    		// �α��� ������ ������ ȸ������ ���� [�α׾ƿ��� �ʱ�ȭ]
    		Login.member = MemberDao.memberDao.getMember(id);
    		
    		boolean result2 = MemberDao.memberDao.pointplus();
    		if(result2) {
    			Login.member = MemberDao.memberDao.getMember(id);
    			Main.instance.loadpage("/view/home/home.fxml");
    		}
    		
    		
    		
    	}
    	else {
    		lblconfirm.setText("������ ȸ�������� �����ϴ�.");
    	}
    	
    }
    
    @FXML
    void enterlogin(ActionEvent event) {
    	// 1. ��Ʈ��[fxid]�� �Էµ� �� ��������
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	// 2. DB ��ü�� �޼ҵ� ȣ��
    	boolean result = MemberDao.memberDao.login(id, password);
    	// 3. ��� Ȯ��
    	if(result) {
    		// �α��� ������ ������ ȸ������ ���� [�α׾ƿ��� �ʱ�ȭ]
    		Login.member = MemberDao.memberDao.getMember(id);
    		
    		boolean result2 = MemberDao.memberDao.pointplus();
    		if(result2) {
    			Login.member = MemberDao.memberDao.getMember(id);
    			Main.instance.loadpage("/view/home/home.fxml");
    		}
    		
    		
    		
    	}
    	else {
    		lblconfirm.setText("������ ȸ�������� �����ϴ�.");
    	}
    }
    

    
  
}
