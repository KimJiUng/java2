        var textarea = document.getElementById("messageWindow");
        var sssss = document.getElementById("tesss1");
        var webSocket = new WebSocket('ws://192.168.17.85:8080/BlueMarble/broadcasting');
        var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    function onMessage(event) {
        textarea.value += event.data + "\n";
        if(event.data.split(",")[0]=="player1"){
			 $("#player1dice").val(event.data.split(",")[2]);
		}else if(event.data.split(",")[0]=="player2"){
			 $("#player2dice").val(event.data.split(",")[2]);
		}else if(event.data.split(",")[0]=="player3"){
			 $("#player3dice").val(event.data.split(",")[2]);
		}
       
    }
    function onOpen(event) {
        textarea.value += "연결 성공\n";
        
    }
    function onError(event) {
      alert(event.data);
    }
    function send() {
        textarea.value += "나 : " + inputMessage.value + "\n";
        webSocket.send(inputMessage.value);
        inputMessage.value = "";
    }
    
    function dice() {
		let player = 0;
		$.ajax({
			url : "chatting/turn",
			success : function(result){
				player = result;
				if(player==$("#player1").val()){
					let dice1 = Math.floor(6 *Math.random()) + 1;
					let sumdice = $("#player1dice").val();
			
					$.ajax({
						url : "chatting/dice",
						data : {"dice1" : dice1, "sumdice" : sumdice},
						success : function(result){
							sumdice = result;
							webSocket.send(player+","+dice1+","+sumdice);
						}
					});
					
				}else if(player==$("#player2").val()){
					let dice1 = Math.floor(6 *Math.random()) + 1;
					let sumdice = $("#player1dice").val();
			
					$.ajax({
						url : "chatting/dice",
						data : {"dice1" : dice1, "sumdice" : sumdice},
						success : function(result){
							sumdice = result;
							webSocket.send(player+","+dice1+","+sumdice);
						}
					});
				}else if(player==$("#player2").val()){
					let dice1 = Math.floor(6 *Math.random()) + 1;
					let sumdice = $("#player1dice").val();
			
					$.ajax({
						url : "chatting/dice",
						data : {"dice1" : dice1, "sumdice" : sumdice},
						success : function(result){
							sumdice = result;
							webSocket.send(player+","+dice1+","+sumdice);
						}
					});
				}	
			}
		})

    

	}
	
	
