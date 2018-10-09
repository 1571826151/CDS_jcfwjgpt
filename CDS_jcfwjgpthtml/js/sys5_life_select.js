onload = function(){
	
	pagination(8 , 1);
	
	span1.onclick = function(){
		var windowwidth = (screen.availWidth) * 0.7;
		var windowheight = (screen.availHeight) * 0.7;
		var marginleft = (screen.availWidth) * 0.15;
		var marginright = (screen.availHeight) * 0.1;
		window.open("sys5_life_selectmore.html","_blank","width="+ windowwidth + ",height="+ windowheight +",left="+ marginleft + ",top=" + marginright +"");
	}
	
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
