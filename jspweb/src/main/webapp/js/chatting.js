function sendtalk(){
	let id = $("#talk_id").val();
	let talk = $("#talk_input").val();
	$.ajax({
		url : "Chatting" ,
		data :{"id" : id, "talk" : talk} ,
		success : function(result){
			if(result==1){
				$("#talk_id").val(id);
				$("#talk_input").val("");
			}else if(result==2){
				alert("DB 오류 [관리자에게 문의]");
			}else if(result==3){
				alert("닉네임과 채팅내용을 모두 입력해주세요.");
			}
		}
		
	});	
}


$(function(){
	timer = setInterval( function () { $("#chattingtable").load(location.href+" #chattingtable");
	$("#tablescroll").scrollTop($("#tablescroll")[0].scrollHeight); 
	}, "500"); // 밀리초 만큼 반복 실행 
	
	
})








