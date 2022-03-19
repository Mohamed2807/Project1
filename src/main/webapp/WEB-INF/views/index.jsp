<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/CSS/style.css" rel="stylesheet">
 <link href="/CSS/cate.css"  rel="stylesheet">
 

 <title>KABSHA Shopping</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

     <%@include file="admin.jsp" %> 
    
    
    
    
    
     <div class="container mt-100">
    <div class="row">
        <div class="col-md-4 col-sm-6"> 
            <div class="card mb-30"><a class="card-img-tiles" href="" data-abc="true">
                    <div class="inner">
                        <div class="main-img"><img src="/img/shirts.jpg"alt="Category"></div>
                        <div class="thumblist"><img src="/img/pant.jpg" alt="Category">
                        <img src="/img/shorts.jpg" alt="Category"></div>
                    </div>
                </a>
                <div class="card-body text-center">
                    <h4 class="card-title">Dresses</h4>
                    <p class="text-muted">hurry up!! 30% offer</p><a class="btn btn-outline-primary btn-sm" href="/productdress" data-abc="true">View Products</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-6">
            <div class="card mb-30"><a class="card-img-tiles" href="#" data-abc="true">
                    <div class="inner">
                        <div class="main-img"><img src="/img/sonata.png" alt="Category"></div>
                        <div class="thumblist"><img src="/img/titan.jpg" alt="Category">
                        <img src="/img/digital.jpg" alt="Category"></div>
                    </div>
                </a>
                <div class="card-body text-center">
                    <h4 class="card-title">Watches</h4>
                    <p class="text-muted"> hurry up!! 40% Offer</p><a class="btn btn-outline-primary btn-sm" href="/productwatches" data-abc="true">View Products</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-6">
            <div class="card mb-30"><a class="card-img-tiles" href="#" data-abc="true">
                    <div class="inner">
                        <div class="main-img"><img src="/img/formalshoe.jpg" alt="Category"></div>
                        <div class="thumblist"><img src="/img/casualshoe.jpg" alt="Category">
                        <img src="/img/chapal.jpg" alt="Category"></div>
                    </div>
                </a>
                <div class="card-body text-center">
                    <h4 class="card-title">Shoes</h4>
                    <p class="text-muted">hurry up!! 25% offer</p><a class="btn btn-outline-primary btn-sm" href="/productfootwear" data-abc="true">View Products</a>
                </div>
            </div>   
            </div>
    </div>
</div>
</div>
    
</body>
</html>