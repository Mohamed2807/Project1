<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<title>Register</title>
</head>
<body>


<div class="container">
<br>  <h1>KABSHA SHOPPING</h1>
<hr>


<div class="row justify-content-center">
<div class="col-md-6">
<div class="card">
<header class="card-header">

	<a href="/login" class="float-right btn btn-outline-primary mt-1">Log in</a>
	<h4 class="card-title mt-2">Registration</h4>
</header>
<article class="card-body">


<form:form action="" modelAttribute="user" method="POST">
	
	
   <form:input type="hidden" path="id" id="id"/>
    
		<div class="form-group ">
			<label>Full Name</label>   
		  	<form:input path ="username" type="text" class="form-control" placeholder="enter full name"/>
		</div> <!-- form-group end.// -->

	<div class="form-group">
		<label>Email address</label>
			<form:input path ="gmail" type="text" class="form-control" placeholder="enter email id"/>
		<small class="form-text text-muted">We'll never share your email with anyone else.</small>
	</div> <!-- form-group end.// -->
	<div class="form-group col-md-6">
			<label>MOBILE NO</label>
		  	<form:input path ="phonenumber" type="text" class="form-control" placeholder=" enter your number"/>
		</div>
	
	
	<div class="form-group">
		<label>Create password</label>
	   	<form:input path ="password" class="form-control" type="password"/>
	</div> <!-- form-group end.// --> 
	
		
  
   	<div class="form-group ">
		  <label>Door no</label>
		<form:input path="doorno" type="text" class="form-control"/>
		</div> <!-- form-group end.// -->
		
		<div class="form-group col-md-6">
		  <label>Area</label>
		<form:input path="street" type="text" class="form-control"/>
		</div> <!-- form-group end.// -->
   
   
		<div class="form-group col-md-6">
		  <label>City</label>
		<form:input path="city" type="text" class="form-control"/>
		</div> <!-- form-group end.// -->
		
		
		<div class="form-group col-md-6">
		  <label>PIN CODE</label>
		  <form:input path="pincode" type="text" class="form-control"/>
		 
		</div> <!-- form-group end.// -->
		
	
	 
         
    <small class="text-muted">By clicking the 'Register' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>                                          

   </div> <!-- form-group end.// -->
</article> <!-- card-body end .// -->
 <div class="form-group">
        <button type="submit" class="btn btn-primary "> Register  </button>
        </form:form>
     

    </div> <!-- form-group// -->
<div class="border-top card-body text-center">Have an account? <a href="/login">Log In</a></div>
</div> <!-- card.// -->
</div> <!-- col.//-->

</div> <!-- row.//-->



</div> 
<!--container end.//-->





</body>
</html>