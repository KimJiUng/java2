package Day10;

public class Day10_1 { // c s

	public static void main(String[] args) { // m s
		
		// p.338 확인문제
		
		Child child = new Child();
		// 6. 자식클래스가 메모리할당[객체생성]을 하면 부모클래스내 생성자 호출 우선
			// this.필드명 : 현 클래스내 필드 호출
			// this.메소드명() : 현 클래스내 메소드 호출
			// this() : 현 클래스내 생성자 호출
			// super.필드명 : 부모 클래스내 필드 호출
			// super.메소드명() : 부모 클래스내 메소드 호출
			// super() : 부모 클래스내 생성자 호출
			// 1. 자식 클래스내 기본 생성자 호출 -> 출력순서 4
				// 2. 부모 클래스내 기본 생성자 호출 -> 출력순서 2
					// 3. 부모 클래스내 [1개인수] 생성자 호출 -> 출력순서 1
				// 4. 자식 클래스내 [1개인수] 생성자 호출 -> 출력순서 3
			
		
		// 7.
			// 자식클래스 자식객체명 = new 자식생성자();
			// 부모클래스 부모객체명 = 자식객체명;
				// 1. 스노우 타이어가 굴러갑니다. 자식객체명.run()
					// 오버라이딩 했기 때문에
				// 2. 스노우 타이어가 굴러갑니다. 부모객체명.run()
					// 자식이 부모로 타입변환 했기 때문에
		
		// 8.
			// 2 : 강제형변환 가능하나 문법 다름
				// new 앞에 강제 형변환 불가능
				// (B) new A() [불가능]
				// A a = new A();  ---> B b = (B) a; [가능]
		
	} // m e
	
	
} // c e
