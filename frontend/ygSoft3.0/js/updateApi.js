$(function () {
	
	$("body").on('click', '.checkBtn', function(event) {
		//点击修改按钮，清除所有数据
			//TODO

		//点击修改按钮，显示修改框
		$("#tag0").show();
		var $tr=$(this).parent().parent().parent();
		for(var i=1;i<4;i++){
			$(".top").children('input').eq(i-1).val($tr.children('td').eq(i).text());	
		}
		var $td=$tr.parent().next(".detailBox").children('tr').children('td');
		//接口地址
		$(".middle").children('input').eq(0).val($td.eq(0).text());
		//请求协议

		var arrp=$td.eq(1).text().split(',');

		for (var i = 0; i<arrp.length;i++) {
			$(".reprotocol").children('input[value='+arrp[i]+']').prop("checked",true);	
		}
		
		//请求方式

		var arrw=$td.eq(2).text().split(',');

		for (var i = 0; i<arrw.length;i++) {
			$(".way").children('input[value='+arrw[i]+']').prop("checked",true);	
		}
		//请求格式
		$(".wayList option:contains("+$td.eq(3).text()+")").prop('selected', true);
		
		//返回格式
		
		$(".returnList option:contains("+$td.eq(4).text()+")").prop('selected', true);
	
		//请求实例
		$("input[name=example]").val($td.eq(5).text());

		//请求参数
		for(var i=6;i<$td.length;i++){

			$(".canshu").eq(i-6).val($td.eq(i).text()).parent().children().eq(0).prop('checked', true);
		}
	});



});