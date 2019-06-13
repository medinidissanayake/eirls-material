<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Sign up</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  
   <form:form method="POST"
          action="/signupsubmit" modelAttribute="usermod">
             <table>
              <tr>
                    <td><form:label path="username">User name</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="pass">Password</form:label></td>
                    <td><form:input path="pass"/></td>
                </tr>
                <tr>                 
                <td><form:radiobutton path="usertype" value="Material Clerk"/> Material Clerk
                <form:radiobutton path="usertype" value="Material Manager"/> Material Manager
                </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

      
</body>
</html>