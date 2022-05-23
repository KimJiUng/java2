<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Wishlist"%>
<%@page import="dto.Stock"%>
<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/jspweb/css/cart.css">
</head>
<body>

	<%@include file="../header.jsp" %>
	<%
	String cnumlist = request.getParameter("cartnum");
	int csize = Integer.parseInt(request.getParameter("csize"));
	ArrayList<Integer> cart_numlist = new ArrayList<>();
	for(int i=0; i<csize; i++){
		cart_numlist.add(Integer.parseInt(cnumlist.split(",")[i]));
	}
	float saverate = 1;
	int sumprice = 0;
	int sumsavemoney = 0;
	for(Integer temp : cart_numlist){
		Cart cart = ProductDao.productDao.getcart1(temp);
		Product product = ProductDao.productDao.getproduct(cart.getPnum());
		int price =(int)((product.getPprice()*(100-product.getPdiscount() ) )/100);
		int savemoney = (int)Math.ceil((price*saverate/100)/10)*10;
		int price2 = price *cart.getCart_selectamount();
		int savemoney2 = savemoney*cart.getCart_selectamount();
		sumprice += price2;
		sumsavemoney += savemoney2;
	}
	%>
	<input type="hidden" id="cnumlist" value="<%=cnumlist+"@@"+csize%>">
	<br><br><br><br><br>
	<%if(loginid==null) {%>
		<div class="container">
			로그인 이후 이용 가능
		</div>
	<%} else{ %>
		<%
		int mnum = MemberDao.memberDao.getmember(loginid).getMnum(); 
		DecimalFormat decimalFormat = new DecimalFormat("#,###원");
		int 배송비 = 2500;
		%>
		<div class="container">
			<h4 class="cart_title">결제창</h4>
			<div class="row">
				<div class="col-sm-8">	<!-- 제품 목록 -->
					<table class="table">
						<tr>
							<th>제품명</th>
							<th>상품정보</th>
							<th>수량</th>
							<th>판매가</th>
							<th>적립금</th>
						</tr>
					
					<%for(Integer cartnum : cart_numlist) {%>
						<%
						Cart cart = ProductDao.productDao.getcart1(cartnum);
						Product product = ProductDao.productDao.getproduct(cart.getPnum());
						Stock stock = ProductDao.productDao.getstock(cart.getSnum());
						int price =(int)(product.getPprice()*(100-product.getPdiscount() ) )/100;
						int savemoney = (int)Math.ceil((price*saverate/100)/10)*10;
						%>
						<tr>
							<td><%=product.getPname() %></td>
							<td>색상 : <%=stock.getScolor() %> / 사이즈 : <%=stock.getSsize() %></td>
							<td><%=cart.getCart_selectamount() %></td>
							<td><%=decimalFormat.format(price)  %></td>
							<td><%=decimalFormat.format(savemoney)  %></td>
						</tr>
					<%} %>
					</table>
					<div>	<!-- 받는 사람 정보 -->
						<input id="checkbox" type="checkbox"> <button style="border: none; background-color: white;" onclick="checkboxclick()" type="button">회원과 동일</button> 
						<h5>받는사람</h5>
						이름 <input id="ordername" type="text"><br>
						연락처 <input id="orderphone" type="text"><br>
						배송시 요청사항 <input id="orderrequest" type="text"><br>
						주소
						<div>
							<div class="row">
								<div class="col-md-6">
									<input class="form-control" type="text" id="sample4_postcode" placeholder="우편번호">
								</div>
								<div class="col-md-6">
									<input class="form-control" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
								</div>
							</div>
						</div>
						<div>
							<div class="row">
								<div class="col-md-6">
									<input class="form-control" type="text" id="sample4_roadAddress" placeholder="도로명주소">
								</div>
								<div class="col-md-6">
									<input class="form-control" type="text" id="sample4_jibunAddress" placeholder="지번주소">
									<span id="guide" style="color:#999;display:none"></span>
								</div>
							</div>
						</div>
						<div>
							<input class="form-control" type="text" id="sample4_detailAddress" placeholder="상세주소">
						</div>
						
					</div>
				</div>
				
				
				
				<div class="col-sm-4">	<!-- 결제 / 포인트 사용 -->
					<div class="paybox" style="border: 1px solid; padding: 20px;">
						<div>
							<%int mpoint = MemberDao.memberDao.getmember(loginid).getMpoint(); %>
							<span>* 5,000 포인트 이상부터 사용 가능합니다.</span><br>
							보유 포인트 <span id="mpoint"></span><button onclick="allpointbtn()">전체사용</button><br>
							포인트사용 <input id="pointinput"> <button onclick="pointbtn()">사용</button>
						</div>
						<div>	<!-- 결제 정보 -->
							<div>
								<input type="hidden" id="sum2" value="<%=sumprice%>">
								총 상품금액 : <span class="total" id="total2"><%=decimalFormat.format(sumprice)  %></span><br>
								총 적립금 : <span class="total" id="totalsavemoney2"><%=decimalFormat.format(sumsavemoney) %></span><br>
								배송비 : <span class="total" id="delievr2"></span><br>
								포인트사용 : <span id="pointbox"></span><br>
								총 결제금액 : <span class="total" id="totalprice"></span><br>
							</div>
							
							<div> 결제수단 : <span id="paymethod"></span><br>
								<button onclick="paymethod('samsung')">삼성페이</button>
								<button onclick="paymethod('card')">카드</button>
								<button onclick="paymethod('trans')">계좌이체</button>
								<button onclick="paymethod('vbank')">무통장입금</button>
								<button onclick="paymethod('phone')">휴대폰결제</button>
							</div>
							
							<div class="cart_selectbtn row d-flex justify-content-center">
								<div class="col-md-6">
									<a href="/jspweb/main.jsp"><button class="form-control">취소</button></a>
								</div>
								<div class="col-md-6">
									<button type="button" onclick="orderpay()" style="background-color: black; color: white;" class="form-control">결제하기</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			
			
	
			</div>
		</div>
	<%} %>
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/order.js" type="text/javascript"></script>
	
	<!-- 다음 주소 API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- iamport.payment.js -->
  	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</body>
</html>