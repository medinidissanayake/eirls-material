<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <style>

.dropbtn {
    background-color: #4db8ff;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
       
}

.dropbtn:hover{
        background-color: white;
     color:#33adff;
     transition:0.5s;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #cce0ff;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
    cursor: pointer
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: white;
     color:#33adff;
     transition:0.5s;
     cursor: pointer
}

.NavBar{
    border:3px solid black;
        border-radius:1px;
    background-color:#4db8ff;
}
.space{ 
    width:900px;
    display:inline-block;





}
    </style>
    
  
    <body>
    <div class="NavBar">
    <a href="/home">    <button class="dropbtn">Home </button></a> 
     

    <a href="/reservedStocks">    <button class="dropbtn"> Reserve stock items </button></a> 
     <a href="/viewProducts">    <button class="dropbtn"> Check Product Details </button></a> 
         
          <div class="space"></div>
  <a href="/login">    <button class="dropbtn"> Logout </button></a> 
    </div>
     
      </div>
    </body>
</html>