package controller.product;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.MemberDao;
import dao.ProductDao;
import dao.ReplyDao;
import dto.Product;
import dto.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Productview implements Initializable {

	public static boolean update=false;
	
	public static Reply reply;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String mid = MemberDao.memberDao.getmid(Productcontrol.select.getMnum());
		if(mid.equals(Login.member.getMid())) {
			btnsendmail.setVisible(false);
		}
		txtpname.setEditable(false);
		txtpcontent.setEditable(false);
		
		if(Login.member.getMnum()==(Productcontrol.select.getMnum())) {
			
		}else {
			btndelete.setVisible(false);
			btnupdate.setVisible(false);
		}
		
		// 1. ��Ͽ��� ���õ� ��ǰ�� ��ü�� ȣ��
		Product product = Productcontrol.select;
		// 2. �� ��Ʈ�ѿ� �� �ֱ�
		img.setImage(new Image(product.getPimg()));
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
			// * õ���� ��ǥ
			DecimalFormat decimalFormat = new DecimalFormat("���� : #,### ��");
		lblpprice.setText(decimalFormat.format(product.getPprice()));
		if(product.getPactivation() == 1) {lblpactivation.setText("���� : �Ǹ���");}
		if(product.getPactivation() == 2) {lblpactivation.setText("���� : �ŷ���");}
		if(product.getPactivation() == 3) {lblpactivation.setText("���� : �ǸſϷ�");}
		lblpdate.setText(product.getPdate());
		// * ȸ�������� �̿��� ȸ�� id ã�� [DAO���� �޼ҵ� �̿�]
		lblpname.setText("��ǰ ���ȸ�� : "+MemberDao.memberDao.getmid(product.getMnum()));
		
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
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private Button btnback;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

    @FXML
    private ImageView img;

    @FXML
    private Label lblpname;

    @FXML
    private Label lblpdate;

    @FXML
    private Label lblpactivation;
    
    @FXML
    private Label lblpprice;

    @FXML
    private TableView<Reply> replytable;

    @FXML
    private TextArea txtrecontent;

    @FXML
    private Button btnrewrite;
    
    @FXML
    private Button btnredelete;

    @FXML
    private Button btnreupdate;
    
    @FXML
    private Button btnsendmail;

    @FXML
    void accdelete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result = ProductDao.productDao.delete(Productcontrol.select.getPnum());
    		if(result) {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
    			alert2.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
    			alert2.showAndWait();
    			Productcontrol.select=null;
    			Home.instance.loadpage("/view/product/product.fxml");
    		}else {
    			System.out.println("�������� DB ����");
    		}
    	}
    	
    }

    boolean reupdatecheck = false;
    
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
        		replytableshow();
        		txtrecontent.setText("");
        		
        	}
    	}
    	else{
	    	String recontent = txtrecontent.getText();
	    	String rwriter = Login.member.getMid();
	    	String a = "p";
	    	int pnum = Productcontrol.select.getPnum();
	    	Reply reply = new Reply(0, rwriter, null, recontent, 0,pnum);
	    	boolean result = ReplyDao.replyDao.wirte(reply, a);
	    	if(result) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("����� �ۼ� �Ǿ����ϴ�.");
	    		alert.showAndWait();
	    		Home.instance.loadpage("/view/product/productview.fxml");
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
        			Home.instance.loadpage("/view/product/productview.fxml");
        		}else {
        			System.out.println("�������� DB����");
        		}
        	}
		}

    }

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

    @FXML
    void accupdate(ActionEvent event) {
    	update=true;
    	Home.instance.loadpage("/view/product/productadd.fxml");
    }

    @FXML
    void back(ActionEvent event) {
    	Productcontrol.select=null;
    	Home.instance.loadpage("/view/product/product.fxml");
    }
    

    @FXML
    void sendmail(ActionEvent event) {
    	Home.instance.loadpage("/view/home/sendmail.fxml");
    }
    
    public void replytableshow() {
    	String a = "p";
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
