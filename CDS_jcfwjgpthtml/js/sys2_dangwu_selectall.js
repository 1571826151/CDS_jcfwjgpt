onload = function(){
	changeSearch('dv2_1', 1);
	changeSearch('dv2_2', 2);
	function changeSearch(oDiv,num){
		var dv2 = document.getElementById(oDiv);
		dv2.onclick = function(){
			waitPic.style.display = 'block';
			table.innerHTML = "<tr><th>文件序号</th><th>所属地区</th><th>文件时间</th><th>文件名称</th><th>操作</th><th>操作</th></tr>";
			var oDivdv2 = document.getElementsByClassName('changediv');
			for (var i=0;i<oDivdv2.length;i++) {
				oDivdv2[i].style.cssText = "background:;color:;";
			}
			dv2.style.cssText = "background:#ff5000;color: #ffe4dc;";
				var url = "/CDS_jcfwjgpt/Sys2_dangwu_selectall";
				var str = "党务公开";
				var arr = {
					"str":str,
					"num":num
				};
				$.post(
					url,
					{"data":JSON.stringify(arr)},
					function(data){
						var list = $.parseJSON(data);
						waitPic.style.display = 'none';
						for (i in list) {
							var olist = list[i];
							var tr = document.createElement('tr');
							tr.setAttribute("class","otr");
							if(num==1){
								tr.innerHTML="<td>"+olist.gongkai_qu_id+"</td><td>"+olist.qu_id+"</td><td>"+olist.gongkai_qu_time+"</td><td>"+olist.gongkai_qu_name+"</td><td><span id="+olist.gongkai_qu_id+" style='cursor: pointer;' class='ospan'>查看详细</span></td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
							}else if(num==2){
								tr.innerHTML="<td>"+olist.gongkai_jie_id+"</td><td>"+olist.jiedao_id+"</td><td>"+olist.gongkai_jie_time+"</td><td>"+olist.gongkai_jie_name+"</td><td><span id="+olist.gongkai_jie_id+" style='cursor: pointer;' class='ospan'>查看详细</span></td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
							}
							table.appendChild(tr);
						}
						var ospan = document.getElementsByClassName('ospan');
						for(let i=0;i<ospan.length;i++){
							ospan[i].onclick = function(){
								var ospan_id = ospan[i].getAttribute("id");
								var windowwidth = (screen.availWidth) * 0.7;
								var windowheight = (screen.availHeight) * 0.7;
								var marginleft = (screen.availWidth) * 0.15;
								var marginright = (screen.availHeight) * 0.1;
								var gopage = "sys2_selectmore.html?ospan_id=" + ospan_id + "&num=" + num + "&type=dangwu";
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
	
	//表格
	var tables = document.getElementsByTagName('tr');
	for(var i=2;i<tables.length;i=i+2){
		tables[i].style.background = "gainsboro";
	}
	

	
}
