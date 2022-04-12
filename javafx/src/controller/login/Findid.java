package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findid implements Initializable{

    @FXML
    private Button btnback;

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindid;

    @FXML
    private Label lblconfirm;

    @FXML
    void accback(ActionEvent event) {
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void accfindid(ActionEvent event) {
    	// 1. ��Ʈ��[fxid]�� �Էµ� �� ��������
    	String email = txtemail.getText();
    	// 2. DB ��ü�� �޼ҵ� ȣ��
    	String result = MemberDao.memberDao.findid(email);
    	// 3. ��� Ȯ��
    	if(result!=null) {
    	// 1. �޼���â ��� [Alert : �޼���(�˶�) Ŭ����]
		Alert alert = new Alert(AlertType.INFORMATION); // �޼��� ��ü
		alert.setTitle("�˸�"); // �޼��� ���� ����
		alert.setHeaderText("���̵�ã�Ⱑ �Ϸ�Ǿ����ϴ�."); // 
		alert.setContentText("ȸ������ ���̵�� : "+result+" �Դϴ�.");
		alert.showAndWait(); // �޼��� ����
		
		// 2. ȭ�� ��ȯ [�α����������� ��ȯ]
		Login.instance.loadpage("/view/login/loginpane.fxml");
    	}
    	else {
    		lblconfirm.setText("��ġ�ϴ� �̸����� �����ϴ�.");
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	lblconfirm.setText("");
    }
	
	
}
