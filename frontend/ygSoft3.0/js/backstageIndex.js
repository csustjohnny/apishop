$(function(){			
			//---------------侧方菜单动画----------------------
				sideBarAnimation();
				
				
				/*
				 * roleId:
				 *  0:添加新用户
				 * 	1：添加审核用户
				 * 	2：添加测试用户
				 * 	3：添加普通用户
				 */
				function addDiffUsr(roleId) {
					$('#myModal').show(500);
					$("#addrole>option").eq(roleId).prop("selected", true).parent().prop("disabled", true);
					var time = new Date();
					var year = time.getFullYear();
					var month = time.getMonth() + 1;
					var day = time.getDate();
					$("#addDate").attr("value", year + "/" + month + "/" + day);
				}
				
				
				//----------------进入动画-------------------
					$(".cartogram").animate({
						marginLeft: 0
					},400);
			
			
			
				//-----------------关闭模态框-----------------
				$(".close").click(function() {
					$('#myModal').hide(500);
					$("#td>input").empty();
				});
				$(".modal-footer").children("button.btn-default").click(function() {
					$('#myModal').hide(500);
				});
				
				//--- --   添加新用户-------------------
				$("#addUser").click(function() {
					addDiffUsr(0);
					$("#addrole>option").eq(0).prop("selected", false).parent().prop("disabled",false);
				});
				
				//--- --   添加审核用户-------------------
				$("#addAssessor").click(function() {
					addDiffUsr(1);
				});
				
				//--- --   添加测试用户-------------------
				$("#addTester").click(function() {
					addDiffUsr(2);
				});
				
				//--- --   添加普通用户-------------------
				$("#addCommonUser").click(function() {
					addDiffUsr(3);
				});
				
				//密码格式提示
				$("[data-toggle='tooltip']").tooltip();
				
				
				//密码格式验证6-12位字母数字组合
				var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
				$("#addpwd").blur(function() {
					var pwd = $(this).val();
					if (!reg.test(pwd) || pwd.length < 6 || pwd.length > 12) {
						$(this).siblings("span").empty();
						$(this).after($("<span style='font-size: 10px;color: red;'>密码必须为6-12位的数字和字母的组合</span>"));
						$("#saveUser").prop("disabled", true);
					} else {
						$(this).siblings("span").empty();
						$("#saveUser").prop("disabled", false);
					}
					
					
					//提交验证
					$("#saveUser").click(function() {
						var userName = $("#addUserName").val();
						var role = $("#addrole>option").eq(0).prop("selected");
						if (userName == "" && role == true) {
							//						console.log(role);
							alert("请填写完整信息");
						} else {
							$('#myModal').hide(500);
							//						console.log(role);
						}
					})
				});
				
				
				//切换面板
				$("#shift").click(function(){
					if($(".detailUser").css("display")=="none"){
						$(this).text("切换角色面板");
						$(".cartogram").hide();
						$(".detailUser").show();
					}else{
						$(this).text("切换统计图表");
						$(".cartogram").show();
						$(".detailUser").hide();
					}
					
				});
		});