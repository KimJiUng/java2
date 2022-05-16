<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
   	
   	<!-- 썸머노트 기본 부트스트랩버젼 3버젼 css cdn -->
   	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
   	<!-- 썸머노트 css cdn -->
   	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
   	
   	
</head>
<body>
	
	<%
	int update;
	if(request.getParameter("update")!=null){
		update = Integer.parseInt(request.getParameter("update"));
	}else{
		update=0;
	}
	%>
	<%@include file="../header.jsp" %>
	<div class="container">
	<%if(loginid==null){ %>
	로그인 이후 이용 가능
	<%} else{%>
		<div class="text-center">
			<%if(update==1) {%>
				<h3>수정하기</h3>
			<%} else {%>
				<h3>글쓰기</h3>
			<%} %>
		</div>
		<a href="boardlist.jsp">목록보기</a>
		<br><br>
		
		<%if(update==1){%>
			<%int bnum = Integer.parseInt(request.getParameter("bnum"));
			Board board = BoardDao.boardDao.getboard(bnum); %>
				<form action="../board/Update?bnum=<%=bnum %>" method="post" enctype="multipart/form-data">
					제목 : <input type="text" name="btitle" value="<%=board.getBtitle() %>"><br>
					내용 : <textarea name="bcontent" id="summernote" ><%=board.getBcontent() %></textarea><br>
					<%if(board.getBfile()!=null) {%>
					첨부파일 :<%=board.getBfile() %><button type="button" onclick="filedelete(<%=bnum%>)">파일삭제</button>
					<%}else{ %>
					첨부파일 :
					<%} %>
					<br> <input type="file" name="bfile" id="bfile">
					<input type="submit" value="등록"><input type="reset" value="취소">
				</form>
			<%}else{ %>
				<form action="../board/Write" method="post" enctype="multipart/form-data">
					<!-- form 전송 인코딩 타입 : 기본타입은 첨부파일 불가능 -->
					<!-- form 첨부파일 전송 인코딩 타입 : multipart/form-data -->
					제목 : <input type="text" name="btitle"><br>
					내용 : <textarea name="bcontent" id="summernote"></textarea><br>
					첨부파일 :<input type="file" name="bfile" id="bfile"> 
					<input type="submit" value="등록"><input type="reset" value="취소">
				</form>
			<%} %>
	</div>
	<%} %>
	<!-- 썸머노트 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	
	<!-- 썸머노트 기본 부트스트랩버젼 3버젼 js cdn -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<!--  썸머노트 한글 버전 cdn -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
    
    <!-- 사용자 정의 js -->
    <script src="/jspweb/js/board.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>

</body>
</html>