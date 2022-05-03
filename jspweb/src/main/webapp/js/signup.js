

// jquery(제이쿼리) : js 프레임워크
	// $ : 제이쿼리
// $(function() { 실행문; }); : 문서 실행시 무조건 실행되는 함수
	// js식			id 불러오기 	.getElementById(id명)
	// jquery식		id 불러오기 	$("#id명")
		// keyup( ) : 해당 id에 키보드가 눌렸을때 [ 입력 되었을 때 ]


$(function(){ // 문서 열리면 해당코드가 실행
	
	$("#mid").keyup(function(){
		
	// 1. HTML 태그내 값 가져오기
	let mid = document.getElementById("mid").value;
	// 2. HTML 태그내 데이터 넣기
	let idcheck = document.getElementById("idcheck");
	
	// 정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
	let idj = /^[a-zA-Z0-9]{5,15}$/;	// 한글,특수문자 제외한 5~15 사이 문자열
		// /^ : 정규표현식 시작
		// $/ : 정규표현식 끝
		// [a-z] : 소문자 찾음
		// [A-Z] : 대문자 찾음
		// [0-9] : 숫자 찾음
		// {최소길이, 최대길이} : 문자길이를 최소길이~최대길이까지만 입력
			// 정규표현식.test(변수) : 해당 변수가 정규표현식에 동일하면 true 다르면 false
	if(idj.test(mid)){ // 정규표현식과 같으면
		
		// 아이디 중복체크
			// 비동기식 통신 [ 목적 : 페이지 전환 없이 java(Controller) 통신 ]
		// $.ajax({ 속성 = 속성값, 속성 = 속성값  });	// jquery에서 제공해주는 메소드
		$.ajax({
			url : "../Idcheck" ,	// 통신할 경로 (서블릿파일과 통신)
			data : {"mid" : mid } ,			// 통신할때 보내는 데이터
			success : function(result){	// 통신 성공후 받는 데이터
				if(result.charAt(0)==1){
					idcheck.innerHTML = "이미 사용중인 아이디입니다."
				}else{
					idcheck.innerHTML = "사용 가능한 아이디입니다."
					
				}
			}
		}); // ajax end
		
	}else{
		idcheck.innerHTML = "영문,숫자 포함 5~15길이로 입력해주세요."
	}	
	});
	
	let epass = false;
	
	// 이메일 체크
	$("#memail").keyup(function(){
		let memail = $("#memail").val();
		//let emailj =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		let emailj =  /^[0-9a-zA-Z]{3,20}$/;
		if(epass==false){
			$("#emailcheck").html("이메일 주소를 입력해주세요.");
		}else{
			if(emailj.test(memail)){
			let email = $("#memail").val()+"@"+$("#memailaddress").val();
				$.ajax({
					url : "../Emailcheck" ,	// 통신할 경로 (서블릿파일과 통신)
					data : {"email" : email } ,			// 통신할때 보내는 데이터
					success : function(result){	// 통신 성공후 받는 데이터
						if(result.charAt(0)==1){
							emailcheck.innerHTML = "이미 사용중인 이메일입니다.."
						}else{
							emailcheck.innerHTML = "사용 가능한 이메일입니다."
						}
					}
				}); // ajax end
			}else{
				$("#emailcheck").html("이메일 형식이 올바르지 않습니다.");
			}
		}	
	});

	// 이메일 목록상자 선택시
	$("#emailselect").change(function(){	// 목록상자내 값이 변경 되었을때
		let emailselect = $("#emailselect").val();
		if(emailselect == ""){
			$("#memailaddress").val("");
			$("#memailaddress").attr("readonly", false);
			$("#emailcheck").html("이메일 형식이 올바르지 않습니다.");
			// 이메일 체크
			$("#memailaddress").keyup(function(){
				let memailaddress = $("#memailaddress").val();
				let memailaddressj =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				if(memailaddressj.test(memailaddress)){
					epass = true;
					let email = $("#memail").val()+"@"+$("#memailaddress").val();
					$.ajax({
						url : "../Emailcheck" ,	// 통신할 경로 (서블릿파일과 통신)
						data : {"email" : email } ,			// 통신할때 보내는 데이터
						success : function(result){	// 통신 성공후 받는 데이터
							if(result.charAt(0)==1){
								emailcheck.innerHTML = "이미 사용중인 이메일입니다.."
							}else{
								emailcheck.innerHTML = "사용 가능한 이메일입니다."
							}
						}
					}); // ajax end
				}else{
					$("#emailcheck").html("이메일 형식이 올바르지 않습니다.");
					epass = false;
				}
			});
		}else{
			$("#memailaddress").val(emailselect);
			$("#memailaddress").attr("readonly", true);
			epass = true;
			let email = $("#memail").val()+"@"+$("#memailaddress").val();
			$.ajax({
				url : "../Emailcheck" ,	// 통신할 경로 (서블릿파일과 통신)
				data : {"email" : email } ,			// 통신할때 보내는 데이터
				success : function(result){	// 통신 성공후 받는 데이터
					if(result.charAt(0)==1){
						emailcheck.innerHTML = "이미 사용중인 이메일입니다.."
					}else{
						emailcheck.innerHTML = "사용 가능한 이메일입니다."
					}
				}
			}); // ajax end
		}
		
	});
	
	
	
	// 주소 체크
	$("#sample4_detailAddress").keyup(function(){
		
		let address1 = $("#sample4_postcode").val();
		let address2 = $("#sample4_roadAddress").val();
		let address3 = $("#sample4_jibunAddress").val();
		let address4 = $("#sample4_detailAddress").val();
		
		if(address1 == "" || address2 == "" || address3 == "" || address4 == ""){
			$("#addresscheck").html("모든 주소를 입력해주세요.");
		}else{
			$("#addresscheck").html("사용 가능한 주소입니다.");
		}
	});
	
	
	// 비밀번호 체크 
	$("#mpassword").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpassword = $("#mpassword").val();  // jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val();
		
		let passswordj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		
		if( passswordj.test( mpassword ) ){ // 정규표현식 같으면
			if( mpassword != mpasswordcheck ){ // 비밀번호 와 비밀번호체크 와 다르면
				// equals(x)  //  != ( o )
			$("#passwordcheck").html("패스워드가 서로 다릅니다.");
			}else{
				$("#passwordcheck").html("사용 가능한 비밀번호 입니다.");
			}
		}else{ // 정규현식 다르면
			$("#passwordcheck").html("영소문자 5~15 사이로 입력해주세요!");
		}
	}); // keyup end 
	
	$("#mpasswordcheck").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpassword = $("#mpassword").val();  // jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val();
		
		let passswordj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		
		if( passswordj.test( mpassword ) ){ // 정규표현식 같으면
			if( mpassword != mpasswordcheck ){ // 비밀번호 와 비밀번호체크 와 다르면
				// equals(x)  //  != ( o )
			$("#passwordcheck").html("패스워드가 서로 다릅니다.");
			}else{
				$("#passwordcheck").html("사용 가능한 비밀번호 입니다.");
			}
		}else{ // 정규현식 다르면
			$("#passwordcheck").html("영소문자 5~15 사이로 입력해주세요!");
		}
	}); // keyup end 
	
	// 이름 체크
	$("#mname").keyup(function(){
		let mname = $("#mname").val();	// 해당 id의 데이터 가져오기
		let namej = /^[가-힣]{2,10}$/; // 한글만 2~10 정규표현식
		if(namej.test(mname)){
			$("#namecheck").html("사용 가능한 이름입니다.")
		}else{
			$("#namecheck").html("한글 2~10 사이만 가능합니다.")
		}
	}); // keyup end
	
	// 전화번호 체크
	$("#mphone").keyup(function(){
		let mphone = $("#mphone").val();
		let phonej = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/;
		if(phonej.test(mphone)){
			$("#phonecheck").html("사용가능한 전화번호입니다.")
		}else{
			$("#phonecheck").html("지역번호-0000-0000 형식으로 입력해주세요.")
		}
	});
	
	
	
	
}); // keyup end

