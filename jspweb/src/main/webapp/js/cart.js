

function wishlistdelete(wnum){
	$.ajax({
		url : "wishlistdelete",
		data : {"wnum" : wnum},
		success : function(result){
			if(result==1){
				location.reload();
			}else{
				alert("삭제 실패 [관리자에게 문의]");
			}
		}
	});
}

function cartdelete(cart_num){
	$.ajax({
		url : "cartdelete",
		data : {"cart_num" : cart_num},
		success : function(result){
			if(result==1){
				location.reload();
			}else{
				alert("삭제 실패 [관리자에게 문의]");
			}
		}
	});
}

function movewishlist(mid,cart_num){
	$.ajax({
		url : "movewishlist",
		data : {"mid" : mid , "cart_num" : cart_num},
		success : function(result){
			if(result==1){
				
			}
		}
	});
	$.ajax({
		url : "cartdelete",
		data : {"cart_num" : cart_num},
		success : function(result){
			if(result==1){
				location.reload();
			}else{
				alert("삭제 실패 [관리자에게 문의]");
			}
		}
	});
}