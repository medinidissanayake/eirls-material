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
          action="/placeItem" modelAttribute="itemmodel">
             <table class="center">
                <tr>
                    <td><form:label path="itemname">Product Name</form:label></td>
                    <td><form:input path="itemname"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="quantity">Product Quantity</form:label></td>
                    <td><form:input path="quantity"/></td>
                </tr>
                <tr>
                    <td><form:label path="price">Product Price</form:label></td>
                    <td><form:input path="price"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Product Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><form:label path="reorderlevel">Reorder Level</form:label></td>
                    <td><form:input path="reorderlevel"/></td>
                </tr>
              <tr>
                    <td><form:radiobutton path="itemtype" value="Finished Good"/> Finished Good
                     <form:radiobutton path="itemtype" value="Raw Material"/> Raw Material 
                      </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

      
</body>
</html>