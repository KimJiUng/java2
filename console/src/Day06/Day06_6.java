package Day06;

import java.util.Scanner;

public class Day06_6 { // c s

	public static void main(String[] args) { // m s
		
		// 비회원제 게시판 [클래스 버전]
			// 0. 게시물 설계 => 클래스 선언
				// 필드 : 제목, 내용, 작성자, 비밀번호
				// 생성자 : 사용유무 선택
		
			// 1. 첫화면 [모든 게시물(번호, 작성자, 제목) 출력]
			// 2. 메뉴 [1.글쓰기 2.글보기]
				// 1. 글쓰기 [제목, 내용, 작성자, 비밀번호 => 4개변수 => 객체화]
				// 2. 글보기 [해당 글번호를 입력받아 해당 글 상세페이지(번호, 작성자, 제목, 내용) 표시]
					// 글번호는 배열에 저장되는 순서 [인덱스]
					// 글보기 메뉴
			// 3. 글보기 메뉴 [1.목록보기 2.삭제 3.수정]
				// 1. 삭제시 : 비밀번호 입력받아 동일하면 삭제
				// 2. 수정시 : 비밀번호 입력받아 동일하면 제목과 내용만 수정
		
		// 준비 [전역변수(모든곳{ }에서 사용되는 변수) 선언]
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
			// * Board 객체 100개를 저장할 수 있는 1차원 배열 선언
		
		// 프로그램 실행
		while(true) { // 프로그램 실행 무한루프 [종료조건 x]
			System.out.println("-----------------커뮤니티---------------");
//////////////////////////////////////////////////////// 모든 게시물 조회/////////////////////////////////////////////
			System.out.printf("%3s\t%10s\t%20s \n", "번호", "작성자", "제목");
				// 배열내 모든 객체(게시물) 출력 반복문
				int index = 0; // 인덱스 변수 [배열내 객체 수 체크]
				for(Board board : boardlist) {
					if(board!=null) {
						System.out.printf("%3d\t%10s\t%20s \n", index, board.writer, board.title );
						index++; // 인덱스 증가
					}
				}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("1.글쓰기 2.글보기");
			int ch = scanner.nextInt();
			if(ch==1) { // 글쓰기 [제목, 내용, 작성자, 비밀번호 => 4개변수 => 객체화]
//////////////////////////////////////////////글쓰기///////////////////////////////////////////////////////////////////
				// 1. 4개 변수를 입력받는다.
				System.out.println("---------------------글 쓰기 페이지----------------------");
				System.out.println("title : "); String title = scanner.next();
				System.out.println("contet : "); String content = scanner.next();
				System.out.println("writer : "); String writer = scanner.next();
				System.out.println("password : "); String password = scanner.next();
				
				// 2. 4개 변수를 객체화 [객체를 만들어서 4개변수를 객체내 필드에 저장]
				Board board = new Board(title, content, writer, password);
					// 4개 필드를 갖는 생성자 사용
				
				// 3. 배열내 빈공간을 찾아서 빈공간에 객체 대입
				int i=0;
				for(Board temp : boardlist) {
					if(temp==null) {
						boardlist[i] = board;
						break; // 한번 저장했으면 반복문 종료
					} // if end
					i++;
				} // for end
////////////////////////////////////////////////////////////////////////////////////////////////////////
			} // if 글쓰기 end
			else if(ch==2) { // 글보기 [해당 글번호를 입력받아 해당 글 상세페이지(번호, 작성자, 제목, 내용) 표시]
//////////////////////////////////////////////////////글보기//////////////////////////////////////////////
				
					System.out.println("게시물 번호 선택 : "); int number = scanner.nextInt();
					System.out.println("-------------------게시물 상세페이지---------------------");
					// 반복문 사용 목적 x -> 출력할위치[인덱스] 입력 받았기 때문에 -> 입력받은 인덱스 위치에 객체 출력
					System.out.printf("작성자 : %s\t제목 : %s \n", boardlist[number].writer, boardlist[number].title);
					System.out.printf("내용 : %s \n", boardlist[number].content);
					System.out.println("----------------------------------------------------");
					System.out.println("1.목록보기(뒤로가기) 2.글삭제 3.글수정"); 
					int ch2 = scanner.nextInt();
					
					if(ch2==1) { // 목록보기
						
					} // if 목록보기 end
					else if(ch2==2) { // 글삭제
//////////////////////////////////////////////////////글삭제//////////////////////////////////////////////
						System.out.println("알림)) 현 게시물 비밀번호 : "); String pw = scanner.next();
						if(boardlist[number].password.equals(pw)) {
							System.out.println("알림)) 삭제 성공");
							boardlist[number]=null;
							
							
							for(int i=number; i<boardlist.length; i++) {
								
								if(i==boardlist.length-1) {
									boardlist[boardlist.length-1]=null;
								}
								else boardlist[i]=boardlist[i+1];
							}
						} // if end
						else System.out.println("알림)) 비밀번호가 다릅니다.[삭제 실패]");
///////////////////////////////////////////////////////////////////////////////////////////////////////////
					}	 // else if 글삭제 end
					else if(ch2==3) { // 글수정
///////////////////////////////////////////////////글수정///////////////////////////////////////////////////
						System.out.println("알림)) 현 게시물 비밀번호 : "); String pw_2 = scanner.next();
						if(boardlist[number].password.equals(pw_2)) {
							// 해당 게시물의 제목과 내용을 새로 입력받아 현 게시물 객체내 제목과 내용 수정
							System.out.println("수정할 제목 : "); boardlist[number].title = scanner.next();
							System.out.println("수정할 내용 : "); boardlist[number].content = scanner.next();
						}
						else System.out.println("알림)) 비밀번호가 다릅니다.[수정 실패]");
//////////////////////////////////////////////////////////////////////////////////////////////////////////
					} // else if 글수정 end
					else System.out.println("알림)) 알 수 없는 번호입니다.");
				
////////////////////////////////////////////////////////////////////////////////////////////////////////				
			} // else if 글보기 end
			else {
				System.out.println("알림)) 알 수 없는 번호입니다.");
			}
			
			
			
		} // while 프로그램 실행 end
		
	} // m e
	
} // c e
