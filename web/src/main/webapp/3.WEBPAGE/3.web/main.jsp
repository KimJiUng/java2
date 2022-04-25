<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		.topitems{
			height: 200px;
		}
		#icon1, #icon2, #text1, #text2{
			float: left;
		}
		.topitems li{margin-left: 30px;}
		.topitems .head{font-size: 20px; font-weight: bold; margin-bottom: 10px;}
		.topitems div{
			width: 400px;
			line-height: 150%;
		}
		.botitems{clear: both; height: 350px;}
		#items1,#items2,#items3,#items4{float: left;}
		.botitems #title{font-weight: bold; font-size: 20px;}
		.botitems div{width: 270px;}

		
	</style>
</head>
<body>
	<div id="box">
		<ul class="topitems">
			<li id="icon1"><img alt="" src="img/icon1.png"></li>
			<li id="text1">
				<div class="head">예약 안내</div>
				<div>스튜디오 대여는 사전에 인터넷 예약을 하셔야 합니다.<br> 예약은 1일 이전까지 가능합니다.</div>
			</li>
			<li id="icon2"><img alt="" src="img/icon2.png"></li>
			<li id="text2">
				<div class="head">포토 갤러리</div>
				<div>취업 사진, 가족 사진, 프로필 사진, 우정 사진 등 개인 또는 단체가 이용할 수 있습니다.</div>
			</li>
		</ul>		
		<ul class="botitems">
			<li id="items1">
				<div id="img"> <img alt="" src="img/image1.jpg" width="270px" height="200px"> </div>
				<div id="title"> 촬영 스튜디오</div>
				<div> 카메라, 조명 등 촬영 장비 완비</div>
			</li>
			<li id="items2">
				<div id="img"> <img alt="" src="img/image2.jpg" width="270px" height="200px"> </div>
				<div id="title"> 촬영 스튜디오</div>
				<div> 카메라, 조명 등 촬영 장비 완비</div>
			</li>
			<li id="items3">
				<div id="img"> <img alt="" src="img/image3.jpg" width="270px" height="200px"> </div>
				<div id="title"> 촬영 스튜디오</div>
				<div> 카메라, 조명 등 촬영 장비 완비</div>
			</li>
			<li id="items4">
				<div id="img"> <img alt="" src="img/image4.jpg" width="270px" height="200px"> </div>
				<div id="title"> 촬영 스튜디오</div>
				<div> 카메라, 조명 등 촬영 장비 완비</div>
			</li>
		</ul>
	</div>
</body>
</html>