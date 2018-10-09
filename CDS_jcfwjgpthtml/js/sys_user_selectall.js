onload = function(){
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
	
	$(function show(){
		var url = "/CDS_jcfwjgpt/Sys_user_selectall";
		$.post(
			url,
			function(data){
				var list = $.parseJSON(data);
				nextdiv.removeChild(document.getElementById('waitPic'));
				for(i in list){
					var olist = list[i];
					var tr = document.createElement('tr');
					tr.innerHTML="<td>"+olist.user_phone+"</td><td>"+olist.user_name+"</td><td>"+olist.user_password+"</td><td>"+olist.user_birthday+"</td><td>"+olist.user_sex+"</td><td>"+olist.user_email+"</td><td>"+olist.user_place_qu+"</td><td>"+olist.user_place_jiedao+"</td><td><span class='deletetd' style='cursor: pointer;'>删除</span></td>";
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
	});
	
}
