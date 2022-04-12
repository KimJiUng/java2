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
		
		// 1. 목록에서 선택된 제품의 객체를 호출
		Product product = Productcontrol.select;
		// 2. 각 컨트롤에 값 넣기
		img.setImage(new Image(product.getPimg()));
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
			// * 천단위 쉼표
			DecimalFormat decimalFormat = new DecimalFormat("가격 : #,### 원");
		lblpprice.setText(decimalFormat.format(product.getPprice()));
		if(product.getPactivation() == 1) {lblpactivation.setText("상태 : 판매중");}
		if(product.getPactivation() == 2) {lblpactivation.setText("상태 : 거래중");}
		if(product.getPactivation() == 3) {lblpactivation.setText("상태 : 판매완료");}
		lblpdate.setText(product.getPdate());
		// * 회원정보를 이용한 회원 id 찾기 [DAO에서 메소드 이용]
		lblpname.setText("제품 등록회원 : "+MemberDao.memberDao.getmid(product.getMnum()));
		
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
    	alert.setHeaderText("정말 삭제하시겠습니까?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result = ProductDao.productDao.delete(Productcontrol.select.getPnum());
    		if(result) {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
    			alert2.setHeaderText("삭제가 완료되었습니다.");
    			alert2.showAndWait();
    			Productcontrol.select=null;
    			Home.instance.loadpage("/view/product/product.fxml");
    		}else {
    			System.out.println("삭제실패 DB 오류");
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
        		alert.setHeaderText("수정이 완료되었습니다.");
        		alert.showAndWait();
        		btnredelete.setVisible(false);
        		btnreupdate.setVisible(false);
        		btnrewrite.setText("댓글작성");
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
	    		alert.setHeaderText("댓글이 작성 되었습니다.");
	    		alert.showAndWait();
	    		Home.instance.loadpage("/view/product/productview.fxml");
	    	}
    	}
    }
    
    @FXML
    void accredelete(ActionEvent event) {
    	if(reply.getRwriter().equals(Login.member.getMid())) {
    		// 1. 경고 메세지 알림
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setHeaderText("정말 삭제하시겠습니까?");
        	Optional<ButtonType> optional = alert.showAndWait();
        	// 2. 확인 버튼 눌렀을때
        	if(optional.get()==ButtonType.OK) {
        		// 3. 삭제처리
        		boolean result = ReplyDao.replyDao.replydelete(reply.getRnum());
        		if(result) {
        			Alert alert2 = new Alert(AlertType.INFORMATION);
            		alert2.setHeaderText("삭제가 완료되었습니다.");
            		alert2.showAndWait();
        			reply=null;
        			Home.instance.loadpage("/view/product/productview.fxml");
        		}else {
        			System.out.println("삭제실패 DB오류");
        		}
        	}
		}

    }

    @FXML
    void accreupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(reupdatecheck==false) { // 수정 시작
    		btnreupdate.setVisible(false);
    		alert.setHeaderText("댓글 수정후 수정완료 버튼 눌러주세요");
    		alert.showAndWait();
    		btnrewrite.setText("수정완료");
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
