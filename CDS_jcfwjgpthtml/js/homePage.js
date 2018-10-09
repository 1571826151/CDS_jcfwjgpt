$(function(){
	var url = "/CDS_jcfwjgpt/GetSession";
	$.post(
		url,
		function(data){
			var list = data;
			user.innerHTML = list;
		}
	);
});
	
onload = function(){
	cancel.onclick=function(){
		var url = "/CDS_jcfwjgpt/DeleteSession";
		$.post(
			url,
			function(data){
				if(data == '已销毁'){
					alert("您已退出登录,3秒后退回首页！");
					setTimeout(function(){
						window.location.href="index.html";
					},3000);
				}else{
					
				}
			}
		);
	}
//	获取时间
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
//	下拉菜单控件功能
	
	huiyuan.onclick = function(){
		var arr = huiyuanxiala.style.display;
		displayNone();
		if(arr == 'none'){
			huiyuanxiala.style.display = 'block';
			document.getElementById('icon1').style.backgroundPosition = '0px -21px';
			var sock = document.getElementsByClassName('sock');
			for(var i=0;i<sock.length;i++){
				sock[i].style.backgroundImage = randomPic();
			}
		}else{
			huiyuanxiala.style.display = 'none';
			document.getElementById('icon1').style.backgroundPosition = '0px 0px';			
		}
	}
	displaygo(zhengce , zhengcexiala , 'icon2' , displayNone);
	displaygo(jiceng , jicengxiala , 'icon3' , displayNone);
	displaygo(jiandu , jianduxiala , 'icon4' , displayNone);
	displaygo(fuwu , fuwuxiala , 'icon5' , displayNone);
	displaygo(goutong , goutongxiala , 'icon6' , displayNone);
	
	displaygo_2(zc , zcxiala , 'sock', 'icon_1' , randomPic );
	displaygo_2(jiedu , jieduxiala , 'sock', 'icon_2' , randomPic );
	displaygo_2(fagui , faguixiala , 'sock', 'icon_3' , randomPic );
	displaygo_2(dangwu , dangwuxiala , 'sock' , 'icon_4' ,  randomPic );
	displaygo_2(zhengwu , zhengwuxiala , 'sock', 'icon_5' , randomPic );
	displaygo_2(jijian , jijianxiala , 'sock', 'icon_6' , randomPic );
	displaygo_2(zuzhi , zuzhixiala , 'sock', 'icon_7' , randomPic );
	displaygo_2(jiefang , jiefangxiala , 'sock', 'icon_8' , randomPic );
	displaygo_2(jinji , jinjixiala , 'sock', 'icon_9' , randomPic );
	displaygo_2(baixing , baixingxiala , 'sock', 'icon_10' , randomPic );
	displaygo_2(xinxiang , xinxiangxiala , 'sock', 'icon_11' , randomPic );
	displaygo_2(toupiao , toupiaoxiala , 'sock', 'icon_12' , randomPic );
	displaygo_2(pingyi , pingyixiala , 'sock', 'icon_13' , randomPic );
	
	document.body.style.height = window.screen.height - 1 + "px";
	document.getElementById('top').style.width = (document.body.clientWidth  - 6) + 'px';
	document.getElementById('hr').style.width = (document.body.clientWidth - 6) + 'px';
	document.getElementById('middle').style.width = (document.body.clientWidth) + 'px';
	var left = document.getElementById('left');
	var oWidth = getComputedStyle(left,false)['width'];
	document.getElementById('right').style.width = (document.body.clientWidth - parseInt(oWidth) - 16) + 'px';
		
	changeIframe('alluser' , 'sys_user_selectall.html');
	changeIframe('inuser' , 'sys_user_selectin.html');
	changeIframe('wenjian_insert' , 'sys1_wenjian_insert.html');
	changeIframe('wenjian_select' , 'sys1_wenjian_select.html');
	changeIframe('jiedu_insert' , 'sys1_jiedu_insert.html');
	changeIframe('jiedu_select' , 'sys1_jiedu_select.html');
	changeIframe('fagui_insert' , 'sys1_fagui_insert.html');
	changeIframe('fagui_select' , 'sys1_fagui_select.html');
	changeIframe('dangwu_insert' , 'sys2_dangwu_insert.html');
	changeIframe('dangwu_selectall' , 'sys2_dangwu_selectall.html');
	changeIframe('dangwu_selectin' , 'sys2_dangwu_selectin.html');
	changeIframe('zhengwu_insert' , 'sys2_zhengwu_insert.html');
	changeIframe('zhengwu_selectall' , 'sys2_zhengwu_selectall.html');
	changeIframe('zhengwu_selectin' , 'sys2_zhengwu_selectin.html');
	changeIframe('jijian_select' , 'sys4_jubao_select.html');
	changeIframe('zuzhi_select' , 'sys4_jubaoperson_select.html');
	changeIframe('jiefang_select' , 'sys4_xinfang_select.html');
	changeIframe('jinji_insert' , 'sys5_jinji_insert.html');
	changeIframe('jinji_select' , 'sys5_jinji_select.html');
	changeIframe('baixing_select' , 'sys5_life_select.html');
	changeIframe('xinxiang_select' , 'sys6_letter_select.html');
	changeIframe('toupiao_insert' , 'sys6_toupiao_insert.html');
	changeIframe('toupiao_select' , 'sys6_toupiao_select.html');
	changeIframe('pingyi_insert' , 'sys6_pingyi_insert.html');
	changeIframe('pingyi_select' , 'sys6_pingyi_select.html');
	
	function changeIframe(aDiv , src){
		var oDiv = document.getElementById(aDiv);
		oDiv.onclick = function(){
			var oDiframe = document.getElementById('oDiframe');
			oDiframe.src = src;
		}
	}
	
	setInterval(function(){
		
		if(f_IsFullScreen()){
			document.body.style.height = window.screen.height - 1 + "px";
			document.getElementById('top').style.width = (document.body.clientWidth  - 6) + 'px';
			document.getElementById('hr').style.width = (document.body.clientWidth - 6) + 'px';
			document.getElementById('middle').style.width = (document.body.clientWidth) + 'px';
			var left = document.getElementById('left');
			var oWidth = getComputedStyle(left,false)['width'];
			document.getElementById('right').style.width = (document.body.clientWidth - parseInt(oWidth) - 16) + 'px';
		}
	},30);
	
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
	function f_IsFullScreen() {
		return (document.body.scrollHeight + 1 == window.screen.height && document.body.scrollWidth == window.screen.width);
	}	 
	function displayNone(){
		huiyuanxiala.style.display = 'none';
		zhengcexiala.style.display = 'none';
		jicengxiala.style.display = 'none';
		jianduxiala.style.display = 'none';
		fuwuxiala.style.display = 'none';
		goutongxiala.style.display = 'none';
		for (var i=0;i<6;i++) {
			var a = 'icon' + (i+1);
			document.getElementById(a).style.backgroundPosition = '0px 0px';
		}
	}
	function randomPic(){
		var a =parseInt(Math.random()*10);
		return "url(img/sock" + a + ".png)";	
	}
	function displaygo(oDiv,toDiv,icon , fn){
		oDiv.onclick = function(){
			var arr = toDiv.style.display;
			if(fn) fn();
			if(arr == 'none'){
				toDiv.style.display = 'block';
				document.getElementById(icon).style.backgroundPosition = '0px -21px';
			}else{
				toDiv.style.display = 'none';
				document.getElementById(icon).style.backgroundPosition = '0px 0px';
			}
		}
	}
	function displaygo_2(oDiv,toDiv,icon,icon_i,fn){
		oDiv.onclick = function(){
			var arr = toDiv.style.display;
			if(arr == 'none'){
				toDiv.style.display = 'block';
				document.getElementById(icon_i).style.backgroundPosition = '0px 0px';
				var sock = toDiv.getElementsByClassName(icon);
				for(var i=0;i<sock.length;i++){
					sock[i].style.backgroundImage = fn();
				}
			}else{
				toDiv.style.display = 'none';
				document.getElementById(icon_i).style.backgroundPosition = '0px -18px';
			}
		}
	}
	
	
}
