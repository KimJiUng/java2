
let ordernumshowtable = [];
let orderlist;

$(function(){
	$.ajax({
		url : "getorder",
		success : function(result){
			//$("#ordertable").html(result);
			orderlist = result;
			console.log(result);
			view()
		}
	});
	
});

let viewcount =5;
$(window).scroll(function(){
	
	// 만약에 스크롤이 바닥에 닿았을때 계산
		// $(window).scroll : 브라우저(인터넷창) 스크롤
		// $(window).scrollTop() : 스크롤 막대의 상단 위치
		// $(document).height() : 현재 보고있는 문서내 높이
		// $(window).height() : 브라우저(인터넷창) 높이
	
	
	if(orderlist.length == viewcount){
		
	}else{
		if($(window).scrollTop() >= $(document).height() - $(window).height() ){
			// 스크롤의 높이 == 현재 보고있는 문서내 높이 - 현재 보고있는 화면의 높이
			viewcount++;
			view();
		}
	}
});

function view(){
	let html ="" ;
		
		for(let i=0; i<orderlist.length; i++){
			if(i==viewcount) break;
			if(ordernumshowtable.includes(i)){
				html += '<tr class="margintable"><td colspan="8"></td></tr>';
				html += '<tr class="margintable"><td colspan="8"></td></tr>';
				html += '<tr class="margintable"><td colspan="8"></td></tr>';
				html += '<tr class="ordernumtable"><td colspan="8">주문번호 : '+orderlist[i][0]["ordernum"]+'　　　주문일 : '+orderlist[i][0]["orderdate"]+'　　　총 주문금액 : '+orderlist[i][0]["ordertotalpay"].toLocaleString('ko-KR')+"원"+'<button style="background-color: white; border: none;" onclick="showdetail('+i+')">　　　상세보기▲</button></td></tr>';
				html += '<tr class="margintable1"><td class="blanktable"></td><td colspan="6"></td><td class="blanktable"></td></tr>';			
				html += '<tr class="tablecontent"><th class="blanktable" width="5%;"></th><th width="15%";>상품이미지</th><th width="20%;">상품정보</th><th width="15%;">판매가</th><th width="10%">수량</th><th width="15%">배송상태</th><th width="15%;">비고</th><th class="blanktable" width="5%;"></th></tr>';
				
				for(let j=0; j<orderlist[i].length; j++){
					let button = "교환,반품신청";
					let active = orderlist[i][j]["orderdetailactive"];
					if(active==0){active = "상품준비중";button = "취소하기"}
					else if(active==1){active = "배송중";}
					else if(active==2){active = "배송완료";}
					else if(active==3){active = "구매확정";}
					else if(active==4){active = "취소요청";}
					else if(active==5){active = "취소완료";}
					else if(active==6){active = "반품요청";}
					else if(active==7){active = "반품완료";}
					else if(active==8){active = "환불요청";}
					else if(active==9){active = "환불완료";}
					let price =(parseInt(orderlist[i][j]["pprice"])*(100-orderlist[i][j]["pdiscount"] ) )/100;
					if(orderlist[i][j]["orderdetailactive"]<3){
						html += '<tr class="tablecontent"><td class="blanktable"></td><td><img width="100%;" src="../admin/productimg/'+orderlist[i][j]["pimg"]+'"</td><td class="align-middle">'+orderlist[i][j]["pname"]+'<br><span class="colorsize"> -색상 : '+orderlist[i][j]["scolor"]+' 사이즈 : '+orderlist[i][j]["ssize"]+'</span></td><td class="align-middle">'+price.toLocaleString('ko-KR')+"원"+'</td><td class="align-middle">'+orderlist[i][j]["samount"]+'</td>'
							+'<td class="align-middle">'+active+'</td>'
							+'<td class="align-middle"><button class="form-control">배송조회</button><button id="activebutton'+orderlist[i][j]["orderdetailnum"]+'" class="form-control" data-bs-toggle="modal" data-bs-target="#cancelmodal" onclick="cancelbtn('+orderlist[i][j]["orderdetailnum"]+','+orderlist[i][j]["orderdetailactive"]+')">'+button+'</button><button class="form-control">리뷰작성</button></td><td class="blanktable"></td></tr>';
					}else if(orderlist[i][j]["orderdetailactive"]==3){
						html += '<tr class="tablecontent"><td class="blanktable"></td><td><img width="100%;" src="../admin/productimg/'+orderlist[i][j]["pimg"]+'"</td><td class="align-middle">'+orderlist[i][j]["pname"]+'<br><span class="colorsize"> -색상 : '+orderlist[i][j]["scolor"]+' 사이즈 : '+orderlist[i][j]["ssize"]+'</span></td><td class="align-middle">'+price.toLocaleString('ko-KR')+"원"+'</td><td class="align-middle">'+orderlist[i][j]["samount"]+'</td>'
							+'<td class="align-middle">'+active+'</td>'
							+'<td class="align-middle"><button class="form-control">배송조회</button><button style="display: none;" id="activebutton'+orderlist[i][j]["orderdetailnum"]+'" class="form-control" data-bs-toggle="modal" data-bs-target="#cancelmodal" onclick="cancelbtn('+orderlist[i][j]["orderdetailnum"]+','+orderlist[i][j]["orderdetailactive"]+')">'+button+'</button><button class="form-control">리뷰작성</button></td><td class="blanktable"><button class="form-control">구매확정</button></td></tr>';
					}else{
						html += '<tr class="tablecontent"><td class="blanktable"></td><td><img width="100%;" src="../admin/productimg/'+orderlist[i][j]["pimg"]+'"</td><td class="align-middle">'+orderlist[i][j]["pname"]+'<br><span class="colorsize"> -색상 : '+orderlist[i][j]["scolor"]+' 사이즈 : '+orderlist[i][j]["ssize"]+'</span></td><td class="align-middle">'+price.toLocaleString('ko-KR')+"원"+'</td><td class="align-middle">'+orderlist[i][j]["samount"]+'</td>'
							+'<td class="align-middle">'+active+'</td>'
							+'<td class="align-middle"><button class="form-control">배송조회</button><button style="display: none;" id="activebutton'+orderlist[i][j]["orderdetailnum"]+'" class="form-control" data-bs-toggle="modal" data-bs-target="#cancelmodal" onclick="cancelbtn('+orderlist[i][j]["orderdetailnum"]+','+orderlist[i][j]["orderdetailactive"]+')">'+button+'</button><button class="form-control">리뷰작성</button></td><td class="blanktable"></td></tr>';
					}

				}
				html += '<tr class="margintable2"><td colspan="8"></td></tr>';
				
			}else{
				html += '<tr class="margintable"><td colspan="8"></td></tr>';
				html += '<tr class="margintable"><td colspan="8"></td></tr>';
				html += '<tr class="margintable"><td colspan="8"></td></tr>';
				html += '<tr class="ordernumtable"><td colspan="8">주문번호 : '+orderlist[i][0]["ordernum"]+'　　　주문일 : '+orderlist[i][0]["orderdate"]+'　　　총 주문금액 : '+orderlist[i][0]["ordertotalpay"].toLocaleString('ko-KR')+"원"+'<button style="background-color: white; border: none;" onclick="showdetail('+i+')">　　　상세보기▼</button></td></tr>';
			}
			

		
			
		
		}
		
	$("#ordertable").html(html);
}

function showdetail(i){
	if(ordernumshowtable.includes(i)){
		for(let a = 0; a < ordernumshowtable.length; a++) {
			if(ordernumshowtable[a] == i)  {
			ordernumshowtable.splice(a, 1);
			a--;
		 }
	}
	}else{
		ordernumshowtable.push(i);	
	}
	
	view();
}

let orderdetailnum = -1;
let orderdetailactive = -1;
function cancelbtn(odnum,active){
	orderdetailnum = odnum;
	orderdetailactive = active
}

function cancel(){
		
	$.ajax({
		url : "ordercancel",
		data : {"orderdetailnum" : orderdetailnum, "orderdetailactive" : 4},
		success : function(result){
			if(result==1){
				alert("취소 요청 성공");
			}else{
				alert("취소 요청 실패");
			}
			location.reload();
		}
	})

	$("#modalclosebtn").click();
}
