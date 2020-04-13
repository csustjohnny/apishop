//-------------新增用户模态框---------
function addUser() {
	$("#addUser").click(function() {
		//打开模态框
		$("#addUserModal").fadeIn(500);
		//设置注册时间为当前时间
		var time = new Date();
		var year = time.getFullYear();
		var month = time.getMonth() + 1;
		var day = time.getDate();
		$("#addDate").attr("value", year + "/" + month + "/" + day);

	});
}



$(function() {
	//---------------侧方菜单动画----------------------
	sideBarAnimation("#users");

	function superUsr() {
		$("#role>option").eq(1).prop("selected", true);
		//查询角色=超级用户
	}

	function assesseor() {
		$("#role>option").eq(2).prop("selected", true);
		//查询角色=审核用户
	}

	function tester() {
		$("#role>option").eq(3).prop("selected", true);
		//查询角色=测试用户
	}

	function commonUsr() {
		$("#role>option").eq(4).prop("selected", true);
		//查询角色=普通用户
	}
	//-----处理从后台首页不同角色查询跳转
	var url = window.location.href;
	var index = url.indexOf("id");
	var str;
	if (index != -1) {
		str = url.substring(url.lastIndexOf("=") + 1, url.length);
	}
	switch (str) {
		case "10":
			superUsr();
			break;
		case "20":
			assesseor();
			break;
		case "30":
			tester();
			break;
		case "40":
			commonUsr();
			break;
	}


	//关闭模态框
	closeMd();

	//删除单个用户
//	delOne();



	//修改用户


	//	$(".updateBtn").click(function() {
	//
	//		$("#myModal").slideDown(500);
	//		$(this).parent().parent().parent().addClass("mark");
	//
	//	});






	//-------------------同步表格和模态框-----------------

//	$("body").on("click", ".updateBtn", function() {
//		$("#myModal").slideDown(500);
//		$(this).parent().parent().parent().addClass("mark");
//		var $tr = $(this).parent().parent().parent();
//
//		for (var i = 0; i < 4; i++) {
//
//			$("#updateInfo input").eq(i).attr("value", $tr.children().eq(i + 1).text());
//
//			//			console.log($("#updateInfo input").eq(i).attr("value"));
//
//		}
//		$("#updaterole>option:contains('" + $tr.children().eq(5).text() + "')").prop("selected", true);
//
//		//判断如果该用户是超级用户，禁用更改角色,密码修改
//		if ($("#updaterole>option:selected").text() == "超级用户") {
//			$("#updaterole").attr("disabled", true);
//			$("#updateInfo input:last").attr("disabled", true);
//		} else {
//			$("#updaterole").attr("disabled", false);
//			$("#updateInfo input:last").attr("disabled", false);
//		}
//	});





	//--------修改用户后增加到列表中---------------

	$("body").on("click", "#saveUpdate", function() {
		var updates = $(this).parent().siblings("div").find("input");
		for (var i = 1; i < updates.length; i++) {
			$(".mark>td").eq(i).text(updates.eq(i - 1).val());
		}
		$(".mark>td").eq(5).text($("#updaterole>option:selected").text());

		$('.modal').hide(500);
		$(".mark").removeClass("mark");
	});




	//新增用户模态框
	addUser();
	//新增用户，同步至用户列表
	$("#saveAdd").click(function() {
		//判断提示信息是否存在
		if ($("#addUsrMb>span").length > 0) {
			$("#addUsrMb>span").remove();
		}

		//判断id，角色是否为空
		if (($("#addUsrID").val() == "") || ($("#addrole>option").eq(0).prop("selected") == true)) {

			//提示添加失败
			alert("请输入账号ID和角色");
			if ($("#addUsrMb>span").length > 0) {
				$("#addUsrMb>span").remove();
			}
			$("#addUsrMb").append("<span style='color:red'>添加失败！</span>");

		} else {

			//添加成功并同步到用户列表
			$("#usrList>tbody").append("<tr class='newUsr'></tr>");
			$(".newUsr").last().append("<td><input type='checkbox' class='check' /></td>")
			for (var i = 0; i < $(".add").length - 2; i++) {

				$(".newUsr").last().append("<td>" + $('#addUserTb input').eq(i).val() + "</td>");
				//				$("#usrList>tbody").append('<tr></tr>').html();
			}

			$(".newUsr").last().append("<td>" + $('#addrole>option:selected').text() + "</td>");
			$(".newUsr").last().append("<td>0</td>");
			$(".newUsr").last().append("<td>-</td>");
			$(".newUsr").last().append("<td><div class='btn-group btn-group-xs'><button type='button' class='btn btn-default updateBtn'><span class='glyphicon glyphicon-pencil'></span></button><button type='button' class='btn btn-default deleteBtn'><span class='glyphicon glyphicon-trash'></span></button></div></td>");

			//添加成功提示信息
			if ($("#addUsrMb>span").length > 0) {
				$("#addUsrMb>span").remove();
			}
			$("#addUsrMb").append("<span style='color:green'>添加成功！</span>");

		}
	});

	//全选&全不选
	$("#checkAll").click(function() {

		$("#usrList input[type='checkbox']").prop("checked", $(this).prop("checked"));

	});
	$("body").on("click", ".check", function() {
		var allLength = $(".check").length;
		var checkLength = $(".check:checked").length;
		if (allLength == checkLength) {
			$("#checkAll").prop("checked", true);
		} else {
			$("#checkAll").prop("checked", false);
		}

	});

	//批量删除
	var datetime;

	$("#delMore").click(function() {
		$("#delConfirmModal").slideDown(600);
		//获取服务器时间
		//var serverTime ;
		//若时间没到30min禁用密码输入
		//	if(serverTime-datetime<1800000){
		//			$("#managerCode").attr("placeholder","输入次数已达上限。请稍后重试!").prop("disabled",true);
		//			$("#delConfirm").prop("disabled",true);
		//			}else{
		//	   			$("#managerCode").attr("placeholder","请输入密码").prop("disabled",false);
		//				$("#delConfirm").prop("disabled",true);
		//		}

	});

	//批量删除验证
	var times = 4;
	$("#delConfirm").click(function() {

		if ($("#managerCode").val() == "123456") { //验证管理员密码
			//判断是否选中用户
			if ($(".check:checked").length > 0) {
				$(".check:checked").parent().parent().empty();
				$("#checkAll").prop("checked", false);
				//删除成功提示
				if ($("#delConfirmMb>span").length > 0) {
					$("#delConfirmMb>span").remove();
				}
				$("#delConfirmMb").append("<span style='color:green'>删除成功！</span>");
			} else {
				if ($("#delConfirmMb>span").length > 0) {
					$("#delConfirmMb>span").remove();
				}
				$("#delConfirmMb").append("<span style='color:red'>请选择要删除的用户！</span>");
			}


		} else {

			times--;

			if ($("#delConfirmMb>span").length > 0) {
				$("#delConfirmMb>span").remove();
			}
			$("#delConfirmMb").append("<span style='color:red'>密码错误！您还有" + times + "次机会</span>");
			if (times == 0) {
				alert("抱歉，输入次数已达上限。请30分钟后重试!");
				$("#delConfirmModal").hide();
				$("#managerCode").attr("placeholder", "输入次数已达上限。请30分钟后重试!").prop("disabled", true);
				$("#delConfirm").prop("disabled", true);
				times = 4;
				$("#delConfirmMb>span").remove();
				$("#managerCode").val("");
				//获取当前时间
				datetime = Date.now();
			}
		}
	});


	//侧方菜单用户管理功能
	//添加
	$("#users>li").eq(1).click(function() {
		$("#addUserModal").fadeIn(500);
	});

	//删除
	$("#users>li").eq(2).click(function() {
		$("#delConfirmModal").slideDown(600);
	});

	//-----条件跳转
	var url = window.location.href;
	var index = url.indexOf("id");
	var str;
	if (index != -1) {
		str = url.substring(url.lastIndexOf("=") + 1, url.length);
	}
	switch (str) {
		case "list":

			$("#users>li").eq(0).css("color", "orangered");
			break;
		case "add":
			$("#users>li").eq(1).css("color", "orangered");
			$("#addUserModal").slideDown();

			break;
		case "del":
			$("#users>li").eq(2).css("color", "orangered");
			alert("提示：请选择要删除的用户");

			break;

	}

});