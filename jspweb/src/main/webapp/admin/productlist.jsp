<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
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
			<th width="5%">제품번호</th>
			<th width="10%">대표이미지</th>
			<th width="15%">제품명</th>
			<th width="10%">가격</th>
			<th width="5%">할인율</th>
			<th width="10%">판매금액</th>
			<th width="5%">제품상태</th>
			<th width="10%">카테고리</th>
			<th width="5%">색상</th>
			<th width="5%">사이즈</th>
			<th width="5%">재고수량</th>
			<th width="5%">수정일</th>
			<th width="10%">비고(삭제,수정,재고채우기)</th>
		</tr>
		<%DecimalFormat decimalFormat = new DecimalFormat("#,###원"); %>
		<%DecimalFormat decimalFormat2 = new DecimalFormat("#.###%"); %>
		<%request.setCharacterEncoding("UTF-8"); %>
		<%ArrayList<Product> plist = ProductDao.productDao.getplist(); %>
		<%for(Product product : plist){ %>
		<tr>
			<td><%=product.getPnum() %></td>
			<td><img alt="" src="<%=request.getContextPath()%>/admin/productimg/<%=product.getPimg()%>" width="100px"> </td>
			<td><%=product.getPname() %></td>
			<td><%=decimalFormat.format(product.getPprice()) %></td>
			<td><%=decimalFormat2.format(product.getPdiscount()/100)%></td>
			<td>
			<%=decimalFormat.format((product.getPprice()*(100-product.getPdiscount() ) )/100)  %>
			</td>
			<td id="pactivetable">
			<%if(product.getPactive()==0) {%>
			판매준비중
			<%} else if(product.getPactive()==1) {%>
			판매중
			<%} else if(product.getPactive()==2){%>
			품절
			<%} else if(product.getPactive()==3){%>
			판매 중단
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
					<input type="hidden" id="pnumbox" value="<%=product.getPnum()%>">
					<select id = "sizebox">
					<%for(Stock stock : slist) {%>
						<option><%=stock.getSsize() %></option>
					<%} %>
					</select>
				</td>
				<td>
					<select>
					<%for(Stock stock : slist) {%>
						<option><%=stock.getSamount() %></option>
					<%} %>
					</select>
				</td>
				<td>수정일</td>
			<td>
				
				<button>제품 삭제</button>
				<button>제품 수정</button>
				<button onclick="pnummove(<%=product.getPnum() %>)" data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button>
				<button>재고 변경</button>
			</td>
		</tr>
		<%} %>
	</table>
	
	<button data-bs-toggle="modal" data-bs-target="#activemodal">모달버튼</button>
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="activemodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">제품 상태 변경</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <p>변경할 상태를 선택해주세요.</p>	<!-- 모달 바디 -->
	        <input type="hidden" id="modalinput">
	        <input type="radio" checked="checked" name="pactive" value="0">준비
	        <input type="radio" name="pactive" value="1">판매
	        <input type="radio" name="pactive" value="2">품절
	        <input type="radio" name="pactive" value="3">중단
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="pactivechange()">적용</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        
	      </div>
	    </div>
	  </div>
	</div>
	

	<script type="text/javascript" src="/jspweb/js/productlist.js"></script>

</body>
</html>