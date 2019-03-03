<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
       
       <script>
	        $(document).ready(function(){
	            $("div.alert").delay(3000).slideUp();
	        });
	    </script>
       	
       <jsp:include page="head.jsp"></jsp:include>
    </head>
    <body>
		<%ProductDAO p = new ProductDAO(); %>
		
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="alert alert-success">
				${status }
			</div>
			
        <jsp:include page="banner.jsp"></jsp:include>
        
        <!---->
        <div class="container">
            <div class="content">
                <div class="content-top">
                    <h3 class="future">all product</h3>
                    <div class="content-top-in">
                    <%for(Product list : p.getListProductAll()){ %>
                        <div class="col-md-3 md-col">
                            <div class="col-md">
                                <a href="single.html"><img  src="images/pi.jpg" alt="" /></a>	
                                <div class="top-content">
                                    <h5><a href="single.html"><%=list.getProductName() %></a></h5>
                                    <div class="white">
                                        <a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
                                        <p class="dollar"><span class="in-dollar">$</span><%=list.getProductPrice() %></span></p>
                                        <div class="clearfix"></div>
                                    </div>

                                </div>							
                            </div>
                        </div>
                    
                    <%} %>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!---->
                <div class="content-middle">
                    <h3 class="future">BRANDS</h3>
                    <div class="content-middle-in">
                        <ul id="flexiselDemo1">			
                            <li><img src="images/ap.png"/></li>
                            <li><img src="images/ap1.png"/></li>
                            <li><img src="images/ap2.png"/></li>
                            <li><img src="images/ap3.png"/></li>

                        </ul>
                        <script type="text/javascript">
                            $(window).load(function () {
                                $("#flexiselDemo1").flexisel({
                                    visibleItems: 4,
                                    animationSpeed: 1000,
                                    autoPlay: true,
                                    autoPlaySpeed: 3000,
                                    pauseOnHover: true,
                                    enableResponsiveBreakpoints: true,
                                    responsiveBreakpoints: {
                                        portrait: {
                                            changePoint: 480,
                                            visibleItems: 1
                                        },
                                        landscape: {
                                            changePoint: 640,
                                            visibleItems: 2
                                        },
                                        tablet: {
                                            changePoint: 768,
                                            visibleItems: 3
                                        }
                                    }
                                });

                            });
                        </script>
                        <script type="text/javascript" src="js/jquery.flexisel.js"></script>

                    </div>
                </div>
                <ul class="start">
                    <li ><a href="#"><i></i></a></li>
                    <li><span>1</span></li>
                    <li class="arrow"><a href="#">2</a></li>
                    <li class="arrow"><a href="#">3</a></li>
                    <li class="arrow"><a href="#">4</a></li>
                    <li class="arrow"><a href="#">5</a></li>
                    <li ><a href="#"><i  class="next"> </i></a></li>
                </ul>
            </div>
        </div>
        
        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
