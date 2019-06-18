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
    table.center {
  border-collapse: collapse;
  width: 80%;
  
    margin-left:auto; 
    margin-right:auto;
  
}

     th{
      background-color: #cce0ff;
  color: black;
  height: 70px;
    }
     tr{
      background-color: #cce0ff;
  color: black;
    }
   

    </style>
</head>
<body>
<jsp:include page="clerkNavBar.jsp"/>

<br>
<br>

<table border="2", class= "center">

    <th>Item name</th>
    <th>Item type</th>
    <th>Item quantity</th>
    <th>Item price</th>
     <th>Reorder quantity</th>
    

    <c:forEach var="products" items="${list}">
      <tr>
        <td>${products.getItem_name()}</td>
        <td>${products.getItem_type()}</td>
        <td>${products.getItem_quantity()}</td>
       <td>${products.getItem_price()}</td>
       <td>${products.getReorder_quantity()}</td>
       
      </tr>
    </c:forEach>
  </table>
  </form>
   
</body>
</html>