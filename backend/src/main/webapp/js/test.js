$(function() {
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

    //测试通过按钮
    $("#pass").click(function() {
        if ($(".check:checked").length == 0) {
            alert("请选择要更改的项目");
            return;
        }
        var state = $(".check:checked").parent().parent().find(".label");
        state.removeClass("label-danger").addClass("label-success").text("测试通过");
        $("input:checked").prop("checked", false);


    });
    //测试不通过按钮
    $("#fail").click(function() {
        if ($(".check:checked").length == 0) {
            alert("请选择要更改的项目");
            return;
        }
        var state = $(".check:checked").parent().parent().find(".label");
        state.removeClass("label-success").addClass("label-danger").text("测试失败");
        $("input:checked").prop("checked", false);
    });

//显示&隐藏详情信息
    $(".detailBox").css("display", "none");
    $(".detailBtn").click(function() {
        if($(this).parent().parent().parent().parent().next(".detailBox").css("display")=="none"){
            $(this).html("<span class='glyphicon glyphicon-list'></span>隐藏详情");
            $(this).parent().parent().parent().parent().next(".detailBox").fadeIn(500);
        }else{
            $(this).html("<span class='glyphicon glyphicon-list'></span>显示详情");
            $(this).parent().parent().parent().parent().next(".detailBox").hide();
        }

    });

    /*详细信息表格样式*/
    $(".detail>th").addClass("success");

});