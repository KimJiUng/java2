<%@page import="dto.Stock"%>
<%@page import="dto.Cart"%>
<%@page import="dto.Product"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Wishlist"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="../header.jsp" %>
	<br><br><br><br><br><br><br><br>
	<%
	int mnum = MemberDao.memberDao.getmember(loginid).getMnum(); 
	ArrayList<Wishlist> wlist = ProductDao.productDao.getwishlist(mnum);
	ArrayList<Cart> clist = ProductDao.productDao.getcart(mnum);
	int 배송비 = 2500;
	%>
	<div class="container">
		<h4>장바구니</h4>
		<table class="table">
			<tr>
				<th>체크박스</th>
				<th>이미지</th>
				<th>상품정보</th>
				<th>판매가</th>
				<th>적립금</th>
				<th>배송구분</th>
				<th>배송비</th>
				<th>합계</th>
				<th>선택</th>
			</tr>
			<%if(clist.isEmpty()) {%>
				<tr>
					<td colspan="9">장바구니에 등록된 상품이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(Cart cart : clist) { %>
					<%
					Product product = ProductDao.productDao.getproduct(cart.getPnum()); 
					Stock stock = ProductDao.productDao.getstock(cart.getSnum());
					float saverate = 1;
					int price =(int)(product.getPprice()*(100-product.getPdiscount() ) )/100;
					int savemoney = (int)Math.ceil((price*saverate/100)/10)*10;
					%>
				<tr>
					<td>체크박스</td>
					<td><img alt="" src="../admin/productimg/<%=product.getPimg()%>" width="100px;"> </td>
					<td><%=product.getPname() %><br>색상 : <%=stock.getScolor() %> / 사이즈 : <%=stock.getSsize() %> / 수량 : <%=cart.getCart_selectamount() %>개</td>
					<td><%=price %></td>
					<td><%=savemoney %></td>
					<td>기본배송</td>
					<td><%=배송비 %>원<br>조건</td>
					<td><%=price*cart.getCart_selectamount()+배송비 %>원</td>
					<td>
						<button>주문하기</button>
						<button onclick="movewishlist('<%=loginid%>',<%=cart.getCart_num()%>)">관심상품담기</button>
						<button onclick="cartdelete(<%=cart.getCart_num()%>)">삭제하기</button> 
					</td>
				</tr>
				<%} %>
			<%} %>
		</table>
	
		<h4>관심상품</h4>
		<table class="table wishlisttable">
			<tr>
				<th>체크박스</th>
				<th>이미지</th>
				<th>상품정보</th>
				<th>판매가</th>
				<th>적립금</th>
				<th>배송구분</th>
				<th>배송비</th>
				<th>합계</th>
				<th>선택</th>
			</tr>
			<%if(wlist.isEmpty()) {%>
				<tr>
					<td colspan="9">관심상품에 등록된 상품이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(Wishlist temp : wlist){ %>
					<%Product product = ProductDao.productDao.getproduct(temp.getPnum()); %>
					<tr>
						<td>체크박스</td>
						<td><img alt="" src="../admin/productimg/<%=product.getPimg()%>" width="100px;"> </td>
						<%if(temp.getWamount()==0) {%>
							<td><%=product.getPname() %></td>
						<%}else{ %>
							<td><%=product.getPname() %><br> 색상 : <%=temp.getWcolor() %> / 사이즈 : <%=temp.getWsize() %> / 수량 : <%=temp.getWamount() %>개</td>
						<%} %>
						<td><%=temp.getWrealprice() %></td>
						<td><%=temp.getWsavemoney() %></td>
						<td>기본배송</td>
						<td><%=배송비 %>원<br>조건</td>
						<%if(temp.getWamount()==0) {%>
							<td><%=temp.getWrealprice()+배송비 %>원</td>
						<%}else{ %>
							<td><%=temp.getWrealprice()*temp.getWamount()+배송비 %>원</td>
						<%} %>
						<td>
							<button>주문하기</button>
							<button>장바구니담기</button>
							<button onclick="wishlistdelete(<%=temp.getWnum()%>)">삭제하기</button> 
						</td>
					</tr>
				<%} %>
		<%} %>
		</table>
	</div>
	
	
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/cart.js" type="text/javascript"></script>

</body>
</html>