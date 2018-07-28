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

<body>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100 p-t-50 p-b-90"
                style="min-width:490px">
                <form class="login100-form validate-form flex-sb flex-w">
                    <span class="login100-form-title p-b-51">
                        Sign Up
                    </span>
                    <div class="row">
                        <div class="col-lg-6"
                            style="text-align:center;">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="firstName"
                                    type="text"
                                    placeholder="Firstname"
                                    required
                                    class="input100" />
                            </div>
                        </div>
                        <div class="col-lg-6"
                            style="text-align:center;">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="lastname"
                                    type="text"
                                    required
                                    placeholder="Lastname"
                                    class="input100" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="email"
                                    type="text"
                                    placeholder="Email"
                                    required
                                    class="input100" />
                            </div>
                        </div>
                        <div class="col-lg-6"
                            style="text-align:center;">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="dob"
                                    type="text"
                                    placeholder="DOB"
                                    required
                                    class="input100" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="password"
                                    type="password"
                                    placeholder="Password"
                                    required
                                    class="input100" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="confirm_password"
                                    class="input100"
                                    type="password"
                                    placeholder="Confirm Password"
                                    required
                                    class="input100" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="mobile"
                                    type="text"
                                    placeholder="Mobile"
                                    required
                                    class="input100" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="wrap-input100 validate-input m-b-16">
                                <input id="address"
                                    type="text"
                                    placeholder="Address"
                                    required
                                    class="input100" />
                            </div>
                        </div>

                        <div class="container-login100-form-btn m-t-17">
                            <div class="col-lg-12">
                                <button class="login100-form-btn"
                                    id="login">
                                    Sign Up
                                </button>
                            </div>
                        </div>
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
                        'Content-Type': 'application/json',
                    },
                    success: function (data) {

                        location.href = "/view/login.jsp";

                    }
                });
                return false;//suppress natural form submission
            });
        });

    </script>
</body>

</html>