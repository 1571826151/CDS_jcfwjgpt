onload = function(){
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
	document.getElementById('dateTime').value = showTime();
}
