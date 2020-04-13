$(function(){
	//关闭模态框
	closeMd();
	//删除单个
	delOne();
	
	//打开编辑框
	$("body").on("click", ".updateBtn", function() {
		$("#editPermissionMd").slideDown(500);
		var $tr = $(this).parent().parent().parent();
		$tr.addClass("mark");
		for (var i = 0; i < $("#editPermissionMb input").length; i++) {

			$("#editPermissionMb input").eq(i).val($tr.children().eq(i).text());

		}
		$("#editPermissionMb textarea").text($tr.children().eq(5).text());
	});
	
	//打开添加框
	$("#add").click(function() {
		$("#addPermissionMd").slideDown();
	});

	//-----条件跳转
	var url = window.location.href;
	var index = url.indexOf("id");
	var str;
	if (index != -1) {
		str = url.substring(url.lastIndexOf("=") + 1, url.length);
	}
	switch (str) {
		case "define":
			
			$("#authority>li").eq(0).css("color", "orangered");
			break;
			case "share":
			
			$("#authority>li").eq(1).css("color", "orangered");
			break;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});
