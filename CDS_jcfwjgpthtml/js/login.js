$(function(){
	$('#btn').click(function(){
		var input1 = document.getElementById('input1').value;
		var input2 = document.getElementById('input2').value;
		var login = {"name":input1,"pwd":input2};
		var url = "/CDS_jcfwjgpt/LoginService";
		console.log(typeof JSON.stringify(login));
		$.post(
			url,
			{"data":JSON.stringify(login)},
			function(data){
				var list = $.parseJSON(data);
				if(list == "222"){
					window.location.href ="homePage.html";
				}else if(list == "111"){
					alert("抱歉,用户名或密码错误!");
				}
			}
		);
	});
});





onload = function(){
//	js解决计算问题
	function accAdd(arg1, arg2) {
	    var r1, r2, m, c;
	    try {
	        r1 = arg1.toString().split(".")[1].length;
	    }
	    catch (e) {
	        r1 = 0;
	    }
	    try {
	        r2 = arg2.toString().split(".")[1].length;
	    }
	    catch (e) {
	        r2 = 0;
	    }
	    c = Math.abs(r1 - r2);
	    m = Math.pow(10, Math.max(r1, r2));
	    if (c > 0) {
	        var cm = Math.pow(10, c);
	        if (r1 > r2) {
	            arg1 = Number(arg1.toString().replace(".", ""));
	            arg2 = Number(arg2.toString().replace(".", "")) * cm;
	        } else {
	            arg1 = Number(arg1.toString().replace(".", "")) * cm;
	            arg2 = Number(arg2.toString().replace(".", ""));
	        }
	    } else {
	        arg1 = Number(arg1.toString().replace(".", ""));
	        arg2 = Number(arg2.toString().replace(".", ""));
	    }
	    return (arg1 + arg2) / m;
	}
	
	function accSub(arg1, arg2) {
	    if (isNaN(arg1)) {
	        arg1 = 0;
	    }
	    if (isNaN(arg2)) {
	        arg2 = 0;
	    }
	    arg1 = Number(arg1);
	    arg2 = Number(arg2);
	
	    var r1, r2, m, n;
	    try {
	        r1 = arg1.toString().split(".")[1].length;
	    }
	    catch (e) {
	        r1 = 0;
	    }
	    try {
	        r2 = arg2.toString().split(".")[1].length;
	    }
	    catch (e) {
	        r2 = 0;
	    }
	    m = Math.pow(10, Math.max(r1, r2)); //last modify by deeka //动态控制精度长度
	    n = (r1 >= r2) ? r1 : r2;
	    return ((arg1 * m - arg2 * m) / m).toFixed(n);
	}
//	图片轮播代码
	var aOpacity = getComputedStyle(backgr , false)['opacity'];
	var bOpacity = parseFloat(aOpacity);
	function downOpacity(){
		if(bOpacity == 0.01){
			clearInterval(p);
			var q = setInterval(function(){
				bOpacity = accAdd(bOpacity , 0.01);
				backgr.style.opacity = bOpacity;
				if(bOpacity == 1){
					clearInterval(q);
					p = setInterval(downOpacity,50);
				}
			},50);
		}
		bOpacity = accSub(bOpacity , 0.01);
		backgr.style.opacity = bOpacity;
		
	}
	var aOpacity1 = getComputedStyle(backgr1 , false)['opacity'];
	var bOpacity1 = parseFloat(aOpacity1);
	function downOpacity1(){
		
		bOpacity1 = accAdd(bOpacity1 , 0.01);
		backgr1.style.opacity = bOpacity1;
		if(bOpacity1 == 1){
			clearInterval(m);
			var n = setInterval(function(){
		
				bOpacity1 = accSub(bOpacity1 , 0.01);
				backgr1.style.opacity = bOpacity1;
				if(bOpacity1 == 0){
					clearInterval(n);
					m = setInterval(downOpacity1,50);
				}
			},50);
		}
	}
	
	var p = setInterval(downOpacity,50);
	var m = setInterval(downOpacity1,50);
//	获取时间的代码
	var timer = document.getElementById('timer');
	function showTime(){
		var time = new Date();
		var year = time.getFullYear();
		var month =changeTime(time.getMonth());
		var dater =changeTime(time.getDate())
		var hour =changeTime(time.getHours());
		var minute =changeTime(time.getMinutes());
		var seconds =changeTime(time.getSeconds());
		var day =changeDay(time.getDay());
		function changeTime(timer){
			if(timer >=0 && timer<=9){
			timer = '0' + timer;
			}
			return timer;
		}
		function changeDay(day){
			switch (day){
				case 1: day = '星期一'; break;
				case 2: day = '星期二'; break;
				case 3: day = '星期三'; break;
				case 4: day = '星期四'; break;
				case 5: day = '星期五'; break;
				case 6: day = '星期六'; break;
				case 0: day = '星期日'; break;
			}
			return day;
		}
		timer.innerHTML = year+"年"+month+"月"+dater+"日 "+hour+":"+minute+":"+seconds+" "+day;
	}
	showTime();
	setInterval(showTime,1000);
	
	
	btn.onclick = function(){
		if(document.getElementById('input1').value == ""){
			alert("请输入用户名");
			return false;
		}else if(document.getElementById('input2').value == ""){
			alert('请输入密码');
			return false;
		}else{
			var input1 = document.getElementById('input1').value;
			var input2 = document.getElementById('input2').value;
			return true;
		}
		
	}
	
	
	
	var title = document.getElementById('title').innerHTML;
	var str = "";
	for (var i=0;i<title.length;i++) {
		str = str + "<span>" + title[i] + "</span>";
	}
	document.getElementById('title').innerHTML = str;
	var oSpan = document.getElementById('title').getElementsByTagName('span');
	colorGo();
	setInterval(colorGo , 500);
	
	
	
	function colorGo(){
		for(var i=0;i<oSpan.length;i++){
			oSpan[i].style.color = randomColor();
		}
	}
	function randomColor(){
		var a =parseInt(Math.random()*256);
		var b =parseInt(Math.random()*256);
		var c =parseInt(Math.random()*256);
		return "rgb("+a+","+b+","+c+")";
	}
	
}

	
