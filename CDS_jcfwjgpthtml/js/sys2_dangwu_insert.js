onload = function(){
	//实例化编辑器
    var um = UM.getEditor('myEditor');
    um.addListener('blur',function(){
        $('#focush2').html('编辑器失去焦点了')
    });
    um.addListener('focus',function(){
        $('#focush2').html('')
    });

	
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
	
	var btn1 = document.getElementById('btn1');
	btn1.onclick = function(){
		var arr = [];
		arr.push(UM.getEditor('myEditor').getContent());
		if(showjiedao.style.display == 'none'){
			var objS = document.getElementById("select2");
			var number = 1;
		}else if(showjiedao.style.display == 'block'){
			var objS = document.getElementById("select3");
			var number = 2;
		}
		
		var oinp1 = inp1.value;
		var oinp2 = inp2.value;
		var oinp3 = inp3.value;
		var oOption = objS.options[objS.selectedIndex].value;
		var json ={	"inp1_id":oinp1,
					"inp2_time":oinp2,
					"inp3_type":"党务公开",
					"inp4_name":oinp3,
					"inp5_text":arr,
					"inp6_oOption":oOption,
					"number":number
				  }
		var url = "/CDS_jcfwjgpt/Sys2_dangwu_insert";
		$.post(
			url,
			{"data":JSON.stringify(json)},
			function(data){
				alert(data);
			}
		);
	}
	
}
