onload = function(){
	changeSearch('dv2_1', 1);
	changeSearch('dv2_2', 2);
	
	
	
	function changeSearch(oDiv,num){
		var dv2 = document.getElementById(oDiv);
		dv2.onclick = function(){
			var oDivdv2 = document.getElementsByClassName('dv2');
			for (var i=0;i<oDivdv2.length;i++) {
				oDivdv2[i].style.cssText = "background:;color:;";
			}
			dv2.style.cssText = "background:#ff5000;color: #ffe4dc;";
			var sea_1 = document.getElementsByClassName('sea_1');
			for (var i=0;i<sea_1.length;i++) {
				sea_1[i].style.display='none';
			}
			
			sea_1[num-1].style.display='block';
		}
	}
	
	
	function showTime(){
		var oDate = new Date();
		var year = oDate.getFullYear();
		var month = oDate.getMonth() + 1;
		var day = oDate.getDate();
		if(month > 0&&month <9){
			month = '0' + month; 
		}
		if(day > 0&&day <9){
			day = '0' + day; 
		}
		return year+"-"+month+"-"+day;
	}
	document.getElementById('doDate').value = showTime();
	document.getElementById('doDate1').value = showTime();
	
	
	
	//表格
	var tables = document.getElementsByTagName('tr');
	for(var i=2;i<tables.length;i=i+2){
		tables[i].style.background = "gainsboro";
	}
	
	
	
	pagination(8 , 1);
	function pagination(total, current) {
		var div3 = document.getElementById("jsPagination");
		var str="";
		var i;
		if(total>5){
			if(current<total-2 && current>=4){
				str = str + "<li>首页</li>"
				for(i=current-2;i<=current+2;i++){
					str = str+"<li id=\"btn"+ i + "\">"+i+"</li>";
				}
				str = str + "<li>末页</li>"
				div3.innerHTML = str;
			}else if(current>=total-2 && current<=total){
				str = str + "<li>首页</li>"
				for(i=total-4;i<=total;i++){
					str = str+"<li id=\"btn"+ i + "\">"+i+"</li>";
				}
				div3.innerHTML = str;
			}else if(current>=1&&current<4){
				for(i=1;i<=5;i++){
					str = str+"<li id=\"btn"+ i + "\">"+i+"</li>";
				}
				str = str + "<li>末页</li>"
				div3.innerHTML = str;
			}
			var btn = document.getElementById("btn"+current);
			btn.style="background: #00bc9b;color: #ffffff;";
		}else if(total<=5 && total>0){
			for(i=1;i<=total;i++){
				str = str+"<li id=\"btn"+ i + "\">"+i+"</li>";
			}
			div3.innerHTML = str;
			var btn = document.getElementById("btn"+current);
			btn.style="background: #00bc9b;color: #ffffff;";
		}else if(total==0){
			div3.className='pagination hide';
		}
		
	}
	
	
	btn1.onclick = function(){
		table.innerHTML = "";
		waitPic.style.display = 'block';
		var num = 111;
		var oinp = document.getElementById('oinp').value;
		
		var arr = {
			"num":num,
			"oinp":oinp
		}
		var url = "/CDS_jcfwjgpt/Sys6_pingyi_select";
		$.post(
			url,
			{"data":JSON.stringify(arr)},
			function(data){
				waitPic.style.display = 'none';
				table.innerHTML = "<tr><th>投票序号</th><th>投票名称</th><th>开始时间</th><th>结束时间</th><th>类型</th><th>操作</th><th>操作</th></tr>";
				var json1 = $.parseJSON(data);
				for(var i in json1){
					var list = json1[i];
					var otr = document.createElement('tr');
					if(list.pinyi_choose == '111'){
						var ochoose = '文字评议';
						var ospan = "<span class=\"span1\" style=\"cursor: pointer;\">查看</span>";
					}else if(list.pinyi_choose == '222'){
						var ochoose = '选项评议';
						var ospan = "<span class=\"span2\" style=\"cursor: pointer;\">查看</span>";
					}
					otr.innerHTML = "<td>"+list.pinyi_id+"</td><td>"+list.pinyi_title+"</td><td>"+list.pinyi_begin+"</td><td>"+list.pinyi_end+"</td><td>"+ochoose+"</td><td>"+ospan+"</td><td>删除</td>";
					table.appendChild(otr);
				}
				var oaspan1 = document.getElementsByClassName('span1');
				var oaspan2 = document.getElementsByClassName('span2');
				if(oaspan1.length != 0){
					for(let i=0;i<oaspan1.length;i++){
						oaspan1[i].onclick = function(){
							var windowwidth = (screen.availWidth) * 0.7;
							var windowheight = (screen.availHeight) * 0.7;
							var marginleft = (screen.availWidth) * 0.15;
							var marginright = (screen.availHeight) * 0.1;
							var gopage = "sys6_pingyi_selectinwenzi.html?title=" + list.pinyi_title ;
							window.open(gopage,"_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +"");
						}
					}
				}
				if(oaspan2.length != 0){
					for(let i=0;i<oaspan2.length;i++){
						oaspan2[i].onclick = function(){
							var windowwidth = (screen.availWidth) * 0.7;
							var windowheight = (screen.availHeight) * 0.7;
							var marginleft = (screen.availWidth) * 0.15;
							var marginright = (screen.availHeight) * 0.1;
							var gopage = "sys6_pingyi_selectinxuanxiang.html?title=" + list.pinyi_title ;
							window.open(gopage,"_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +"");
						}
					}
				}
			}
		)
	}

	btn2.onclick = function(){
		table.innerHTML = "";
		waitPic.style.display = 'block';
		var num = '222';
		var doDate = document.getElementById('doDate').value;
		var doDate1 = document.getElementById('doDate1').value;
		var arr = {
			"num":num,
			"doDate":doDate,
			"doDate1":doDate1
		}
		var url = "/CDS_jcfwjgpt/Sys6_pingyi_select";
		$.post(
			url,
			{"data":JSON.stringify(arr)},
			function(data){
				waitPic.style.display = 'none';
				table.innerHTML = "<tr><th>投票序号</th><th>投票名称</th><th>开始时间</th><th>结束时间</th><th>类型</th><th>操作</th><th>操作</th></tr>";
				var json1 = $.parseJSON(data);
				for(var i in json1){
					var list = json1[i];
					var otr = document.createElement('tr');
					if(list.pinyi_choose == '111'){
						var ochoose = '文字评议';
						var ospan = "<span class=\"span1\" id=\""+ list.pinyi_title +"\" style=\"cursor: pointer;\">查看</span>";
					}else if(list.pinyi_choose == '222'){
						var ochoose = '选项评议';
						var ospan = "<span class=\"span2\" id=\""+ list.pinyi_title +"\" style=\"cursor: pointer;\">查看</span>";
					}
					otr.innerHTML = "<td>"+list.pinyi_id+"</td><td>"+list.pinyi_title+"</td><td>"+list.pinyi_begin+"</td><td>"+list.pinyi_end+"</td><td>"+ochoose+"</td><td>"+ospan+"</td><td>删除</td>";
					table.appendChild(otr);
				}
				var oaspan1 = document.getElementsByClassName('span1');
				var oaspan2 = document.getElementsByClassName('span2');
				if(oaspan1.length != 0){
					for(let i=0;i<oaspan1.length;i++){
						oaspan1[i].onclick = function(){
							var windowwidth = (screen.availWidth) * 0.7;
							var windowheight = (screen.availHeight) * 0.7;
							var marginleft = (screen.availWidth) * 0.15;
							var marginright = (screen.availHeight) * 0.1;
							var gopage = "sys6_pingyi_selectinwenzi.html?title=" + this.getAttribute("id") ;
							window.open(gopage,"_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +"");
						}
					}
				}
				if(oaspan2.length != 0){
					for(let i=0;i<oaspan2.length;i++){
						oaspan2[i].onclick = function(){
							var windowwidth = (screen.availWidth) * 0.7;
							var windowheight = (screen.availHeight) * 0.7;
							var marginleft = (screen.availWidth) * 0.15;
							var marginright = (screen.availHeight) * 0.1;
							var gopage = "sys6_pingyi_selectinxuanxiang.html?title=" + this.getAttribute("id") ;
							window.open(gopage,"_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +"");
						}
					}
				}
			}
		)
	}
}
