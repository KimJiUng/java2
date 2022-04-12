package Day13;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Day13_4 { // c s
	
	public static void main(String[] args) throws InterruptedException { // m s
		
		// p.544 DecimalFormat Ŭ���� : ���� �����͸� ���ϴ� �������� ǥ��
			// ���� ����
				// 0 : �ڸ��� [ ���ڸ��� 0���� ä�� ]
				// # : �ڸ��� [ ���ڸ��� ä����x ]
		double num = 1234567.89;
		
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("0.0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("0000000000.00000");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#.#");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("##########.#####");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#.0"); // ������ �Ҽ��� ���ڸ� ǥ��
		System.out.println(df.format(num));
		
		df = new DecimalFormat("+#.0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("-#.0");
		System.out.println(df.format(num));
		
		// *************** õ���� ���� ��ǥ ******************
		df = new DecimalFormat("#,##0��");
		System.out.println(df.format(0));
		
		df = new DecimalFormat("#,###��");
		System.out.println(df.format(0));
		
		df = new DecimalFormat("0,000��");
		System.out.println(df.format(0));
		
		df = new DecimalFormat("0.0E0"); // E : ��������
		System.out.println(df.format(num));
		
		df = new DecimalFormat("+#,### ; -#,###"); // ��� ; ����
		System.out.println(df.format(num));
		
		// ��ǻ�ʹ� ����� x [ ���� 1: 100% /  0.5 : 50% / 0.05 : 5% ]
		df = new DecimalFormat("#,###%");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println(df.format(num));
		
		// p.544 DecimalFromat Ŭ���� : ���� ���� ��ȯ
		// p.878 SimpleDateFormat Ŭ���� : ��¥ ���� ��ȯ
		// p. MessageFromat Ŭ���� : ���� ���� ��ȯ
		
		
		String id = "java";
		String name ="�ſ��";
		String tel = "010-123-5678";
		
		String text = "ȸ�� ID : {0} \nȸ�� �̸� : {1} \nȸ�� ��ȭ : {2}";
		String result1 = MessageFormat.format(text, id, name, tel);
											// ����, {0}, {1}, {2}
		System.out.println(result1);
		
		String sql = "insert info member values( {0}, {1}, {2})";
										// �ε��� : 0, 1 ,2
		Object[] �迭 = {id, name, tel};
		String result2 = MessageFormat.format(sql, �迭);
		System.out.println(result2);
		
		// JAVA 7 ���� ���� Date ���Ŀ��� �������� ��¥ API �߰���
		LocalDate currDate = LocalDate.now(); // new[x] static �޼ҵ� now()
		System.out.println("���� ��¥ : "+currDate);
		
		LocalTime currTime = LocalTime.now();
		System.out.println("���� �ð� : "+currTime);
		
		// Date ���糯¥/�ð� [ ������ �ȵǰų� �񱳱�� ����� ]
		// vs
		// LocalDate : ���� ��¥ 			LocalTime : ���� �ð�
		
		LocalDateTime currdatetime = LocalDateTime.now();
		System.out.println("���� ��¥/�ð� : "+currdatetime);
		
		// �ð� ���
		Instant instant1 = Instant.now();
		Thread.sleep(1000); // 1000�и��� : 1�� ��� [ �ڵ��� �帧�� 1�ʰ� ���� ]
		Instant instant2 = Instant.now();
		if(instant1.isBefore(instant2)) {
			System.out.println("instant1�� �����ϴ�.");
		} else if(instant1.isAfter(instant2)) {
			System.out.println("instant1�� �ʽ��Ѵ�.");
		} else {
			System.out.println("������ �ð��Դϴ�.");
		}
		System.out.println("����(nanos): "+instant1.until(instant2, ChronoUnit.NANOS));
			// �и��� = 1/1,000 ��			����ũ���� = 1/1,000,000 ��		������ = 1/1,000,000,000 ��		
		
		
		
		
		
		
	} // m e
	
	

} // c e
