<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Category"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<h3>제품 목록 페이지</h3>
	<table class="table table-hover">
		<tr>
			<th>제품번호</th>
			<th>대표이미지</th>
			<th>제품명</th>
			<th>가격</th>
			<th>할인율</th>
			<th>판매금액</th>
			<th>제품상태</th>
			<th>카테고리</th>
			<th>색상</th>
			<th>사이즈</th>
			<th>재고수량</th>
			<th>수정일</th>
			<th>비고(삭제,수정,재고채우기)</th>
		</tr>
		<%DecimalFormat decimalFormat = new DecimalFormat("#,###원"); %>
		<%DecimalFormat decimalFormat2 = new DecimalFormat("#.###%"); %>
		<%ArrayList<Product> plist = ProductDao.productDao.getplist(); %>
		<%for(Product product : plist){ %>
		<tr>
			<td><%=product.getPnum() %></td>
			<td><%=product.getPimg() %></td>
			<td><%=product.getPname() %></td>
			<td><%=decimalFormat.format(product.getPprice()) %></td>
			<td><%=decimalFormat2.format(product.getPdiscount()/100)%></td>
			<td>
			<%=decimalFormat.format((product.getPprice()*(100-product.getPdiscount() ) )/100)  %>
			</td>
			<td>
			<%if(product.getPactive()==0) {%>
			판매준비중
			<%} else if(product.getPactive()==1) {%>
			판매중
			<%} else if(product.getPactive()==2){%>
			매진
			<%} %>
			</td>
			<td>
			<%
			String categroyname = null;
			ArrayList<Category> clist = ProductDao.productDao.getclist(); 
			for(Category category : clist) {
				if(category.getCg_num()==product.getCg_num()){
					categroyname = category.getCg_name();
				}
			} 
			%>
			<%=categroyname %>
			</td>
				<%
				ArrayList<Stock> slist = ProductDao.productDao.getstocklist(product.getPnum());
				int cnum = 0;
				%>
				<td>
					<select  name="scolor" id="scolor" onchange="changeLangSelect()">
					<%for(Stock stock : slist) {%>
						<option value="<%=stock.getScolor()%>"><%=stock.getScolor() %></option>
					<%} %>
					
					</select>
				</td>
				<td>
					<select>
					<%for(Stock stock : slist) {%>
						<option><%=stock.getSsize() %></option>
					<%} %>
					</select>
				</td>
				<td>
				<%
				//System.out.println(request.getParameter("scolor")); 
				//Stock stock = ProductDao.productDao.getstock(snum);
				%>
				
				</td>
				<td>수정일</td>
			<td>비고</td>
		</tr>
		<%} %>
	</table>

	<script type="text/javascript" src="/jspweb/js/productlist.js"></script>

</body>
</html>