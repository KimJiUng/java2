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
	int sumprice = 0;
	for(Integer temp : cart_numlist){
		Cart cart = ProductDao.productDao.getcart1(temp);
		Product product = ProductDao.productDao.getproduct(cart.getPnum());
		int price =(int)((product.getPprice()*(100-product.getPdiscount() ) )/100);
		int price2 = price *cart.getCart_selectamount();
		sumprice += price2;
	}
	
	
	%>
	
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
			
			<table class="table my-3">
				<tr class="totalprint1">
					<td class="align-middle" colspan="3">총 상품금액</td>
					<td class="align-middle" colspan="2">총 배송비</td>
					<td class="align-middle" colspan="2">총 적립금</td>
					<td class="align-middle" colspan="3">결제 예정 금액</td>
				</tr>
				<tr class="totalprint2">
					<td class="align-middle" colspan="3">
						<span class="total" id="total2"><%=decimalFormat.format(sumprice)  %></span>
					</td>
					<td class="align-middle" colspan="2">
						<span class="total" id="delievr2"><%=decimalFormat.format(배송비)  %></span>
					</td>
					<td class="align-middle" colspan="2">
						<span class="total" id="totalsavemoney2"></span>
					</td>		
					<td class="align-middle" colspan="3">
						<input type="hidden" id="sum2" value="<%=sumprice+배송비%>">
						<span class="total" id="sum2"><%=decimalFormat.format(sumprice+배송비)  %></span>
					</td>
				</tr>
			</table>
			<br><br><br>
			<div class="cart_selectbtn row d-flex justify-content-center">
				<div class="col-md-2">
					<a href="/jspweb/main.jsp"><button class="form-control">취소</button></a>
				</div>
				<div class="col-md-2">
					<button type="button" onclick="orderpay()" style="background-color: black; color: white;" class="form-control">결제하기</button>
				</div>
			</div>
		</div>
	<%} %>
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/order.js" type="text/javascript"></script>
	
	<!-- iamport.payment.js -->
  	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</body>
</html>