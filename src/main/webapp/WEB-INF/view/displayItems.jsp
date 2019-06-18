<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Display products</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style>
    body {
       
    background-color: #E6E6FA;
    font-family: Times New Roman;
    font-size: 20px;
    text-align:center;
    

    }
    
    

    </style>
</head>
<body>
<jsp:include page="managerNavBar.jsp"/>
<%-- <form action="/cancelOrder" method="post">
 <input type="hidden" name="myField" id="myField" value="" /> --%>
<table border="2">

    <th>Item name</th>
    <th>Item type</th>
    <th>Item quantity</th>
    

    <c:forEach var="products" items="${list}">
      <tr>
        <td>${products.getItem_name()}</td>
        <td>${products.getItem_type()}</td>
        <td>${products. getItem_quantity()}</td>
       
        <%-- <td><a href="/cancelOrder"> <button type="submit" class="button" value="${emp.getOrder_id()}" onclick="senddata(this)" name="confirm"> Cancel Order </button></a> </td> --%>
      </tr>
    </c:forEach>
  </table>
  </form>
   <%-- <script>
          function senddata(e){
              
             document.getElementById('myField').value= e.value; 
              
              
          }
          
          
          
          
          </script> --%>
</body>
</html>
