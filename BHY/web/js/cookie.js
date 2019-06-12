//设置cookie并跳转页面
function jumpWithCookie(date, url) {
    setCookie(date);
    $(location).attr("href", url);
}

/*

➕
🛠
📝
input.setAttribute("onclick", "jumpWithCookie(" + JSON.stringify(item) + ",\"/BHY/html/BHY-showPet.html\" )");

$("#updateButton").attr("onclick", "jumpWithCookie(" + item + ",'/BHY/html/BHY-updatePet.html')")
<button id="updateButton">修改</button>


$(location).attr("href", url);
* */

//设置cookie
function setCookie(data) {
    delCookie("item");
    var json = JSON.stringify(data);
    document.cookie = "item=" + json;
}

//删除cookie
function delCookie(key) {
    var date = new Date();
    date.setTime(date.getTime() - 1);
    var delValue = getCookie(key);
    if (!!delValue) {
        document.cookie = key + '=' + delValue + ';expires=' + date.toGMTString();
    }
}

//得到cookie中的数据
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
}

//清空标签的子标签
function clearElement(id) {
    var div = document.getElementById(id);
    while (div.hasChildNodes()) //当div下还存在子节点时 循环继续
    {
        div.removeChild(div.firstChild);
    }
}

//页面跳转
function jump(url) {
    $(location).attr("href", url);
}

//设置添加按钮
function setAddButton(tb, num, url) {
    var tr = document.createElement("tr");
    var td = document.createElement("td");
    td.colSpan = num.toString();
    var addButton = document.createElement("button");
    addButton.innerHTML = "<span class=\"glyphicon glyphicon-plus\" style=\"color: rgb(255, 255, 255); font-size: 15px;\"></span>";
    addButton.className = "btn btn-primary";
    addButton.setAttribute("onclick", "jump(\'" + url + "\')");
    addButton.style = "width:100%;height:100%";
    td.appendChild(addButton);
    tr.appendChild(td);
    tb.appendChild(tr);
}

//根据d_id查询d_value
function getValueByID(d_id) {
    var rtn = "11";
    $.ajax({
        url: "/BHY/FindDValueByIDServlet",
        type: "post",
        async: false,
        data: {"d_id": d_id},
        success: function (result) {
            var json = jQuery.parseJSON(result);
            rtn = json.d_value;
        }
    });
    return rtn;
}

function getDate(){
    var time = new Date();
    var day = ("0" + time.getDate()).slice(-2);
    var month = ("0" + (time.getMonth() + 1)).slice(-2);
    var today = time.getFullYear() + "-" + (month) + "-" + (day)
    return today
}

function logout() {
    $.ajax({
        type:"post",
        url:"/BHY/LogoutServlet",
        success:function () {
            $(location).attr("href", "/BHY/html/BHY-login.html");
        }
    })
}