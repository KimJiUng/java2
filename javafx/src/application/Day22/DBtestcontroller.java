package application.Day22;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DBtestcontroller implements Initializable{
										// Initializable : fxml�� ���� �������� �ʱⰪ[ó����] ���� �޼ҵ� ����
    @FXML
    private TextField txtwirter;

    @FXML
    private TextField txtcontent;

    @FXML
    private Button btnget;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtcontentlist;

    @FXML
    void accget(ActionEvent event) {
    	System.out.println("DB�� �����͸� ȣ���մϴ�.");
    	
    	// 1. DB ���� ��ü �����
    	Day22_2 DB���� = new Day22_2();
    	// 2. DB ��ü�� �޼ҵ� ȣ��
    	ArrayList<data> datalist = DB����.get();
    	// 3. ����Ʈ�� ��Ʈ�ѿ� �־��ֱ�
    	for(data temp : datalist) {
    		// txtcontentlist.appendText : �ش� ��Ʈ�ѿ� ���� �߰�
    		
    		txtcontentlist.appendText(
    				"��ȣ : "+temp.getNum()+
    				"\t�ۼ��� : "+temp.getWriter()+
    				"\t���� : "+temp.getContent()+"\n"
    				
    				);
    		
    	}
    	
    }

    @FXML
    void accwrite(ActionEvent event) {
    	System.out.println("DB�� �����͸� �����մϴ�.");
    	
    	// fxid��.getText() : �ش� ��Ʈ�ѿ� �Էµ� ���� ��������
    	String writer = txtwirter.getText();
    	String content = txtcontent.getText();
    	
    	// 1. DB ���� ��ü �����
    	Day22_2 DB���� = new Day22_2();
    	// 2. DB ���� ��ü������ ����[write] �޼ҵ� ȣ��
    	boolean result = DB����.write(writer, content);
    	if(result) {
    		System.out.println("DB�� ���� ����");
    		
    		// ������ ��Ʈ�ѿ� �Էµ� ������ �����ֱ�
    			// fxid��.setText() : �ش� ��Ʈ�ѿ� �� �ֱ�
    		txtwirter.setText("");
    		txtcontent.setText("");
    		
    	}else {
    		System.out.println("DB�� ���� ����");
    	}
    }
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	Day22_2 DB���� = new Day22_2(); // �����ڿ� db���� �ڵ带 �־��� ������ ��ü ����� ����
    }
	
	
}
