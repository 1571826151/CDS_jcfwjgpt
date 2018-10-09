onload = function(){
	//?id=1
	var url = window.location.search;
	var json1 = {};
	var url1 = url.slice("1").split("&");
	for (var i=0;i<url1.length;i++) {
		var url2 = url1[i].split("=");
		json1[url2[0]] = url2[1];
	}
	var url = "/CDS_jcfwjgpt/Sys6_letter_back";
	$.post(
		url,
		{"data":JSON.stringify(json1)},
		function(data){
			var arr = data.split("+");
			var list = JSON.parse(arr[0]);
			if(arr[1] == 'block'){
				backshow.style.display = "block";
				backinput.style.display = "none";
			}else if(arr[1] == 'none'){
				backshow.style.display = "none";
				backinput.style.display = "block";
			}
//			var middle = document.getElementById('middle');
//			var waitPic = document.getElementById('waitPic');
//			middle.removeChild(waitPic);
			for (var i in list) {
				ospan1.innerHTML=list[i].lettergo_title;
				ospan2.innerHTML=list[i].lettergo_time;
				ospan3.innerHTML=list[i].lettergo_name;
				ospan4.innerHTML=list[i].lettergo_phone;
				ospan5.innerHTML=list[i].lettergo_addressee;
				odiv2_1_3_1.innerHTML=list[i].lettergo_text;
			}
			
			
			if(backshow.style.display == 'block' && backinput.style.display == 'none'){
				var json2 = json1;
				json2["num"] = "111";
				var url = "/CDS_jcfwjgpt/Sys6_letter_selectOrinsert";
				$.post(
					url,
					{"data":JSON.stringify(json2)},
					function(data){
						var list = $.parseJSON(data);
						for (var i in list) {
							back_span1.innerHTML=list[i].letterback_dept;
							back_span2.innerHTML=list[i].letterback_time;
							back_span3.innerHTML=list[i].letterback_title;
							odiv2_1_3_2.innerHTML=list[i].letterback_text;
						}
					}
				);
			}else if(backinput.style.display == 'block' && backshow.style.display == 'none'){
				var btn = document.getElementById('btn');
				btn.onclick = function(){
					var json2 = json1;
					json2["num"] = "222";
					var inp1 = document.getElementById('inp1').value;
					var inp2 = document.getElementById('inp2').value;
					var inp3 = document.getElementById('inp3').value;
					var otextarea = document.getElementById('otextarea').value;
					json2["inp1"] = inp1;
					json2["inp2"] = inp2;
					json2["inp3"] = inp3;
					json2["otextarea"] = otextarea;
					var url = "/CDS_jcfwjgpt/Sys6_letter_selectOrinsert";
					$.post(
						url,
						{"data":JSON.stringify(json1)},
						function(data){
							if(data == '回复成功'){
								alert("恭喜您，回复成功！");
								backshow.style.display = "block";
								backinput.style.display = "none";
								var json3 = json1;
								json3["num"] = "111";
								var url = "/CDS_jcfwjgpt/Sys6_letter_selectOrinsert";
								$.post(
									url,
									{"data":JSON.stringify(json3)},
									function(data){
										var list = $.parseJSON(data);
										for (var i in list) {
											back_span1.innerHTML=list[i].letterback_dept;
											back_span2.innerHTML=list[i].letterback_time;
											back_span3.innerHTML=list[i].letterback_title;
											odiv2_1_3_2.innerHTML=list[i].letterback_text;
										}
									}
								);
							}else if(data == '回复失败'){
								alert("抱歉,回复失败,请重新输入");
							}
						}
					);
				}
				
			}
		}
	);
	
	function btngo(btn){
		var obtn = document.getElementById(btn);
		obtn.onclick = function(){
			var inp1 = document.getElementById('inp1').value;
			var inp2 = document.getElementById('inp2').value; 
			var inp3 = document.getElementById('inp3').value; 
			var otextarea = document.getElementById('otextarea').value;
			var goinp = {"inp1":inp1,"inp2":inp2,"otextarea":otextarea};
			var url = "/CDS_jcfwjgpt/Sys6_letter_selectOrinsert";
			$.post(
				url,
				{"data":JSON.stringify(goinp)},
				function(data){
					
				}
			);
		}
	}
}
