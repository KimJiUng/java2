function selectcolor(pnum){
	
	let color = $("#scolor"+pnum+" option:selected").val();
	$.ajax({
		url : "selectcolor",
		data : {"color" : color, "pnum" : pnum} ,
		success : function(result){
			$("#sizebox"+pnum).html(result);
		}
	});
}

function pnummove(pnum){
	$("#modalinput").val(pnum);
}

function selectsize(pnum){
	let size = $("#sizebox"+pnum).val();
	let color = $("#scolor"+pnum+" option:selected").val();
	$.ajax({
		url : "selectsize",
		data : {"size" : size, "pnum" : pnum, "color" : color} ,
		success : function(result){
			if(result.split(",")[0]=="a"){
				$("#samount"+pnum).html('재고 없음');
				$("#supdate"+pnum).html(result.split(",")[1]);
			}else{
				$("#samount"+pnum).html(result.split(",")[0]+'개');	
				$("#supdate"+pnum).html(result.split(",")[1]);
			}
			
		}
	});
	
	
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


function getproduct(pnum){
	let field = "update";
	$.ajax({
		url : "getproduct" ,
		data : {"field" : field, "pnum" : pnum} ,
		success : function(result){
			$("#productinfo").html(result);
		}
	});
}

function getstock(pnum){
	$("#supdatebox").css("display","none");
	$.ajax({
			url : "getstock",
			data : {"field" : 'update', "pnum" : pnum},
			success : function(result){
				$("#stocktable").html(result);
			}
		});
}

function showupdate(snum,scolor,ssize,samount){
	$("#supdatebox").css("display","block");
	$("#snum").val(snum);
	$("#scolor").val(scolor);
	$("#ssize").val(ssize);
	$("#samount").val(samount);
}

function stockupdate(){
	let samount = $("#samount").val();
	let snum = $("#snum").val();
	let scolor = $("#scolor").val();
	let ssize = $("#ssize").val();
	$.ajax({
		url : "stockupdate",
		data : {"snum" : snum , "samount" : samount, "scolor" : scolor, "ssize" : ssize},
		success : function(result){
			if(result==1){
				$("#modalclosebtn3").click();
				$("mainbox").load("productlist.jsp");
			}else{
				alert("재고변경실패");
			}
		}
	});
}

function deletecheck(pnum){
	$("#modalinput").val(pnum);
	$.ajax({
		url : "stockcheck",
		data : {"pnum" : pnum},
		success : function(result){
			$("#deletetable").html(result);	
		}
	})
}

function deleteproduct(){
	let pnum = $("#modalinput").val();
	$.ajax({
		url : "productdelete",
		data : {"pnum" : pnum},
		success : function(result){
			if(result==1){
				alert("삭제가 완료되었습니다.");
				$("#modalclosebtn4").click();
				$("mainbox").load("productlist.jsp");
			}else{
				alert("삭제실패");
			}
		}
	});
}