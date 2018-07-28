<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Online ticket booking</title>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon"
        type="image/png"
        href="images/icons/favicon.ico" />
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        href="vendor/jquery-ui/jquery-ui.js">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="css/util.css">
    <link rel="stylesheet"
        type="text/css"
        href="css/main.css">
    <!--===============================================================================================-->
</head>


<body background="/resources/images/login.jpg">
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100 p-t-50 p-b-90">
                <form class="login100-form validate-form flex-sb flex-w">
                    <span class="login100-form-title p-b-51">
                        Login
                    </span>


                    <div class="wrap-input100 validate-input m-b-16"
                        data-validate="Username is required">
                        <input class="input100"
                            id="userName"
                            type="text"
                            name="username"
                            placeholder="Username">
                        <span class="focus-input100"></span>
                    </div>


                    <div class="wrap-input100 validate-input m-b-16"
                        data-validate="Password is required">
                        <input class="input100"
                            id="password"
                            type="password"
                            name="pass"
                            placeholder="Password">
                        <span class="focus-input100"></span>
                    </div>

                    <div class="flex-sb-m w-full p-t-3 p-b-24">
                        <div class="contact100-form-checkbox">
                            <input class="input-checkbox100"
                                id="ckb1"
                                type="checkbox"
                                name="remember-me">
                            <label class="label-checkbox100"
                                for="ckb1">
                                Remember me
                            </label>
                        </div>

                        <div>
                            <a href="/view/createuseraccount.jsp"
                                class="txt1">Signup</a>
                        </div>
                    </div>

                    <div class="container-login100-form-btn m-t-17">
                        <button class="login100-form-btn"
                            id="login">
                            Login
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </div>

    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery-ui/jquery-ui.js"></script>
    <script src="js/main.js"></script>
    <!-- Custom JS files -->
    <script>
        $(document).ready(function () {
            $('#login').click(function () {

                var request = {};

                request.userName = $('#userName').val();
                request.password = $('#password').val();


                $.ajax({

                    type: 'POST',
                    url: 'http://localhost:8081/login',
                    data: JSON.stringify(request),
                    dataType: "json", //to parse string into JSON object,
                    //   contentType: 'application/json',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    success: function (data) {

                        localStorage.setItem("userId", data.userInfoId);
                        localStorage.setItem("sessionToken", data.sessionToken);
                        location.href = "/view/bookingdetails.jsp";

                    }
                });
                return false;//suppress natural form submission
            });
        });

    </script>
</body>

</html>