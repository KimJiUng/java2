<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#join{
			width: 600px;
			margin: 0 auto;
			border-bottom: solid 1px gray;
			border-top: solid 1px gray;
			padding: 30px;
		}
		li{ list-style-type: none;} /* �۸Ӹ� ���� */
		h3{text-align: center;}
		#btn{padding : 20px; width: 300px; margin-right: 120px; float: right; }
		#btn input{width: 100px; height: 40px;}
		.cols{ padding: 5px;}
		.cols li{ display: inline-block;}
		.col1{width: 150px;}
		.col2 input, select{ width: 200px; height: 25px;}
		.email input{height: 25px; width: 130px;}
		.hello{vertical-align: top;} /* ���� ���� */
		#contents{
			width: 1150px;
			margin: 0 auto;
			padding: 100px;
		}
	</style>
	
</head>
<body>
	<%@include file="2_header.jsp" %> <!-- ��� -->
	<%@include file="3_mainimage.jsp" %> <!-- ����̹��� -->
	<!-- ���� -->
	<div id="contents">
		<h3> ȸ�� ���� �� </h3>
		<form>
			<ul id="join"> <!-- ��ü -->
				<li> <!-- �� -->
					<ul class="cols">
						<li class="col1"> ���̵�</li> <!-- �� -->
						<li class="col2"><input type="text"> </li>
					</ul>
				 </li>
				<li>
					<ul class="cols">
						<li class="col1">��й�ȣ</li>
						<li class="col2"><input type="password"></li>
					</ul> 
				</li>
				<li>
				 	<ul class="cols">
				 		<li class="col1">��й�ȣ Ȯ��</li>
				 		<li class="col2"><input type="password"></li>
				 	</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">�̸��� </li>
						<li class="email"><input type="text"> @ 
					<select> 
						<option> �����Է� </option>
						<option> naver.com </option>
						<option> nate.com </option> 
					</select> 
						</li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">�̸��� ����</li>
						<li  ><input type="radio" name="mail" checked="checked"> �����
							<input type="radio" name="mail"> ����</li>
					</ul>	 
				</li>
				<li>
					<ul class="cols">
						<li class="col1">���� ���</li>
						<li><input type="checkbox" name="root"> ģ����õ
							<input type="checkbox" name="root"> ���ͳ� �˻�
							<input type="checkbox" name="root" checked="checked"> ��Ÿ</li>
					</ul>	
			 	</li>
				<li>
					<ul class="cols">
						<li class="col1 hello">�λ縻</li>
						<li class="col2"><textarea rows="6" cols="40"></textarea></li>
					</ul>
				</li>
			</ul>
		</form>
		<div id="btn">
			<input type="submit" value="�����ϱ�">
			<input type="reset" value="����ϱ�">
		</div>
	</div>
	<%@include file="5_footer.jsp" %> <!-- ��� -->

</body>
</html>