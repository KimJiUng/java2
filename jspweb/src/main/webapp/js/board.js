
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



