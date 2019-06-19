$(document).ready(function () {
	
    $("#search-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {
/*
    var search = {}
    search["username"] = $("#username").val();
    $("#btn-search").prop("disabled", true);
    */
/*
    var data = $("#search-form").serializeArray();
    
    var formArray = {};
    
    $.map(data, function(n, i){
        formArray[n['name']] = n['value']; // key - value
    });
*/ 
		var formArray = {
			"name" : $('#name').val(),
			"company" : $('#company').val()
		};
		var json =JSON.stringify(formArray)
    console.log(json);
    $.ajax({
        type: 'post',
        contentType: 'application/json; charset=utf-8',
        url: '/users',
        data: json,
        dataType: 'json',
        success: function (formArray) {
        	console.log("SUCCESS : ", formArray);
        	/*
            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            
            $("#btn-search").prop("disabled", false);
			*/
        },
        error: function (e) {
        	console.log("ERROR : ", e);
        	/*
        	
            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            
            $("#btn-search").prop("disabled", false);
            
			*/
        }
    });

}
