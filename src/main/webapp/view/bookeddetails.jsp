<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="Scripts/bootstrap.min.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet" />
</head>
<script>
    
        function addpassenger() {
            var html = "";
            console.log("clicked");
            if ($("#add").find(".passengerdetails").length != 0) {
                count = $("#add").find(".passengerdetails").length + 1;

                html = html + '<div class="passengerdetails">'
                html = html + '<div>'
                html = html + '<div class="col-lg-12" style="border-bottom:1px solid #565656">'
                html = html + '   <div class=" col-lg-9"style="padding-bottom:20px;padding-top:20px;text-align:center;">Passenger '+count+' Details</div>'
                html = html + '  <div class="col-lg-3" style="padding-bottom:20px;padding-top:20px;text-align:right;"><button id="addpassenger_' + count + '" onclick="addpassenger()">Add Passenger</button></div>'
                html = html + '</div>'
                html = html + '</div>'
                html = html + '<div style="margin-top:45px;border-bottom:1px solid #565656;">'
                html = html + ' <div class="row" >'
                html = html + '<p class="col-lg-3">Name:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-3">Age:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-3">Gender:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-3">Mobile:<input type="text" style="border-style:none;"></p>'
                html = html + '</div>'
                html = html + '<div class="row" style="padding-top:25px;">'
                html = html + ' <p class="col-lg-3">DOJ:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-3">Pickup:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-3">Drop:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-3" seat<input type="text" style="border-style:none;"></p>'
                html = html + '</div>'
                html = html + '</div>'
                html = html + '</div>'
            }
            $("#add").append(html);
        }
    
</script>
<body>
    <div id="add"style="border-top:1px solid #565656;margin-top:25px;background-color:#fff;padding-left:0px;padding-right:0px;" class="col-lg-12">
   
<div class="passengerdetails">
        
            <div class="col-lg-12" style="border-bottom:1px solid #565656">
                <div class=" col-lg-9"style="padding-bottom:20px;text-align:center;">Passenger 1 Details</div>
                <div class="col-lg-3" style="padding-bottom:20px;text-align:right;"><button id="addpassenger" onclick="addpassenger()">Add Passenger</button></div>
            </div>
            <div id="passengeradddetails">
            <div style="border-bottom:1px solid #565656;">
                <div class="row" style="margin-top:75px;">
                    <p class="col-lg-3">Name:<input type="text" style="border-style:none;"></p>
                    <p class="col-lg-3">Age:<input type="text" style="border-style:none;"></p>
                    <p class="col-lg-3">Gender:<input type="text" style="border-style:none;"></p>
                    <p class="col-lg-3">Mobile:<input type="text" style="border-style:none;"></p>
                </div>
                <div class="row" style="padding-top:25px;">
                    <p class="col-lg-3">DOJ:<input type="text" style="border-style:none;"></p>
                    <p class="col-lg-3">Pickup:<input type="text" style="border-style:none;"></p>
                    <p class="col-lg-3">Drop:<input type="text" style="border-style:none;"></p>
                    <p class="col-lg-3"> seat<input type="text" style="border-style:none;"></p>
                </div>
            </div>
            </div>
</div>
        </div>
</body>
</html>
