onload = function(){
	
	changeopacity('pingyi1' , 'bottom1' , 'bottom2');
	changeopacity('pingyi2' , 'bottom2' , 'bottom1');
	
	
	showquAndjiedao(wenzi_select2 , "#wenzi_select2" , "#wenzi_select3");
	showquAndjiedao(xuanxiang_select2 , "#xuanxiang_select2" , "#xuanxiang_select3");
	
	changeType(wenzi_qu , wenzi_jiedao , wenzi_showjiedao);
	changeType(xuanxiang_qu , xuanxiang_jiedao , xuanxiang_showjiedao);
	
	function changeopacity(ojinji , bottom1 , bottom2){
		var ojinji = document.getElementById(ojinji);
		ojinji.onclick = function(){
			var oDivdv2 = document.getElementsByClassName('dvjinji');
			for (var i=0;i<oDivdv2.length;i++) {
				oDivdv2[i].style.cssText = "background:;color:;";
			}
			ojinji.style.cssText = "background:#ff5000;color: #ffe4dc;";
			var obottom1 = document.getElementById(bottom1);
			var obottom2 = document.getElementById(bottom2);
			obottom1.style.display = 'block';
			obottom2.style.display = 'none';
		}
	}
	
	var toupiaoqu = document.getElementById('toupiaoqu');
	var oimgdelete = document.getElementsByClassName('imgdelete');
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
	
	function showquAndjiedao(select2 , select2_1 , select3){
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
		$(select2_1).change(function(){
		    var value = select2.options[select2.selectedIndex].value;
		    var page = "/CDS_jcfwjgpt/Query_AllJiedaoName";
			$.post(
				page,
				{value},
				function(data){
					var list = $.parseJSON(data);
					if(a == 0){
						for(i in list){
						var sysJiedao = list[i];
						$(select3).append("<option value="+ sysJiedao.jiedao_id +">" + sysJiedao.jiedao_name + "</option>");	
						}
					}else{
						$(select3).empty();
						$(select3).append("<option>- 请选择 -</option>");	
						for(i in list){
						var sysJiedao = list[i];
						$(select3).append("<option value="+ sysJiedao.jiedao_id +">" + sysJiedao.jiedao_name + "</option>");	
						}
					}
					a = i;
				}
			);
		});	
	}
	
	
	function changeType(qu , jiedao , showjiedao){
		qu.onclick = function(){
			showjiedao.style.display = 'none';
		}
		jiedao.onclick = function(){
			showjiedao.style.display = 'block';
		}
	}
	
//	btngo(wenzi_btn);
//	btngo(xuanxiang_btn);
//	function btngo(btn){
	wenzi_btn.onclick = function(){
		var wenzi_inp1 = document.getElementById('wenzi_inp1').value;
		var wenzi_inp2 = document.getElementById('wenzi_inp2').value;
		if(wenzi_showjiedao.style.display == 'none'){
			var objS = document.getElementById('wenzi_select2');
			var oOption = objS.options[objS.selectedIndex].value;
			var o_type = "qu";
		}else if(wenzi_showjiedao.style.display == 'block'){
			var objS = document.getElementById('wenzi_select3');
			var oOption = objS.options[objS.selectedIndex].value;
			var o_type = "jie";
		}
		var startTime = document.getElementById('wenzi_startTime').value;
		var endTime = document.getElementById('wenzi_endTime').value;
		var wenzi_otextarea = document.getElementById('wenzi_otextarea').value;
		var pinyi_choose = "文字评议";
		var json1 = {
			"wenzi_inp1":wenzi_inp1,
			"wenzi_inp2":wenzi_inp2,
			"oOption":oOption,
			"o_type":o_type,
			"startTime":startTime,
			"endTime":endTime,
			"wenzi_otextarea":wenzi_otextarea,
			"pinyi_choose":pinyi_choose
		}
		console.log(json1);
		var url = "/CDS_jcfwjgpt/Sys6_pingyi_insert";
		$.post(
			url,
			{"data":JSON.stringify(json1)},
			function(data){
				alert(data);
			}
		);
	}
//	}
	
	xuanxiang_btn.onclick = function(){
		var xuanxiang_inp1 = document.getElementById('xuanxiang_inp1').value;
		var xuanxiang_inp2 = document.getElementById('xuanxiang_inp2').value;
		if(xuanxiang_showjiedao.style.display == 'block'){
			var objS = document.getElementById('xuanxiang_select3');
			var oOption = objS.options[objS.selectedIndex].value;
			var o_type = "jie";
		}else if(xuanxiang_showjiedao.style.display == 'none'){
			var objS = document.getElementById('xuanxiang_select2');
			var oOption = objS.options[objS.selectedIndex].value;
			var o_type = "qu";
		}
		var startTime = document.getElementById('xuanxiang_startTime').value;
		var endTime = document.getElementById('xuanxiang_endTime').value;
		var pinyi_choose = "选项评议";
		var arr = [];
		var oxxinp = document.getElementsByClassName('oxxinp');
		for (var i=1;i<=oxxinp.length;i++) {
			var oinp = "xuanxiang" + i;
			var oxuanxiang = document.getElementById(oinp).value;
			arr.push(oxuanxiang);
		}
		var otextarea = document.getElementById('xuanxiang_otextarea').value;
		
		var json1 = {
			"xuanxiang_inp1":xuanxiang_inp1,
			"xuanxiang_inp2":xuanxiang_inp2,
			"oOption":oOption,
			"o_type":o_type,
			"startTime":startTime,
			"endTime":endTime,
			"arr":arr,
			"otextarea":otextarea,
			"pinyi_choose":pinyi_choose
		};
		console.log(JSON.stringify(json1));
		var url = "/CDS_jcfwjgpt/Sys6_pingyi_insert";
		$.post(
			url,
			{"data":JSON.stringify(json1)},
			function(data){
				alert(data);
			}
		);
		
	}
}
