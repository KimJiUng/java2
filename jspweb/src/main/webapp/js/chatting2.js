

$("#incontent").focus();	// 스크립트가 실행될때 입력창에 커서 두기
let websocket = null;	// js 웹소켓 변수

start();	// 웹 소켓 실행

let id = "";
// enter 입력했을때 이벤트
function enterkey(mid){
	if(window.event.keyCode == 13){
		send(mid);
		id = mid;
	}
}

// 전송 버튼을 눌렀을때 이벤트
function sendbtn(mid){
	send(mid);
	id = mid;
}


// 채팅 소켓 실행
function start(){
	let mid = $("#mid").val();
	// js 에서 사용되는 웹 소켓 클래스(ws:// IP번호 / HTTP PORT번호 /프로젝트명/서버소켓명)
	websocket = new WebSocket("ws://192.168.17.85:8080/jspweb/board/Chatting2/"+mid);
	websocket.onopen = function(e){ OnOpen(e) }
	websocket.onmessage = function(e){OnMessage(e)}
	websocket.onclose  = function(e){OnClose(e)}
	websocket.onerror = function(e){OnError(e)}
}

function OnOpen(e){
	id = $("#mid").val();
	
	websocket.send(id+"@@id");
	
}

let html2 = "";

function OnMessage(e){
	
	if(e.data.includes("@@id")){
		let html = '<div class="alarm">'+
					'<span>'+e.data.split("@@")[0]+'님이 입장 하셨습니다.</span>'+
				'</div>'
		$("#contentbox").append(html);
	}else{
		// e : 메소드 이벤트 실행정보가 담겨있는 객체
			// e.data : 메세지 내용이 담겨있는 필드
		
		let msg = JSON.parse(e.data);	// 문자열 -> JSON
		let type = msg["type"];		
		let from = msg["from"];		// json 키를 통한 value 호출
		let content = msg["content"];	// json 키를 통한 value 호출
		let img = msg["img"];	// json 키를 통한 value 호출
		let date = msg["date"];	// json 키를 통한 value 호출
		
		if(type == 1){
			if(id==from){
				let html = '<div class="secontent my-2">'+
							'<span class="date">'+date+'</span>'+
							'<span class="content">'+content+'</span>'+
						'</div>'
				$("#contentbox").append(html);	
			}else{
				let html = '<div class="row g-0 my-2">' +
							'<div class="col-sm-2 mx-2">'+
								'<img class="rounded-circle" alt="" src="../img/'+img+'" width="100%;">'+
							'</div>'+
							'<div class="col-sm-9">'+
								'<div class="recontent">'+
									'<div class="member_name">'+from+'</div>'+
									'<span class="content">'+content+'</span>'+
									'<span class="date">'+date+'</span>'+
								'</div>'+
							'</div>'+
						'</div>';
				$("#contentbox").append(html);
			}
		}else{	// 접속자 명단
			let html = "";
			for(let i=0; i<msg.length; i++){
				html += '<div class="col-sm-4">'+
								'<img class="rounded-circle" alt="" src="../img/토끼.jpg" width="100%;">'+
							'</div>'+
							'<div class="col-sm-8">'+
								'<div class="member_name">'+msg[i]["mid"]+'</div>'+
								'<div class="btnbox">'+
									'<span>귓말</span>'+
									'<span>친추</span>'+
								'</div>'+
							'</div>';
			}
			$("#enterlist").html(html);
			
		}
		
		
		
	}
	
	// 스크롤 하단으로 내리기
	$("#contentbox").scrollTop($("#contentbox")[0].scrollHeight);
		// $("#contentbox").scrollTop : 현재 스크롤의 상단위치
		// $("#contentbox")[0].scrollHeight : 현재 스크롤의 전체 길이
	
}

function send(mid){
	let content = $("#incontent").val();
	if(content.includes("<script>")){
		return;
	}else{
		// json 형식으로 통신 [JS <--> JAVA , DB(X)]
		let msg = {	// js 객체화
			type : "1",
			from : mid,		// 보내는 사람
			content : content,	// 채팅 내용
			img : "토끼.jpg",		// 프로필 이미지
			date : new Date().toLocaleTimeString()	// 채팅보낸시간
		}
		// json 통신할때 json 모양의 문자열 변환
			// JSON -> 문자열 : JSON.stringify
			// 문자열 -> JSON : JSON.parse()
		
		websocket.send( JSON.stringify(msg) );
		$("#incontent").val("");	// 전송 후 입력창 초기화
		$("#incontent").focus();	// 전송 후 마우스 포커스
	}
	
		
}

function OnClose(e){
	alert("채팅방을 나갑니다.");
}

function OnError(e){
	alert("서버소켓 오류입니다. : "+e);
}
