<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp" %>
	<br><br><br><br><br><br><br><br>
	
	<div class="container">
		<h3 class="text-center titleline"> 문의 글 </h3>
	
	
		<!-- 상단 버튼 -->
		<div class="my-3">
			<a href="boardlist.jsp"><button class="btn btn-outline-info">목록</button> </a>
			<a href="boardlist.jsp"><button class="btn btn-outline-info">삭제</button> </a>
			<a href="boardlist.jsp"><button class="btn btn-outline-info">수정</button> </a>
			<a href="boardlist.jsp"><button class="btn btn-outline-info">답변</button> </a>
		</div>
		
		<!-- 작성자가 입력한 내용 -->
		<div>	<!-- div 박스권 : display = block		/ span 박스권 : display = inline  -->
			<div>
				<span>작성자</span> <span>유재석</span>
				<span>문의날짜</span> <span>2022-04-24 10:10</span>
			</div>
		</div>
		<div>
			<input type="text" value="환불해주세요" class="form-control" readonly> 
		</div>
		<div>
			<textarea rows="20" cols="" class="form-control" readonly style="resize: none;">문의 내용입니다.</textarea>
		</div>
		
		<div class="row my-4">	<!-- 첨부된 사진들 -->
			<h4>첨부 사진</h4>
			<div class="col-md-3">
				<img alt="" src="img/c361e7ecdc2b4c2956e7bcd641d5810d.webp" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/c361e7ecdc2b4c2956e7bcd641d5810d.webp" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/c361e7ecdc2b4c2956e7bcd641d5810d.webp" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/c361e7ecdc2b4c2956e7bcd641d5810d.webp" width="100%">
			</div>
		</div>
		
		<!-- 관리자가 답변한 내용 -->
		<h4>답변</h4>
		<p> 답변일 : 2022-04-24 12:10</p>
		<div>
			<textarea rows="20" cols="" class="form-control" readonly style="resize: none;">관리자 답변입니다.</textarea>
		</div>
	
	</div>
	
	
	<br><br><br><br><br><br><br><br>
	<%@include file="footer.jsp" %>

</body>
</html>