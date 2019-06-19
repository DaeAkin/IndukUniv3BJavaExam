$(document).ready(function () {
    $("#delete-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {
    var data = $("#delete-form").serializeArray();    
    var formArray = {};    
    $.map(data, function(n, i){
        formArray[n['name']] = n['value']; // key - value
    });
    var json = JSON.stringify(formArray);
    console.log(json);
    url = 
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/users/",
        data: json,
        dataType: 'text', // json -> text
        cache: false,
        timeout: 600000,
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	window.location.href = "/users";
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}
