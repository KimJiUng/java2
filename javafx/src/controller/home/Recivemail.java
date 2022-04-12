package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import dao.MailDao;
import dto.Mail;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Recivemail implements Initializable {

	public static Mail mail;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Mail> maillist = MailDao.mailDao.recive();
		TableColumn tc = mailtable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("msendid"));
		
		tc = mailtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("mcontent"));
		
		tc = mailtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("maildate"));
		
		mailtable.setItems(maillist);
		
		mailtable.setOnMouseClicked(e->{
			mail = mailtable.getSelectionModel().getSelectedItem();
			Home.instance.loadpage("/view/home/sendmail.fxml");
		});
		
	}
	
    @FXML
    private Button btnback;

    @FXML
    private TableView<Mail> mailtable;

    @FXML
    void accback(ActionEvent event) {
    	Main.instance.loadpage("/view/home/home.fxml");
    }
	
}
