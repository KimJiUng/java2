


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
				if(result==0){
					alert("해당 상품은 품절되었습니다.");
				}else{
					$("#selectproduct").append(result.split("@@")[0]);
					선택한목록.push(result);
					sumprice();
				}	
			}
		});		
	}
}

function sumprice(){
	let totalprice = 0;
	let totalselect = 0;
	let totalsavemoney = 0;
	for(let i=0; i<선택한목록.length; i++){
		let a = 선택한목록[i].split("@@")[1];
		let select = parseInt($("#samount"+a).val());
		totalselect += select;
		totalprice += parseInt(선택한목록[i].split("@@")[2])*parseInt(select);
		totalsavemoney += parseInt(선택한목록[i].split("@@")[3])*parseInt(select);
	}
	let tselect = totalselect.toLocaleString('ko-KR');
	let total = totalprice.toLocaleString('ko-KR')+"원 ("+tselect+"개)";
	let point = totalsavemoney.toLocaleString('ko-KR')+"원)";
	$("#total_price").html(total);
	$("#savemoney").html(
		'(<span id="savepoint">적</span>'+
		point
		);

}

function amountup(snum){
	let samount = $("#samount"+snum).val()*1;
	$.ajax({
		url : "getamount",
		data : {"snum" : snum},
		success : function(maxamount){
			if(parseInt(maxamount) <= parseInt($("#samount"+snum).val()) ){
				alert("해당 상품의 재고가 부족합니다.");
			}else{
				$("#samount"+snum).val(samount+1);
				sumprice();	
			}
		}
	});
}

function amountdown(snum){
	let samount = $("#samount"+snum).val()*1;
	if(samount<=1){
		alert("최소 구매수량은 1 입니다.");
		$("#samount"+snum).val(1);	
	}else{
		$("#samount"+snum).val(samount-1);	
	}
	sumprice();	
	
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
			sumprice();	
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

function cartadd(mid,pnum){
	if(mid==null){
		alert("로그인 후 등록 가능합니다.");
	}
	if(선택한목록.length==0){
		alert("옵션을 선택하신 후에 장바구니 추가 버튼을 클릭해주세요.");
	}else{
		for(let i=0; i<선택한목록.length; i++){
			let snum = 선택한목록[i].split("@@")[1];
			let samount = $("#samount"+snum).val();
			$.ajax({
				url : "cartadd",
				data : {"mid" : mid , "pnum" : pnum, "snum" : snum, "samount" :samount},
				success : function(result){
					if(result==1){
						$("#cartmodalclick").click();
					}
				}
			});
		}	
	}
}

function wishlistadd(mid,pnum){
	if(mid==null){
		alert("로그인 후 등록 가능합니다.");
	}
	if(선택한목록.length==0){
		$.ajax({
			url : "wishlistadd",
			data : {"field":'product', "mid" : mid , "pnum" : pnum},
			success : function(result){
				if(result==1){
					$("#modalclick").click();
				}
			}
		});
	}else{
		for(let i=0; i<선택한목록.length; i++){
			let snum = 선택한목록[i].split("@@")[1];
			let realprice = 선택한목록[i].split("@@")[2];
			let savemoney = 선택한목록[i].split("@@")[3];
			let samount = $("#samount"+snum).val();

			$.ajax({
				url : "wishlistadd",
				data : {"mid" : mid , "pnum" : pnum, "snum" : snum, "realprice" : realprice, "savemoney" : savemoney, "samount" :samount},
				success : function(result){
					if(result==1){
						$("#modalclick").click();
					}
				}
			});
		}
		
		
	}

}

function mywishlist(){
	location.href = "/jspweb/product/wishlist.jsp";
}


