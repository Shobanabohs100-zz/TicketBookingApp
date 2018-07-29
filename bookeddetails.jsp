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
        href="vendor/jquery-datatable/css/jquery.dataTables.min.css">
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
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand"
                    href="#">
                    <img class="nav-logo" src="travel-logo.png" alt="Booking app"/>
                    WebSiteName</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">Page 1</a>
                </li>
                <li>
                    <a href="#">Page 2</a>
                </li>
                <li>
                    <a href="#">Page 3</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">

        <div class="row">
            <div class=" col-lg-9">Passenger 1 Details</div>
            <div class="col-lg-3 text-left">
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn"
                        data-toggle="modal"
                        data-target="#myModal"
                        id="addpassenger">
                        Add Passesnger
                    </button>
                </div>
            </div>
        </div>
        <table id="table_id"
            class="display">
            <thead>
                <tr>
                    <th>Bus name</th>
                    <th>No. of available Seats</th>
                    <th>Fare</th>
                    <th>Arrival Time</th>
                    <th>Duration</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Row 1 Data 1</td>
                    <td>Row 1 Data 2</td>
                    <td>Row 1 Data 2</td>
                    <td>Row 1 Data 2</td>
                    <td>Row 1 Data 2</td>
                    <td>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn"
                                id="book">
                                Book >
                            </button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Row 1 Data 1</td>
                    <td>Row 1 Data 2</td>
                    <td>Row 1 Data 2</td>
                    <td>Row 1 Data 2</td>
                    <td>Row 1 Data 2</td>
                    <td>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn"
                                id="book">
                                Book >
                            </button>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>

    </div>

    <!-- Modal -->
    <div id="myModal"
        class="modal fade"
        role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button"
                        class="close"
                        data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Passenger details</h4>
                </div>
                <div class="modal-body">
                    <div id="passengeradddetails">
                        <div style="border-bottom:1px solid #565656;">
                            <div class="row">
                                <div class="col-lg-6">Name:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                                <div class="col-lg-6">Age:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                                <div class="col-lg-6">Gender:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                                <div class="col-lg-6">Mobile:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">DOJ:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                                <div class="col-lg-6">Pickup:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                                <div class="col-lg-6">Drop:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                                <div class="col-lg-6">Seat:
                                    <div class="wrap-input100 validate-input m-b-16"
                                        data-validate="Username is required">
                                        <input class="input100"
                                            id="userName"
                                            type="text"
                                            name="username"
                                            placeholder="Username">
                                        <span class="focus-input100"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn"
                            data-dismiss="modal"
                            id="login">
                            Add
                        </button>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery-ui/jquery-ui.js"></script>
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/jquery-datatable/js/jquery.dataTables.min.js"></script>
    <script src="js/main.js"></script>
    <!-- Custom JS files -->
    <script>
        $(document).ready(function () {
            $('#table_id').DataTable();
            $('.js-example-basic-single').select2();
            $("#Date").datepicker();
        });
        $(function () {
            var availableTags = [
                "ActionScript",
                "AppleScript",
                "Asp",
                "BASIC",
                "C",
                "C++",
                "Clojure",
                "COBOL",
                "ColdFusion",
                "Erlang",
                "Fortran",
                "Groovy",
                "Haskell",
                "Java",
                "JavaScript",
                "Lisp",
                "Perl",
                "PHP",
                "Python",
                "Ruby",
                "Scala",
                "Scheme"
            ];
            $("#source").autocomplete({
                source: "localhost:8080/location"
            });
            $("#destination").autocomplete({
                source: availableTags,
                serviceurl: "localhost:8080/location"
            });
        });


    </script>
    <script>

        function addpassenger() {
            var html = "";
            console.log("clicked");
            if ($("#add").find(".passengerdetails").length != 0) {
                count = $("#add").find(".passengerdetails").length + 1;

                html = html + '<div class="passengerdetails">'
                html = html + '<div>'
                html = html + '<div class="col-lg-12" style="border-bottom:1px solid #565656">'
                html = html + '   <div class=" col-lg-9"style="padding-bottom:20px;padding-top:20px;text-align:center;">Passenger ' + count + ' Details</div>'
                html = html + '  <div class="col-lg-6" style="padding-bottom:20px;padding-top:20px;text-align:right;"><button id="addpassenger_' + count + '" onclick="addpassenger()">Add Passenger</button></div>'
                html = html + '</div>'
                html = html + '</div>'
                html = html + '<div style="margin-top:45px;border-bottom:1px solid #565656;">'
                html = html + ' <div class="row" >'
                html = html + '<p class="col-lg-6">Name:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-6">Age:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-6">Gender:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-6">Mobile:<input type="text" style="border-style:none;"></p>'
                html = html + '</div>'
                html = html + '<div class="row" style="padding-top:25px;">'
                html = html + ' <p class="col-lg-6">DOJ:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-6">Pickup:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-6">Drop:<input type="text" style="border-style:none;"></p>'
                html = html + '<p class="col-lg-6" seat<input type="text" style="border-style:none;"></p>'
                html = html + '</div>'
                html = html + '</div>'
                html = html + '</div>'
            }
            $("#add").append(html);
        }

    </script>
</body>

</html>