
(function ($) {
    "use strict";


    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }

    $(document).ready(function () {
        /**
         * on login click
         */
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

    
    

})(jQuery);