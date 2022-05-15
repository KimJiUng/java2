let dicethrow=1;

function throwDice(playernum,gamenum){
	let dice1 = Math.floor(6 * Math.random()) + 1;
	let dice2 = Math.floor(6 * Math.random()) + 1;
	$("#dice1").html(dice1);
	$("#dice2").html(dice2);
	$("#sum").html(dice1+dice2);
	let sum = dice1+dice2;
	if(dicethrow==0){
		alert("이번턴에 더이상 주사위를 던질 수 없습니다.");
	}else{
		$.ajax({
		url : "playermove",
		data : {"playernum" : playernum , "sum" : sum, "gamenum" : gamenum},
		success : function(result){
			if(result==0){
				alert("db오류");
			}else{
				alert(sum+"칸 이동");
				dicethrow = 0;
				$("#gemetable").load(location.href+" #gemetable");
				city(result,playernum,gamenum);
			}
		}
	});
	}
	
	
	
}

function city(location,playernum,gamenum){
	$.ajax({
		url : "city",
		data : {"location" : location , "playernum" : playernum , "gamenum" : gamenum},
		success : function(result){
			if(result==1){
				alert("빈땅 : 구매가능");
				$("#buymodal").val(gamenum);
				getcity();
				$("#buymodal").click();
				
			}else if(result==2){
				alert("내땅 : 건물구매가능");
			}else if(result==3){
				alert("황금열쇠");
			}else if(result==4){
				alert("무인도");
			}else if(result==5){
				alert("우주여행");
			}else if(result==6){
				alert("사회복지기금수령처");
			}else if(result==7){
				alert("사회복지기금 접수처");
			}else if(result==8){
				alert("출발");
			}else{
				$("#pay").html(result);
				$("#paymodal").click();
				
			}
		}
	});
}

function getcity(){
	let playernum = $("#playernum").val();
	$.ajax({
		url : "getcity",
		data : {"playernum" : playernum} ,
		success : function(result){
			$("#modal_contents").html(result);
		}
	})
}

function pay(){
	
	let pay = $("#pay").text();
	let playernum = $("#playernum").val();
	$.ajax({
		url : "pay" ,
		data : {"pay" : pay, "playernum" : playernum} ,
		success : function(result){
			if(result==1){
				alert("통행료 지불 완료");
				$("#modalclosebtn").click();
				$("#playertable").load(location.href+" #playertable");
			}else{
				alert("현재 보유자금이 부족합니다.");
			}
		}
	});
}

function giveup(){
	alert("게임포기");
}

function player(gamenum){
	let nickname = $("#nickname").val();
	$.ajax({
		url : "playeradd",
		data : {"nickname" : nickname , "gamenum" : gamenum},
		success : function(result){
			if(result==1){
				alert("등록성공");
				$("#playertable").load(location.href+" #playertable");
			}else if (result==2){
				alert("최대 4명까지 등록가능합니다.");
			}else if(result==3){
				alert("동일한 닉네임을 사용할 수 없습니다.");
			}else{
				alert("오류 - 관리자에게 문의");
			}
		}
	});
	
}

function turnend(){
	let gamenum = $("#gamenum").val();
	let playernum = $("#playernum").val();
	$.ajax({
		url : "turnend" ,
		data : {"gamenum" : gamenum,  "playernum" : playernum} ,
		success : function(result){
			if(result==1){
				alert("턴을 종료합니다.");
				$("#headtable").load(location.href+" #headtable");
				dicethrow = 1;
			}else{
				alert("오류 - 관리자에게 문의");
			}
		}
	});
}
