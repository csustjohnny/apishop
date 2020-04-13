		function sideBarAnimation(id){
			$(".sideMenuItem").mouseenter(function() {
					$(this).children("ul").stop().slideDown(500,"swing").parent().siblings().children("ul").stop().slideUp(500,"swing");
					$(this).css({
						backgroundColor: "#35404d",
						boxShadow: "-1px 1px 3px #000000"
					});
					$(this).children().children(".glyphicon-tags").css(
						"color", "orangered");
				}).mouseleave(function() {
					$(this).css({
						backgroundColor: "#2a3542",
						boxShadow: "none"
					});
					$(this).children().children(".glyphicon-tags").css("color", "");
				});
			$(".sideMenu").mouseleave(function() {
					$(".menuTil").next().stop().slideUp(500,"swing");
					$(id).stop().slideDown(500,"swing");
					$(id).parent().css("backgroundColor", "#35404d");
					
				});
			
			}