package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
	
	public static Main instance;
	
	public Main() { instance = this; }
	
    @FXML
    private BorderPane borderpane1;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/login/login.fxml"); // loadpage �޼ҵ� ȣ���(���ϰ��)
	}
    
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page)); // �ش� ���� �ҷ�����
			borderpane1.setCenter(parent); // main.fxml�� �����ϴ� borderpane1 ��ü�� center�� �ش� ���Ϸ� ����
		} catch(Exception e) {System.out.println("�������� �ҷ����� ���� ���� : "+e);}
		
	}
	
    
}
