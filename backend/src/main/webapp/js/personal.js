$(function(){
    $(".sideMenuItem").mouseenter(function() {
        $(this).children("ul").stop().slideDown(500,"swing").parent().siblings().children("ul").stop().slideUp(500,"swing");
        $(this).css({
            backgroundColor: "rgba(184, 184, 184, 0.26)",
            boxShadow: "-1px 1px 3px #000000"
        });
        $(this).children().children(".glyphicon-tags").css(
            "color", "orangered");
    }).mouseleave(function() {
        $(this).css({
            backgroundColor: "#ffffff",
            boxShadow: "none"
        });
        $(this).children().children(".glyphicon-tags").css("color", "");
    });
    $(".sideMenu").mouseleave(function() {
        $(".menuTil").next().stop().slideUp(500,"swing");
        $(id).stop().slideDown(500,"swing");
        $(id).parent().css("backgroundColor", "#ffffff");

    });

    /*点击li,切换到对应的div*/
    $(document).ready(function(){
        $(".sideMenuItem li").click(function(){
            var order = $(".sideMenuItem li").index(this);
            $("#tag" + order).show().siblings("div").hide();
        });
    });

});