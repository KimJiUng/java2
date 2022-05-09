
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

