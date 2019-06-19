$(document).ready(function () {
    $("#user-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {
    var data = $("#user-form").serializeArray();    
    var formArray = {};    
    $.map(data, function(n, i){
        formArray[n['name']] = n['value']; // key - value
    });
    var json = JSON.stringify(formArray);
	/*
	var data = {
			"name" : $('#name').val(),
			"company" : $('#company').val()
	};
   
    var json = JSON.stringify(data);
    */
    
    console.log(json);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/users",
        data: json,
        dataType: 'text', // json -> text
        cache: false,
        timeout: 600000,
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	//window.location.href = "/users";
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}
