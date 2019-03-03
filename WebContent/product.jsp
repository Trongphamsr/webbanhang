<%@page import="model.Cart"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product</title>
        <jsp:include page="head.jsp"></jsp:include>
    </head>
    <body>
        <%
        	CategoryDAO c = new CategoryDAO();
        	ProductDAO p = new ProductDAO();
        	String categoryid="";
        	if(request.getParameter("categoryid")!=null){
        		categoryid=request.getParameter("categoryid");
        		
        	}
        	
        	 Cart cart = (Cart) session.getAttribute("cart");
             if (cart == null) {
                 cart = new Cart();
                 session.setAttribute("cart", cart);
             }
        
        %>
        <jsp:include page="header.jsp"></jsp:include>
       
        
        <!---->
        <div class="container">
            <div class="content">
                <div class="content-top">
                	<%for(Category ca : c.getListSupperCategory(Integer.parseInt(categoryid)) ){%>
                    <h3 class="future"><%=ca.getCategoryName() %></h3>
                    <%} %>
                    <div class="content-top-in">
                        <%for(Product list : p.getListProductByCategory(Long.parseLong(categoryid))){%>
                        <div class="col-md-3 md-col">
                            <div class="col-md">
                                <a href="single.html"><img  src="images/pi.jpg" alt="" /></a>	
                                <div class="top-content">
                                    <h5><a href="single.jsp?productID=<%=list.getProductID()%>"><%=list.getProductName()%></a></h5>
                                    <div class="white">
                                        <a href="CartServlet?command=plus&productID=<%=list.getProductID() %>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
                                        <p class="dollar"><span class="in-dollar">$</span><%=list.getProductPrice()%></span></p>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>							
                            </div>
                        </div>
                       <%} %>
                        <div class="clearfix"></div>
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
