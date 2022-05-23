

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

function movewishlist(mid,cart_num,snum,selectamount,pnum){
	$.ajax({
		url : "wishlistadd",
		data : {"mid" : mid , "snum" : snum , "samount" : selectamount, "pnum" :pnum},
		success : function(result){
			if(result==1){
				cartdelete(cart_num);
			}else if(result==3){
				alert("이미 관심상품에 등록된 상품입니다.");
			}else{
				alert("관심상품 담기 오류");
			}
		}
	});
	
	
}

function movecart(wnum,mid,pnum,snum,samount){
	if(snum==0){
		alert("옵션 선택 후 장바구니에 넣을 수 있습니다.");
		$("#selectoption").click();
	}else{
		$.ajax({
			url : "cartadd",
			data : {"mid" : mid , "pnum" : pnum, "snum" : snum, "samount" :samount},
			success : function(result){
				if(result==1){
					location.reload();
				}else if(result==3){
					alert("이미 장바구니에 있는 상품입니다.");
					return;
				}else if(result==0){
					alert("해당 상품은 품절되었습니다.");
				}else{
					alert("장바구니 담기 오류");
				}
			}
		});
		
	}
	
}

function amountup(snum,price,cart_num){
	let samount = $("#samount"+snum).val()*1;
	$.ajax({
		url : "getamount",
		data : {"snum" : snum},
		success : function(maxamount){
			if(parseInt(maxamount) <= parseInt($("#samount"+snum).val()) ){
				alert("해당 상품의 재고가 부족합니다.");
			}else{
				$("#samount"+snum).val(samount+1);
				totalprice(snum,price,samount+1);
				$.ajax({
					url : "cartupdate",
					data : {"cart_num" : cart_num , "samount" :samount+1},
					success : function(result){
						if(result==1){
							location.reload();
						}else{
							alert("수량변경 오류");
						}
					}
				});
			}
		}
	});
	
}

function amountdown(snum,price,cart_num){
	let samount = $("#samount"+snum).val()*1;
	if(samount<=1){
		alert("최소 구매수량은 1 입니다.");
		$("#samount"+snum).val(1);	
	}else{
		$("#samount"+snum).val(samount-1);	
		totalprice(snum,price,samount-1);
		$.ajax({
			url : "cartupdate",
			data : {"cart_num" : cart_num , "samount" :samount-1},
			success : function(result){
				if(result==1){
					location.reload();
				}else{
					alert("수량변경 오류");
				}
			}
		});
	}
	
}

function totalprice(snum,price,samount){
	let deleverpay = $("#deleverpay").val();
	let sumprice = parseInt(samount)*parseInt(price)+parseInt(deleverpay);
	let total = sumprice.toLocaleString('ko-KR')+"원";
	$("#totalprice").html(total);
}

function optionchange(pnum,cart_num){
	$("#modalinput").val(pnum);
	$("#modalinputcnum").val(cart_num);
	
	$.ajax({
		url : "viewcolor",
		data : {"pnum" : pnum},
		success : function(result){
			$("#scolor").html(result);
		}
	})
}
/*
function optionchange2(pnum){
	$("#modalinput").val(pnum);
	$.ajax({
		url : "viewcolor",
		data : {"pnum" : pnum},
		success : function(result){
			$("#scolor").html(result);
		}
	})
}
*/
function selectcolor(){
	let color = $("#scolor option:selected").val();
	let pnum = $("#modalinput").val();
	$.ajax({
		url : "../admin/selectcolor",
		data : {"field" : 'productview', "color" : color, "pnum" : pnum} ,
		success : function(result){
			$("#ssize").html(result);
		}
	});
}

function change(){
	let pnum = $("#modalinput").val();
	let color = $("#scolor").val();
	let size = $("#ssize").val();
	let cart_num = $("#modalinputcnum").val();
	$.ajax({
		url : "optionchange",
		data : {"pnum":pnum , "color" : color, "size":size, "cart_num" : cart_num},
		success : function(result){
			if(result.split(",")[0]==1){
				let snum = result.split(",")[1];
				$("#samount"+snum).val(1);
				location.reload();
			}else if(result==0){
				alert("해당 상품은 품절되었습니다.");
			}else if(result==3){
				alert("이미 장바구니에 있는 상품입니다.");
			}else{
				alert("옵션 변경 오류");
			}
		}
	});
}

function optionselect(pnum,wnum){
	$("#modalinput2").val(pnum);
	$("#modalinput2wnum").val(wnum);
	$.ajax({
		url : "viewcolor",
		data : {"pnum" : pnum},
		success : function(result){
			$("#scolor2").html(result);
		}
	})
}

function selectcolor2(){
	let color = $("#scolor2 option:selected").val();
	let pnum = $("#modalinput2").val();
	$.ajax({
		url : "../admin/selectcolor",
		data : {"field" : 'productview', "color" : color, "pnum" : pnum} ,
		success : function(result){
			$("#ssize2").html(result);
		}
	});
}

function select(mid){
	let pnum = $("#modalinput2").val();
	let color = $("#scolor2").val();
	let size = $("#ssize2").val();
	let wnum = $("#modalinput2wnum").val();
	$.ajax({
		url : "findsnum",
		data : {"pnum" : pnum , "color" : color, "size" : size},
		success : function(result){
			if(result==0){
				alert("1장바구니 담기 오류");
			}else{
				let snum=result;
				$.ajax({
					url : "cartadd",
					data : {"mid" : mid , "pnum" : pnum, "snum" : snum, "samount" :1},
					success : function(result){
						if(result==1){
							wishlistdelete(wnum);
						}else if(result==3){
							alert("이미 장바구니에 있는 상품입니다.");
							return;
						}else if(result==0){
							alert("해당 상품은 품절되었습니다.");
						}else{
							alert("장바구니 담기 오류");
						}
					}
				});
			}
		}
	});	
}

