
let pay_method;
function paymethod(method){
	$("#paymethod").html(method);
	pay_method = method;
}


// 아임포트 API = 결제 API
function orderpay(){
	pay();
	if(pay_method==null){
		alert("결제 수단을 선택해주세요.");
		return;
	}
	
	var IMP = window.IMP; // 생략가능
	IMP.init("imp49612363");	// 가맹점 식별코드 [아임포트 관리자콘솔 -> 시스템설정 메뉴]
	IMP.request_pay({ // param
		pg: "html5_inicis",	// pg사 -> 결제 대행 회사
		pay_method: pay_method,	// 결제방식
		merchant_uid: "ORD20180131-0000011",	// 주문번호 [별도]
		name: "EZEN SHOP",	// 홈페이지 이름 [결제 이름]
		amount: totalprice ,		// 총 주문금액
		buyer_email: "gildong@gmail.com",	// 주문하는 이메일
		buyer_name: "홍길동",					// 주문하는 이름
		buyer_tel: "010-4242-4242",			// 주문하는 전화번호
		buyer_addr: "서울특별시 강남구 신사동",		// 주문하는 주소
		buyer_postcode: "01181"				// 주문하는 주소
	},function (rsp) { // callback
		if (rsp.success) {
			// 결제 성공 시 로직,
		} else {
			alert("주문완료");
			saveorder();
			// 결제 실패 시 로직,
		}
	});
}


let member;	// 회원정보 json 객체
let mpoint; // 회원이 사용하는 포인트
let deliver;	// 배송비
let totalprice;	// 총 결제금액
let sumprice;	// 총 상품금액
// 받는사람 정보가 기존 회원과 동일 버튼 눌렀을때
$(document).ready(function(){
	// 문서내에서 대기상태 이벤트
	checkboxchange();
});


$(function(){
	$.ajax({
		url : "../member/getmember",
		success : function(json){
			member = json;
			$("#mpoint").html(member['mpoint']);
			pay();
		}
	});
	
	
})

function pay(){
	sumprice = $("#sum2").val();
	if(sumprice>70000){
		$("#delievr2").html("무료");
		deliver =0;
	}else{
		$("#delievr2").html("2,500원");
		deliver =2500;
	}
	
	if(mpoint==null){
		mpoint=0;
	}
	totalprice = parseInt(sumprice) + parseInt(deliver) - parseInt(mpoint);
	let totalpay = totalprice.toLocaleString('ko-KR')+"원";
	$("#totalprice").html(totalpay);
}

function checkboxchange(){
		$("#checkbox").change(function(){
		// 체크박스가 변경 되었을때
		// 만약에 체크박스가 체크 되어있으면
			if($("#checkbox").is(":checked") ){
				$("#ordername").val(member['mname']);
				$("#orderphone").val(member['mphone']);
				$("#sample4_postcode").val(member['maddress'].split("_")[0]);
				$("#sample4_roadAddress").val(member['maddress'].split("_")[1]);
				$("#sample4_jibunAddress").val(member['maddress'].split("_")[2]);
				$("#sample4_detailAddress").val(member['maddress'].split("_")[3]);
			}else{
				$("#ordername").val("");
				$("#orderphone").val("");
				$("#orderrequest").val("");
				$("#sample4_postcode").val("");
				$("#sample4_roadAddress").val("");
				$("#sample4_jibunAddress").val("");
				$("#sample4_detailAddress").val("");
			}
		});
	}

function checkboxclick(){
	if($("#checkbox").is(":checked") ){
		$("#checkbox").prop('checked',false);
		$("#ordername").val("");
		$("#orderphone").val("");
		$("#orderrequest").val("");
		$("#sample4_postcode").val("");
		$("#sample4_roadAddress").val("");
		$("#sample4_jibunAddress").val("");
		$("#sample4_detailAddress").val("");
	}else{
		$("#checkbox").prop('checked',true);
		$("#ordername").val(member['mname']);
		$("#orderphone").val(member['mphone']);
		$("#sample4_postcode").val(member['maddress'].split("_")[0]);
		$("#sample4_roadAddress").val(member['maddress'].split("_")[1]);
		$("#sample4_jibunAddress").val(member['maddress'].split("_")[2]);
		$("#sample4_detailAddress").val(member['maddress'].split("_")[3]);
	}
}

function pointbtn(){
	mpoint = $("#pointinput").val();
	if(mpoint<5000){
		alert("최소 5,000 포인트 이상 사용 가능합니다.");
		mpoint  = 0;
		return;
	}else if(mpoint>member['mpoint']){
		alert("보유 포인트가 부족합니다.");
		return;	
	}else{
		if(mpoint%100!=0){
			alert("포인트는 100포인트 단위로 사용이 가능합니다.");
		}else {
			let printpoint = mpoint.toLocaleString('ko-KR');
			$("#pointbox").html(printpoint);
			$("#mpoint").html(parseInt(member['mpoint'])-parseInt(mpoint));
			pay();
		}	
	} 
		
}


function allpointbtn(){
	mpoint = member['mpoint'];
	if(mpoint<5000){
		alert("최소 5,000 포인트 이상 사용 가능합니다.");
		mpoint  = 0;
		return;
	}
	else{
		let pointsum = parseInt(mpoint)-(parseInt(mpoint)%100);
		let printpoint = pointsum.toLocaleString('ko-KR');
		$("#mpoint").html((parseInt(mpoint)%100));
		$("#pointinput").val(printpoint);
		$("#pointbox").html(printpoint);
		mpoint = pointsum;
		pay();
	}
}


function saveorder(){
	let ordername = $("#ordername").val();
	let orderphone = $("#orderphone").val();
	let orderaddress = $("#sample4_postcode").val()+"_"+$("#sample4_roadAddress").val()+"_"+$("#sample4_jibunAddress").val()+"_"+$("#sample4_detailAddress").val();
	let ordertotalpay = totalprice;
	let orderrequest = $("#orderrequest").val();
	let cnumlist = $("#cnumlist").val();
	
	let orderjson = {
		ordername : ordername,
		orderphone : orderphone,
		orderaddress : orderaddress,
		ordertotalpay : ordertotalpay,
		orderrequest : orderrequest,
		cartnum_list : cnumlist,
		mpoint : mpoint
	}
	
	$.ajax({
		url : "saveorder",
		data : {'orderjson' : JSON.stringify(orderjson)},
		success : function(result){
			if(result==1){
				location.href = "/jspweb/product/ordersuccess.jsp";
			}else{
				alert("db처리 실패");
			}
		}
	});
}


// 다음 api js
  function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
