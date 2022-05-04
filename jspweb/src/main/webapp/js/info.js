
function passwordcheck(mid){
	
	// * 제이쿼리식
	let mpassword = $("#mpassword").val();
	// * 자바스크립트식
	// let mpassword = document.getElementById("mpassword").value;
	
	// 비동기 통신 = 제이쿼리에서 제공해주는 통신[js(view) --> java(controller)] 메소드
	
	// $.ajax({ 속성명 = 속성값, 속성명2 = 속성값2});
	
	$.ajax({
		url : "../Passwordcheck",
		data : {"mpassword" : mpassword, "mid" : mid},
		type : "POST", // HTTP 요청방식 정의 [get = 기본값, POST]
		success : function(result){
			if(result==1){
				$("#checkmsg").html("정말 탈퇴하시겠습니까?");
				$("#mpassword").css("display" , "none");	// 제이쿼리 css 적용 [ .css("속성명","속성값")]
				$("#btnconfirm").css("display" , "none");
				$("#btndelete").css("display" , "block");
			}else{
				$("#checkmsg").html("비밀번호가 틀렸습니다.");
			}
		}
	});
	
}

function mdelete(mid){
	
	$.ajax({
		url : "../Delete",
		data : {"mid" : mid} ,
		success : function(result){
			if(result==1){
				alert("회원탈퇴가 완료되었습니다.");
				location.href="/jspweb/Logout";
			}else{
				location.href="/jspweb/error.jsp";
			}
		}
	});
	
}

