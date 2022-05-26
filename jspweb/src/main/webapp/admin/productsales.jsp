<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Orderdetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
	#chartdiv {
	  width: 100%;
	  height: 500px;
	}
	#piechartdiv {
	  width: 100%;
	  height: 500px;
	}
	#linechartdiv {
		width: 100%;
		height: 500px;
		max-width: 100%
	}
	</style>

</head>
<body>

	
	
	<div class="container" style="margin-left: 200px;">
		<h3> 매출 관리 </h3>
		<div>	<!-- 일 매출 차트 -->
			<div id="chartdiv"></div>
		</div>
		<div class="row">
			<div class="col-md-6">	<!-- 일 매출 테이블 -->
				<%
					ArrayList<Orderdetail> odlist = ProductDao.productDao.getorderlist();
					DecimalFormat decimalFormat = new DecimalFormat("#,###원");
					
				%>
				<h3 class="text-center">오늘 판매 내역</h3>
				<table class="table table-hover">
					<tr>
						<th>주문번호</th>
						<th>주문상세번호</th>
						<th>카테고리</th>
						<th>상품이름</th>
						<th>판매가격</th>
						<th>주문수량</th>
					</tr>
					<%for(Orderdetail temp : odlist) {%>
						<%int price =(int)(temp.getPprice()*(100-temp.getPdiscount() ) )/100; %>
						<tr onclick="getchart('<%=temp.getPname()%>')">
							<td><%=temp.getOrdernum() %></td>
							<td><%=temp.getOrderdetailnum() %></td>
							<td><%=temp.getCg_name() %></td>
							<td><%=temp.getPname() %></td>
							<td><%=decimalFormat.format(price)  %></td>
							<td><%=temp.getSamount() %></td>
						</tr>
					<%} %>
				</table>
				<div id="linechartdiv"></div>
			</div>
			<div class="col-md-6">	<!-- 카테고리별 차트 -->
				<div id="piechartdiv"></div>
			</div>
		</div>
		
	</div>

	<script src="/jspweb/js/productsales.js" type="text/javascript"></script>

</body>
</html>