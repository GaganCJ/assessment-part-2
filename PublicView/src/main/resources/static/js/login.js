jQuery(document).ready(
    function ($) {
        $("button[type='submit']").click(function (event) {
            var data = {}
            data["userid"] = $("input[name='userid']").val();
            data["password"] = $("input[name='password']").val();
            data["level"] = $("select[name='level'] option:selected").text();

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/putLoginData",
                data: JSON.stringify(data),
                dataType: 'json',
                cache: false,
                timeout: 600000,
                success: function(response){
                    var y = JSON.stringify(response)
                    $("#alertMsg strong").text(y);
                }
            });
        });
    }
);