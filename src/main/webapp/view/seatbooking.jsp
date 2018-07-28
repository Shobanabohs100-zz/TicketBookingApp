<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

   <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="Scripts/bootstrap.min.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet" />
    
    <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/animate/animate.css">
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.css">
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->	
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/util.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
    <!--===============================================================================================-->
     <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="limiter">
    	<div class="container-login100">
        	<!-- <div class="wrap-login100 p-t-50 p-b-90"> -->
           		 <div class="row">
           		 	<div class="col-lg-3">
                     	<div class="wrap-input100 validate-input m-b-16">
                        	<input id="firstName"  type="text" placeholder="Firstname" class="input100" />
                         </div>
           		 	</div>
           		 	<div class="col-lg-3">
                     	<div class="wrap-input100 validate-input m-b-16">
                        	<input id="lastName"  type="text" placeholder="lastName" class="input100" />
                         </div>
           		 	</div>
           		 	<div class="col-lg-3">
                     	<div class="wrap-input100 validate-input m-b-16">
                     		<input id="gender"  type="text" placeholder="Gender" class="input100" />
                         </div>
           		 	</div>
           		 	<div class="col-lg-3">
                     	<div class="wrap-input100 validate-input m-b-16">
                        	<input id="age"  type="text" placeholder="Age" class="input100" />
                         </div>
           		 	</div>
           		 </div>
           		  <div class="row">
           		 	<div class="col-lg-3">
                     	<div class="wrap-input100 validate-input m-b-16">
                        	<input id="seatNo"  type="text" placeholder="Seat No" class="input100" />
                         </div>
           		 	</div>
           		 	<div class="col-lg-3">
                     	<div class="wrap-input100 validate-input m-b-16">
                        	<input id="boardingPoint"  type="text" placeholder="Boarding Point" class="input100" />
                         </div>
           		 	</div>
           		 	<div class="col-lg-3">
                     	<div class="wrap-input100 validate-input m-b-16">
                        	<input id="dropPoint"  type="text" placeholder="Drop Point" class="input100" />
                         </div>
           		 	</div>
           		 	<div class=" col-lg-3 container-login100-form-btn m-t-17">
                        <button class="login100-form-btn" id="delete">
                            Delete
                        </button>
                    </div>
           		 </div>
           		 <div>
           		 	<div class=" col-lg-3"></div>
           		 	<div class=" col-lg-3"></div>
           		 	<div class=" col-lg-3"></div> 	
           		 	<div class=" col-lg-3 container-login100-form-btn m-t-17">
                        <button class="login100-form-btn" id="add">
                            Add
                        </button>
                    </div>
           		 </div>
        <!--   -->	
   		 </div>
   	 </div>

</body>
</html>