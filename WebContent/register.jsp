<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script>
    $(document).ready(function(){
        $("div.alert").delay(3000).slideUp();
    });
</script>


<jsp:include page="head.jsp"></jsp:include>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#username").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1000);
                });

                function check_username_ajax(username) {
                    $("#user-result").html('<img src="img/ajax-loader.gif" />');
                    $.post('CheckUsername', {'username': username}, function (data) {
                        $("#user-result").html(data);
                    });
                }
            });
        </script>


</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="account">
			<h2 class="account-in">Register</h2>
			
			<div class="alert alert-danger">
				${status }
			</div>
			
			
			<form method="post" action="UsersServlet">
				<div>
					<span>Username *</span> <input type="text" name="username"
						id="username"> <span id="user-result"></span>
				</div>
				<div>
					<span class="word">Password *</span> <input type="password"
						name="password">
				</div>
				<input type="hidden" value="insert" name="command">
				<input type="submit" value="register">
			</form>
		</div>
		<p>${status}</p>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
