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
	<br><br><br><br><br>
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
			<h4 class="cart_title">장바구니</h4>
			<table class="table">
				<tr>
					<th style="text-align: center;" width="8%">전체선택<br><input class="form-check-input" type="checkbox" id="cartcheck" name="cartcheck" onclick="selectAll(this,<%=loginid%>)"> </th>
					<th width="10%">이미지</th>
					<th width="25%">상품정보</th>
					<th width="9%">판매가</th>
					<th width="9%">적립금</th>
					<th width="7%">수량</th>
					<th width="7%">배송구분</th>
					<th width="7%">배송비</th>
					<th width="9%">합계</th>
					<th width="9%">선택</th>
				</tr>
				<%if(clist.isEmpty()) {%>
					<tr>
						<td colspan="10">장바구니에 등록된 상품이 없습니다.</td>
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
						<td style="text-align: center;" class="align-middle">
							<input class="form-check-input" id="cartcheck" type="checkbox" name="cartcheck" value="<%=cart.getCart_num()%>" onclick="check(this,'<%=cart.getCart_num()%>')">
						</td>
						<td onclick="location.href='/jspweb/product/productview.jsp?pnum=<%=product.getPnum() %>'"><img alt="" src="../admin/productimg/<%=product.getPimg()%>"> </td>
						<td class="align-middle">
							<%=product.getPname() %><br><span class="sizecolor">- 색상 : <%=stock.getScolor() %> / 사이즈 : <%=stock.getSsize() %></span><br>
							<button style="font-size: 13px; padding: 3px;" onclick="optionchange(<%=product.getPnum()%>,<%=cart.getCart_num() %>)" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#optionchangemodal">
								옵션변경
							</button> 
						</td>
						
						<td class="align-middle"><%=decimalFormat.format(price) %></td>
						<td class="align-middle"><span id="savepoint">적</span> <%=decimalFormat.format(savemoney) %></td>
						<td class="align-middle">
							<div class="row g-0">
								<div class="col-md-7">
									<input style="background-color: white;" readonly="readonly" id="samount<%=stock.getSnum() %>" value="<%=cart.getCart_selectamount() %>" type="text" class="form-control fc amount_input " >
								</div>
								<div class="col-md-5">
									<button onclick="amountup(<%=stock.getSnum() %>,<%=price %>,<%=cart.getCart_num()%>)" class="amount_btn">▲</button>
									<button onclick="amountdown(<%=stock.getSnum() %>,<%=price %>,<%=cart.getCart_num()%>)" class="amount_btn">▼</button>
								</div>
							</div>
						</td>
						<td class="align-middle">기본배송</td>
						<td class="align-middle"><input type="hidden" id="deleverpay" value="<%=배송비%>"> <%=decimalFormat.format(배송비)%><br>조건</td>
						<td class="align-middle"><span id="totalprice"><%= decimalFormat.format(price*cart.getCart_selectamount()) %></span></td>
						<td class="cart_btn align-middle">
							<a href="/jspweb/product/order.jsp?cartnum=<%=cart.getCart_num()%>"><button class="form-control">주문하기</button></a>
							<button class="form-control" onclick="movewishlist('<%=loginid%>',<%=cart.getCart_num()%>,<%=stock.getSnum()%>,<%=cart.getCart_selectamount()%>,<%=product.getPnum()%>)">관심상품등록</button>
							<button class="form-control" onclick="cartdelete(<%=cart.getCart_num()%>)">삭제하기</button> 
						</td>
					</tr>
					<%} %>
				<%} %>
			</table>
			<input type="hidden" id="cartnumlist">
			<table class="table my-3">
				<tr class="totalprint1">
					<td class="align-middle" colspan="3">총 상품금액</td>
					<td class="align-middle" colspan="2">총 배송비</td>
					<td class="align-middle" colspan="2">총 적립금</td>
					<td class="align-middle" colspan="3">결제 예정 금액</td>
				</tr>
				<tr class="totalprint2">
					<td class="align-middle" colspan="3">
						<span class="total" id="total"></span>
					</td>
					<td class="align-middle" colspan="2">
						<span class="total" id="delievr"></span>
					</td>
					<td class="align-middle" colspan="2">
						<span class="total" id="totalsavemoney"></span>
					</td>		
					<td class="align-middle" colspan="3">
						<span class="total" id="sum"></span>
					</td>
				</tr>
			</table>
			<br><br><br>
			<div class="cart_selectbtn row d-flex justify-content-center">
				<div class="col-md-2">
					<a href="/jspweb/main.jsp"><button class="form-control">쇼핑계속하기</button></a>
				</div>
				<div class="col-md-2">
					<button style="background-color: #999999; color: white;" class="form-control" onclick="selectcartdelete()">선택상품삭제하기</button>
				</div>
				<div class="col-md-2">
					<button style="background-color: #999999; color: white;" class="form-control" onclick="cartclear(<%=loginid%>)">장바구니 비우기</button>
				</div>
				<div class="col-md-2">
					<button style="background-color: black; color: white;" class="form-control" onclick="orderall(<%=loginid%>)">전체상품주문</button>
				</div>
				<div class="col-md-2">
					<button style="background-color: #999999; color: white;" onclick="orderselect(<%=loginid %>)" class="form-control">선택상품주문</button>
				</div>
			</div>
			<br><br><br><br><br><br><br>
			<h4 class="cart_title">관심상품</h4>
			<table class="table wishlisttable">
				<tr>
					<th width="10%">이미지</th>
					<th width="30%">상품정보</th>
					<th width="10%">판매가</th>
					<th width="10%">적립금</th>
					<th width="10%">배송구분</th>
					<th width="10%">배송비</th>
					<th width="10%">합계</th>
					<th width="10%">선택</th>
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
							<td onclick="location.href='/jspweb/product/productview.jsp?pnum=<%=temp.getPnum() %>'"><img alt="" src="../admin/productimg/<%=product.getPimg()%>" width="100px;"> </td>
							<td class="align-middle">
								<%if(temp.getWamount()==0) {%>
									<%=product.getPname() %>
								<%}else{ %>
									<%=product.getPname() %><br><span class="sizecolor">- 색상 : <%=stock.getScolor() %> / 사이즈 : <%=stock.getSsize() %> / 수량 : <%=temp.getWamount() %>개</span>
								<%} %>
								<br>
								<button hidden="" id="selectoption" onclick="optionselect(<%=product.getPnum()%>,<%=temp.getWnum() %>)" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#optionselectmodal">
									옵션변경
								</button> 
							</td>
							<td class="align-middle"><%=decimalFormat.format(price)  %></td>
							<td class="align-middle"><span id="savepoint">적</span>  <%=decimalFormat.format(savemoney)  %></td>
							<td class="align-middle">기본배송</td>
							<td class="align-middle"><%=decimalFormat.format(배송비) %><br>조건</td>
							<%if(temp.getWamount()==0) {%>
								<td class="align-middle"><%=decimalFormat.format(price)%></td>
							<%}else{ %>
								<td class="align-middle"><%=decimalFormat.format(price*temp.getWamount()) %></td>
							<%} %>
							<td class="cart_btn align-middle">
								<button class="form-control">주문하기</button>
								<button class="form-control" onclick="movecart(<%=temp.getWnum()%>,'<%=loginid%>',<%=temp.getPnum()%>,<%=temp.getSnum()%>,<%=temp.getWamount()%>)">장바구니담기</button>
								<button class="form-control" onclick="wishlistdelete(<%=temp.getWnum()%>)">삭제하기</button> 
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