<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Online ticket booking</title>
        <meta charset="UTF-8">
        <meta name="viewport"
            content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon"
            type="image/png"
            href="${pageContext.request.contextPath}/resources/images/icons/favicon.ico" />
        <!--===============================================================================================-->
        <link rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css">
        <!--===============================================================================================-->
        <link rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/vendor/jquery-ui/jquery-ui.css">
        <!--===============================================================================================-->
        <link rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/vendor/jquery-datatable/css/jquery.dataTables.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/resources/css/util.css">
        <!--===============================================================================================-->
        <link rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/resources/css/main.css">
        <!--===============================================================================================-->
    </head>

    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button"
                        class="navbar-toggle collapsed"
                        data-toggle="collapse"
                        data-target="#navbar"
                        aria-expanded="false"
                        aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand"
                        href="#">Project name</a>
                </div>
                <div id="navbar"
                    class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Home</a>
                        </li>
                        <li>
                            <a href="#">About</a>
                        </li>
                        <li>
                            <a href="#">Contact</a>
                        </li>
                        <li class="dropdown">
                            <a href="#"
                                class="dropdown-toggle"
                                data-toggle="dropdown"
                                role="button"
                                aria-haspopup="true"
                                aria-expanded="false">Dropdown
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li role="separator"
                                    class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                                <li>
                                    <a href="#">One more separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">
                            <a href="./">Default
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li>
                            <a href="../navbar-static-top/">Static top</a>
                        </li>
                        <li>
                            <a href="../navbar-fixed-top/">Fixed top</a>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
            <!--/.container-fluid -->
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="wrap-input100 validate-input m-b-16"
                        data-validate="Username is required">
                        <select class="js-example-basic-single"
                            name="state">
                            <option value="AL">Alabama</option>
                            <option value="WY">Wyoming</option>
                        </select>
                        <span class="focus-input100"></span>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="wrap-input100 validate-input m-b-16"
                        data-validate="Username is required">
                        <select class="js-example-basic-single"
                            name="state">
                            <option value="AL">Alabama</option>
                            <option value="WY">Wyoming</option>
                        </select>
                        <span class="focus-input100"></span>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="wrap-input100 validate-input m-b-16"
                        data-validate="Username is required">
                        <input class="input100"
                            id="Date"
                            type="text"
                            name="username"
                            required
                            placeholder="Date">
                        <span class="focus-input100"></span>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn"
                            id="login">
                            Search
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
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery-ui/jquery-ui.js"></script>
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/jquery-datatable/js/jquery.dataTables.min.js"></script>
        <script src="js/main.js"></script>
        <!-- Custom JS files -->
        <script>
            $(function () {
                $(document).ready(function () {
                    $('#table_id').DataTable();
                    $('.js-example-basic-single').select2();
                    $("#Date").datepicker();
                });
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
                                locationType: "SOURCE"
                            },
                            success: function (data) {
                                response($.map(data, function (value) {
                                    return {
                                        label: value
                                    };
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
                        source: $("#source").val(),
                        destination: $("#destination").val(),
                        journeydate: $("#journeydate").val()
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
    </body>

    </html>