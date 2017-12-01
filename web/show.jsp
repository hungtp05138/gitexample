<%-- 
    Document   : show
    Created on : Jul 1, 2017, 10:05:48 AM
    Author     : hpt
--%>

<%@page import="model.product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADMIN</h1>
        <%!
            double id;
            String name;
            String image;
            String price;
        %>

        <table border="1">


            <thread>

                <tr>
                    <th>No.</th>
                    <th>name</th>
                    <th>Image</th>
                    <th>Price</th>
                </tr>
                <%
                    product pro = new product();
                    product[] list = pro.getConnectProduct();
                    for (int i = 0; i < list.length; i++) {
                        id = list[i].getIDproduct();
                        name = list[i].getNameproduct();
                        price = list[i].getPrice();
                        image = list[i].getImage();
                        
                %>

                <tr>
                <form action="Controller" method="get" >
                    <th><input type="text" value="<%=id%>" name="txtId"></th>
                    <th><input type="text" value="<%=name%>" name="txtTensp"></th>
                    <th><input type="text" value="<%=image%>" name="txtImage"></th>
                    <th><input type="text" value="<%=price%>" name="txtGia"></th>

                    <th><input type="submit" value="Update" name="btAction" /></th>
                    <th><input type="submit" value="Delete" name="btAction"/></th>

                    <%}%>
                </form>
                </tr>
            </thread>
        </table>
        <form action="Controller" method="post" style="width: 300px">
            <p>Ten San Pham  :<input type="text" name="txtTensp" value="" style="float: right" /></p>
            <p>Gia  :<input type="text" name="txtGia" value="" style="float: right" /></p>
            <p>URL Image  :<input type="text" name="txtImage" value="" style="float: right" /></p>

            <input type="submit" value="Add" name="btAction" />
            <a href="index.jsp"><button type="button">Home</button></a>
        </form>
    </body>
</html>