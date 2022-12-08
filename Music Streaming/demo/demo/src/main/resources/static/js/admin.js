$(document).ready(function() {
    $(".sb-ul li").click(function() {
        $(".sb-sub-ul").slideUp();

        if($(this).children(".sb-sub-ul").is(":visible")) {
            $(this).children(".sb-sub-ul").slideUp();
            $(".chev-pos").removeClass("chev-rotate");
        }
        else {
            $(this).children(".sb-sub-ul").slideDown();
            $(".sb-ul li a").on("click", function() {
                $(".chev-pos").removeClass("chev-rotate");
                $(this).find(".chev-pos").toggleClass("chev-rotate");
            });
        }
    });

    // --------------

    $(".sb-ul li a").click(function() {
        $(".sb-ul li a").removeClass("sb-ul-active");
        $(this).addClass("sb-ul-active");
    });


    // --------------
    // Responsive
    $(".btn-hamburger").click(function() {
        $(".sidebar").toggleClass("sidebar-active");
    });

    $(window).resize(function() {
        var width = $(window).width();
        if( width > 500) {
            $(".sidebar").show();
        }
    });


});