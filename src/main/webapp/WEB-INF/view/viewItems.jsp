<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Display products</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<jsp:include page="clerkNavBar.jsp"/>

<table border="2">

    <th>Item name</th>
    <th>Item type</th>
    <th>Item quantity</th>
    <th>Item price</th>
    

    <c:forEach var="products" items="${list}">
      <tr>
        <td>${products.getItem_name()}</td>
        <td>${products.getItem_type()}</td>
        <td>${products. getItem_quantity()}</td>
       <td>${products. getItem_price()}</td>
       
      </tr>
    </c:forEach>
  </table>
  </form>
   
</body>
</html>