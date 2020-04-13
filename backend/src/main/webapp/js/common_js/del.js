function delOne(){
//	$(".deleteBtn").click(function() {
//
//		$(this).parent().parent().parent().remove();
//
//	});

	$("body").on("click", ".deleteBtn", function() {
		$(this).parent().parent().parent().remove();
	});

}

function delMore(){
	
	//批量删除
	var datetime;
	
	$("#delMore").click(function(){
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
	var times=4;
	$("#delConfirm").click(function(){
		
		if($("#managerCode").val()=="123456"){	//验证管理员密码
			//判断是否选中用户
			if($(".check:checked").length>0){
				$(".check:checked").parent().parent().empty();
				$("#checkAll").prop("checked",false);
				//删除成功提示
				if($("#delConfirmMb>span").length>0){
				$("#delConfirmMb>span").remove();
				}
				$("#delConfirmMb").append("<span style='color:green'>删除成功！</span>");
			}else{
				if($("#delConfirmMb>span").length>0){
				$("#delConfirmMb>span").remove();
				}
				$("#delConfirmMb").append("<span style='color:red'>请选择要删除的用户！</span>");
			}
			
			
		}else{
			
			times--;
			
			if($("#delConfirmMb>span").length>0){
				$("#delConfirmMb>span").remove();
			}
			$("#delConfirmMb").append("<span style='color:red'>密码错误！您还有"+times+"次机会</span>");
			if(times==0){
				alert("抱歉，输入次数已达上限。请30分钟后重试!");
				$("#delConfirmModal").hide();
				$("#managerCode").attr("placeholder","输入次数已达上限。请30分钟后重试!").prop("disabled",true);
				$("#delConfirm").prop("disabled",true);
				times=4;
				$("#delConfirmMb>span").remove();
				$("#managerCode").val("");
				//获取当前时间
				datetime = Date.now();
			}
		}
	});
	
}
