onload = function(){
	changeSearch('dv2_1', 1);
	changeSearch('dv2_2', 2);
	
	Searchtable('btn1' , 'inp1' , '1');
	Searchtable1('btn2' , 'doDate' , 'doDate1' , '2');
	function Searchtable(btn , inp , num){
		var btn = document.getElementById(btn);
		btn.onclick = function(){
			waitPic.style.display = 'block';
			var oinp = document.getElementById(inp).value;
			var arr = {"inp":oinp,"num":num};
			var url = "/CDS_jcfwjgpt/Sys6_letter_select";
			$.post(
				url,
				{"data":JSON.stringify(arr)},
				function(data){
					var list = $.parseJSON(data);
					waitPic.style.display = 'none';
					table.innerHTML = "<tr><th>来信序号</th><th>来信主题</th><th>来信时间</th><th>操作</th><th>操作</th></tr>";
					for (i in list) {
						var olist = list[i];
						var tr = document.createElement('tr');
						tr.setAttribute("class","otr");
						tr.innerHTML="<td>"+olist.lettergo_id+"</td><td>"+olist.lettergo_time+"</td><td>"+olist.lettergo_title+"</td><td><span id="+olist.lettergo_id+" style='cursor: pointer;' class='ospan'>查看详细</span></td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
						table.appendChild(tr);
					}
					
					var ospan = document.getElementsByClassName('ospan');
					for(let j=0;j<ospan.length;j++){
						ospan[j].onclick = function(){
							var id = ospan[j].getAttribute("id");
							var windowwidth = (screen.availWidth) * 0.7;
							var windowheight = (screen.availHeight) * 0.7;
							var marginleft = (screen.availWidth) * 0.15;
							var marginright = (screen.availHeight) * 0.1;
							var page = "sys6_letter_back.html?id=" + id;
							window.open(page,"_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +"");
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
	
	function Searchtable1(btn , dateStart , dateEnd , num){
		var btn = document.getElementById(btn);
		btn.onclick = function(){
			waitPic.style.display = 'block';
			var odateStart = document.getElementById(dateStart).value;
			var odateEnd   = document.getElementById(dateEnd).value;
			
			var arr = { "odateStart":odateStart,
						"odateEnd":odateEnd,
						"num":num
					  };
			var url = "/CDS_jcfwjgpt/Sys6_letter_select";
			$.post(
				url,
				{"data":JSON.stringify(arr)},
				function(data){
					var list = $.parseJSON(data);
					waitPic.style.display = 'none';
					table.innerHTML = "<tr><th>来信序号</th><th>来信主题</th><th>来信时间</th><th>操作</th><th>操作</th></tr>";
					for (i in list) {
						var olist = list[i];
						var tr = document.createElement('tr');
						tr.setAttribute("class","otr");
						tr.innerHTML="<td>"+olist.lettergo_id+"</td><td>"+olist.lettergo_time+"</td><td>"+olist.lettergo_title+"</td><td><span id="+olist.lettergo_id+" style='cursor: pointer;' class='ospan'>查看详细</span></td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
						table.appendChild(tr);
					}
					
					var ospan = document.getElementsByClassName('ospan');
					for(let j=0;j<ospan.length;j++){
						ospan[j].onclick = function(){
							var id = ospan[j].getAttribute("id");
							var windowwidth = (screen.availWidth) * 0.7;
							var windowheight = (screen.availHeight) * 0.7;
							var marginleft = (screen.availWidth) * 0.15;
							var marginright = (screen.availHeight) * 0.1;
							var page = "sys6_letter_back.html?id=" + id;
							window.open(page,"_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +"");
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
