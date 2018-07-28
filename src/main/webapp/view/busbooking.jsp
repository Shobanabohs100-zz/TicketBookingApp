<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="/resource/scripts/bootstrap.min.js"></script>
    <link href="/resource/css/bootstrap.css" rel="stylesheet" />

    <script>
    $(function () {
        function log(message) {
            $("<div>").text(message).prependTo("#log");
            $("#log").scrollTop(0);
        }

        $("#source").autocomplete({
            source: function (request, response) {
                $.ajax({
                	type: 'GET',
                    url: 'http://localhost:8080/location',
                    dataType: 'json',
                    data: {
                        q: request.term,
                        locationType : "SOURCE"
                    },
                    success: function (data) {
                    	 response($.map(data, function (value) {
                    		 return {
                    			 label: value }; 
                    		 }));
                    }
                });
            },
            minLength: 3,
            select: function (event, ui) {
                log(ui.item ?
                  "Selected: " + ui.item.label :
                  "Nothing selected, input was " + this.value);
            },
            open: function () {
                $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
            },
            close: function () {
                $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
            }
        });
        
        $('#search').click(function () {
        	
        	var request = {
        		    source = $("#source").val();
        			destination = $("#destination").val();
        			journeydate = $("#journeydate").val();
        			
        	}

            $.ajax({

                type: 'POST',

                url: 'localhost:8080/travel-detail',

                data: request,

                dataType: "json", //to parse string into JSON object,

                success: function (data) {

                    if (data) {

                        var len = data.length;

                        var txt = "";

                        if (len > 0) {

                            for (var i = 0; i < len; i++) {

                                if (data[i].city && data[i].cStatus) {

                                    txt += "<tr><td>" + data[i].city + "</td><td>" + data[i].cStatus + "</td></tr>";

                                }

                            }

                            if (txt != "") {

                                $("#table").append(txt).removeClass("hidden");

                            }

                        }

                    }

                },

                error: function (jqXHR, textStatus, errorThrown) {

                    alert('error: ' + textStatus + ': ' + errorThrown);

                }

            });

            return false;//suppress natural form submission

        });
    });
   
    </script>
</head>
<body>
<div class="container-fluid" style="max-width:1200px;border:1px solid #565656;background-color:#fff;height:700px;padding:25px;">
    <div class="col-lg-12">
      <div class="col-lg-4">
          <input type="text" id="source" style="width:100%;" autocomplete="off"/>
      </div>
        <div class="col-lg-4">
            <input type="text" id="destination" style="width:100%;" />
        </div>
        <div class="col-lg-4">
            <input type="text" style="width:100%;" />
        </div>
    </div>
</div>


    <!--<div class="ui-widget">
        <label for="city">Your city: </label>
        <input id="city">
        Powered by <a href="http://geonames.org">geonames.org</a>
    </div>-->

    <!--<div class="ui-widget" style="margin-top:2em; font-family:Arial">
        Result:
        <div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
    </div>-->
</body>
</html>





