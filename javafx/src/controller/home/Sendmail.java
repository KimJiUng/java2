package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import controller.product.Productcontrol;
import dao.MailDao;
import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Sendmail implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Recivemail.mail!=null) {
			txtid.setText(Recivemail.mail.getMsendid());
			Recivemail.mail=null;
		}
		if(Productcontrol.select!=null) {
			String mid = MemberDao.memberDao.getmid(Productcontrol.select.getMnum());
			txtid.setText(mid);
			Productcontrol.select=null;
		}
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnsend;

    @FXML
    void send(ActionEvent event) {
    	Member member = MemberDao.memberDao.getMember(txtid.getText());
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(member==null) {
    		alert.setHeaderText("��ġ�ϴ� ���̵� �����ϴ�.");
    		alert.showAndWait();
    		return;
    	} else if(member.getMid().equals(Login.member.getMid())) {
    		alert.setHeaderText("�ڽ��� ���̵�� ���� �� �����ϴ�.");
    		alert.showAndWait();
    		return;
    	} else {
    		MailDao.mailDao.send(member.getMid(), txtcontent.getText());
    		alert.setHeaderText("���Ϻ����Ⱑ �Ϸ�Ǿ����ϴ�.");
    		alert.showAndWait();
    	}
    	
    }
}
