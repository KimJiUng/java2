package app;

import controller.Chatting;
import controller.login.Login;
import dao.RoomDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// 5. �����̳� �ҷ�����
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		// 6. �� ��ü -> �����̳�
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
	
		// 3. �������� �ΰ� ����
			// 1. �̹��� �ҷ����� [�̹��� ��üȭ]
		Image image = new Image("/img/stagelogo.png");
				// ������ : ��� ���
				// ����� : �� ��ġ[������Ʈ���� src] ���� ���
					// ���� [src ��������] /img/���ϸ�.Ȯ����
		
		stage.getIcons().add(image);
		
		// * �ܺ� ��Ʈ ����
			// 1. ��Ʈ ��������
			Font.loadFont(getClass().getResourceAsStream("�س�ü.ttf"), 14);
			// 2. �ܺ� ��Ÿ�Ͻ�Ʈ ����
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		// * stage = ������â�� x��ư �������� �̺�Ʈ
		stage.setOnCloseRequest(e ->{
			// ���࿡ �α����� �Ǿ�������
			if(Login.member!=null) {
				if(Chatting.room != null) {
					// 1. �� ���Ӹ�� ����
					RoomDao.roomDao.roomlivedelete(Login.member.getMid());
					// 2. �� ����
					RoomDao.roomDao.roomdelete(Chatting.room.getRoomnum());
				}
				// 3. ���� �� �ʱ�ȭ
				Chatting.room = null;
			}
		});
		
		stage.setResizable(false); // 4. �������� ũ�� ���� �Ұ�
		stage.setTitle("��������"); // 2. �������� â �̸�
		stage.show(); // 1. �������� ����
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
