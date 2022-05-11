
// 문서가 열렸을때 실행
$(document).ready(function(){
	
	$('#summernote').summernote({
        placeholder: '내용 입력',
        tabsize: 2,
        minHeight : 400, 	// 최소 높이
        maxHeight : null, 	// 최대 높이
        lang : 'ko-KR'		// 메뉴 한글 버젼
	});
	
});

function filedelete(bnum){
	
	// HTML 에서 JS 로 변수 이동
		// 1. 메소드 인수로 이동
		// 2. 태그의 value 혹은 html 이동
	
	$.ajax({
		url : "../board/Filedelete" ,	// 서블릿 통신
		data : {"bnum" : bnum},
		success : function(result){
			if(result==1){
				alert("첨부파일 삭제 성공");
				location.reload(); // 현재 페이지 새로고침
			}else{
				alert("첨부파일 삭제 실패[관리자에게 문의]");
			}
		}
		
	});
}

function replywrite(bnum){
	let rcontent = $("#rcontent").val();
	
	$.ajax({
		url : "Replywrite" ,
		data : {"bnum" : bnum , "rcontent" : rcontent} ,
		success : function(result){
			if(result==1){
				alert("댓글이 작성되었습니다.");
				$("#rcontent").val("");
				$("#replytable").load(location.href+" #replytable"); // 특정 태그 새로고침
			}
			else if(result==2){alert("댓글작성이 실패했습니다.");}
			else if(result==3){alert("댓글 내용을 입력해주세요.");}
			else if(result==4){alert("로그인해야 댓글 작성이 가능합니다.");}
			else if(result==5){alert("10초안에 새로운 댓글 작성은 불가능합니다.");}
			else if(result==6){alert("댓글에 스크립트 사용은 불가능합니다.");}
		}
	});
}

let a = false;
function rereplyview(rnum,bnum){
	if(a==false){
		$("#"+rnum).html(
			'<div class="row">'+
				'<div class="col-md-10">'+
					'<textarea class="form-control my-1" rows=3 type="text" id="rercontent"></textarea>'+
				'</div>'+
				'<div class="col-md-2">'+
					'<button class="form-control py-4 my-1" onclick="rereplywrite('+rnum+','+bnum+')">등록</button>'+
				'</div>'+
			'</div>'
		);
		a = true;	
	}else{
		$("#"+rnum).html("");
		a = false;
	}
	
}


function rereplywrite(rnum,bnum){
	
	let rercontent = $("#rercontent").val();
	$.ajax({
		url : "Rereplywrite" ,
		data : {"rnum" : rnum , "bnum" : bnum , "rercontent" : rercontent} ,
		success : function(result){
			if(result==1){
				alert("댓글이 작성되었습니다.");
				$("#rercontent").val("");
				$("#replytable").load(location.href+" #replytable"); // 특정 태그 새로고침 
			}
			else if(result==2){alert("댓글작성이 실패했습니다.");}
			else if(result==3){alert("댓글 내용을 입력해주세요.");}
			else if(result==4){alert("로그인해야 댓글 작성이 가능합니다.");}
			else if(result==5){alert("10초안에 새로운 댓글 작성은 불가능합니다.");}
			else if(result==6){alert("댓글에 스크립트 사용은 불가능합니다.");}
		}
	});
	
}

function replydelete(rnum,rindex){
	$.ajax({
		url : "Replydelete" ,
		data : {"rnum" : rnum , "rindex" : rindex} ,
		success : function(result){
			if(result==1){
				alert("댓글이 삭제되었습니다.");
				$("#replytable").load(location.href+" #replytable"); // 특정 태그 새로고침 
			}else{
				alert("댓글삭제를 실패했습니다.[관리자에게 문의]");
			}
		}
	});
}

function replyupdateview(rnum){
	if(a==false){
		$("#"+rnum).html(
			'<div class="row">'+
				'<div class="col-md-10">'+
					'<textarea class="form-control my-1" rows=3 type="text" id="reupdatecontent"></textarea>'+
				'</div>'+
				'<div class="col-md-2">'+
					'<button class="form-control py-4 my-1" onclick="replyupdate('+rnum+')">수정</button>'+
				'</div>'+
			'</div>'
		);
		a = true;	
	}else{
		$("#"+rnum).html("");
		a = false;
	}
}

function replyupdate(rnum){
	let reupdatecontent = $("#reupdatecontent").val();
	$.ajax({
		url : "Replyupdate" ,
		data : {"rnum" : rnum , "reupdatecontent" : reupdatecontent} ,
		success : function(result){
			if(result==1){
				alert("댓글 수정이 완료되었습니다.");
				$("#reupdatecontent").val("");
				$("#replytable").load(location.href+" #replytable"); // 특정 태그 새로고침 
			}
			else if(result==2){alert("댓글수정이 실패했습니다.");}
			else if(result==3){alert("댓글 내용을 입력해주세요.");}
			else if(result==4){alert("로그인해야 댓글 작성이 가능합니다.");}
			else if(result==5){alert("10초안에 새로운 댓글 작성은 불가능합니다.");}
			else if(result==6){alert("댓글에 스크립트 사용은 불가능합니다.");}
		}
	});
}





