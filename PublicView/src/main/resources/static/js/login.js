$(document).ready(
    function () {
        $("button[type='submit']").click(function () {
            if ($("input[name='userid']").val() == null) {
                $("#alertMsg strong").text("User ID should not be empty");
            } else if ($("input[name='password']").val() == null) {
                $("#alertMsg strong").text("Password should not be empty");
            } else if ($("select[name='level'] option:selected").text() == "Select a Level") {
                $("#alertMsg strong").text("Select the access level");
            } else {
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
                    success: function (res) {
                        $("#alertMsg strong").text(res);
                    }
                });
            }
        });
    }
);