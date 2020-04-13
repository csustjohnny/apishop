$(function(){
	var time = new Date();
		var year = time.getFullYear();
		var month = time.getMonth() + 1;
		var day = time.getDate();
	//全选&全不选
	
	$("#checkAll").click(function(){
		
		$("#resList input[type='checkbox']").prop("checked",$(this).prop("checked"));
		
	});
	$("body").on("click", ".check", function() {
		var allLength = $(".check").length;
		var checkLength = $(".check:checked").length;
		if(allLength==checkLength){
			$("#checkAll").prop("checked",true);
		}else{
			$("#checkAll").prop("checked",false);
		}
	});
	
	//关闭模态框
	closeMd();
	//删除单个资源
//	delOne();
	
	//批量删除
	delMore();
	
	//公开发布
	$("body").on("click", "#release", function() {
		
		if($(".check:checked").length>0){
				$(".check:checked").parent().parent().children(".state").text("已公开");
				$(".check:checked").parent().parent().children(".updateDate").text(year + "/" + month + "/" + day);
			}else{
				alert("请选择需要更改的项目");
			}
	});

	//停止公开发布
	$("body").on("click", "#unrelease", function() {
		var time = new Date();
		var year = time.getFullYear();
		var month = time.getMonth() + 1;
		var day = time.getDate();
		if($(".check:checked").length>0){
					$(".check:checked").parent().parent().children(".state").text("未公开");
					$(".check:checked").parent().parent().children(".updateDate").text(year + "/" + month + "/" + day);
			}else{
				alert("请选择需要更改的项目");
			}
	});
	
	
	
	//修改api信息时，列表同步至模态框
//	$("body").on("click", ".updateBtn", function() {
//		$("#myModal").slideDown(500);
//		$(this).parent().parent().parent().addClass("mark");
//		var $tr = $(this).parent().parent().parent();
//		
//		for (var i = 0; i < $("#updateInfo input").length; i++) {
//
//			$("#updateInfo input").eq(i).attr("value", $tr.children().eq(i+1).text());
//
//			//			console.log($("#updateInfo input").eq(i).attr("value"));
//		}
//		$("#updateInfo input").eq(4).attr("value", $tr.children().eq(6).text());
//		$("#updateReleaseState>option:contains('" + $tr.children().eq(5).text() + "')").prop("selected", true);
////		$("#updateInfo input").last().attr("value",year+"/"+month+"/"+day);
//	});
	
	//--------修改信息后增加到列表中---------------
//	$("body").on("click", "#saveUpdate", function() {
//		var updates = $(this).parent().siblings("div").find("input");
//		for (var i = 1; i < updates.length; i++) {
//			$(".mark>td").eq(i).text(updates.eq(i).val());
//		}
//		
//		//同步发布状态信息	
//		$(".mark>td").eq(5).text($("#updateReleaseState>option:selected").text());
//		
//		//修改日期 设置为当前时间
//		$(".mark>td").eq(6).text("value",year+"/"+month+"/"+day);
//		$('.modal').hide(500);
//		$(".mark").removeClass("mark");
//	});
	//-----条件跳转
	var url = window.location.href;
	var index = url.indexOf("id");
	var str;
	if (index != -1) {
		str = url.substring(url.lastIndexOf("=") + 1, url.length);
	}
	switch (str) {
		case "list":
				$("#first>li").eq(0).addClass("activeLi");
			break;
		case "permission":
				$("#first>li").eq(3).addClass("activeLi");
			break;
	}
	
});