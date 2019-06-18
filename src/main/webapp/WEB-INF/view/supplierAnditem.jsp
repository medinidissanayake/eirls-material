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
          action="/assignSupplier" modelAttribute="suppliermodel">
             <table>
              
            <tr>
               <td><form:label path = "supplierID">Select supplier ID</form:label></td>
               <td>
                  <form:select path = "supplierID">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${supList}" />
                  </form:select>       
               </td>
            </tr>
  <tr>
               <td><form:label path = "brandname">Select item id</form:label></td>
               <td>
                  <form:select path = "brandname">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${itemList}" />
                  </form:select>       
               </td>
            </tr>
             <tr>
                    <td><form:label path="orderquantity">Reorder quantity</form:label></td>
                    <td><form:input path="orderquantity"/></td>
                </tr>
                 <tr>
                    <td><form:label path="leadtime">Lead time</form:label></td>
                    <td><form:input path="leadtime"/></td>
                </tr>
               
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

      
</body>
</html>