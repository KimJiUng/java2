package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.BoardDao;
import dto.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Boardcontroller implements Initializable {

	public static Board board; // ���̺��� Ŭ���� ��ü�� �����ϴ� ��ü
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ArrayList �� �ƴ� ObservableList ����ϴ� ���� : TableView�� �ֱ� ���ؼ�
		// DB���� ��� �Խñ� ��������
		ObservableList<dto.Board> boardlist = BoardDao.boardDao.list();
		// TableView�� �߰�
		TableColumn tc = boardtable.getColumns().get(0); // ���̺��� �ε���0(ù��°) �� ��������
		tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
		
		tc = boardtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		tc = boardtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("bwrite"));
		
		tc = boardtable.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
		
		tc = boardtable.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("bview"));
		
		// TableView�� list ����
		boardtable.setItems(boardlist);
		
		// * TableView���� �ش� ���� Ŭ�������� �̺�Ʈ
		boardtable.setOnMouseClicked(e ->{ // �μ� -> { �����ڵ� } : ���̺��� Ŭ��������
			// 1. ���̺��� Ŭ���� ��ü�� �ӽð�ü�� ����
			board = boardtable.getSelectionModel().getSelectedItem(); // Ŭ���� board ��ü ȣ��
			
			// 2. ��ȸ�� ����
			// 3. ������ ��ȯ
			Home.instance.loadpage("/view/board/boardview.fxml");
		});
		
	}
	
    @FXML
    private TableView<Board> boardtable;

    @FXML
    private Button btnwrite;

    @FXML
    void accwrite(ActionEvent event) {
    	Home.instance.loadpage("/view/board/boardwrite.fxml");
    }
}
