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
          action="/recordPerformance" modelAttribute="suppliermodel">
             <table>
              <tr>
               <td><form:label path = "supplierID">Select Supplier ID</form:label></td>
               <td>
                  <form:select path = "supplierID">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${supList}" />
                  </form:select>       
               </td>
            </tr>
                <tr>
                    <td><form:label path="deliveryperform">Delivery Performance</form:label></td>
                    <td><form:input path="deliveryperform"/></td>
                </tr>
                <tr>
                    <td><form:label path="qualityperform">Quality Performance</form:label></td>
                    <td><form:input path="qualityperform"/></td>
                </tr>
                <tr>
                <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

      
</body>
</html>