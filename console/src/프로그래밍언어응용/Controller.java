package ���α׷��־������;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

	public static ArrayList<Car> carlist = new ArrayList<>();
	
	
	// ���� �޼ҵ�
	public static boolean incar(Date date, String carnum) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum) && temp.getOuttime().equals("���� ��")) {
				return false;
			}
		}
		Car temp = new Car(carnum,sdf.format(date),ymd.format(date),hm.format(date),"���� ��","���� ��");
		carlist.add(temp);
		return true;
	}
	
	// ���� �޼ҵ�
	public static int outcar(String carnum) {
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum) && temp.getPay().equals("���� ��")) {
				return 1; // ��������
			}
		}
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum)) {
				return 2; // �̹� �����Ϸ��� ����
			}
		}
		return 3; // ��ġ�ϴ� ���� ��ȣ ����
	}
	
	// �ݾװ�� �޼ҵ�
	public static void count(String carnum) throws ParseException {
		
		int i=0;
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum) && temp.getPay().equals("���� ��")) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
				DecimalFormat df = new DecimalFormat("###,###��");
				
				Date d1 = sdf.parse(temp.getIntime());
				Date d2 = date;
				String outtime = hm.format(d2);
				
				long dif = d2.getTime() - d1.getTime();
				long min = dif/(1000*60);
				long min1 = (long)Math.ceil(min/10.0)*10;
				long pay =min1*100-3000;		
				if(min<=30) {
					pay=0;
				}
				
				carlist.get(i).setOuttime(outtime);
				carlist.get(i).setPay(df.format(pay));
				
			}
			i++;
		}
	}
	
	
}
