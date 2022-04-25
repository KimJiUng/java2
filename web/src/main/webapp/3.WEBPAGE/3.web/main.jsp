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
				<div class="head">���� �ȳ�</div>
				<div>��Ʃ��� �뿩�� ������ ���ͳ� ������ �ϼž� �մϴ�.<br> ������ 1�� �������� �����մϴ�.</div>
			</li>
			<li id="icon2"><img alt="" src="img/icon2.png"></li>
			<li id="text2">
				<div class="head">���� ������</div>
				<div>��� ����, ���� ����, ������ ����, ���� ���� �� ���� �Ǵ� ��ü�� �̿��� �� �ֽ��ϴ�.</div>
			</li>
		</ul>		
		<ul class="botitems">
			<li id="items1">
				<div id="img"> <img alt="" src="img/image1.jpg" width="270px" height="200px"> </div>
				<div id="title"> �Կ� ��Ʃ���</div>
				<div> ī�޶�, ���� �� �Կ� ��� �Ϻ�</div>
			</li>
			<li id="items2">
				<div id="img"> <img alt="" src="img/image2.jpg" width="270px" height="200px"> </div>
				<div id="title"> �Կ� ��Ʃ���</div>
				<div> ī�޶�, ���� �� �Կ� ��� �Ϻ�</div>
			</li>
			<li id="items3">
				<div id="img"> <img alt="" src="img/image3.jpg" width="270px" height="200px"> </div>
				<div id="title"> �Կ� ��Ʃ���</div>
				<div> ī�޶�, ���� �� �Կ� ��� �Ϻ�</div>
			</li>
			<li id="items4">
				<div id="img"> <img alt="" src="img/image4.jpg" width="270px" height="200px"> </div>
				<div id="title"> �Կ� ��Ʃ���</div>
				<div> ī�޶�, ���� �� �Կ� ��� �Ϻ�</div>
			</li>
		</ul>
	</div>
</body>
</html>