
function login(){
	let mid = $("#mid").val();
	let mpassword = $("#mpassword").val();
	$.ajax({
		url : "../Login" ,	// 통신할 경로 (서블릿파일과 통신)
		data : {
			"mid" : mid, 
			"mpassword" : mpassword,
			} ,			// 통신할때 보내는 데이터
		success : function(result){	// 통신 성공후 받는 데이터
			if(result.charAt(0)==1){
				alert("로그인이 완료되었습니다.");
				sessionStorage.setItem("loginid",mid);
				location.href = "/jspweb/main.jsp";
			}else{
				$("#logincheck").html("아이디와 비밀번호가 일치하지 않습니다.")
			}
		}
	}); // ajax end
}