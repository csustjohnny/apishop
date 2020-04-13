$(function() {
	$("#log").append("<li>查看所有</li>");
	$("#first>li").eq(2).empty();
	
	
	//用户管理跳转
	$('#userMgTil').click(function() {
		location.href = "allUsers.html";
	});
	$("#users>li").eq(0).click(function() {
		location.href = "allUsers.html?id=list";
		
	});
	$("#users>li").eq(1).click(function() {
		location.href = "allUsers.html?id=add";
	});
	$("#users>li").eq(2).click(function() {
		location.href = "allUsers.html?id=del";
	});
	//权限管理跳转
	
	$("#authorityMgTil").click(function() {
		location.href = "authority.html";
	});
	$("#authority>li").eq(0).click(function() {
		location.href = "authorityList.html?id=define";
	});
	$("#authority>li").eq(1).click(function() {
		location.href = "authority.html?id=share";
	});
	
	$("#authority>li").eq(2).click(function() {
		location.href = "authority.html?id=weituo";
	});
	//日志管理跳转
	$("#logMgTil").click(function() {
		location.href = "logs.html";
	});
	//日志跳转
	$("#log>li").eq(0).click(function() {
		location.href = "usrLogs.html";
	});
	$("#log>li").eq(1).click(function() {
		location.href = "roleLogs.html";
	});
	$("#log>li").eq(2).click(function() {
		location.href = "resLogs.html";
	});
	$("#log>li").eq(3).click(function() {
		location.href = "authorityLogs.html";
	});
	$("#log>li").eq(4).click(function() {
		location.href = "logs.html";
	});

	
	//资源管理跳转
	$("#resourceMgTil").click(function() {
		location.href = "resources.html";
	});
	$("#first>li").eq(0).click(function() {
		location.href = "resources.html?id=list";
	});
	$("#first>li").eq(1).click(function() {
		location.href = "resClassify.html?id=classify";
	});
	$("#first>li").eq(3).click(function() {
		location.href = "resources.html?id=permission";
	});
//	$("#first>li").eq(3).click(function() {
//		location.href = "resources.html";
//	});
	
	//角色管理跳转
	$('#roleMgTil').click(function() {
		location.href = "roles.html";
	});
	$("#role>li").eq(0).click(function() {
		location.href = "roles.html?id=list";
	});
	$("#role>li").eq(1).click(function() {
		location.href = "roles.html?id=add";
	});
	$("#role>li").eq(2).click(function() {
		location.href = "roles.html?id=del";
	});
	$("#role>li").eq(3).click(function() {
		location.href = "roles.html?id=update";
	});
	
});