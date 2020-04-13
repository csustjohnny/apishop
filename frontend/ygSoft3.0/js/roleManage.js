$(function() {

	//全选&全不选

	$("#checkAll").click(function() {

		$("#roleList input[type='checkbox']").prop("checked", $(this).prop("checked"));

	});
	$("body").on("click", ".check", function() {
		var allLength = $(".check").length;
		var checkLength = $(".check:checked").length;
		if(allLength == checkLength) {
			$("#checkAll").prop("checked", true);
		} else {
			$("#checkAll").prop("checked", false);
		}
	});

	//关闭模态框
	closeMd();
	//删除单个资源
//	delOne();

	//批量删除
	delMore();

	//修改信息时，列表同步至模态框
	

	//--------修改信息后增加到列表中---------------
	$("body").on("click", "#saveUpdate", function() {
		var updates = $(this).parent().siblings("div").find("input");
		for(var i = 1; i < updates.length; i++) {
			$(".mark>td").eq(i + 1).text(updates.eq(i).val());
		}

		$('.modal').hide(500);
		$(".mark").removeClass("mark");
	});

	//-----------新增角色打开模态框-----------

	//----新增到列表中---------------
	//	$("body").on("click","#saveAdd",function(){
	//		//判断提示信息是否存在
	//		if ($("#addRoleMb>span").length > 0) {
	//			$("#addRoleMb>span").remove();
	//		}
	//
	//		//判断id，角色是否为空
	//		if (($("#addRoleID").val() == "") || ($("#addRole>option").eq(0).prop("selected")==true)) {
	//
	//			//提示添加失败
	//			alert("请输入账号ID和角色");
	//			if ($("#addRoleMb>span").length > 0) {
	//				$("#addRoleMb>span").remove();
	//			}
	//			$("#addRoleMb").append("<span style='color:red'>添加失败！</span>");
	//
	//		} else {
	//
	//			//添加成功并同步到用户列表
	//			$("#roleList>tbody").append("<tr class='newRole'></tr>");
	//			$(".newRole").last().append("<td><input type='checkbox' class='check' /></td>")
	//								.append("<td>" + $('#addRoleTb input').eq(0).val() + "</td>")
	////								.append("<td>" + $('#addRoleM>option:selected').text() + "</td>");
	//			for (var i = 1; i < $('#addRoleTb input').length ; i++) {
	//
	//				$(".newRole").last().append("<td>" + $('#addRoleTb input').eq(i).val() + "</td>");
	//				
	//			}
	//
	//			$(".newRole").last().append("<td><div class='btn-group btn-group-xs'><button type='button' class='btn btn-default updateBtn'><span class='glyphicon glyphicon-pencil'></span></button><button type='button' class='btn btn-default deleteBtn'><span class='glyphicon glyphicon-trash'></span></button></div></td>");
	//
	//			//添加成功提示信息
	//			if ($("#addRoleMb>span").length > 0) {
	//				$("#addRoleMb>span").remove();
	//			}
	//			$("#addRoleMb").append("<span style='color:green'>添加成功！</span>");
	//
	//		}
	//	});
	//-----来自其他页面的角色管理子菜单跳转
	var url = window.location.href;
	var index = url.indexOf("id");
	var str;
	if(index != -1) {
		str = url.substring(url.lastIndexOf("=") + 1, url.length);
	}
	//					alert('hello');
	switch(str) {
		case "list":
			$("#addRoleMd").slideDown();
			$("#role>li").eq(0).addClass("activeLi");
			break;
		case "add":
			$("#addRoleMd").slideDown();
			$("#role>li").eq(1).addClass("activeLi");
			break;
		case "del":
			$("#delTipMd").slideDown(600);
			$("#role>li").eq(2).addClass("activeLi");
			break;
		case "update":
			$("#updateTipMd").slideDown(600);
			$("#role>li").eq(3).addClass("activeLi");
			break;
	}

});

function showAddRole() {
	$("#addRoleMd").slideDown();
}