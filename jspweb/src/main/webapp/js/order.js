// 아임포트 API = 결제 API
function orderpay(){
	let sumprice = $("#sum2").val();
	alert(sumprice);
	var IMP = window.IMP; // 생략가능
	IMP.init("imp49612363");	// 가맹점 식별코드 [아임포트 관리자콘솔 -> 시스템설정 메뉴]
	IMP.request_pay({ // param
		pg: "html5_inicis",	// pg사 -> 결제 대행 회사
		pay_method: "card",	// 결제방식
		merchant_uid: "ORD20180131-0000011",	// 주문번호 [별도]
		name: "EZEN SHOP",	// 홈페이지 이름 [결제 이름]
		amount: sumprice ,		// 총 주문금액
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
			// 결제 실패 시 로직,
		}
	});
}
