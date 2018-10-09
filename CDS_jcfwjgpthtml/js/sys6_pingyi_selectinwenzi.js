onload = function(){
	var url = window.location.search;
	var json1 = {};
	var url1 = url.slice("1").split("&");
	for (var i=0;i<url1.length;i++) {
		var url2 = url1[i].split("=");
		json1[url2[0]] = decodeURI(url2[1]);
	}
	
	var url = "/CDS_jcfwjgpt/Sys6_pingyi_selectinwenzi";
	
	$.post(
		url,
		{"data":JSON.stringify(json1)},
		function(data){
			var list = $.parseJSON(data);
			for(var i in list){
				var olist = list[i];
				ospan1.innerHTML = olist.pinyi_title;
				ospan2.innerHTML = olist.pinyi_dept;
				ospan3.innerHTML = olist.pinyi_begin;
				ospan4.innerHTML = olist.pinyi_end;
				odiv2_1_3_1.innerHTML = olist.pinyi_text;
			}
		}
	)
}
