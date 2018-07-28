<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>TicketBooking</title>
  <script src="${pageContext.request.contextPath}/resources/scripts/bootstrap.min.js"></script>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" />
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script>
  $(document).ready(function (){
	  $('#login').click(function () {
			
		  var request = {};
				
			request.userName = $('#userName').val();
			request.password = $('#password').val();
				
		  
	      $.ajax({

	          type: 'POST',
	          url: 'http://localhost:8080/login',
	          data: JSON.stringify(request),
	          dataType: "json", //to parse string into JSON object,
	         // contentType: 'application/json',
	          beforeSend: function(xhrObj){
	                xhrObj.setRequestHeader("contentType","application/json");
	        },
	          success: function (data) {
				
	        	  localStorage.setItem("userId", data.userInfoId);
	        	  localStorage.setItem("sessionToken", data.sessionToken);
	              
	     	 }
	      });
	      return false;//suppress natural form submission
	});
  });

  </script>
 
</head>
<body>
    <div class="container-fluid username" >
       
        <div class="col-lg-12">
            <div class="col-lg-2"> </div> 
                <div class="col-lg-8" style="padding:25px;">  <input id = "userName" type="text"  placeholder="Username" class="input" /></div>
            <div class="col-lg-2"> </div>
            </div>
        <div class="col-lg-12">
            <div class="col-lg-2"> </div>
                <div class="col-lg-8" style="padding:25px;">  <input id = "password" type="text" placeholder="Password" class="input" /></div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12">
            <div class="col-lg-3"> </div>
            <div class="col-lg-3 btn" > <button id = "sign-up" style="width:100px;">Create </button></div>
            <div class="col-lg-3 btn" > <button id = "login" style="width:100px;">Login</button></div>
            <div class="col-lg-3"> </div>
        </div>
    </div>
</body>
</html>