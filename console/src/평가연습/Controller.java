package �򰡿���;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

	public static ArrayList<Car> carlist = new ArrayList<>(); 


	
	
	// ���� �޼ҵ�
	public static boolean incar(Date date,String carnumber) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber) && temp.getOuttime().equals("���� ��")) {
				return false;
			}
		}
		
		Car temp = new Car(carnumber,ymd.format(date), hm.format(date) , "���� ��", "���� ��",sdf.format(date));
		carlist.add(temp);

		return true;
	}
	
	// ���� �޼ҵ�
	public static int outcar(String carnumber) throws ParseException {
		
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber) && temp.getPay().equals("���� ��")) {
				count(carnumber);
				return 3; // ���� �Ϸ�
			}	
		}
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber)) {
				return 2; // �̹� ���Ϸ�� ����
			}
		}
		
		
		return 1; // ��ġ�ϴ� ���� ��ȣ ����
	}
	
	// �ݾװ�� �޼ҵ�
	public static void count(String carnumber) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		DecimalFormat decimalFormat = new DecimalFormat("###,###��"); 
		
		int i=0; // �ε��� ��ȣ
		for(Car temp : carlist) {
			Date date = new Date();
			if(temp.getCarnum().equals(carnumber)) {
				
				
				Date d1 = sdf.parse(temp.getIntime()); // String -> Date �������� ��ȯ
				Date d2 = date; // ����ð� 
				String dateend = hm.format(d2); // �����ð� ��¿� ��ȯ
				long diff = d2.getTime() - d1.getTime(); // �����ð� - �����ð�
				long min = diff/(1000*60); // �� ���� ������ ȯ��
				

				System.out.println(min);
				long min1 = (long)Math.ceil(min/10.0) *10; // 1~10�п� õ���� �ޱ� ���ؼ� ������ ����� ���� 10.0���� ������ �ø��� ���ϱ�
				min = (min1*100 -3000); // ���� 30�� �����̱� ������ 3õ�����
				if(min<=30) { // 30�� ����
					min=0;
				}

				int fee = (int)min; // long���� ����ѰŸ� int�� ��ȯ
				
				// ����Ʈ�� ����
				carlist.get(i).setOuttime(dateend);
				carlist.get(i).setPay(decimalFormat.format(fee)); // õ���� �ڸ� �����ؼ� ����
			
			} // if end
			
			
			i++; // �ε�����ȣ ����
		} // for end
	}
	
	
	
	
	
	
	
}
