<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <style>

.dropbtn {
    background-color: gray;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
       
}

.dropbtn:hover{
        background-color: white;
     color:purple;
     transition:0.5s;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
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
     color:purple;
     transition:0.5s;
     cursor: pointer
}

.NavBar{
    border:3px solid black;
        border-radius:1px;
    background-color:gray;
}
.space{ 
    width:900px;
    display:inline-block;





}
    </style>
    
  
    <body>
    <div class="NavBar">
    <a href="/homemanager">    <button class="dropbtn">Home </button></a> 
     
     <div class="dropdown">
  <button class="dropbtn">Manage suppliers</button>
  <div class="dropdown-content">
    <a href="/addSuppplier">Add supplier</a>
    <a href="/editSupplier">Edit supplier</a>
      <a href="/supStatus">Change supplier status</a>
       <a href="/performance">Record performance </a>
    </div>
    </div>
    
    <a href="/addItem">    <button class="dropbtn"> Add Item </button></a> 
            <a href="/assignSup">    <button class="dropbtn"> Assign Item to Supplier </button></a> 
          

           <div class="space"></div>
  <a href="/login">    <button class="dropbtn"> Logout </button></a> 
    </div>
     
      </div>
    </body>
</html>