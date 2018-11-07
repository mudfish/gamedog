/**
 * Created by xusucheng on 2018/11/1.
 */

//找到目前点击的菜单
var findMenu = function () {
    var pathname = window.location.pathname + window.location.search;

    $(".nav li a").each(function () {

        var href = $(this).attr("href");

        if (pathname == href) {

            $(this).parents("ul").parent("li").addClass("active open");

            $(this).parent("li").addClass("active");

        }

    });
}

/**
 * 自动将form表单封装成json对象
 */
$.fn.serializeJSON = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

/*
* 使用例子:format="yyyy-MM-dd hh:mm:ss";
*/
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, // month
        "d+": this.getDate(), // day
        "h+": this.getHours(), // hour
        "m+": this.getMinutes(), // minute
        "s+": this.getSeconds(), // second
        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
        "S": this.getMilliseconds()
// millisecond
    }

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
            - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1
                ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}


//全选反选
$("#checkAll").click(function () {
    var th_checked = this.checked; //checkbox inside "TH" table header

    $(this).closest('table').find('tbody > tr').each(function () {
        var row = this;
        if (th_checked) {
            $(row).addClass('active').find('input[type=checkbox]').eq(0).prop('checked', true);
            $(row).find('input[type=checkbox]').eq(0).addClass('selectedId');
        }
        else {
            $(row).removeClass('active').find('input[type=checkbox]').eq(0).prop('checked', false);
            $(row).find('input[type=checkbox]').eq(0).removeClass('selectedId');
        }
    });
});

//单选
var checkMe = function(e){
    var th_checked = e.checked; //checkbox inside "TH" table header
    if (th_checked) {
        $(this).prop('checked', true);
    }
    else {
        this.prop('checked', false);
    }
}


