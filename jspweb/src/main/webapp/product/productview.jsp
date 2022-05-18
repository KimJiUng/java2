<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Product"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- 사용자정의 css 호출 -->
	<link rel="stylesheet" href="/jspweb/css/productview.css">
</head>
<body>

	<%
	int pnum = Integer.parseInt(request.getParameter("pnum"));
	Product product = ProductDao.productDao.getproduct(pnum);
	ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
	DecimalFormat decimalFormat = new DecimalFormat("#,###원");
	DecimalFormat decimalFormat2 = new DecimalFormat("#.###%");
	Set<String> size = new TreeSet<>();
	ArrayList<String> sizelist = new ArrayList<String>();
	for(Stock stock : slist) {
		size.add(stock.getSsize()); 
	}
	for(String temp : size){
		sizelist.add(temp);
	}
	
	Set<String> color = new TreeSet<>();
	
	for(Stock stock : slist) {
		color.add(stock.getScolor()); 
	}
	float saverate = 1;
	int realprice=0;
	%>
	<%@include file="../header.jsp" %>
	<div class="container viewbox">
		<div class="row">	<!-- 이미지 / 제품설명,구매 -->
			<div class="col-md-5">	<!-- 이미지 -->
				<img alt="" src="../admin/productimg/<%=product.getPimg()%>">
			</div>
			<div class="col-md-6 offset-1 infobox">	<!-- 제품설명,구매 -->
				<div class="view_title"><%=product.getPname() %></div>
				<div class="price_box">
					<%if(product.getPdiscount()==0) {%>
						<span class="price_discount col-md-2"><%=decimalFormat.format( product.getPprice() ) %></span>
						<%realprice=product.getPprice(); %>
					<%}else{ %>
						<span class="price_rat"><%=decimalFormat2.format(product.getPdiscount()/100)  %></span>
						<span class="price_discount"><%=decimalFormat.format( (product.getPprice()*(100-product.getPdiscount() ) )/100)  %></span>
						<%realprice=(int)(product.getPprice()*(100-product.getPdiscount() ) )/100; %>
						<span class="p_price"><%=decimalFormat.format( product.getPprice() ) %></span>
					<%} %>
				</div>
				<div class="size_box">
					[
					<%for(int i=0; i<sizelist.size(); i++) {%>
						<%if(i==sizelist.size()-1) {%>
							<%=sizelist.get(i) %>
						<%}else{ %>
							<%=sizelist.get(i)+" , " %>
						<%} %>
					<%} %>
					]
				</div>
				<table class="table info_t my-3">
					<tr>
						<td> DELVERY </td>
						<td> 2,500원 (70,000원 이상 구매시 무료) </td>
					</tr>
					<tr>
						<td> SAVE </td>
						<td> <%=decimalFormat.format(Math.ceil( (realprice*saverate/100)/10 )*10) %> (<%=saverate%>%) </td>
					</tr>
					<tr>
						<td> COLOR </td>
						<td> 
							<select id="scolor" class="form-select info_t" onchange="selectcolor(<%=product.getPnum()%>)">
								<option class="info_t">- [필수] 옵션 선택 -</option>
								<%for(String temp : color) {%>
									<option value="<%=temp %>" class="info_t"><%=temp %></option>
								<%} %>
							</select> 
						</td>
					</tr>
					<tr>
						<td> SIZE </td>
						<td> 
							<select class="form-select info_t" id="sizebox" onchange="selectsize(<%=product.getPnum()%>)">
								<option class="info_t">- [필수] 옵션 선택 -</option>
							</select> 
						</td>
					</tr>
				</table>
				<table class="table my-3" id="selectproduct">
					<tr>
						<td width="60%" >상품명</td>
						<td width="25%">상품수</td>
						<td width="15%">가격</td>
					</tr>
				</table>
				<div class="row my-4">
					<div class="col-md-6"> 총 상품금액 </div>
					<div class="col-md-6 total_price"> <span id="total_price"></span><br> <span id="savemoney"></span> </div>
				</div>
				
				<div class="row my-4">
					<div class="col-md-4"><button class="form-control p-4" style="background-color: black; color: white;">바로 구매하기</button> </div>
					<div class="col-md-4"><button onclick="cartadd('<%=loginid %>', <%=product.getPnum() %>)" class="form-control p-4">장바구니 담기</button> </div>
					<div class="col-md-4"><button onclick="wishlistadd('<%=loginid %>' ,<%=product.getPnum() %>)" class="form-control p-4">관심상품 등록</button> </div>
				</div>
				
			</div>
		</div>
		<div>	<!-- 추천 상품 -->
		
		</div>
		<div>	<!-- 제품 상세설명 -->
		
		</div>
		<div>	<!-- with item -->
		
		</div>
		<div>	<!-- review -->
		
		</div>
		<div>	<!-- Q&A -->
		
		</div>
		<div>	<!-- 가이드 -->
		
		</div>
		
	</div>
	
	
	<button hidden="" id="modalclick" data-bs-toggle="modal" data-bs-target="#wishlistmodal"></button>
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="wishlistmodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">관심상품담기</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body"> <!-- 모달 바디 -->
	         <input type="hidden" id="modalinput">
	         <p>선택하신 상품을 관심상품에 담았습니다.<br>
				지금 관심상품을 확인하시겠습니까?</p>
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="mywishlist()">관심상품 확인</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">쇼핑 계속하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<button hidden="" id="cartmodalclick" data-bs-toggle="modal" data-bs-target="#carttmodal"></button>
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="carttmodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">장바구니 담기</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body"> <!-- 모달 바디 -->
	         <input type="hidden" id="modalinput">
	         <p>선택하신 상품을 장바구니에 담았습니다.<br>
				지금 장바구니를 확인하시겠습니까?</p>
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="mywishlist()">장바구니 확인</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">쇼핑 계속하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<%@include file="../footer.jsp" %>
	
	<script src="/jspweb/js/productview.js" type="text/javascript"></script>

</body>
</html>