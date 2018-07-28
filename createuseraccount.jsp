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
        href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        type="text/css"
        href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet"
        href="css/jquery-ui.css">
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
    <div class="container-fluid username">

        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="firstName"
                    type="text"
                    placeholder="Firstname"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="lastname"
                    type="text"
                    placeholder="Lastname"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="email"
                    type="text"
                    placeholder="Email"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="dob"
                    type="text"
                    placeholder="DOB"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="password"
                    type="password"
                    placeholder="Password"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="confirm_password"
                    type="password"
                    placeholder="Confirm Password"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="mobile"
                    type="text"
                    placeholder="Mobile"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <div class="col-lg-2"> </div>
            <div class="col-lg-8"
                style="padding:25px;">
                <input id="address"
                    type="text"
                    placeholder="Address"
                    class="input" />
            </div>
            <div class="col-lg-2"> </div>
        </div>
        <div class="col-lg-12"
            style="text-align:center;">
            <button id="submit"
                style="width:100px;">Create</button>
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