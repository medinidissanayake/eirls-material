<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Login </title>
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
    margin-top:20px;
    font-size: 23px;
     font-family: Times New Roman;
  text-align:left;
}
    input[type=submit] {
    width: 10em;  height: 2em;
}
    
p{
    margin-left:270px;
    font-size: 26px;
    text-align:left;
     font-family: Times New Roman;
}
    </style>
</head>
<body>
  <p><b> Login </b></p>
   <form:form method="POST"
          action="/placelogin" modelAttribute="usermod">
             <table>
                <tr>
                    <td><form:label path="username">Username</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="pass">Password</form:label></td>
                    <td><form:input path="pass"/></td>
                </tr>
        
                <</tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

      
</body>
</html>