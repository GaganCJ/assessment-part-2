var today = new Date();
var dd = today.getDate() + 1;
var mm = today.getMonth() + 1;
var yyyy = today.getFullYear();
if (dd < 10) { dd = '0' + dd; }
if (mm < 10) { mm = '0' + mm; }
today = yyyy + '-' + mm + '-' + dd;
$(document).ready(
    function () {
        $("#techA").click(function () {
            $("#Behv").empty();
            $("#Tech").append("<div style='display: none' class='alert alert-danger signupalert'><p>Error:</p><span></span></div><div class='form-group'><label class='col-md-3 control-label'>User ID</label><div class='col-md-9'><input type='text' class='form-control userId' disabled></div></div><div class='form-group'><label class='col-md-3 control-label'>Assessment</label><div class='col-md-9'><select class='form-control assessment'><option selected disabled>Select an assessment</option><option>Java</option><option>C++</option><option>C#</option><option>Python</option><option>Perl</option><option>PHP</option></select></div></div><div class='form-group'><label class='col-md-3 control-label'>Date</label><div class='col-md-9'><input type='date' class='form-control dateof' placeholder='Select a Date'></div></div><div class='form-group'><!-- Button --><div class='col-md-offset-3 col-md-9'><button type='submit' class='btn btn-info'><i class='icon-hand-right'></i>Register</button></div></div>");
            $.ajax({
                type: "GET",
                url: "/getUserId",
                success: function (userId) {
                    $(".userId").val(userId);
                }
            });
            $(".dateof").attr("min", today)
        });
        $("#behA").click(function () {
            $("#Tech").empty();
            $("#Behv").append("<div style='display: none' class='alert alert-danger signupalert'><p>Error:</p><span></span></div><div class='form-group'><label class='col-md-3 control-label'>User ID</label><div class='col-md-9'><input type='text' class='form-control userId' disabled></div></div><div class='form-group'><label class='col-md-3 control-label'>Assessment</label><div class='col-md-9'><select class='form-control assessment'><option selected disabled>Select an assessment</option><option>Step Plus</option><option>Email Etiquette</option><option>Learning Agility</option></select></div></div><div class='form-group'><label class='col-md-3 control-label'>Date</label><div class='col-md-9'><input type='date' class='form-control dateof' placeholder='Select a Date'></div></div><div class='form-group'><!-- Button --><div class='col-md-offset-3 col-md-9'><button type='submit' class='btn btn-info'><i class='icon-hand-right'></i>Register</button></div></div>");
            $.ajax({
                type: "GET",
                url: "/getUserId",
                success: function (userId) {
                    $(".userId").val(userId);
                }
            });
            $(".dateof").attr("min", today)
        });
        $(".btn").click(function () {
            var data = {}
            data["userId"] = $(".userId").val();
            if ($(".assessment option:selected").text() == "Select an assessment") {
                $(".signupalert").css("display", "inline-block");
                $(".signupalert span").text("Select an assessment");
            } else if ($(".dateof").val() == null) {
                $(".signupalert").css("display", "inline-block");
                $(".signupalert span").text("Select a date");
            } else {
                data["skillTopic"] = $(".assessment option:selected").text();
                data["scheduled_date"] = $(".dateof").val();
                //data["assessment_type"] 
            }
                $.ajax({
                    type: "POST",
                    url: "/postRegDetails",
                });
        });
    }
);