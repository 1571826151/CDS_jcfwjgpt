onload = function(){
	var url = window.location.search;
	var json1 = {};
	var url1 = url.slice("1").split("&");
	for (var i=0;i<url1.length;i++) {
		var url2 = url1[i].split("=");
		json1[url2[0]] = decodeURI(url2[1]);
	}
	var url = "/CDS_jcfwjgpt/Sys6_pingyi_selectinxuanxiang";
	$.post(
		url,
		{"data":JSON.stringify(json1)},
		function(data){
			var data1 = data.split("+")[0];
			var data2 = data.split("+")[1];
			var list1 = $.parseJSON(data1);
			var list2 = $.parseJSON(data2);
			for(var i in list1){
				var list_1 = list1[i];
				ospan1.innerHTML = list_1.pinyi_title;
				ospan2.innerHTML = list_1.pinyi_dept;
				ospan3.innerHTML = list_1.pinyi_begin;
				ospan4.innerHTML = list_1.pinyi_end;
				odiv2_1_3_1.innerHTML = list_1.pinyi_text;
			}
			for(var j in list2){
				var list_2 = list2[j];
				var odiv = document.createElement('div');
				odiv.setAttribute("class","odiv2_1");
				odiv.innerHTML="<div class=\"odiv2_1_31 float\">"+list_2.pinyiItem_name+"</div><div class=\"odiv2_1_41 float\"><span id=\"aspan1\" style=\"margin-left: 10px;\">20</span></div>";
				showdiv.appendChild(odiv);
			}
		}
	);
}
