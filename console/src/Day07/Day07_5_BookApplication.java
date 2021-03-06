package Day07;

import java.util.Scanner;

public class Day07_5_BookApplication { // c s
	
	
		
		// BookApplication 클래스 : 입출력 관련코드
		// Book 클래스 : 도서 관련 코드
		// Member 클래스 : 회원 관련 코드
		
		// * 도서 대여 console 프로그램 [클래스버전]
			// 1. 클래스
				// 1. Book
					// 필드 : ISBN(도서번호), 도서명, 작가, 도서대여여부, 대여회원
					// 메소드 : 1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.도서등록 6.도서삭제
				// 2. Member
					// 필드 : 번호, 아이디, 비밀번호, 이름, 연락처
					// 메소드 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			// 2. 화면 설계
				// 1. 초기 메뉴 [1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기]
				// 2. 일반회원메뉴 [1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.로그아웃]
				// 3. 관리자메뉴 [1.도서등록 2.도서목록 3.도서삭제 4.대여순위(도전) 5.로그아웃]
		
		
		
	// * main 밖에 변수를 선언하는 이유 : 모든 메소드에서 사용하기 위해서
			// 지역변수 : { 변수선언 } 괄호내에서 선언된 변수는 { } 밖을 못나감
				// 서로 다른 { } 괄호 내에서 사용시 -> 전역변수
			// static : 프로그램 시작시 메모리 할당 / 프로그램 종료시 메모리 초기화
				// 프로그램 전반적으로 모든 곳에 사용되는 메모리[변수]
	static Scanner scanner = new Scanner(System.in); // static : 모든 곳에서 사용 가능
	static Member1[] members = new Member1[1000];
	static Book[] books = new Book[1000];
	
	// 0. 코드를 읽어주는 시작 메소드[스레드]
	public static void main(String[] args) { // m s
		// 메소드 호출
			//menu(); // 내부호출 불가능
				// 1. menu(); // 내부호출 불가능
					// static : 메모리 우선할당이기 때문에 static 외 메소드, 필드 x
					// main 메소드는 static 메소드이기 때문에 static 메소드만 내부호출 가능
				// 2. 외부호출
					// 1. 객체 생성(메모리할당) -> 메소드 호출
			Day07_5_BookApplication application = new Day07_5_BookApplication();
			application.menu();
	} // m e
		
	
	// 1. 초기 메뉴 메소드
	void menu() {
		while(true) { // 무한루프 [종료조건 x]
			System.out.println("----------------도서 대여 프로그램----------------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch = scanner.nextInt();
			Member1 member = new Member1();
			
			if(ch==1) {
				// 회원가입 메소드 호출
				boolean result = member.회원가입();
				if(result) System.out.println("알림)) 회원가입 성공");
				else System.out.println("알림)) 회원가입 실패");
				
			} // if end 
			else if(ch==2) {
				// 로그인 메소드 호출
				String result = member.로그인();
					
				if(result == null) {
					System.out.println("알림)) 동일한 회원정보가 없습니다.");
				}
				else if(result.equals("admin")){ // 2. 관리자 메뉴 메소드 호출
					System.out.println("알림) 안녕하세요~"+result+"님");
					adminmenu(); // 내부 메소드 호출
				}
				else { // 1. 일반회원 메뉴 메소드 호출
					System.out.println("알림) 안녕하세요~"+result+"님");
					membermenu(result); // 인수1개 [로그인 성공한 id]
				}  	
			} // else if end
			else if(ch==3) {
				// 아이디찾기 메소드 호출
				member.아이디찾기();
			} // else if end
			else if(ch==4) {
				// 비밀번호찾기 메소드 호출
				member.비밀번호찾기();
			} // else if end
			else System.out.println("알림)) 알 수 없는 번호입니다.");
		}
	}
	// 2. 일반회원 메뉴 메소드
	void membermenu(String loginid) { // 인수의 변수명은 달라도 되지만 자료형 동일
		while(true) { // 무한루프 [종료조건 : 로그아웃]
			Book book = new Book();
			System.out.println("----------------회원 메뉴------------------");
			System.out.println("1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.로그아웃 선택 : ");
			int ch = Day07_5_BookApplication.scanner.nextInt();
			
			if(ch==1) book.도서검색(); 
			else if(ch==2) book.도서목록();
			else if(ch==3) book.도서대여(loginid);
			else if(ch==4) book.도서반납(loginid);
			else if(ch==5) return; // 일반회원 메소드 종료 [로그아웃]
			else System.out.println("알림)) 알 수 없는 번호입니다.");
		} // while end
	}
	// 3. 관리자 메뉴 메소드
	void adminmenu() {
		while(true) {
			Book book = new Book();
			System.out.println("----------------관리자 메뉴------------------");
			System.out.println("1.도서등록 2.도서목록 3.도서삭제 4.로그아웃 선택 : ");
			int ch = Day07_5_BookApplication.scanner.nextInt();
			
			if(ch==1) book.도서등록();	
			else if(ch==2) book.도서목록();
			else if(ch==3) book.도서삭제();
			else if(ch==4) return;
			else System.out.println("알림)) 알 수 없는 번호입니다.");
		} // while end
	}
} // c e
