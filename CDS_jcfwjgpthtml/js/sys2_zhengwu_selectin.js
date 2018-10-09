onload = function(){
	changeSearch1('div2_1',middle1,middle2);
	changeSearch1('div2_2',middle2,middle1);
	
	changeSearch('dv2_1', 1);
	changeSearch('dv2_2', 2);
	changeSearch('dv2_3', 3);
	changeSearch('dv2_4', 4);
	changeSearch('dv2_5', 1);
	changeSearch('dv2_6', 2);
	changeSearch('dv2_7', 3);
	changeSearch('dv2_8', 4);
	
 	Searchtable('btn1', 'inp1' , function(){
 		if(middle1.style.display=='none' && middle2.style.display=='block'){
 			return 5;
 		}else if(middle2.style.display=='none' && middle1.style.display=='block'){
 			return 1;
 		}
 	});
	Searchtable1('btn2', 'doDate' , 'doDate1' , function(){
		if(middle1.style.display=='none' && middle2.style.display=='block'){
 			return 6;
 		}else if(middle2.style.display=='none' && middle1.style.display=='block'){
 			return 2;
 		}
	});
	
	Searchtable('btn3', 'inp3' , function(){
 		if(middle1.style.display=='none' && middle2.style.display=='block'){
 			return 7;
 		}else if(middle2.style.display=='none' && middle1.style.display=='block'){
 			return 3;
 		}
 	});
	Searchtable('btn4', 'inp4' , function(){
 		if(middle1.style.display=='none' && middle2.style.display=='block'){
 			return 8;
 		}else if(middle2.style.display=='none' && middle1.style.display=='block'){
 			return 4;
 		}
 	});
	function Searchtable(btn , inp , fn){
		
		var btn = document.getElementById(btn);
		btn.onclick = function(){
			num = fn();
//			waitPic.style.display = "block";
			var inp1 = document.getElementById(inp);
			var oinp = inp1.value;
			var arr = {"inp":oinp,"str":num};
			var url = "/CDS_jcfwjgpt/Sys2_zhengwu_select";
			$.post(
				url,
				{"data":JSON.stringify(arr)},
				function(data1){
					table.innerHTML="<tr><th>文件序号</th><th>编辑时间</th><th>所属地区</th><th>文档名称</th><th>查看详细</th><th>删除</th></tr>";
					var list = $.parseJSON(data1);
//					next3_4_1.removeChild(document.getElementById('waitPic'));
					for(i in list){
						var olist = list[i];
						var tr = document.createElement('tr');
						if(num=='1'||num=='2'||num=='3'||num=='4'){
							tr.innerHTML="<td>"+olist.gongkai_qu_id+"</td><td>"+olist.gongkai_qu_time+"</td><td>"+olist.qu_id+"</td><td>"+olist.gongkai_qu_name+"</td><td><span id="+olist.gongkai_qu_id+" style='cursor: pointer;' class='ospan'>查看详细</span></td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
						}else if(num=='5'||num=='6'||num=='7'||num=='8'){
							tr.innerHTML="<td>"+olist.gongkai_jie_id+"</td><td>"+olist.gongkai_jie_time+"</td><td>"+olist.jiedao_id+"</td><td>"+olist.gongkai_jie_name+"</td><td><span id="+olist.gongkai_jie_id+" style='cursor: pointer;' class='ospan'>查看详细</span></td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
						}

						table.appendChild(tr);
					}
					
					var gonum;
					if(num=='1'||num=='2'||num=='3'||num=='4'){
						gonum = '1';
					}else if(num=='5'||num=='6'||num=='7'||num=='8'){
						gonum = '2';
					}
					var ospan = document.getElementsByClassName('ospan');
					for(let i=0;i<ospan.length;i++){
						ospan[i].onclick = function(){
							var ospan_id = ospan[i].getAttribute("id");
							var windowwidth = (screen.availWidth) * 0.7;
							var windowheight = (screen.availHeight) * 0.7;
							var marginleft = (screen.availWidth) * 0.15;
							var marginright = (screen.availHeight) * 0.1;
							var gopage = "sys2_selectmore.html?ospan_id=" + ospan_id + "&num=" + gonum + "&type=zhengwu";
							window.open(gopage,"_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +",toolbar=no,menubar=no,scrollbars=yes,location=yes,status=yes");
						}
					}
					//表格
					var tables = document.getElementsByTagName('tr');
					for(var i=2;i<tables.length;i=i+2){
						tables[i].style.background = "gainsboro";
						var odeletetd = document.getElementsByClassName('deletetd')
						for(let i=0;i<odeletetd.length;i++){
							odeletetd[i].onclick = function(){
								//删除Servlet
							}
						}
					}
				}
			);
		}
	}
	function Searchtable1(btn , inp , inp1 , fn){
		
		var btn = document.getElementById(btn);
		btn.onclick = function(){
			num = fn();
//			waitPic.style.display = "block";
			var inp_1 = document.getElementById(inp);
			var inp_2 = document.getElementById(inp1)
			var oinp = inp_1.value;
			var oinp1 = inp_2.value;
			var arr = {"inp_1":oinp,"inp_2":oinp1,"str":num};
			var url = "/CDS_jcfwjgpt/Sys2_zhengwu_select";
			$.post(
				url,
				{"data":JSON.stringify(arr)},
				function(data1){
					table.innerHTML="<tr><th>文件序号</th><th>编辑时间</th><th>所属地区</th><th>文档名称</th><th>查看详细</th><th>删除</th></tr>";
					var list = $.parseJSON(data1);
//					nextdiv.removeChild(document.getElementById('waitPic'));
					for(i in list){
						var olist = list[i];
						var tr = document.createElement('tr');
						if(num=='1'||num=='2'||num=='3'||num=='4'){
							tr.innerHTML="<td>"+olist.gongkai_qu_id+"</td><td>"+olist.gongkai_qu_time+"</td><td>"+olist.qu_id+"</td><td>"+olist.gongkai_qu_name+"</td><td>查看详细</td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
						}else if(num=='5'||num=='6'||num=='7'||num=='8'){
							tr.innerHTML="<td>"+olist.gongkai_jie_id+"</td><td>"+olist.gongkai_jie_time+"</td><td>"+olist.jiedao_id+"</td><td>"+olist.gongkai_jie_name+"</td><td>查看详细</td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
						}

						table.appendChild(tr);
					}
					//表格
					var tables = document.getElementsByTagName('tr');
					for(var i=2;i<tables.length;i=i+2){
						tables[i].style.background = "gainsboro";
						var odeletetd = document.getElementsByClassName('deletetd')
						for(let i=0;i<odeletetd.length;i++){
							odeletetd[i].onclick = function(){
								//删除Servlet
							}
						}
					}
				}
			);
		}
	}
	function changeSearch1(oDiv,ospan1,ospan2){
		var dv2 = document.getElementById(oDiv);
		dv2.onclick = function(){
			var oDivdv2 = document.getElementsByClassName('changediv');
			for (var i=0;i<oDivdv2.length;i++) {
				oDivdv2[i].style.cssText = "background:;color:;";
			}
			dv2.style.cssText = "background:#ff5000;color: #ffe4dc;";
			ospan1.style.display = 'block';
			ospan2.style.display = 'none';
		}
	}
	
	
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
	
	
	
	
}
