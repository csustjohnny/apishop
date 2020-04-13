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

    /*点击li,切换到对应的div*/
    $(document).ready(function(){
        $(".tabItems li a").click(function(){
            var order = $(".tabItems li a").index(this);
            $("#tag" + order).show().siblings("div").hide();
        });
    });

    //返回
    $(".foot a").click(function() {
        $(".query").show().siblings("div").hide();
    });

    $("body").on('click', '.checkBtn', function(event) {
		alert("修改");
        //点击修改按钮，显示修改框
        var $tr = $(this).parent().parent().parent();
        if($tr.find("span").is(".label-success")){
            alert("不 可 修 改！");
        }
        else {
            $(".update").show().siblings("div").hide();

            for (var i = 1; i < 4; i++) {
                $(".update .top").children('input').eq(i - 1).val($tr.children('td').eq(i).text());
            }
            var $td = $tr.parent().next(".detailBox").children('tr').children('td');
            //接口地址
            $(".update .middle").children('input').eq(0).val($td.eq(0).text());
            //请求协议

            var arrp = $td.eq(1).text().split(',');

            for (var i = 0; i < arrp.length; i++) {
                $(".reprotocol").children('input[value=' + arrp[i] + ']').prop("checked", true);
            }

            //请求方式

            var arrw = $td.eq(2).text().split(',');

            for (var i = 0; i < arrw.length; i++) {
                $(".way").children('input[value=' + arrw[i] + ']').prop("checked", true);
            }
            //请求格式
            $(".wayList option:contains(" + $td.eq(3).text() + ")").prop('selected', true);

            //返回格式

            $(".returnList option:contains(" + $td.eq(4).text() + ")").prop('selected', true);

            //请求实例
            $(".update input[name=example]").val($td.eq(5).text());

            //请求参数
            for (var i = 6; i < $td.length; i++) {

                $(".canshu").eq(i - 6).val($td.eq(i).text()).parent().children().eq(0).prop('checked', true);
            }
        }
    });

    //修改信息后同步到列表中
    $("body").on("click", "#saveUpdate", function() {
		alert('保存成功');
        for (var i = 1; i < 4; i++) {
            $(".mark>td").eq(i).text($(".top").children('input').eq(i-1).val());
        }

        var $td = $(".mark").parent().next(".detailBox").children('tr').children('td');
        //接口地址
        $td.eq(0).text($(".middle").children('input').eq(0).val());
        //请求协议
        $(".reprotocol:checkbox").each(function(){//给所有的input绑定事件
            $(this).click(function(){
                var l=[]; //创建空数组l
                $("input.protocol:checked").each(function(i){l[i]=this.value});
                //将所有的选中的值存放l
                $td.eq(1).text(l.join(","));//将数据值联合字符串给显示对象附值
            })
        });
        //请求方式
        $(".reway:checkbox").each(function(){//给所有的input绑定事件
            $(this).click(function(){
                var l=[]; //创建空数组l
                $("input.way:checked").each(function(i){l[i]=this.value});
                //将所有的选中的值存放l
                $td.eq(2).text(l.join(","));//将数据值联合字符串给显示对象附值
            })
        });
        //请求格式
        var o = $(".wayList option:checked");
        $td.eq(3).text(o.text());
        //返回格式
        var p = $(".returnList option:checked");
        $td.eq(4).text(p.text());
        //请求实例
        $td.eq(5).text($("input[name=example]").value());
        //请求参数
            for (var i = 0; i <$(".canshu").length; i++) {
                $td.eq(i+6).text($(".canshu").eq(i).value());
        }
        //同步发布状态信息
        $(".mark>td").eq(5).text("未发布");
        $(".mark>td").eq(5).css('background','#5bc0de');

        //修改日期 设置为当前时间
        $(".mark>td").eq(4).text("value",year+"/"+month+"/"+day);
        $(".mark").removeClass("mark");

    });
});