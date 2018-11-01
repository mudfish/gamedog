/**
 * Created by xusucheng on 2018/11/1.
 */

var findMenu=function () {
    var pathname = window.location.pathname + window.location.search;

    $(".nav li a").each(function() {

        var href = $(this).attr("href");

        if(pathname ==  href){

            $(this).parents("ul").parent("li").addClass("active open");

            $(this).parent("li").addClass("active");

        }

    });
}