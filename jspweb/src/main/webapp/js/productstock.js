

// 특정 select에 DB 데이터 넣기

$(function getcategory(){
	
	$.ajax({
		url : "getcategory",
		success : function(result){
			$("#categorybox").html(result);		
		}
	});
	
	
});

// 카테고리목록 select 값이 변경될때마다
$("#categorybox").change(function(){
	let cg_num = $("#categorybox").val();
	$.ajax({
		url : "getproduct",
		data : {"cg_num" : cg_num},
		success : function(result){
			if(result==""){
				$("#productbox").html(
					"<option>제품 없음</option>"
				);	
			}else{
				$("#productbox").html(result);	
			}
				
		}
	});
});

$("#productbox").change(function(){
	let pnum = $("#productbox").val();
	if(pnum==0){
		$("#stockbox").css("display", "none");
	}else{
		$("#stockbox").css("display", "block");
		$.ajax({
			url : "getstock",
			data : {"pnum" : pnum},
			success : function(result){
				$("#stocktable").html(result);
			}
		});
	}
	
});

// 재고 추가
function stockadd(){
	let pnum = $("#productbox").val();
	let scolor = $("#scolor").val();
	let ssize = $("#ssize").val();
	let samount = $("#samount").val();
	
	$.ajax({
		url : "stockadd" ,
		data : {"pnum" : pnum, "scolor" : scolor , "ssize" : ssize, "samount" : samount},
		success : function(result){
			if(result==1){
				alert("재고등록 성공");
				$("#mainbox").load("productstock.jsp");
			}else if(result==2){
				alert("이미 동일한 색상과 사이즈가 존재합니다.");
			}else{
				alert("재고등록 실패");
			}
		}
	});	
}

function stockdelete(snum){
	
	$.ajax({
		url : "stockdelete" ,
		data : {"field" : 'stockdelete' , "pnum" : pnum} ,
		success : function(result){
			$("#deletecheck").html(result);
		}
	});
}