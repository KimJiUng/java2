package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Day21_2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		// 1. FXML ���� �ҷ����� : �����̳�
		Parent parent = FXMLLoader.load(getClass().getResource("test.fxml") );
		// 2. Scene ��ü ���� : scene�� 
		Scene scene = new Scene(parent);
		// 3. stage�� scene �ֱ�
		stage.setScene(scene);
		// 4. stage ����
		stage.show(); // �������� ����
		
	}
	
	public static void main(String[] args) {
		launch(args); // start �޼ҵ� ȣ��
	}
	
	
	
}
