package controller.board;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dao.ReplyDao;
import dto.Board;
import dto.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardview implements Initializable {

	public static Reply reply;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		BoardDao.boardDao.viewplus();
		Board board = controller.board.Boardcontroller.board; // boardcontroller�� ���̺��� ���õ� ��ü ȣ��
		
		// �� ��Ʈ�ѿ� ���õ� board�� ������ �����ϱ�
		txttitle.setText(board.getBtitle());
		txtcontent.setText(board.getBcontent());
		lblwriter.setText("�ۼ��� : "+board.getBwrite());
		lbldate.setText("�ۼ��� : "+board.getBdate());
		lblview.setText("��ȸ�� : "+board.getBview());
		
		// ���࿡ �Խù� �ۼ��ڿ� ����α��ε� id�� �������� ������
		if(!Login.member.getMid().equals(board.getBwrite())) {
			btndelete.setVisible(false);
			btnupdate.setVisible(false);
			
		}
		// ����� ���� ���� ���ϰ�
		txttitle.setEditable(false);
		txtcontent.setEditable(false);
		btnredelete.setVisible(false);
		btnreupdate.setVisible(false);
		
		replytableshow();
		replytable.setOnMouseClicked(e ->{
			reply = replytable.getSelectionModel().getSelectedItem();
			if(reply.getRwriter().equals(Login.member.getMid())) {
				btnreupdate.setVisible(true);
				btnredelete.setVisible(true);
			}
			else {
				btnredelete.setVisible(false);
				btnreupdate.setVisible(false);
			}
		});
		
	}
	
    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnback;

    @FXML
    private Label lblwriter;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblview;

    @FXML
    private TextArea txtrecontent;

    @FXML
    private Button btnrewrite;

    @FXML
    private TableView<Reply> replytable;
    
    @FXML
    private Button btnredelete;

    @FXML
    private Button btnreupdate;

    @FXML
    void accback(ActionEvent event) {
    	Home.instance.loadpage("/view/board/board.fxml");
    }

    @FXML
    void accdelete(ActionEvent event) {
    	// 1. ��� �޼��� �˸�
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	// 2. Ȯ�� ��ư ��������
    	if(optional.get()==ButtonType.OK) {
    		// 3. ����ó��
    		boolean result = BoardDao.boardDao.delete(Boardcontroller.board.getBnum());
    		if(result) {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
        		alert2.showAndWait();
    			Boardcontroller.board=null;
        		Home.instance.loadpage("/view/board/board.fxml");
    		}else {
    			System.out.println("�������� DB����");
    		}
    	}
    }

    @FXML
    void accrewrite(ActionEvent event) {
    	if(reupdatecheck) {
    		String rcontent = txtrecontent.getText();
        	int rnum = reply.getRnum();
        	boolean result = ReplyDao.replyDao.replyupdate(rnum, rcontent);
        	if(result) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
        		alert.showAndWait();
        		btnredelete.setVisible(false);
        		btnreupdate.setVisible(false);
        		btnrewrite.setText("����ۼ�");
        		reupdatecheck=false;
        		Home.instance.loadpage("/view/board/boardview.fxml");
        		
        	}
    	}else {
    		String recontent = txtrecontent.getText();
        	String rwriter = Login.member.getMid();
        	String a = "b";
        	int bnum = Boardcontroller.board.getBnum();
        	Reply reply = new Reply(0, rwriter, null, recontent, bnum,0);
        	boolean result = ReplyDao.replyDao.wirte(reply,a);
        	if(result) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setHeaderText("����� �ۼ� �Ǿ����ϴ�.");
        		alert.showAndWait();
        		Home.instance.loadpage("/view/board/boardview.fxml");
        	}
    	}
    	
    }

    boolean updatecheck = true; // ���� ��ư ����ġ ����
    @FXML
    void accupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	
    	if(updatecheck) { // ���� ����
    		
    		alert.setHeaderText("�Խñ� ������ �����Ϸ� ��ư �����ּ���");
    		alert.showAndWait();
    		txttitle.setEditable(true);
    		txtcontent.setEditable(true);
    		btnupdate.setText("�����Ϸ�");
    		updatecheck=false;
    		
    	} else {
    		String title = txttitle.getText();
        	String content = txtcontent.getText();
        	int bnum = Boardcontroller.board.getBnum();
        	
        	boolean result = BoardDao.boardDao.update(bnum, title, content);
        	if(result) {
        		alert.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
        		alert.showAndWait();
        		txttitle.setEditable(false);
        		txtcontent.setEditable(false);
        		btnupdate.setText("����");
        		updatecheck=true;
        		Home.instance.loadpage("/view/board/boardview.fxml");
        		
        	}
    		
    	}

    }
    
    @FXML
    void accredelete(ActionEvent event) {
    	if(reply.getRwriter().equals(Login.member.getMid())) {
    		// 1. ��� �޼��� �˸�
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
        	Optional<ButtonType> optional = alert.showAndWait();
        	// 2. Ȯ�� ��ư ��������
        	if(optional.get()==ButtonType.OK) {
        		// 3. ����ó��
        		boolean result = ReplyDao.replyDao.replydelete(reply.getRnum());
        		if(result) {
        			Alert alert2 = new Alert(AlertType.INFORMATION);
            		alert2.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
            		alert2.showAndWait();
        			reply=null;
        			Home.instance.loadpage("/view/board/boardview.fxml");
        		}else {
        			System.out.println("�������� DB����");
        		}
        	}
		}    	
    }
    boolean reupdatecheck = false;
    @FXML
    void accreupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	
    	if(reupdatecheck==false) { // ���� ����
    		btnreupdate.setVisible(false);
    		alert.setHeaderText("��� ������ �����Ϸ� ��ư �����ּ���");
    		alert.showAndWait();
    		btnrewrite.setText("�����Ϸ�");
    		reupdatecheck=true;
    		
    	} 
    }
    
    public void replytableshow() {
    	String a = "b";
    	ObservableList<Reply> replylist = ReplyDao.replyDao.list(a);
    	
    	TableColumn tc = replytable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rwriter"));
    	
    	tc = replytable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rdate"));
    	
    	tc = replytable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rcontent"));
    	
    	replytable.setItems(replylist);
    	
    }
	
	
	
}
