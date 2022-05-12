let a=false;
function categorybtn(){
	if(a==false){
		$("#categoryinput").html(
		'<input type="text" id="categoryname">'+
		'<button onclick="categoryadd()" type="button">등록</button>'
		);
		a=true;
	}else{
		a=false;
		$("#categoryinput").html("");
	}
	
}


function categoryadd(){
	let cg_name = $("#categoryname").val();
	let cg_namej = /^[a-zA-Z0-9가-힣]{1,15}$/;
	
	if(cg_namej.test(cg_name)){
		$.ajax({
			url : "categorycheck" ,
			data : {"cg_name" : cg_name} ,
			success : function(result){
				if(result==2){
					let categoryname = $("#categoryname").val();
					$.ajax({
						url : "categoryadd" ,
						data : {"categoryname" : categoryname},
						success : function(result){
							if(result==1){
								alert("카테고리 등록 성공");
								$.ajax({
									url : "getcategory",
									success : function(result){
										$("#categorybox").html(result);
									}
								})
								$("#categoryname").val("");
							}else{
								alert("카테고리 등록 실패");
							}
						}
					});
				}else{
					alert("중복된 이름입니다.");
				}
			}
		});
		
	}else{
		alert("1~15글자 한글,영어,숫자만 사용해주세요.");
	}
	
}

$(function getcategory(){
	$.ajax({
		url : "getcategory",
		success : function(result){
			$("#categorybox").html(result);
		}
	})
});


function productadd(){
	var form = $("#addform")[0];	// 폼 태그 id 호출 [0] 인덱스 호출
	var formData = new FormData(form); // js에서 지원하는 FormData 클래스를 이용한 form 태그 객체화
	
	$.ajax({
		url : "productadd",
		type : 'POST' , /* type : 1.GET(기본타입) 2.POST(첨부파일 사용시, 보안용 등) */
		data : formData ,
		contentType : false,	/* 전송시 문자열 타입 X */
		/* contentType 전송시 내용물 타입 : URL */
		/* 첨부파일 String 인코딩 X*/
		/* contentType : true : URL 인코딩 타입 문자열 O [기본타입]  */
		/* contentType : false : URL 인코딩 타입 문자열 X */
		processData : false,	/* 전송시 문자열 전송 X */
		/* html 에서 enctype="multipart/form-data" */
		/* ajax 에서 contentType : false , processData : false */
		success : function(result){
			if(result==1){
				alert("제품 등록 성공")
				form.reset();
			}else{
				alert("제품 등록 실패")
			}
		}
	});
}