$(function() {
	//-----条件跳转
	var url = window.location.href;
	var index = url.indexOf("id");
	var str;
	if (index != -1) {
		str = url.substring(url.lastIndexOf("=") + 1, url.length);
	}
	switch (str) {
		case "weituo":
			$("#authorizeMd").slideDown();
			$("#authority>li").eq(2).css("color", "orangered");
			break;
			case "define":
			
			$("#authority>li").eq(0).css("color", "orangered");
			break;
			case "share":
			
			$("#authority>li").eq(1).css("color", "orangered");
			break;

	}


	//关闭模态框
//	closeMd();


	//打开编辑框
//	$("body").on("click", ".updateBtn", function() {
//		$("#editPermissionMd").slideDown(500);
//		var $tr = $(this).parent().parent().parent();
//		$tr.addClass("mark");
//		for (var i = 0; i < $("#editPermissionMb input[type='text']").length; i++) {
//
//			$("#editPermissionMb input[type='text']").eq(i).val($tr.children().eq(i).text());
//
//		}
//		$("#editPermissionMb textarea").text($tr.children().eq(2).text());
//	});

	//二级权限展开
	$(".backStageItem").click(function() {
		if ($(this).prop("checked") == true) {
			$(".firstSonItems").slideDown();
		} else {
			$(".firstSonItems").slideUp();
			$(".firstSonItems input:checked").prop("checked", false);
		}

	});
	//三级权限展开
	$(".usrItem").click(function() {
		if ($(this).prop("checked") == true) {
			$(".secondSonItems").slideDown();
		} else {
			$(".secondSonItems").slideUp();
			$(".secondSonItems input:checked").prop("checked", false);
		}

	});
	//删除单个
//	delOne();

	//委托
	$("#authorize").click(function() {
		$("#authorizeMd").slideDown();
	});

	//新增
//	$("#add").click(function() {
//		$("#addPermissionMd").slideDown();
//	});


	//--------修改信息后增加到列表中---------------
	$("body").on("click", "#saveUpdate", function() {

		var updates = $(this).parent().siblings("div").find("input[type='text']");
		var textareas = $("#editPermissionMb textarea");
		for (var i = 1; i < updates.length; i++) {
			$(".mark>td").eq(i).text(updates.eq(i).val());
		}

		//		$(".mark>td").eq(2).html($("#editPermissionMb textarea").html());
		$('.modal').hide(500);
		$(".mark").removeClass("mark");





	});








});