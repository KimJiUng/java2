


function selectcolor(pnum){
	let color = $("#scolor option:selected").val();
	$.ajax({
		url : "../admin/selectcolor",
		data : {"field" : 'productview', "color" : color, "pnum" : pnum} ,
		success : function(result){
			$("#sizebox").html(result);
		}
	});
}

function selectsize(pnum){
	let color = $("#scolor option:selected").val();
	let size = $("#sizebox").val().split(",")[0];
	let snum = $("#sizebox").val().split(",")[1];
	if($("#"+snum).val()==snum){
		alert("이미 선택한 상품입니다.");
	}else{
		$.ajax({
			url : "selectoption",
			data : {"pnum":pnum, "color":color, "size":size , "snum" : snum},
			success : function(result){
				$("#selectproduct").append(result.split("@@")[0]);
				선택한목록.push(result);
				
			}
		});		
	}
}


function amountup(snum){
	let samount = $("#samount"+snum).val()*1;
	$("#samount"+snum).val(samount+1);
	
}

function amountdown(snum){
	let samount = $("#samount"+snum).val()*1;
	if(samount<=1){
		alert("최소 구매수량은 1 입니다.");
		$("#samount"+snum).val(1);	
	}else{
		$("#samount"+snum).val(samount-1);	
	}
	
}
// js 배열
	// let 배열명 = [객체1, 객체2];
	// 추가 : push 	-> 배열내 마지막인덱스 뒤에 추가
	// 제거 : pop()  	-> 제일 끝에 있는 인덱스 제거
let 선택한목록 = []; 

function cancel(snum){
	for(let i=0; i<선택한목록.length; i++){
		if(선택한목록[i].split("@@")[1] == snum){
			선택한목록.splice(i, 1);
		}
	}
	$("#selectproduct").html(
		'<tr>'+
			'<td width="60%">상품명</td>'+
			'<td width="25%">상품수</td>'+
			'<td width="15%">가격</td>'+
		'</tr>'
	);
	for(let i=0; i<선택한목록.length; i++){
		$("#selectproduct").append(선택한목록[i].split("@@")[0]);
	}
}