onload = function(){
	var toupiaoqu = document.getElementById('toupiaoqu');
	var oimgdelete;
	addxuanxiang.onclick = function(){
		var a = document.createElement('div');
		var lastButton = document.getElementById('lastButton');
		var oinp2_1 = document.getElementsByClassName('inp2_1');
		var num = oinp2_1.length + 1;
		a.className = "inp2_1";
		a.innerHTML = "<img src='img/add.png'/><span class='ospan'>"+ "选项" + num +"</span><input type='text' class='oxxinp' name='' id='xuanxiang"+ num +"' value='' /><img src='img/delete.png' class='imgdelete' style='cursor: pointer;'/>";
		toupiaoqu.insertBefore(a , lastButton);
		oimgdelete = document.getElementsByClassName('imgdelete');
		for(var i=0;i<oimgdelete.length;i++){
			oimgdelete[i].onclick = function(){
				toupiaoqu.removeChild(this.parentNode);
				var odivspan = document.getElementsByClassName('ospan');
				for(var j=0;j<odivspan.length;j++){
					odivspan[j].innerHTML = "选项" + (j+1);
					var getid = "xuanxiang" + (j+1);
					odivspan[j].parentNode.getElementsByTagName('input')[0].setAttribute("id" , getid);
				}
			};
		}
	}
	
	$(function(){
		var url = "/CDS_jcfwjgpt/Query_AllQuName";
		$.post(
			url,
			function(data){
				var list = $.parseJSON(data);
				for(i in list){
					var sysJiedao = list[i];
					var oOption = document.createElement('option');
					oOption.setAttribute("value" , sysJiedao.qu_id);
					oOption.innerHTML = sysJiedao.qu_name;
					select2.appendChild(oOption);
				}
			}
		);
	});
	
	var a = 0;
	$("#select2").change(function(){
		var objS = document.getElementById("select2"); 
	    var value = objS.options[objS.selectedIndex].value;
	    var page = "/CDS_jcfwjgpt/Query_AllJiedaoName";
		$.post(
			page,
			{value},
			function(data){
				var list = $.parseJSON(data);
				if(a == 0){
					for(i in list){
					var sysJiedao = list[i];
					$("#select3").append("<option value="+ sysJiedao.jiedao_id +">" + sysJiedao.jiedao_name + "</option>");	
					}
				}else{
					$("#select3").empty();
					$("#select3").append("<option>- 请选择 -</option>");	
					for(i in list){
					var sysJiedao = list[i];
					$("#select3").append("<option value="+ sysJiedao.jiedao_id +">" + sysJiedao.jiedao_name + "</option>");	
					}
				}
				a = i;
			}
		);
		
	});	
	
	
	qu.onclick = function(){
		showjiedao.style.display = 'none';
	}
	jiedao.onclick = function(){
		showjiedao.style.display = 'block';
	}
	
	
	
	var btn = document.getElementById('btn');
	btn.onclick = function(){
		var inp1 = document.getElementById('inp1').value;
		var inp2 = document.getElementById('inp2').value;
		var startDate = document.getElementById('startDate').value;
		var endDate = document.getElementById('endDate').value;
		var oxxinp = document.getElementsByClassName('oxxinp');
		if(showjiedao.style.display == 'none'){
			var objS = document.getElementById('select2');
			var oOption = objS.options[objS.selectedIndex].value;
			var o_type = "qu";
		}else if(showjiedao.style.display == 'block'){
			var objS = document.getElementById('select3');
			var oOption = objS.options[objS.selectedIndex].value;
			var o_type = "jie";
		}
		var otextarea = document.getElementById('otextarea').value;
		var xxarr = [];
		for(var i=0;i<oxxinp.length;i++){
			var hnum = "xuanxiang" + (i+1);
			
			xxarr.push(document.getElementById(hnum).value);
		}
		console.log(xxarr);
		var json1 = {
			"o_type":o_type,
			"inp1":inp1,
			"inp2":inp2,
			"oOption":oOption,
			"startDate":startDate,
			"endDate":endDate,
			"xxarr":xxarr,
			"otextarea":otextarea
		}
		var url = "/CDS_jcfwjgpt/Sys6_toupiao_insert";
		console.log(json1);
		$.post(
			url,
			{"data":JSON.stringify(json1)},
			function(data){
				alert(data);
			}
		);
		
	}
}
