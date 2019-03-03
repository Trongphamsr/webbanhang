
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager category</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
		<%
			CategoryDAO categoryDAO = new CategoryDAO();
			ArrayList<Category> listCateory = categoryDAO.getListCategory();
		
		%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>
				
                <div id="rightContent">
                	<h3>quan ly danh muc</h3>
                   <a href="${root}/admin/insert_category.jsp">them danh muc</a>
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">ma danh muc</th>
                            <th class="data">ten danh muc</th>
                            <th class="data">tuy chon</th>
                        </tr>
                        
                        <%
                        	int count=0;
                        	for(Category category :listCateory){
                        	count++;
                        %>
                        
                        <tr class="data">
                            <td class="data" width="30px"><%=count%></td>
                            <td class="data"><%=category.getCategoryID() %></td>
                            <td class="data"><%=category.getCategoryName()%></td>
                            <td class="data" width="90px">
                        <center>
                             <a href="${root}/admin/update_category.jsp?command=update&categoryID=<%=category.getCategoryID()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;
                             <a onclick="return confirm('Ban co muôn xóa không ?')";  href="/WebBanHang/ManagerCategoryServlet?command=delete&categoryID=<%=category.getCategoryID() %> ">Xóa</a>
                        </center>
                        </td>
                        </tr>
                        <%}%>
                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
