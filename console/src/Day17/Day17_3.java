package Day17;

import java.util.Arrays;

public class Day17_3 {

	public static void main(String[] args) {
		
		// �ڽ� Ŭ���� ���׸��� ���Ŭ���� �ֱ�
		Course<Person> pc = new Course<>("�Ϲ��ΰ���", 5);
		pc.add(new Person("�Ϲ���"));
		pc.add(new Worker("������")); // ���Ŭ�������� ��� �޾ұ� ������ ����
		pc.add(new Student("�л�")); // ���Ŭ�������� ��� �޾ұ� ������ ����
		pc.add(new Highschool_student("����л�")); // �л�Ŭ�������� ��� -> ���Ŭ�������� ��� �޾ұ� ������ ����
		// * ���׸��� ���� Ŭ������ �ڽ�Ŭ������ ���� �� �� �ִ�.
		Course<Worker> wc = new Course<>("�����ΰ���", 5);
		// wc.add(new Person("�Ϲ���")); // �θ�Ŭ������ �� �� ����.
		wc.add(new Worker("������")); // ������ ����
		// wc.add(new Student("�л�")); // �θ� �ڽ� ���谡 �ƴϿ��� �Ұ���
		Course<Student> sc = new Course<>("�л�����",5);
		// sc.add(new Person("�Ϲ���"));
		// sc.add(new Worker("������"));
		sc.add(new Student("�л�"));
		sc.add(new Highschool_student("����л�")); // �л�Ŭ�������� ��� �޾ұ� ������ ����
		Course<Highschool_student> hc = new Course("����л�����",5);
		// hc.add(new Person("�Ϲ���"));
		// hc.add(new Worker("������"));
		// hc.add(new Student("�л�"));
		hc.add(new Highschool_student("����л�"));
		
		// �޼ҵ� ȣ��
		registerCourse(pc);
		registerCourse(wc);
		registerCourse(sc);
		registerCourse(hc);
		System.out.println();
		registerCourseStudent(hc);
		registerCourseStudent(sc);
		System.out.println();
		registerCourseWorker(wc);
		registerCourseWorker(pc);
		
		
		
	} // m e
	
	
	// ���ϵ�ī�� : ? [���Ŭ���� ����]
		// �ڽ�<?> : ��� ���׸� ����
		// �ڽ�<? extends Ŭ������> : �ش� Ŭ�����κ��� ��� ����(�ڽ�) ���׸� Ŭ���� ����
		// �ڽ�<? super Ŭ������> : �ش� Ŭ�����κ��� ��� ��(�θ�) ���׸� Ŭ���� ����
	
	// 1.
	public static void registerCourse(Course<?> course) {
						// �μ��κ��� ��� �ڽ��� ���׸� ����
						// Course<Person> : Person ���׸� Course�� ����
						// Course<?> : ��� ���׸� Course ����
		System.out.println(course.getName()+" ��������� : "+
						Arrays.toString(course.getStudents() ) );
						// Arrays : �迭���� �޼ҵ� ����
							// Arrays.toString(�迭��) : �ش� �迭�� ���� ��� ���
		
	}
	
	// 2.
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName()+" ��������� : "+Arrays.toString(course.getStudents()));
	}
	
	// 3.
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " ��������� :"+Arrays.toString(course.getStudents()));
	}
	
} // c e
