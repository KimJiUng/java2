package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Modify implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
		txtnewemail.setText(Login.member.getMemail());
		txtnewaddress.setText(Login.member.getMaddress());
	}
	
    @FXML
    private TextField txtpw;

    @FXML
    private TextField txtnewpw;

    @FXML
    private TextField txtnewpwcheck;

    @FXML
    private TextField txtnewemail;

    @FXML
    private TextField txtnewaddress;
    
    @FXML
    private Button btnmodify;

    @FXML
    private Button btnback;
    
    @FXML
    private Label lblconfirm;

    @FXML
    void accback(ActionEvent event) {
    	Main.instance.loadpage("/view/home/home.fxml");
    }

    @FXML
    void accmodify(ActionEvent event) {
    	String pw=null;
    	String newpw=null;
    	String newpwcheck=null;
    	String newemail=null;
    	String newaddress=null;

    	
    	if(txtpw.getText().equals("")) {
    		if(!(txtnewpw.getText().equals("") || txtnewpwcheck.getText().equals("") )) {
    			lblconfirm.setText("���� ��й�ȣ, ���ο� ��й�ȣ, ��й�ȣ Ȯ���� ��� �Է����ּ���.");
    			return;
    		}
    		pw = Login.member.getMpassword();
    		newpw = Login.member.getMpassword();
    		newpwcheck = Login.member.getMpassword();
    	}else {
    		if(!txtpw.getText().equals(Login.member.getMpassword())) {
    			lblconfirm.setText("���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
    			return;
    		}
    		if(txtnewpw.getText().length()<4 || txtnewpw.getText().length()>10) {
    			lblconfirm.setText("��й�ȣ�� ���̴� 4~10 ���̷� �Է����ּ���.");
        		return;
    		}
    		if(!txtnewpw.getText().equals(txtnewpwcheck.getText())) {
    			lblconfirm.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
    			return;
    		}
    		
    		pw = txtpw.getText();
    		newpw = txtnewpw.getText();
    		newpwcheck = txtnewpwcheck.getText();
    	}
    	if(txtnewemail.getText().equals("")) {
    		newemail = Login.member.getMemail();
    	}else {
    		if(txtnewemail.getText().indexOf("@")==-1) { // ���࿡ �Է��� �̸��Ͽ� @�� ������
        		lblconfirm.setText("�̸��� �������� �Է����ּ���");
        		return;
        	}
    		newemail = txtnewemail.getText();
    	}
    	if(txtnewaddress.getText().equals("")) {
    		newaddress = Login.member.getMaddress();
    	}else {
    		if(!(txtnewaddress.getText().contains("��") && txtnewaddress.getText().contains("��") && txtnewaddress.getText().contains("��")) ) {
        		lblconfirm.setText("�ּ� �������� �Է����ּ���");
        		return;
        	}
    		newaddress = txtnewaddress.getText();
    	}
    	
    	boolean result = MemberDao.memberDao.modify(pw, newpw, newpwcheck, newemail, newaddress);
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("�˸�");
    		alert.setHeaderText("ȸ������ ������ �Ϸ�Ǿ����ϴ�.");
    		alert.setContentText("�α׾ƿ��� ������������ ���ư��ϴ�.");
    		alert.showAndWait();
    		Login.member=null;
    		Main.instance.loadpage("/view/login/login.fxml");
    	}else {
    		System.out.println("����");
    	}
    }


	
	
	
}
