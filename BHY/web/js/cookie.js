//设置cookie并跳转页面
function jumpWithCookie(date, url) {
    setCookie(date);
    $(location).attr("href", url);
}

/*

➕
🛠
📝
input.setAttribute("onclick", "jumpWithCookie(" + JSON.stringify(item) + ",\"/BHY/html/BHY-BHY-showPet.html\" )");

* */
//设置cookie
function setCookie(data) {
    var json = JSON.stringify(data);
    document.cookie = "item=" + json;
}
//删除cookie
function delCookie(key) {
    var date = new Date();
    date.setTime(date.getTime() - 1);
    var delValue = getCookie(key);
    if (!!delValue) {
        document.cookie = key+'='+delValue+';expires='+date.toGMTString();
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

function clearElement(id) {
    var div = document.getElementById(id);
    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
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
    var addButton = document.createElement("input");
    addButton.value = "➕";
    addButton.type = "button";
    addButton.setAttribute("onclick", "jump(\'" + url + "\')");
    addButton.style = "width:100%;height:100%";
    td.appendChild(addButton);
    tr.appendChild(td);
    tb.appendChild(tr);
}