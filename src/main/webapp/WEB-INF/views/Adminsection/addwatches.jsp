<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>


<!--<form class="form-horizontal">-
<fieldset>

<!-- Form Name -->
<legend>PRODUCTS</legend>

<form:form action="" modelAttribute="product" method="POST" class="form-horizontal" enctype = "multipart/form-data">
   <form:input type="hidden" path="id" id="id"/>
<!-- Text input-->
<div class="form-group">

<fieldset>
   
   
  <label class="col-md-4 control-label" for="name">Product Name</label>  
  <div class="col-md-4">
  <form:input id="name" path="name" placeholder="Enter the product name" class="form-control input-md" required="" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Brand">Brand NAME</label>  
  <div class="col-md-4">
  
<%--      <form:input id="brand" path="brand" placeholder="Enter the brand name" class="form-control input-md" required="" type="text"/> --%>
     <form:select id="brand" path="brand" class="form-control input-md">
  
           <option value="analogwatch">Analog Watches</option>
             <option value="digitalwatch">Digital Watches</option>
               <option value="smartwatchwatch">Smart Watches</option>
  
</form:select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="material">Material NAME</label>  
  <div class="col-md-4">
  
  
<%--      <form:input id="material" path="material" placeholder="Enter the material name" class="form-control input-md" required="" type="text"/> --%>
     <form:select id="material" path="material" class="form-control input-md">
 
  <option value="watch">Watches</option>
 
  
</form:select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="description">description</label>
  <div class="col-md-4">
    <form:input id="description" path="description" placeholder="Enter the description" class="form-control input-md" required="" type="text"/>

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">prize</label>  
  <div class="col-md-4">
      <form:input id="prize" path="prize" placeholder="Enter the prize" class="form-control input-md" required="" type="number"/>

    
  </div>
</div>

<!-- Text input-->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="product_weight">size</label>   -->
<!--   <div class="col-md-4"> -->
<%--     <form:input id="size" path="size" placeholder="Enter the size" class="form-control input-md" required="" type="number"/> --%>
    
<!--   </div> -->
<!-- </div> -->




<!-- <!-- File Button -->  
 <div class="form-group"> 
  <label class="col-md-4 control-label" for="filebutton">images</label> 
  <div class="col-md-4"> 
     <input  name="myImage" type="file" class="form-control" id="myImage" aria-describedby="" placeholder="Enter image"/>
    
  </div> 
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Single Button</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
  </div>
   </fieldset>
  </div>
 
  </form:form>
  
 

</body>
</html>