<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- ��Ʈ��Ʈ�� css ���� -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- ����ڰ� ������ css ���� -->
	<link href="css/index.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<div class="container login">
		<div class="col-md-3 offset-5">
			<div class="mainhead text-center">
				<h4>LOGIN</h4>
			</div>
			<br><br>
			<div class="my-4">
				<div class="row">
					<div class="col-md-8">
						<input class="form-control" type="text" placeholder="���̵�">
						<input class="form-control" type="password" placeholder="��й�ȣ" >
					</div>
					<div class="col-md-4">
						<input class="form-control" id="login" type="submit" value="LOGIN" >
					</div>	
				</div>
					
				<ul class="nav" id="findid">
					<li><input type="checkbox" class="form-check-input">���̵� ���� <i id="lock" class="fa fa-lock fa-1x"></i> ��������</li>
					<li> |  ���̵�ã��</li>
					<li> |  ��й�ȣã��</li>
				</ul>
				<div class="row">
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/���̹�.PNG"></a>
					</div>
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/���̽���.PNG"></a>
					</div>
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/īī��.PNG"></a>
					</div>
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/����.PNG"></a>
					</div>
				</div>
				<input class="form-control" id="login" type="submit" value="JOIN US" >
			</div>
			<div id="botbox" class="my-4">
				<p>��ȸ���� ���, �ֹ����� �ֹ���ȣ�� �ֹ���ȸ�� �����մϴ�.</p>
				<div class="row">
					<div class="col-md-6">
						�ֹ��ڸ�
					</div>
					<div class="col-md-6">
						<input class="form-control my-2"  type="text">
					</div>
					<div class="col-md-6">
						�ֹ���ȣ
					</div>
					<div class="col-md-6">
						<input class="form-control my-2"  type="text" placeholder="������(-) ����">
					</div>
					<div class="col-md-6">
						��ȸ���ֹ� ��й�ȣ
					</div>
					<div class="col-md-6">
						<input class="form-control my-2"  type="text">
					</div>
				
				<button class="form-control my-2" >��ȸ�� �α���</button>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>