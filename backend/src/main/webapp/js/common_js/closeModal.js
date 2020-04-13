function closeMd(){
	

//-----------------关闭模态框

	function closeModal(){
	$('.modal').hide(500);
		$(".mark").removeClass("mark");
		$(".modal-body>span").remove();
		$("#delConfirmMb>input").val("");
	}

	//-----------------点击关闭按钮关闭模态框-----------------
	$(".close").click(function() {
			closeModal();	
	});
	$(".modal-footer").children("button.btn-default").click(function() {
			closeModal();	
	});
}