package controller.product;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Productcontrol implements Initializable {
						// �������̽�=�����ϴ�
    @FXML
    private Button btnadd;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;
    
    @FXML
    private TextField txtserch;

    @FXML
    private Button btnserch;
    
    @FXML
    void accserch(ActionEvent event) { // �˻� ��ư ��������
    	String serch = txtserch.getText(); // �˻�â�� �Էµ� ������ ��������
    	show(serch);
    	
    }

    @FXML
    void accadd(ActionEvent event) {
    	Home.instance.loadpage("/view/product/productadd.fxml");
    }

    public static Product select;
    
    void show(String serch) {
    	if(vbox.getChildren().isEmpty() == false) { // .isEmpty() : �ش� ��ü�� ����ִ��� Ȯ�� [vbox�� ��� �ִ��� Ȯ��]
    		// vbox�� ��ü�� ��������� true ������������� false
    		vbox.getChildren().remove(0); // vbox�� ���� ��ü ����
    	}
    	// 1. ��� ��ǰ ��������
		ArrayList<Product> productlist = ProductDao.productDao.list(Home.category,serch);
		
		// 2. �׸��� Ŭ���� [��/��]
		GridPane gridPane = new GridPane();
			// * �׸��� ����
			gridPane.setPadding(new Insets(10));
			// * ��ư�� ����
			gridPane.setHgap(20); // ���ο���
			gridPane.setVgap(20); // ���ο���
		// 3. �ݺ���
		int i=0; // �ε����� ����
		for(int row=0; row<productlist.size()/3; row++) { // ��		
			for(int col=0; col<3; col++) { // ��
				// 1. �̹���
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg() ) );
					imageView.setFitHeight(250); // �̹��� ���α���
					imageView.setFitWidth(200); // �̹��� ���α���
				// 2. ��ư ����
				Button button = new Button(null, imageView);
					// * ��ư ������� [transparent : �����]
					button.setStyle("-fx-background-color:transparent");
					// * ��ư id�� �ֱ� [��ǰ�ĺ� = index]
					button.setId(i+"");
					// * ��ư Ŭ���̺�Ʈ
					button.setOnAction(e ->{
						// 1. Ŭ���� ��ư�� id ��������
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						// 2. Ŭ���� ��ǰ ����
						select = productlist.get(id);
						Home.instance.loadpage("/view/product/productview.fxml");
					});
				gridPane.add(button, col, row); // �׸��峻 �ش� ����ȣ, ���ȣ�� ��ư �߰�
				i++; // �ε��� ����
			}
		}
		// * 3�ǹ�� ��������
		int row = productlist.size()/3; // ��������
		int remain = productlist.size()%3;
		if(remain !=0) {
			for(int col=0; col<remain; col++) { // ��
				// 1. �̹���
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg() ) );
					imageView.setFitHeight(250); // �̹��� ���α���
					imageView.setFitWidth(200); // �̹��� ���α���
				// 2. ��ư ����
				Button button = new Button(null, imageView);
					// * ��ư ������� [transparent : �����]
					button.setStyle("-fx-background-color:transparent");
					// * ��ư id�� �ֱ� [��ǰ�ĺ� = index]
					button.setId(i+"");
					// * ��ư Ŭ���̺�Ʈ
					button.setOnAction(e ->{
						// 1. Ŭ���� ��ư�� id ��������
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						// 2. Ŭ���� ��ǰ ����
						select = productlist.get(id);
						Home.instance.loadpage("/view/product/productview.fxml");
					});
				gridPane.add(button, col, row); // �׸��峻 �ش� ����ȣ, ���ȣ�� ��ư �߰�
				i++; // �ε��� ����
			}
		}
		// 4. vbox�� �׸��� �ֱ�
		vbox.getChildren().add(gridPane);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show(null); // ȭ���� ó�� ���������� �˻�� null�� �־��ֱ�
	}
	
	
	
}
