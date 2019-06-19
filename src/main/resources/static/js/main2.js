$(document).ready(function () {
	
    $("#search-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

	var data = {
			"name" : $('#name').val(),
			"company" : $('#company').val()
		};
	console.log(JSON.stringify(data));
    $.ajax({
        type: 'POST',
        contentType: "application/json",
        url: "/users",
        data: JSON.stringify(data),
        dataType: 'text',
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	window.location.href = "/users";
        	/*
            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            
            $("#btn-search").prop("disabled", false);
			*/
        },
        error: function (e){
          console.log("ERROR : " + e);
        }
    });

}
