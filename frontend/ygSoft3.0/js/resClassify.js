$(function(){
	

//全选&全不选
				$("#checkAll").click(function() {
					$(".check").prop("checked", $(this).prop("checked"));
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
				
//打开编辑框
$("body").on("click",".updateBtn",function(){
		$("#updateMd").slideDown();
});

//打开子分类添加框
$("body").on("click",".addSonBtn",function(){
		$("#addSonClassifyeMd").slideDown();
});



$("#addClassify").click(function(){
			$("#addClassifyMd").slideDown(500);

});


//关闭模态框

closeMd();

//删除单个

delOne();


});
