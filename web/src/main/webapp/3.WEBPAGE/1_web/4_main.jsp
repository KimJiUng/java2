<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#contents{
			width: 1150px;
			margin: 0 auto;
		}
		li{list-style-type: none;}
		#sub_menu{
			float: left; 
			width: 240px;
		}
		#main_contents{
			float: right;
			width: 900px;
		}
		#sub_menu h3{
			font-size: 20px;
			color: #55cfad;
			background-color : #516e7f;
			padding: 15px;
		}
		#sub_menu li{
			padding: 10px;
			border-bottom: dotted 1px #cccccc;
		}
		#main_contents h3{
			font-size: 20px;
			border-bottom: solid 1px #cccccc;
			padding-bottom: 10px;
		}
		#main_contents p{
			line-height: 180%;
			margin-top: 30px;
		}
		#figure{
			text-align: center;
			margin: 20px 0px;
		}
		#main_contents li{
			padding: 5px;
		}
	</style>
</head>
<body>
	<div id="contents">
		<div id="sub_menu">	<!-- 왼쪽 사이드바 -->
			<h3> 사진 이론 </h3>
			<ul>
				<li>카메라 동작 원리</li>
				<li>무조건 찍어 보자!</li>
				<li>피사체의 배경</li>
				<li>조리개와 심도</li>
				<li>카메라 촬영 모드</li>
			</ul>
		</div>
		<div id="main_contents">	<!-- 본문 -->
			<h3> 카메라 동작 원리 </h3>
			<p>DSLR 카메라에서 DSLR은 “Digital Single Lens Reflex”의 약어로써 우리말로는 디지털 일안 반사식 카메라을 의미합니다. DSLR은 디지털 카메라로써 카메라 내부에 들어온 빛이 상단의 펜타프리즘을 통하여 뷰파인더에 맺히게 되어 셔터를 누르기 전에 뷰 파인더를 통하여 피사체를 확인할 수 있게 됩니다</p>
			<div id="figure">
				<img alt="" src="img/내용.png">
			</div>
			<p>[그림 1]은 DSLR 카메라에서 셔터를 누르기 전의 상태를 보여주는데 렌즈를 통해 들어오는 빛은 카메라 내부에서 다음과 같은 과정을 거치게 됩니다.</p>
			<ul>
				<li>① 빛이 카메라 렌즈를 통과합니다.</li>
	            <li>② 빛이 반사 거울에 반사되어 위쪽으로 향합니다.</li>
	            <li>③ 빛이 펜타프리즘 거울에 반사되어 뷰파인더로 향합니다.</li>
	            <li>④ 들어온 빛에 의해 뷰파인터들 통하여 피사체를 볼 수 있습니다.</li>
			</ul>
		</div>
	</div>

</body>
</html>