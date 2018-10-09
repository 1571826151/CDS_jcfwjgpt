onload = function(){
	Searchtable('btn1', 'inp1' , '1');
	Searchtable('btn2', 'inp2' , '2');
	Searchtable('btn3', 'inp3' , '3');
	function Searchtable(btn , inp , num){
		var btn = document.getElementById(btn);
		btn.onclick = function(){
//			waitPic.style.display = "block";
			var inp1 = document.getElementById(inp);
			var oinp = inp1.value;
			var arr = {"inp":oinp,"str":num};
			var url = "/CDS_jcfwjgpt/Sys_user_select";
			$.post(
				url,
				{"data":JSON.stringify(arr)},
				function(data1){
					table.innerHTML="<tr><th>手机号</th><th>姓名</th><th>密码</th><th>生日</th><th>性别</th><th>邮箱</th><th>所属区</th><th>所属街道</th><th>操作</th></tr>"
					var list = $.parseJSON(data1);
//					nextdiv.removeChild(document.getElementById('waitPic'));
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
		}
	}
	
	changeSearch('dv2_1', 1);
	changeSearch('dv2_2', 2);
	changeSearch('dv2_3', 3);
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
}
