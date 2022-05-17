<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Stock"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%
	session.setAttribute("logincheck", null);
	%>
	<%@include file="header.jsp" %>
	
	<div class="container">
	
<!----------------------------------- 캐러셀 --------------------------------------------->
		<div id="mainslide" class="carousel slide" data-bs-ride="carousel" data-bs-interval="1000">	
			<!-- 슬라이드 하단 위치 버튼 -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="2"></button>
			</div>
			<div class="carousel-inner">	<!-- 이미지 목록 -->
				<div class="carousel-item active">	<!-- 이미지 -->
					<img alt="" src="img/mainpageimg1.jpg">
				</div>
				<div class="carousel-item">	<!-- 이미지 -->
					<img alt="" src="img/mainpageimg2.jpg">
				</div>
				<div class="carousel-item">	<!-- 이미지 -->
					<img alt="" src="img/mainpageimg3.jpg">
				</div>
			</div>
			<!-- 왼쪽 이동 버튼 -->
			<button class="carousel-control-prev" type="button" data-bs-target="#mainslide" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</button>
			<!-- 오른쪽 이동 버튼 -->
			<button class="carousel-control-next" type="button" data-bs-target="#mainslide" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
			</button>			
		</div>
		
<!------------------------------------------------ 광고 / 이벤트 ------------------------------------>		
		<div class="row adbox">	
			<div class="col-md-6">
				<img alt="" src="img/mainad1.gif">
			</div>
			<div class="col-md-6">
				<img alt="" src="img/mainad2.jpg">
			</div>
		</div>
		<div class="main_box">	<!-- 베스트 -->
			<h6 class="main_title"> BEST </h6>
			<div class="row best_box">
				<div class="col-md-3">	
					<img alt="" src="img/productimg1.webp">
				</div>
				<div class="col-md-3">
					<img alt="" src="img/productimg2.jpg">
				</div>
				<div class="col-md-3">
					<img alt="" src="img/productimg1.webp">
				</div>
				<div class="col-md-3">
					<img alt="" src="img/productimg2.jpg">
				</div>
			</div>
		</div>
		<div class="main_box">	<!-- 신상품 -->
			<h6 class="main_title"> NEW ARRIVAL </h6>
			<%
			ArrayList<Product> plist = ProductDao.productDao.getplist();
			DecimalFormat decimalFormat = new DecimalFormat("#,###원");
			%>
			
			
			<div class="row best_box">
			<%for(Product product : plist){ 
				ArrayList<Stock> slist = ProductDao.productDao.getstocklist(product.getPnum()); 
				Set<String> size = new TreeSet<>();
				if(product.getPactive()==1){
					for(Stock stock : slist) {
						size.add(stock.getSsize()); 
					} %>
					<div class="col-md-4">
						<a href="product/productview.jsp?pnum=<%=product.getPnum()%>"><img alt="" src="admin/productimg/<%=product.getPimg()%>"></a> 
						<div class="p_item">
							<div class="p_title"> <%=product.getPname() %> </div>
							<div class="p_size"> 
								<%for(String temp : size) {%>
									<%=temp+"  " %>
								<%} %>
							</div>
							<div class="row py-3">
								<%if(product.getPdiscount()==0) {%>
									<div class="p_discount col-md-3"><%=decimalFormat.format( product.getPprice() ) %></div>
								<%}else{ %>
									<div class="p_price"><%=decimalFormat.format( product.getPprice() ) %></div>
									<div class="p_discount col-md-3"><%=decimalFormat.format( (product.getPprice()*(100-product.getPdiscount() ) )/100)  %></div>
								<%} %>
								<div class="p_review col-md-3 offset-6" style="text-align: right;">리뷰 개수</div>
							</div>
						</div>
					</div>
				<% }else{ %>
					
				<% } %>
			<%} %>
				
				
			</div>
		</div>
		<div class="main_box">	<!-- 실시간 구매후기 -->
			<h6 class="main_title"> 실시간 구매후기 </h6>
		</div>
	</div>
	
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<%@include file="footer.jsp" %>

</body>
</html>