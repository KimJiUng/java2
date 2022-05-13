function changeLangSelect(){
	
	let color = $("#scolor option:selected").val();
	let pnum = $("#pnumbox").val();
	$.ajax({
		url : "selectcolor",
		data : {"color" : color, "pnum" : pnum} ,
		success : function(result){
			$("#sizebox").html(result);
		}
	});
}

function pnummove(pnum){
	$("#modalinput").val(pnum);
}


function pactivechange(){
	let pnum = $("#modalinput").val();
	let pactive = $('input:radio[name="pactive"]:checked').val( ) ;
	$.ajax({
		url : "pactivechange",
		data : {"pnum" : pnum, "pactive" : pactive},
		success : function(result){
			if(result==1){
				$("#modalclosebtn").click();	// [특정버튼 강제클릭] 모달내 취소 버튼 클릭 이벤트
				$("#mainbox").load("productlist.jsp");	// 해당 div에 해당 페이지 로드
			}else{
				alert("상태변경 실패");
			}
		}
	});
}