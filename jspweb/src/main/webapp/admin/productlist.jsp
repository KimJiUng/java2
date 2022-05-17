<%@page import="java.util.HashSet"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
	<link href="/jspweb/css/productlist.css" rel="stylesheet">
</head>
<body>
	
	<h3>제품 목록 페이지</h3>
	<table class="table table-hover producttable">
		<tr>
			<th width="7%">제품번호</th>
			<th width="8%">대표이미지</th>
			<th width="15%">제품명</th>
			<th width="9%">가격</th>
			<th width="4%">할인율</th>
			<th width="9%">판매금액</th>
			<th width="8%">제품상태</th>
			<th width="7%">카테고리</th>
			<th width="4%">색상</th>
			<th width="4%">사이즈</th>
			<th width="7%">재고수량</th>
			<th width="10%">수정일</th>
			<th width="8%">비고(삭제,수정,재고채우기)</th>
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
				ArrayList<Stock> stocklist = ProductDao.productDao.getstocklist(product.getPnum());
				HashSet<String> slist = new HashSet<>();
				for(Stock stock : stocklist){
					slist.add(stock.getScolor());
				}
				int cnum = 0;
				%>
				<td>
					<select id="scolor<%=product.getPnum() %>" onchange="selectcolor(<%=product.getPnum()%>)">
						<option>색상 선택</option>
					<%for(String color : slist) {%>
						<option value="<%=color%>"><%=color %></option>
					<%} %>
					
					</select>
				</td>
				<td>
					<select id = "sizebox<%=product.getPnum() %>" onchange="selectsize(<%=product.getPnum()%>)">
						<option>사이즈 선택</option>
					</select>
				</td>
				<td id="samount<%=product.getPnum() %>"></td>
				<td id="supdate<%=product.getPnum() %>"></td>
			<td>
				
				<button onclick="deletecheck(<%=product.getPnum() %>)" data-bs-toggle="modal" data-bs-target="#pdeletemodal">제품 삭제</button>
				<button onclick="getproduct(<%=product.getPnum() %>)" data-bs-toggle="modal" data-bs-target="#pupdatemodal">제품 수정</button>
				<button onclick="pnummove(<%=product.getPnum() %>)" data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button>
				<button onclick="getstock(<%=product.getPnum() %>)" data-bs-toggle="modal" data-bs-target="#supdatemodal">재고 변경</button>
			</td>
		</tr>
		<%} %>
	</table>
	
	<button hidden="" data-bs-toggle="modal" data-bs-target="#activemodal"></button>
	
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
	
	<button hidden="" data-bs-toggle="modal" data-bs-target="#pupdatemodal"></button>
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="pupdatemodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">제품 수정</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <p>변경할 상태를 선택해주세요.</p>	<!-- 모달 바디 -->
	        <input type="hidden" id="modalinput">
			<div id="productinfo"></div>
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="pupdate()">수정</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<button hidden="" data-bs-toggle="modal" data-bs-target="#supdatemodal"></button>
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="supdatemodal">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">제품 재고 변경</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <p>재고 변경!</p>	<!-- 모달 바디 -->
	        <input type="hidden" id="modalinput">
			<div id="stocktable"></div>
			
			<div id="supdatebox" style="display: none;">
				<input type="hidden" id="snum">
				<input type="hidden" id="scolor">
				<input type="hidden" id="ssize">
				재고수량 : <input type="text" id="samount">
				<div id="deletecheck"></div>
			</div>
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="stockupdate()">변경</button>
	        <button type="button" id="modalclosebtn3" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<button hidden="" data-bs-toggle="modal" data-bs-target="#pdeletemodal"></button>
	
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="pdeletemodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">제품 삭제</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body"> <!-- 모달 바디 -->
	         <input type="hidden" id="modalinput">
	         <div id="deletetable"></div>
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="deleteproduct()">변경</button>
	        <button type="button" id="modalclosebtn4" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>

	<script type="text/javascript" src="/jspweb/js/productlist.js"></script>

</body>
</html>