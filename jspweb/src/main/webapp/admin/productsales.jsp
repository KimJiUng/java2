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
	</style>

</head>
<body>

	
	
	<div class="container" style="margin-left: 200px;">
		<h3> 매출 관리 </h3>
		<div>	<!-- 일 매출 차트 -->
			<div id="chartdiv"></div>
		</div>
		<div class="row">
			<div class="col-md-6">	<!-- 주 매출 차트 -->
				주문확정 리스트
			</div>
			<div class="col-md-6">	<!-- 월 매출 차트 -->
				<div id="piechartdiv"></div>
			</div>
		</div>
		
	</div>

	<script src="/jspweb/js/productsales.js" type="text/javascript"></script>

</body>
</html>