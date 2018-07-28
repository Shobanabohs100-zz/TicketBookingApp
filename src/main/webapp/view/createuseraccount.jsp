 <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>User Registration</title>
    <script src="scripts/bootstrap.min.js"></script>
    <link href="/resources/css/login.css" rel="stylesheet" />
    <link href="/resources/css/bootstrap.css" rel="stylesheet" />
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
     <script>
  $(document).ready(function (){
	  $('#submit').click(function () {
			
		  var request = {};
				
			request.firstName = $('#firstName').val();
			request.lastname = $('#lastname').val();
			request.email = $('#email').val();
			request.dob = $('#dob').val();
			request.firstName = $('#mobile').val();
			request.lastname = $('#address').val();
		  
	      $.ajax({

	          type: 'POST',
	          url: 'http://localhost:8081/user',
	          data: JSON.stringify(request),
	          dataType: "json", //to parse string into JSON object,
	          headers: {
       			 'Content-Type':'application/json',
   			 },
	          success: function (data) {
				
	        	  location.href = "/view/login.jsp";
	              
	     	 }
	      });
	      return false;//suppress natural form submission
	});
  });

  </script>
 
 
</head>
<body background="/resources/images/registration.jpg" style="height:100%; background-position:center; background-repeat:no-repeat; background-size:cover;">

    <div class="container-fluid username">

        <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "firstName" type="text" placeholder="Firstname" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "lastname"  type="text" placeholder="Lastname" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "email"  type="text" placeholder="Email" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "dob"  type="text" placeholder="DOB" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
         <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "password"  type="password" placeholder="Password" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
         <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "confirm_password"  type="password" placeholder="Confirm Password" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "mobile"  type="text" placeholder="Mobile" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12" style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8" style="padding:25px;">  <input id = "address"  type="text" placeholder="Address" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12" style="text-align:center;">
             <button id = "submit" style="width:100px;">Create</button>
        </div>
    </div>
</body>
</html>
