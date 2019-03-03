<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <jsp:include page="head.jsp"></jsp:include>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="account">
                    <h2 class="account-in">login</h2>
                    <p>${error }</p>
                    <form action="UsersServlet" method="post">
                        <div>
                            <span>Username *</span>
                            <input type="text" name="username">
                        </div> 	
                         <div> 
                            <span class="word">Password *</span>
                            <input type="password" name="password">
                        </div>
                        <input type="hidden" value="login" name="command">				
                        <input type="submit" value="login"> 
                    </form>
                </div>
            </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
