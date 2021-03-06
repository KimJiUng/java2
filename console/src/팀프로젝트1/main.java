package 팀프로젝트1;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;



public class main {

	static Scanner scanner = new Scanner(System.in);
	static String yourId;
	static String yourPw;

	public static void main(String[] args){
		try {
			Controller.게시물출력();
			Controller.회원출력();
			Controller.차단출력();
			Controller.쪽지출력();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			scanner = new Scanner(System.in);
			try {
				
					그림();

					// 메뉴
					메인메뉴();

				
			} catch (Exception e) {
				System.err.println("제대로된 입력 바람");
			}
		}
		
		

		
	}

	public static void 로그인메뉴(String id) throws IOException {
		while (true) {
			//////////////////////////////////////////// 인기글출력
//////////////////////////////////////////////인기글출력
			for (int i = 0; i < Controller.카테고리.length; i++) {
				ArrayList<Board> 인기글 = Controller.인기글(Controller.카테고리[i]); // 각 카테고리 인기글 가져오기
				System.out
						.println("---------------------카테고리: " + Controller.카테고리[i] + "-----------------------------");
				System.out.println("제목\t\t내용\t\t글번호\t\t추천수");
				for (int j = 0; j < 인기글.size(); j++) {
					if (인기글.size() != 0) {
						String 내용 = "";
						for (int s = 0; s < 인기글.get(j).getContent().length(); s++) {
							내용 += 인기글.get(j).getContent().charAt(s);
							if (s == 9) {
								break;
							}
						}
						String 제목 = "";
						for (int s = 0; s < 인기글.get(j).getTitle().length(); s++) {
							제목 += 인기글.get(j).getTitle().charAt(s);
							if (s == 9) {
								break;
							}
						}
						System.out.println(String.format("%-15s", 제목)+ String.format("%-15s", 내용)
								+ 인기글.get(j).getIndex() + "\t\t" + 인기글.get(j).getGood());

					}
					if (j == 4) {
						break;
					}
				}

			}
			///////////////////////////////////////////////////

			System.out.println("-------------");
			System.out.println("|1.카테고리 선택|");
			System.out.println("-------------");
			System.out.println();
			System.out.println("--------");
			System.out.println("|2.놀이방|");
			System.out.println("--------");
			System.out.println();
			System.out.println("------------------");
			System.out.println("|3.쪽지 보내기|");
			System.out.println("------------------");
			System.out.println();
			System.out.println("-----------");
			System.out.println("|4.쪽지확인|");
			System.out.println("-----------");
			System.out.println();
			System.out.println("----------");
			System.out.println("|5.로그아웃|");
			System.out.println("----------");
			System.out.println();

			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.print("번호: ");
			int ch = scanner.nextInt();
			if (ch == 1) {
				카테고리메뉴(id);
			} else if (ch == 2) {
				놀이방메뉴(id);
			} else if (ch == 3) { // 쪽지 보내기
				System.out.println("받는 사람 id: ");
				String receiveid = scanner.next();
				scanner.nextLine();
				System.out.println("내용: ");
				String con = scanner.nextLine();

				boolean pass = Controller.쪽지보내기(receiveid, id, con);
				if (pass) {
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}
			} else if (ch == 4) { // 쪽지확인
				for (Acount temp : Controller.acountlist) {
					if (temp.getId().equals(id)) {
						for (쪽지클래스 temp2 : temp.get쪽지()) {
							System.out.println("--------------------------------------------");
							System.out.print("번호 : " + temp2.get번호() + "\t");
							System.out.print("보낸사람 : " + temp2.get받는사람() + "\t");
							System.out.print("받는사람 : " + temp2.get보낸사람() + "\n");
							System.out.print("내용 : " + temp2.get내용() + "\n");
							System.out.println("--------------------------------------------");
						}
					}
				}
			} else if (ch == 5) { // 로그아웃
				scanner = new Scanner(System.in);
				try {
					그림();
					메인메뉴();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("제시된 번호 입력 바람");
			}
		}
	}

	public static void 카테고리메뉴(String id) {
		for(int i = 0; i < Controller.카테고리.length; i++) {
			System.out.print(i+". "+Controller.카테고리[i]+" ");
		}
		int 카테고리선택 = scanner.nextInt();
		while (true) {
			System.out.println("*** " + Controller.카테고리[카테고리선택] + " ***");
			// 출력
			System.out.println("제목\t\t내용\t\t작성자\t번호");
			ArrayList<String> templist = new ArrayList<>();
			boolean block = true;
			for (Acount temp2 : Controller.acountlist) {
				for (차단유저 temp : Controller.차단유저list) {
					if (temp2.getId().equals(id) && temp.getIndex().equals(id)) {
						templist.add(temp.getTarget());
					}
				}
			}
			if (templist.isEmpty())// 차단유저가 비어있다면
				block = false; // 차단유저 여부 기본값은 true였던것
			if (block) {// 차단유저가있다면 출력

				for (Board temp : Controller.boardlist) {
					// 내용 최대 10글자까지 출력
					String 내용 = ""; 
					for (int s = 0; s < temp.getContent().length(); s++) {
						내용 += temp.getContent().charAt(s);
						if (s == 9) {
							break;
						} 
						
					}
					// 제목 최대 10글자까지 출력
					String 제목 = "";
					for (int s = 0; s < temp.getTitle().length(); s++) {
						제목 += temp.getTitle().charAt(s);
						if (s == 9) {
							break;
						}
						
					} 
					if (temp.getCategory().equals(Controller.카테고리[카테고리선택])) { // 카테고리 같은것만
						if (templist.contains(temp.getWriter())) {				   // 차단리스트와 작성가 같다면
							System.out.println("차단된 유저의 글");
						} else {
							System.out.println(String.format("%-15s", 제목 ) + "\t" + String.format("%-15s", 내용 ) + "\t" + temp.getWriter()
									+ "\t" + temp.getIndex());
						}
					}

				}

			} else { // 차단유저가 없으면
				for (Board temp : Controller.boardlist) {
					String 내용 = "";
					for (int s = 0; s < temp.getContent().length(); s++) {
						내용 += temp.getContent().charAt(s);
						if (s == 9) {
							break;
						}
						
					}
					String 제목 = "";
					for (int s = 0; s < temp.getTitle().length(); s++) {
						제목 += temp.getTitle().charAt(s);
						if (s == 9) {
							break;
						}
						
					}
					if (temp.getCategory().equals(Controller.카테고리[카테고리선택])) {
						System.out.println(String.format("%-15s", 제목 ) + "\t" + String.format("%-15s", 내용 ) + "\t" + temp.getWriter()
						+ "\t" + temp.getIndex());
					}
				}
			}

			templist.clear();
			System.out.println("------------"); // 구분선
			try {
				카테고리보기(id, 카테고리선택);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // while end

	} // 카테고리 선택 end

	public static void 그림() {
		System.out.println(
				" -------------------------------------------------------------------------------------------        ");
		System.out.println(
				"/                 *          *          *        **********      ***********               |        ");
		System.out.println(
				"|                *          *          *         *                    *                    |        ");
		System.out.println(
				"|               *          *          *          *                    *                    |        ");
		System.out.println(
				"|              *          *          *           **********           *        6 6 6       |        ");
		System.out.println(
				"|             * * *      * * *      * * *        *                    *                    |        ");
		System.out.println(
				"|             *     *    *     *    *     *      *                    *       엔터테인먼트     |        ");
		System.out.println(
				"|             *     *    *     *    *     *      *                    *                    |        ");
		System.out.println(
				"|               * *        * *        * *        **********           *        커뮤니티      /         ");
		System.out.println(
				"-------------------------------------------------------------------------------------------          ");
		System.out.println("\\    /\\          \\    /\\          \\    /\\");
		System.out.println(" )  ( ')          )  ( ')          )  ( ')");
		System.out.println("(  /  )          (  /  )          (  /  )");
		System.out.println(" \\(__)|           \\(__)|           \\(__)|");

	}

	public static void 메인메뉴() throws IOException {
		while (true) {
			System.out.println("---------");
			System.out.println("|1.회원가입|");
			System.out.println("---------");
			System.out.println("");

			System.out.println("--------");
			System.out.println("|2.로그인|");
			System.out.println("--------");
			System.out.println("");

			System.out.println("------------");
			System.out.println("|3.아이디 찾기|");
			System.out.println("------------");
			System.out.println("");

			System.out.println("-------------");
			System.out.println("|4.비밀번호 찾기|");
			System.out.println("-------------");

			System.out.println("원하시는 메뉴의 번호를 입력하세요,,,,,,,,,,,@@@,,");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.print("번호 : ");
			int ch = scanner.nextInt();
			if (ch == 1) {
				회원가입();
			} // 회원가입
			else if (ch == 2) {
				로그인();
			} // 로그인
			else if (ch == 3) {
				아이디찾기();
			} // 아이디 찾기
			else if (ch == 4) {
				비밀번호찾기();
			} // 비밀번호 찾기 메소드
			else {
				System.out.println("제시된 번호 입력 바람");
			}
		}

	}

	public static void 회원가입() throws IOException {
		System.out.println("----------------회원가입 페이지----------------");
		System.out.println("(아이디는 1~6글자만 가능하며, 한글,공백,특수문자는 사용할 수 없습니다.)");
		scanner.nextLine();
		System.out.print("아이디 입력 : ");
		String id = scanner.nextLine();
		int idresult = Controller.회원가입아이디(id);
		if (idresult == 1)
			System.out.println("아이디에 한글,공백,특수문자는 들어갈 수 없습니다.");
		else if (idresult == 2)
			System.out.println("아이디의 길이는 1~6글자만 가능합니다.");
		else if (idresult == 3)
			System.out.println("중복된 아이디입니다.");
		else if (idresult == 4) {
			System.out.println("(비밀번호는 4~12글자만 가능합니다.)");
			System.out.print("비밀번호 입력 : ");
			String pw = scanner.nextLine();
			System.out.print("비밀번호 확인 : ");
			String pwcheck = scanner.nextLine();
			int pwresult = Controller.회원가입비밀번호(pw, pwcheck);
			if (pwresult == 1)
				System.out.println("비밀번호에 공백은 포함될 수 없습니다.");
			else if (pwresult == 2)
				System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			else if (pwresult == 3) {
				System.out.print("이름 입력 : ");
				String name = scanner.next();
				System.out.print("이메일 입력 : ");
				String email = scanner.next();
				System.out.print("전화번호 입력 : ");
				String phone = scanner.next();
				boolean result = Controller.회원가입(id, pw, pwcheck, name, email, phone);

				if (result)
					System.out.println("회원가입에 성공하였습니다.");
				else
					System.out.println("해당 전화번호로 더이상 가입이 불가능합니다.");
			}
			else if(pwresult==4) {
				System.out.println("비밀번호의 길이는 4~12글자만 가능합니다.");
			}
		}

	}

	public static void 로그인() throws IOException {

		String id = null;
		String pw = null;
		System.out.print("아이디 입력 : ");
		id = scanner.next();
		System.out.print("비밀번호 입력 : ");
		pw = scanner.next();
		int result = Controller.로그인(id, pw);
		if (result == 1) {
			System.out.println(id + "님 환영합니다.");
			System.out.println();
			로그인메뉴(id);
		} else if (result == 2) {
			System.out.println("가입된 아이디가 없습니다.");
		} else if (result == 3) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}

	public static void 아이디찾기() {
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("전화번호 입력 : ");
		String phone = scanner.next();
		System.out.print("이메일 입력 : ");
		String email = scanner.next();
		String result = Controller.아이디찾기(name, phone, email);
		if (result.equals("1")) {
			System.out.println("일치하는 정보가 없습니다.");
		} else {
			System.out.println("회원님의 아이디는 \"" + result + "\" 입니다.");
		}
	}

	public static void 비밀번호찾기() {
		System.out.print("아이디 입력 : ");
		String id = scanner.next();
		System.out.print("전화번호 입력 : ");
		String phone = scanner.next();
		System.out.print("이메일 입력 : ");
		String email = scanner.next();

		String result = Controller.비밀번호찾기(id, phone, email);
		if (result.equals("1")) {
			System.out.println("일치하는 정보가 없습니다.");
		} else {
			System.out.println("회원님의 비밀번호는 \"" + result + "\" 입니다.");
		}
	}

	public static void 카테고리보기(String id, int 카테고리선택) throws IOException {
		System.out.println("1.글쓰기 2.글보기 3.검색 4.이전페이지 5.다음페이지 6.뒤로가기");
		int 행동선택 = scanner.nextInt();// 선택입력받기
		if (행동선택 == 1) {
			System.out.println("제목: ");
			String title = scanner.next(); // 제목 입력받기
			System.out.println("내용: ");
			String content = scanner.next();// 내용 입력받기
			boolean pass = Controller.글쓰기(id, title, content, Controller.카테고리[카테고리선택]);
			if (pass) { // 성공시
				System.out.println("글작성성공");
			} else { // 실패시
				System.out.println("글작성실패");
			}
		} else if (행동선택 == 2) { // 글보기
			글보기(id, 카테고리선택);
		} else if (행동선택 == 3) { // 검색
			System.out.println("제목 검색 : ");
			String serch = scanner.next();

			ArrayList<Board> result = Controller.검색(serch);

			System.out.println("---------------------검색 결과---------------------------");
			for (Board temp : result) {
				System.out.println(temp.getTitle() + "\t" + temp.getContent() + "\t" + temp.getIndex());
			}
			System.out.println("-------------------------------------------------------");

		} else if (행동선택 == 4) { // 이전페이지

		} else if (행동선택 == 5) { // 다음페이지

		} else if (행동선택 == 6) { // 뒤로가기
			로그인메뉴(id);
		} else {
			System.out.println("알수없는 행동");
		}
	}

	public static void 글보기(String id, int 카테고리선택) throws IOException {
		System.out.println("글번호입력: ");
		int index = scanner.nextInt();
		boolean pass = Controller.글상세보기(id, index);
		if (pass) { // 글찾기 성공시
			while (true) {
				for (Board temp : Controller.boardlist) {
					if (temp.getIndex() == index) {
						System.out.println("작성일: " + temp.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd | hh:mm")) + "\n");
						System.out.println(
								"번호: " + temp.getIndex() + " 제목: " + temp.getTitle() + " 카테고리: " + temp.getCategory() +"\n");
						System.out.println("내용: " + temp.getContent());
						System.out.println(
								"추천수: " + temp.getGood() + " 비추: " + temp.getBad() + " 신고수: " + temp.getReport());
						System.out.println("----댓글창-----------------------------------------------------------");

						if (temp.getReplylist() == null) {

						} else {
							int 인덱스 = 0;
							for (Reply temp2 : temp.getReplylist()) {
								System.out.println(인덱스 + " 내용: " + temp2.getContent());
								인덱스++;
							} // 댓글 출력 end
						} // 댓글 출력 if문 end
						break;
					}
				} // 출력 for문 end

				System.out.println("1.수정 2.삭제 3.댓글달기 4.댓글수정 5.댓글삭제 6.신고하기 7.뒤로가기 8.추천 9.비추");
				int 선택 = scanner.nextInt();
				////////////////////////////// 글 수정
				////////////////////////////// //////////////////////////////////////////////////
				if (선택 == 1) {
					boolean result = Controller.글수정아이디체크(id, index);
					if (result) {
						System.out.print("비밀번호 입력 : ");
						String pw = scanner.next();
						boolean result2 = Controller.글수정비밀번호체크(id, pw, index);
						if (result2) {
							System.out.print("수정할 제목 입력 : ");
							scanner.nextLine();
							String title = scanner.nextLine();
							System.out.print("수정할 내용 입력 : ");
							String content = scanner.nextLine();
							Controller.글수정(index, title, content);
							System.out.println("수정이 완료되었습니다.");
						}
					} else
						System.out.println("본인이 작성한 글만 수정이 가능합니다.");
					//////////////////////////////////// 글 삭제
					//////////////////////////////////// ////////////////////////////////////////
				} else if (선택 == 2) {
					boolean result = Controller.글수정아이디체크(id, index);
					if (result) {
						System.out.print("비밀번호 입력 : ");
						String pw = scanner.next();
						boolean result2 = Controller.글수정비밀번호체크(id, pw, index);
						if (result2) {
							Controller.글삭제(id, pw, index);
							System.out.println("삭제가 완료되었습니다.");
							break;
						} else
							System.out.println("비밀번호가 일치하지 않습니다.");

					} else
						System.out.println("본인이 작성한 글만 삭제가 가능합니다.");
					/////////////////////////////////// 댓글 달기
					/////////////////////////////////// /////////////////////////////////////////
				} else if (선택 == 3) {
					System.out.println("내용: ");
					scanner.nextLine();
					String con = scanner.nextLine();
					Controller.댓글작성(con, index, id);
					/////////////////////////////////// 댓글 수정
					/////////////////////////////////// ///////////////////////////////////////////
				} else if (선택 == 4) {
					System.out.println("수정할댓글인덱스: ");
					int 댓글인덱스 = scanner.nextInt();
					System.out.println("수정할내용: ");
					String 댓글수정 = scanner.next();
					boolean pass2 = Controller.댓글수정(index, 댓글인덱스, 댓글수정, id);
					if (pass2) {
						System.out.println("댓글수정 성공");
					} else {
						System.out.println("댓글수정 실패");
					}
					///////////////////////////////////// 댓글삭제//////////////////////////////////////////////////
				} else if (선택 == 5) {
					System.out.println("수정할댓글인덱스: ");
					int 댓글인덱스 = scanner.nextInt();
					boolean pass2 = Controller.댓글삭제(index, 댓글인덱스, id);
					if (pass2)
						System.out.println("댓글삭제 성공");
					else
						System.out.println("댓글삭제 실패");
				} else if (선택 == 6) { // 신고
					System.out.println("신고한 유저는 자동으로 차단됩니다. 정말 신고하시겠습니까?");
					System.out.println("1.신고하기 2.취소");
					int ch = scanner.nextInt();
					if (ch == 1) {
						boolean result = Controller.신고(id, index);
						if (result) {
							System.out.println("\t\t\t신고가 완료되었습니다.");
							카테고리보기(id, 카테고리선택);
						} else
							System.out.println("자신의 아이디는 신고가 불가능합니다.");

					} else if (ch == 2) {

					}

				} else if (선택 == 7) {
					break;
				} // 뒤로가기
				else if (선택 == 8) {
					Controller.추천비추(true, index, id);
				} else if (선택 == 9) {
					Controller.추천비추(false, index, id);
				} else
					System.out.println("알수없는 행동");
			} // while end

		} // 글찾기 성공 if 출력문 end
		else {// 찾기 실패시
			System.out.println("해당글을 찾지못했습니다");
		}
	}

	public static void 놀이방메뉴(String id) throws IOException {
		System.out.println("1.포인트복권 2.포인트랭킹 3. 보물찾기 4.뒤로가기");
		int ch = scanner.nextInt();
		if (ch == 1) { // 포인트복권
			String[] result = Controller.복권(id);
			if (result[0].equals("[ ]")) {
				System.out.println("\t\t\t보유 포인트가 부족해서 구매할 수 없습니다.");
			} else {
				System.out.print("\t\t\t");
				for (int i = 0; i < result.length; i++) {
					System.out.print(result[i]);
				}
				int result2 = Controller.복권결과(result, id);

				if (result2 == 1)
					System.out.println("\n1등 1000포인트 당첨");
				else if (result2 == 2)
					System.out.println("\n2등 300포인트 당첨");
				else if (result2 == 3)
					System.out.println("\n3등 100포인트 당첨");
				else if (result2 == 4)
					System.out.println("\n4등 10포인트 당첨");
				else if (result2 == 5)
					System.out.println("\n꽝");
			}
			놀이방메뉴(id);
		}

		else if (ch == 2) {
			ArrayList<Acount> ranking = Controller.포인트랭킹();
			int i = 1;
			System.out.println("등수\t아이디\t포인트");
			for (Acount temp : ranking) {
				System.out.println(i + "등\t" + temp.getId() + "\t" + temp.getPoint());
				if(i == 4) {
					break;
				}
				i++;
			}
			놀이방메뉴(id);

		} else if (ch == 3) {
			// 1.게임판 초기화
			while (true) { // 프로그램실행
				int 게임판인덱스 = 0;
				for (String temp : Controller.게임판) { // 전부 for 문돌려서
					if (temp != "[■]") {
						Controller.게임판[게임판인덱스] = "[■]";
					} // "[■]" 초기화
					게임판인덱스++; // 다음인덱스
				}
				System.out.println("보물 찾기 1번 3회 30원");
				System.out.println("1.뽑기 2.뒤로가기");
				int ch2 = scanner.nextInt(); // 선택입력받기
				if (ch2 == 1) {// 뽑기 시작
					boolean pass = true; // 돈 pass 체크
					for (Acount temp : Controller.acountlist) { // 회원돌려서
						if (temp.getId().equals(id)) { // id 일치하면
							if (temp.getPoint() < 30) { // 돈 체크
								System.out.println("돈부족");
								pass = false; // 실행실행 스위치 역활
							}
						}
					}
					if (pass) {// 돈이 있다면
						int 기회 = 3;
						int[] 등수 = Controller.보물찾기게임설정(); // 당첨번호 초기화
						for (int j = 0; j < 3; j++, 기회--) { // 3번 돌리기
							// 게임판 출력
							for (int i = 0; i < Controller.게임판.length; i++) {
								System.out.print(Controller.게임판[i]);
								if (i % 5 == 4) {
									System.out.println();
								} // 줄바꿈
							}
							System.out.println("남은기회: " + 기회 + " | 인덱스선택: ");
							int 선택 = scanner.nextInt(); // 인덱스받기
							boolean pass2 = false;
							if(선택 > 14) {
								while(true) {
									System.out.println("0~14까지만 다시입력"); 선택 = scanner.nextInt();
									if(선택>=0 && 선택 < 15) {
										break;
									}
								}
								
							}
							int 당첨여부 = Controller.보물찾기(선택, id, 등수); // 보물찾기 메소드 호출
							if (기회 == 0) {
								break;
							} // 게임끝기회가 끝나면
							if (당첨여부 == 1) {
								System.out.println("1등 당첨");
								Controller.회원파일처리(id);
							} else if (당첨여부 == 2) {
								System.out.println("2등 당첨");
								Controller.회원파일처리(id);
							} else if (당첨여부 == 3) {
								System.out.println("3등 당첨");
								Controller.회원파일처리(id);
							} else if (당첨여부 == -1) {
								System.out.println("꽝");
							}
						}
						// 게임판 출력
						for (int i = 0; i < Controller.게임판.length; i++) {
							System.out.print(Controller.게임판[i]);
							if (i % 5 == 4) {
								System.out.println();
							} // 줄바꿈
						}
						System.out.println("게임종료");
					} else {
						System.out.println("돈부족");
					}
				} else if (ch2 == 2) { // 뒤로가기
					break;
				} else {
					System.out.println("알수없는 선택");
				}
			}
		}

		else if (ch == 4) {
			로그인메뉴(id);
		} else {
			System.out.println("\t\t\t제시된 번호 입력 바람");
			놀이방메뉴(id);
		}

	}

}