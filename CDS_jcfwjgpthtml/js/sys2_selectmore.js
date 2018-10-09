onload = function(){
	var url = window.location.search;
	var json1 = {};
	var url1 = url.slice("1").split("&");
	for (var i=0;i<url1.length;i++) {
		var url2 = url1[i].split("=");
		json1[url2[0]] = url2[1];
	}
	var url = "/CDS_jcfwjgpt/Sys2_selectmore";
	$.post(
		url,
		{"data":JSON.stringify(json1)},
		function(data){
			var list = $.parseJSON(data);
			var middle = document.getElementById('middle');
			var waitPic = document.getElementById('waitPic');
			middle.removeChild(waitPic);
			for (var i in list) {
				if(json1["num"] == 1){
					ospan1.innerHTML=list[i].gongkai_qu_id;
					ospan2.innerHTML=list[i].qu_id;
					ospan3.innerHTML=list[i].gongkai_qu_time;
					ospan4.innerHTML=list[i].gongkai_qu_type;
					ospan5.innerHTML=list[i].gongkai_qu_name;
					odiv2_1_3_1.innerHTML=list[i].gongkai_qu_text;
				}else if(json1["num"] == 2){
					ospan1.innerHTML=list[i].gongkai_jie_id;
					ospan2.innerHTML=list[i].jiedao_id;
					ospan3.innerHTML=list[i].gongkai_jie_time;
					ospan4.innerHTML=list[i].gongkai_jie_type;
					ospan5.innerHTML=list[i].gongkai_jie_name;
					odiv2_1_3_1.innerHTML=list[i].gongkai_jie_text;
				}
				
			}
		}
	)
	
}
