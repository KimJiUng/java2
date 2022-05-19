<%@page import="java.text.DecimalFormat"%>
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
	<link rel="stylesheet" href="/jspweb/css/cart.css">
</head>
<body>

	<%@include file="../header.jsp" %>
	<br><br><br><br><br><br><br><br>
	<%if(loginid==null) {%>
		<div class="container">
			로그인 이후 이용 가능
		</div>
	<%} else{ %>
		<%
		int mnum = MemberDao.memberDao.getmember(loginid).getMnum(); 
		ArrayList<Wishlist> wlist = ProductDao.productDao.getwishlist(mnum);
		ArrayList<Cart> clist = ProductDao.productDao.getcart(mnum);
		DecimalFormat decimalFormat = new DecimalFormat("#,###원");
		int 배송비 = 2500;
		%>
		<div class="container">
			<h4>장바구니</h4>
			<table class="table">
				<tr>
					<th width="5%">체크박스</th>
					<th width="10%">이미지</th>
					<th width="25%">상품정보</th>
					<th width="9%">판매가</th>
					<th width="9%">적립금</th>
					<th width="8%">수량</th>
					<th width="8%">배송구분</th>
					<th width="8%">배송비</th>
					<th width="9%">합계</th>
					<th width="9%">선택</th>
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
						<td onclick="location.href='/jspweb/product/productview.jsp?pnum=<%=product.getPnum() %>'"><img alt="" src="../admin/productimg/<%=product.getPimg()%>"> </td>
						<td>
							<%=product.getPname() %><br>색상 : <%=stock.getScolor() %> / 사이즈 : <%=stock.getSsize() %><br>
							<button onclick="optionchange(<%=product.getPnum()%>,<%=cart.getCart_num() %>)" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#optionchangemodal">
								옵션변경
							</button> 
						</td>
						
						<td><%=decimalFormat.format(price) %></td>
						<td><%=decimalFormat.format(savemoney) %></td>
						<td>
							<div class="row g-0">
								<div class="col-md-7">
									<input style="background-color: white;" readonly="readonly" id="samount<%=stock.getSnum() %>" value="<%=cart.getCart_selectamount() %>" type="text" class="form-control fc amount_input" >
								</div>
								<div class="col-md-5">
									<button onclick="amountup(<%=stock.getSnum() %>,<%=price %>,<%=cart.getCart_num()%>)" class="amount_btn">▲</button>
									<button onclick="amountdown(<%=stock.getSnum() %>,<%=price %>,<%=cart.getCart_num()%>)" class="amount_btn">▼</button>
								</div>
							</div>
						</td>
						<td>기본배송</td>
						<td><input type="hidden" id="deleverpay" value="<%=배송비%>"> <%=decimalFormat.format(배송비)%><br>조건</td>
						<td><span id="totalprice"><%= decimalFormat.format(price*cart.getCart_selectamount()+배송비) %></span></td>
						<td class="cart_btn">
							<button class="form-control" >주문하기</button>
							<button class="form-control" onclick="movewishlist('<%=loginid%>',<%=cart.getCart_num()%>,<%=stock.getSnum()%>,<%=cart.getCart_selectamount()%>,<%=product.getPnum()%>)">관심상품등록</button>
							<button class="form-control" onclick="cartdelete(<%=cart.getCart_num()%>)">삭제하기</button> 
						</td>
					</tr>
					<%} %>
				<%} %>
			</table>
			<br><br><br><br><br><br><br>
			<h4>관심상품</h4>
			<table class="table wishlisttable">
				<tr>
					<th>체크박스</th>
					<th width="10%">이미지</th>
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
						<%Stock stock = ProductDao.productDao.getstock(temp.getSnum()); %>
						<%float saverate = 1;
						int price =(int)(product.getPprice()*(100-product.getPdiscount() ) )/100;
						int savemoney = (int)Math.ceil((price*saverate/100)/10)*10; %>
						<tr>
							<td>체크박스</td>
							<td onclick="location.href='/jspweb/product/productview.jsp?pnum=<%=temp.getPnum() %>'"><img alt="" src="../admin/productimg/<%=product.getPimg()%>" width="100px;"> </td>
							<td>
								<%if(temp.getWamount()==0) {%>
									<%=product.getPname() %>
								<%}else{ %>
									<%=product.getPname() %><br> 색상 : <%=stock.getScolor() %> / 사이즈 : <%=stock.getSsize() %> / 수량 : <%=temp.getWamount() %>개
								<%} %>
								<br>
								<button id="selectoption" onclick="optionselect(<%=product.getPnum()%>,<%=temp.getWnum() %>)" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#optionselectmodal">
									옵션변경
								</button> 
							</td>
							<td><%=price %></td>
							<td><%=savemoney %></td>
							<td>기본배송</td>
							<td><%=배송비 %>원<br>조건</td>
							<%if(temp.getWamount()==0) {%>
								<td><%=price+배송비 %>원</td>
							<%}else{ %>
								<td><%=price*temp.getWamount()+배송비 %>원</td>
							<%} %>
							<td>
								<button>주문하기</button>
								<button onclick="movecart(<%=temp.getWnum()%>,'<%=loginid%>',<%=temp.getPnum()%>,<%=temp.getSnum()%>,<%=temp.getWamount()%>)">장바구니담기</button>
								<button onclick="wishlistdelete(<%=temp.getWnum()%>)">삭제하기</button> 
							</td>
						</tr>
					<%} %>
			<%} %>
			</table>
		</div>
	<%} %>
	
	
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="optionchangemodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">옵션 변경</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body"> <!-- 모달 바디 -->
	         <input type="hidden" id="modalinput">
	         <input type="hidden" id="modalinputcnum">
	         <select id="scolor" class="form-select info_t" onchange="selectcolor()">
			</select> 
			<select id="ssize" class="form-select info_t">
				<option class="info_t">- [필수] 옵션 선택 -</option>
			</select> 
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="change()">옵션 변경</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="optionselectmodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">옵션 선택</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body"> <!-- 모달 바디 -->
	         <input type="hidden" id="modalinput2">
	         <input type="hidden" id="modalinput2wnum">
	         <select id="scolor2" class="form-select info_t" onchange="selectcolor2()">
			</select> 
			<select id="ssize2" class="form-select info_t">
				<option class="info_t">- [필수] 옵션 선택 -</option>
			</select> 
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="select(<%=loginid%>)">장바구니에 추가</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/cart.js" type="text/javascript"></script>

</body>
</html>