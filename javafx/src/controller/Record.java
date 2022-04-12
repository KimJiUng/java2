package controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.MemberDao;
import dao.ProductDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ��ü ȸ����
		int mtotal = MemberDao.memberDao.membertotal();
		lblmtotal.setText(mtotal+"��");
		// ��ü ��ǰ��
		int ptotal = ProductDao.productDao.list(null, null).size();
		lblptotal.setText(ptotal+"��");
		// ��ü �Խù���
		int btotal = BoardDao.boardDao.list().size();
		lblbtotal.setText(btotal+"��");
		
		// ��¥�� ȸ������ ��
		String a = "msince";
		String table = "member";
			// 1. x,y�� �迭 ����
		XYChart.Series series = new XYChart.Series<>();
			// XYChart.Series : �迭 Ŭ����
				// XYChart.Data : �迭������ Ŭ���� [x���� ��, y���� ��]
		series.setName("��¥�� ȸ������ ��");
			// 2. ��¥���� ȸ������ �� üũ [2022-04-11, 3]
				// Map �÷��� -> Ű[��¥], ��[������ ��]���� �ϳ��� ��Ʈ�� ����
		Map<String, Integer> datemtotal = MemberDao.memberDao.total(a,table);
			// 3. �����͸� �迭�� �߰�
		for(String key : datemtotal.keySet()) { // �ݺ���
				// 3-1 : ������ �迭 ����(������ : key=��¥, value=�����ڼ�)
			XYChart.Data data = new XYChart.Data<>(key, datemtotal.get(key));
				// 3-2 : �ش� ������ ��ü�� �迭�� �߰�
			series.getData().add(data);
		}
			// 4. �ش� �迭�� ������Ʈ�� �߰�
		mbc.getData().add(series);
	
		// ��¥�� �Խù� ��
		XYChart.Series series2 = new XYChart.Series<>();
		series2.setName("��¥�� �Խù� ��");
		table = "board";
		Map<String, Integer> datebtotal = BoardDao.boardDao.datetotal(table);
		for(String key : datebtotal.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, datebtotal.get(key));
			series2.getData().add(data);
		}
		bbc.getData().add(series2);
		
		// ��¥�� ��ǰ ��
		table = "product";
		XYChart.Series series3 = new XYChart.Series<>();
		series3.setName("��¥�� ��ǰ ��");
		Map<String, Integer> dateptotal = BoardDao.boardDao.datetotal(table);
		for(String key : dateptotal.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, dateptotal.get(key));
			series3.getData().add(data);
		}
		pbc.getData().add(series3);
		
		// ������Ʈ : ī�װ��� ����
		a = "pcategory";
		table = "product";
			// * ObservableList ������� : ������Ʈ�� ����Ʈ�� �߰���
			// 1. ObservableList<������Ʈ ������ �ڷ���> ����Ʈ�� ����
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
			// 2. db���� ī�װ��� ����
		Map<String, Integer> categorytotal = MemberDao.memberDao.total(a,table);
			// 3. ������Ʈ ������ �߰�
		for(String key : categorytotal.keySet()) {
			PieChart.Data data = new Data(key, categorytotal.get(key));
			// * �����͸� ����Ʈ�� �߰�
			list.add(data);
		}
			// 4. ����Ʈ�� ������Ʈ�� �߰�
		ppc.setData(list);
		
	}
	
    @FXML
    private Label lblmtotal;

    @FXML
    private Label lblptotal;
	
    @FXML
    private Label lblbtotal;
    
    @FXML
    private BarChart mbc;

    @FXML
    private BarChart pbc;
    
    @FXML
    private BarChart bbc;
    
    @FXML
    private PieChart ppc;
	
}
