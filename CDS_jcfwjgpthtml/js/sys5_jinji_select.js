onload = function(){
	changeSearch('dv2_1', 1);
	changeSearch('dv2_2', 2);
	changeSearch('dv2_3', 3);
	changeSearch('dv2_4', 4);
	
	changeopacity('jinji1');
	changeopacity('jinji2');
	changeopacity('jinji3');
	function changeopacity(ojinji){
		var ojinji = document.getElementById(ojinji);
		ojinji.onclick = function(){
			var oDivdv2 = document.getElementsByClassName('dvjinji');
			for (var i=0;i<oDivdv2.length;i++) {
				oDivdv2[i].style.cssText = "background:;color:;";
			}
			ojinji.style.cssText = "background:#ff5000;color: #ffe4dc;";
			
			var wodiv = document.getElementById('wodiv');
			var wodivopacity = getComputedStyle(wodiv , false)['opacity'];
				var t = setInterval(function(){
					if(wodivopacity == 0.02	){
						clearInterval(t);
						var q = setInterval(function(){
							wodiv.style.opacity = wodivopacity;
							wodivopacity = accAdd(wodivopacity , 0.02);
							if(wodivopacity == 1.02){
								clearInterval(q);
							}
						} , 2);
					}
					wodiv.style.opacity = wodivopacity;
					wodivopacity = accSub(wodivopacity , 0.02);
					
				} , 0.5);
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
