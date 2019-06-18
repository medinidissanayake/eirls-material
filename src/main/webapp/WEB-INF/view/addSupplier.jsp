<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style>
    body {
       
    background-color: #E6E6FA;
    font-family: Times New Roman;
    font-size: 20px;
    text-align:center;
    

    }
   
     table {
         border-collapse: separate;
  border-spacing: 15px;
  margin-left:250px;
    margin-top:25px;
    font-size: 23px;
     font-family: Times New Roman;
  text-align:left;
}
    input[type=submit] {
    width: 10em;  height: 2em;
}
    </style>
</head>
<body>
  <jsp:include page="managerNavBar.jsp"/>
   <form:form method="POST"
          action="/placeSupp" modelAttribute="suppliermodel">
             <table>
                <tr>
                    <td><form:label path="brandname">Brand Name</form:label></td>
                    <td><form:input path="brandname"/></td>
                </tr>
                <tr>
                    <td><form:label path="deliveryloc">Delivery Location</form:label></td>
                    <td><form:input path="deliveryloc"/></td>
                </tr>
                <tr>
                    <td><form:label path="mainloc">Main Location</form:label></td>
                    <td><form:input path="mainloc"/></td>
                </tr>
                <tr>
                    <td><form:label path="collectionloc">Collection Location</form:label></td>
                    <td><form:input path="collectionloc"/></td>
                </tr>
                <tr>
                    <td><form:label path="contact">Contact Number</form:label></td>
                    <td><form:input path="contact"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email Address</form:label></td>
                    <td><form:input path="email"/></td>
                <</tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

      
</body>
</html>