// 다음 api js
  function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }




// js에서 폼 전송 방법
// document.getElementById("signup").submit

function signup(){
	let mid = document.getElementById("mid").value;
	let mpassword = $("#mpassword").val();
	let mname = $("#mname").val();
	let mphone = $("#mphone").val();
	let memail = $("#memail").val()+"@"+$("#memailaddress").val();
	let maddress = $("#sample4_roadAddress").val()+" "+$("#sample4_detailAddress").val();
	
	if(
		$("#idcheck").text() == "사용 가능한 아이디입니다." && 
		$("#passwordcheck").text() == "사용 가능한 비밀번호 입니다." &&
		$("#namecheck").text() == "사용 가능한 이름입니다." &&
		$("#emailcheck").text() == "사용 가능한 이메일입니다." &&
		$("#phonecheck").text() == "사용가능한 전화번호입니다." &&
		$("#addresscheck").text() == "사용 가능한 주소입니다."
	){
		$.ajax({
			url : "../Signup" ,	// 통신할 경로 (서블릿파일과 통신)
			data : {
				"mid" : mid, 
				"mpassword" : mpassword,
				"mname" : mname,
				"mphone" : mphone,
				"memail" : memail,
				"maddress" : maddress,
				} ,			// 통신할때 보내는 데이터
			success : function(result){	// 통신 성공후 받는 데이터
				if(result.charAt(0)==1){
					alert("회원가입이 완료되었습니다.")
					location.href = "/jspweb/main.jsp";
				}else{
					alert("회원가입 실패 관리자에게 문의")
				}
			}
		}); // ajax end
	}else{
		alert("빈칸을 모두 올바르게 채워주세요.")
	}
	
}