function selectAll(selectAll,mid)  {
	
	const checkboxes = document.getElementsByName('cartcheck');
	  
	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked;
	})
	if(selectAll.checked == true){
		$.ajax({
			url : "findcartnum",
			data : {"mid" : mid},
			success : function(result){
				checklist = [];
				let clistsize = result.split("@@")[0];
				let cartnum = result.split("@@")[1];
				for(let i=0; i<clistsize; i++){
					checklist.push(cartnum.split(",")[i]);
				}
				$("#cartnumlist").val(checklist);
			}
		});
		$.ajax({
			url : "cartselect",
			data : {"mid"  : mid},
			success : function(result){
				if(result==0){
					
				}else{
					let a = parseInt(result.split(",")[0]);
					let b = parseInt(result.split(",")[1]);
					let c = parseInt($("#deleverpay").val());
					let total2 = a.toLocaleString('ko-KR')+"원";
					let totalsavemoney2 =b.toLocaleString('ko-KR')+"원";
					let totalsum = (a+c).toLocaleString('ko-KR')+"원";
					let delievr = c.toLocaleString('ko-KR')+"원";
					$("#delievr").html(delievr);
					$("#total").html(total2);
					$("#totalsavemoney").html(totalsavemoney2);
					$("#sum").html(totalsum);
				}
			
			}
		});
	}else{
		checklist = [];
		$("#cartnumlist").val(checklist);
		$("#total").html("");
		$("#totalsavemoney").html("");
		$("#sum").html("");
	}
}
let checklist = [];

function check(box,cart_num){
	let a=0;
	let b=0;
	let c = parseInt($("#deleverpay").val());
	if(box.checked == true){
		checklist.push(box.value);
		$("#cartnumlist").val(checklist);
		for(let i=0; i<checklist.length; i++){
			$.ajax({
				url : "cartselect",
				data : {"cart_num" : checklist[i], "mid" : 0},
				success : function(result){
					a += parseInt(result.split(",")[0]);
					b += parseInt(result.split(",")[1]);
					let total2 = a.toLocaleString('ko-KR')+"원";
					let totalsavemoney2 =b.toLocaleString('ko-KR')+"원";
					let totalsum = (a+c).toLocaleString('ko-KR')+"원";
					let delievr = c.toLocaleString('ko-KR')+"원";
					$("#delievr").html(delievr);
					$("#total").html(total2);
					$("#totalsavemoney").html(totalsavemoney2);
					$("#sum").html(totalsum);
				}
			});
		}
		
		
	}
		
	else{
		for(let i=0; i<checklist.length; i++){
			if(checklist[i] == box.value){
				checklist.splice(i, 1);
				$("#cartnumlist").val(checklist);
				if(checklist.length == 0){
					$("#total").html("");
					$("#totalsavemoney").html("");
					$("#sum").html("");
				}else{
					for(let i=0; i<checklist.length; i++){
						$.ajax({
							url : "cartselect",
							data : {"cart_num" : checklist[i], "mid" : 0},
							success : function(result){
								a += parseInt(result.split(",")[0]);
								b += parseInt(result.split(",")[1]);
								let total2 =a.toLocaleString('ko-KR')+"원";
								let totalsavemoney2 =b.toLocaleString('ko-KR')+"원";
								let totalsum = (a+c).toLocaleString('ko-KR')+"원";
								let delievr = c.toLocaleString('ko-KR')+"원";
								$("#delievr").html(delievr);
								$("#total").html(total2);
								$("#totalsavemoney").html(totalsavemoney2);
								$("#sum").html(totalsum);
							}
						});
					}
				}
				
			}
		}
	}
		
}

function cartclear(mid){
	$.ajax({
			url : "cartselect",
			data : {"mid"  : mid},
			success : function(result){
				if(result==0){
					alert("장바구니에 상품이 없습니다.");
				}else{
					if(confirm("전체 삭제하시겠습니까?")){
						$.ajax({
							url : "cartdelete",
							data : {"mid" : mid, "cart_num" : 0},
							success : function(result){
								if(result==3){
									location.reload();
								}else{
									alert("장바구니 삭제 오류");
								}
							}
						});
					}
				}
			}
	});
}

function selectcartdelete(){
	if(checklist.length==0){
		alert("선택된 상품이 없습니다.");
	}else{
		for(let i=0; i<checklist.length; i++){
			cartdelete(checklist[i]);
		}
	}
	
}

function orderall(mid){
	if(checklist.length==0){
		$.ajax({
			url : "findcartnum",
			data : {"mid" : mid},
			success : function(result){
				checklist = [];
				let clistsize = result.split("@@")[0];
				let cartnum = result.split("@@")[1];
				for(let i=0; i<clistsize; i++){
					checklist.push(cartnum.split(",")[i]);
				}
				$("#cartnumlist").val(checklist);
				location.href = "/jspweb/product/order.jsp?cartnum="+checklist+"&csize="+checklist.length;
			}
		});

	}else{
		location.href = "/jspweb/product/order.jsp?cartnum="+checklist+"&csize="+checklist.length;
	}
	
	
}

function orderselect(mid){
	if(checklist.length==0){
		alert("선택된 상품이 없습니다.");
	}else{
		location.href = "/jspweb/product/order.jsp?cartnum="+checklist+"&csize="+checklist.length;
	}
	
	
}


