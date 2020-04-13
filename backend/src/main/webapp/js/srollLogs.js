function AutoScroll(obj) {
    $(obj).find("ul:first").animate({
        marginTop: "-22px"
    },
    500,
    function() {
        $(this).css({
            marginTop: "0px"
        }).find("li:first").appendTo(this);
    });
}
$(document).ready(function() {
    setInterval('AutoScroll(".usrLogBox")', 1000);
    setInterval('AutoScroll(".roleLogBox")', 1000);
    setInterval('AutoScroll(".resLogBox")', 1000);
    setInterval('AutoScroll(".authorityLogBox")', 1000);
    
});


