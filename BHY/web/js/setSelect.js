
function getDicSelect(selectId, selectValue) {
    var select = document.getElementById(selectId);
    $.ajax({
        url:"/BHY/FindDicByParValueServlet",
        type:"post",
        data:{"d_value":selectValue},
        success:function (result) {
            var jsons = jQuery.parseJSON(result);
            $.each(jsons, function (i, item) {
                var option = document.createElement("option");
                option.value=item.d_id;
                option.innerText = item.d_value;
                select.appendChild(option);
            })
        },error(){
            alert("error");
        }
    })
}

function getStoreSelect(selectName) {
    var select = document.getElementById(selectId);
    $.ajax({
        url:"/BHY/FindStoreLimitServlet",
        type:"post",
        success:function (result) {
            var jsons = jQuery.parseJSON(result);
            $.each(jsons, function (i, item) {
                var option = document.createElement("option");
                option.value=item.st_id;
                option.innerText = item.st_address;
                select.appendChild(option);
            })
        },error(){
            alert("error");
        }
    })
}