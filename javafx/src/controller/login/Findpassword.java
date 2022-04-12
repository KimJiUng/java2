package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findpassword implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private Button btnback;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpw;

    @FXML
    private Label lblconfirm;

    @FXML
    void accback(ActionEvent event) {
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void accfindpw(ActionEvent event) {
    	// 1. ��Ʈ��[fxid]�� �Էµ� �� ��������
    	String email = txtemail.getText();
    	String id = txtid.getText();
    	// 2. DB ��ü�� �޼ҵ� ȣ��
    	String result = MemberDao.memberDao.findpw(email, id);
    	// 3. ��� Ȯ��
    	if(result!=null) {
    		Member.sendmail(email, result);
	    	// 1. �޼���â ��� [Alert : �޼���(�˶�) Ŭ����]
			Alert alert = new Alert(AlertType.INFORMATION); // �޼��� ��ü
			alert.setTitle("�˸�"); // �޼��� ���� ����
			alert.setHeaderText("��й�ȣã�Ⱑ �Ϸ�Ǿ����ϴ�."); // 
			alert.setContentText("�ش� ���Ϸ� ��й�ȣ�� �����Ͽ����ϴ�.");
			alert.showAndWait(); // �޼��� ����
		
		// 2. ȭ�� ��ȯ [�α����������� ��ȯ]
		Login.instance.loadpage("/view/login/loginpane.fxml");
    	}
    	else {
    		lblconfirm.setText("��ġ�ϴ� �̸����� �����ϴ�.");
    	}
    }
}
