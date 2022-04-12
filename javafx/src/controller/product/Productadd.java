package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Productadd implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Product product = Productcontrol.select;
		if(Productview.update==true) {
			btnadd.setText("�����Ϸ�");
			txtpname.setText(product.getPname());
			txtpcontent.setText(product.getPcontent());
			img.setImage(new Image(product.getPimg()));
			txtpprice.setText(Integer.toString(product.getPprice()) );
			if(product.getPcategory().equals("�����Ƿ�")) {opt1.setSelected(true);}
			if(product.getPcategory().equals("�����Ƿ�")) {opt2.setSelected(true);}
			if(product.getPcategory().equals("��Ȱ��ǰ")) {opt3.setSelected(true);}
			if(product.getPcategory().equals("������ǰ")) {opt4.setSelected(true);}
			
			if(product.getPactivation()==1) { txtactivation.setText("�Ǹ���"); btnactivation.setText("�ǸŻ��� ���� : �ŷ���");	}
			if(product.getPactivation()==2) { txtactivation.setText("�ŷ���"); btnactivation.setText("�ǸŻ��� ���� : �ǸſϷ�");	}
			if(product.getPactivation()==3) { txtactivation.setText("�ǸſϷ�"); btnactivation.setText("�ǸŻ��� ���� : �Ǹ���");	}
		}
		
		if(Home.category.equals("�����Ƿ�")) {opt1.setSelected(true);}
		if(Home.category.equals("�����Ƿ�")) {opt2.setSelected(true);}
		if(Home.category.equals("��Ȱ��ǰ")) {opt3.setSelected(true);}
		if(Home.category.equals("������ǰ")) {opt4.setSelected(true);}
		
	}
	
    @FXML
    private Button btnadd;

    @FXML
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private TextField txtpprice;

    @FXML
    private Button btnimg;

    @FXML
    private RadioButton opt1;

    @FXML
    private ToggleGroup category;

    @FXML
    private RadioButton opt2;

    @FXML
    private RadioButton opt3;

    @FXML
    private RadioButton opt4;

    @FXML
    private ImageView img;

    @FXML
    private Button btnback;

    @FXML
    private Label txtpath;
    
    @FXML
    private Button btnactivation;
    
    @FXML
    private Text txtactivation;

    @FXML
    void accactivation(ActionEvent event) {
    	if(btnactivation.getText().equals("�ǸŻ��� ���� : �ŷ���")) {
    		txtactivation.setText("�ŷ���");
    		btnactivation.setText("�ǸŻ��� ���� : �ǸſϷ�");
    		ProductDao.productDao.activation(Productcontrol.select.getPnum());
    		Productcontrol.select.setPactivation(2);
    		return;
    	}
    	if(btnactivation.getText().equals("�ǸŻ��� ���� : �ǸſϷ�")) {
    		txtactivation.setText("�ǸſϷ�");
    		btnactivation.setText("�ǸŻ��� ���� : �Ǹ���");
    		ProductDao.productDao.activation(Productcontrol.select.getPnum());
    		Productcontrol.select.setPactivation(3);
    		return;
    	}
    	if(btnactivation.getText().equals("�ǸŻ��� ���� : �Ǹ���")) {
    		txtactivation.setText("�Ǹ���");
    		btnactivation.setText("�ǸŻ��� ���� : �ŷ���");
    		ProductDao.productDao.activation(Productcontrol.select.getPnum());
    		Productcontrol.select.setPactivation(1);
    		return;
    	}
    	
    	
    }
    

    @FXML
    void add(ActionEvent event) {
    	if(Productview.update==true) {
    		if(pimage==null) {
    			pimage=Productcontrol.select.getPimg();
    		}
    		Alert alert = new Alert(AlertType.INFORMATION);
        	try {
        		
            	// 1. ��Ʈ�ѿ� �Էµ� ������ ��������
        		int pnum = Productcontrol.select.getPnum();
            	String pname = txtpname.getText();
            	String pcontent = txtpcontent.getText();
            	int pprice = Integer.parseInt(txtpprice.getText());
            		// * ī�װ�
            	String pcategory = null;
            		if(opt1.isSelected()) { // ���࿡ opt1�̶�� fxid�� ��Ʈ��(������ư)�� ���õǾ�����
            			pcategory="�����Ƿ�";
            		}
            		if(opt2.isSelected()) {pcategory="�����Ƿ�";}
            		if(opt3.isSelected()) {pcategory="��Ȱ��ǰ";}
            		if(opt4.isSelected()) {pcategory="������ǰ";}
            	int mnum = Login.member.getMnum();
            	// 2. (��ȿ���˻�)
            	if(pname.length()<1) {
            		alert.setHeaderText("��ǰ���� �Է��ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	if(pcontent.length()<1) {
            		alert.setHeaderText("��ǰ������ �Է��ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	if(txtpprice.getText().length()<1) {
            		alert.setHeaderText("��ǰ������ �Է��ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	if(!(opt1.isSelected() || opt2.isSelected() || opt3.isSelected() || opt4.isSelected() ) ) {
            		alert.setHeaderText("ī�װ��� �����ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	// 3. ��üȭ
            	Product product = new Product(pnum, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
            	boolean result = ProductDao.productDao.update(product);
            	if(result) {
            		alert.setHeaderText("���� �Ϸ�");
            		alert.showAndWait();
            		Productview.update=false;
            		Productcontrol.select=null;
            		Home.instance.loadpage("/view/product/product.fxml");
            	}else {
            		alert.setHeaderText("���� ����[�����ڿ��� ����]");
            		alert.showAndWait();
            		Productview.update=false;
            	}
            	// 4. DBó��
            	
            	// 5. ���ó��
        	} catch(NumberFormatException e) {
        		alert.setHeaderText("��ǰ������ ���ڸ� �Է°����մϴ�.");
        		alert.showAndWait();
        	}
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	try {
        		
            	// 1. ��Ʈ�ѿ� �Էµ� ������ ��������
            	String pname = txtpname.getText();
            	String pcontent = txtpcontent.getText();
            	int pprice = Integer.parseInt(txtpprice.getText());
            		// * ī�װ�
            	String pcategory = null;
            		if(opt1.isSelected()) { // ���࿡ opt1�̶�� fxid�� ��Ʈ��(������ư)�� ���õǾ�����
            			pcategory="�����Ƿ�";
            		}
            		if(opt2.isSelected()) {pcategory="�����Ƿ�";}
            		if(opt3.isSelected()) {pcategory="��Ȱ��ǰ";}
            		if(opt4.isSelected()) {pcategory="������ǰ";}
            	int mnum = Login.member.getMnum();
            	// 2. (��ȿ���˻�)
            	if(pname.length()<1) {
            		alert.setHeaderText("��ǰ���� �Է��ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	if(pcontent.length()<1) {
            		alert.setHeaderText("��ǰ������ �Է��ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	if(txtpprice.getText().length()<1) {
            		alert.setHeaderText("��ǰ������ �Է��ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	if(!(opt1.isSelected() || opt2.isSelected() || opt3.isSelected() || opt4.isSelected() ) ) {
            		alert.setHeaderText("ī�װ��� �����ϼž� �մϴ�.");
            		alert.showAndWait();
            		return;
            	}
            	// 3. ��üȭ
            	Product product = new Product(0, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
            	boolean result = ProductDao.productDao.add(product);
            	if(result) {
            		alert.setHeaderText("��ǰ ��� �Ϸ�");
            		alert.showAndWait();
            		Home.instance.loadpage("/view/product/product.fxml");
            	}else {
            		alert.setHeaderText("��ǰ ��� ����[�����ڿ��� ����]");
            		alert.showAndWait();
            	}
            	// 4. DBó��
            	
            	// 5. ���ó��
        	} catch(NumberFormatException e) {
        		alert.setHeaderText("��ǰ������ ���ڸ� �Է°����մϴ�.");
        		alert.showAndWait();
        	}
    	}
    	
    	
    	
    	
    }

    @FXML
    void back(ActionEvent event) {
    	if(Productview.update==true) {
    		Productview.update=false;
    		Home.instance.loadpage("/view/product/productview.fxml");
    	}else {
    		Home.instance.loadpage("/view/product/product.fxml");
    	}
    	
    }

    private String pimage = null; // �޼ҵ�ۿ��� �����ϴ� ���� : imgadd �޼ҵ�� add �޼ҵ忡�� ����ϱ� ����
    
    @FXML
    void imgadd(ActionEvent event) { // �̹��� ��Ϲ�ư Ŭ��������
    	// 1. ���� ���� Ŭ���� ��ü ����
    	FileChooser fileChooser = new FileChooser();
    	
    	// 2. ���� ����[����] ����
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("�̹�������:image file", "*png","*jpg","*jpeg","*gif"));
    	
    	// 3. ���ο� stage(������â)
    	File file = fileChooser.showOpenDialog(new Stage());
    		// ���ϼ��ð�ü.showOpenDialog(���������̸�);
    		// fileChooser ���� ������ ������ file Ŭ���� ��üȭ
    	
    	// 4. ������ ������ ��� ǥ��
    	txtpath.setText("���� ��� : "+file.getPath());
    	txtpath.setWrapText(true);
    	// 5. ���ϰ��
    	pimage = file.toURI().toString();
    	//	System.out.println(file.getPath());				// ��� ���м� : \
    	//	System.out.println(file.toURI());				// ��� ���м� : /
    	//	System.out.println(file.toURI().toString());	// ���ڿ��� ��ȯ
    	
    	// 5. �̸����� �̹�����Ʈ�ѿ� ����
    	Image image = new Image(pimage); // �ش� �̹����� ��ΰ��� / �� ���еǾ� �־����
    	img.setImage(image);
    	
    	// * ������ ������ ���� ������Ʈ ������ ����(�̵�)�ؿ���
    	try {
    		// 1. ���� �Է� ��Ʈ�� [ �̵� ���� : ����Ʈ ]
        	FileInputStream fileInputStream = new FileInputStream(file); // file : fileChooser���� ���õ� ���� ��ü
        	// 2. ���� ��� ��Ʈ��
        		// 1. ���ο� ��� ����
        	File copyfile = new File("C:\\Users\\504\\git\\java\\2\\src\\img\\product\\"+file.getName());
        	FileOutputStream fileOutputStream = new FileOutputStream(copyfile);
        	// 3. ����Ʈ �迭 ����
        	byte[] bytes = new byte[1024*1024*1024]; // 1024byte = 1KB -> 1024KB = 1MB -> 1024MB = 1GB
        	// 4. �ݺ����� �̿��� inputStream�� ���� ��Ʈ�� ��� �о����
        	int size;
        	while( (size=fileInputStream.read(bytes)) >0 ) { // �о�� ����Ʈ�� 0���� ������ �ݺ��� ����
        		fileOutputStream.write(bytes, 0, size);
        	}
        	// 5. �뷮 ū ��쿡�� ��Ʈ�� ���� �ʼ� !
        	fileInputStream.close();
        	fileOutputStream.close();
    	// *���ϸ� DB ����
        	pimage = copyfile.toURI().toString();
    	} catch(Exception e) {
    		System.out.println("���� ���� : "+e);
    	}
    	
    	
    }

	
}
