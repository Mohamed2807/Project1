<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="/CSS/product.css"  rel="stylesheet"> 
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<meta charset="ISO-8859-1">

</style>
<title>Insert title here</title>
</head>
<body>
 <%@include file="/WEB-INF/views/admin.jsp" %> 
 

<h1 class="visually-hidden"></h1>
<main>
  <h2 class="visually-hidden"></h2>
  <div class="row row-cols-lg-4 g-2">
   <c:forEach items="${allproduct}" var="product">
    <div class="col">
      <div class="card">
        <a class="card-item-link" href="#">
          <img class="card-img-top img-fluid" src="data:image/jpeg;base64,${product.myimageobj}" alt="" aria-labelledby="title_1" width="270" height="200">
        </a>
        <div class="card-body">
          <div class="card-item-header">
            <p class="card-item-code"> "${product.brand}"</p>
            
            <div class="rate">
              <p class="card-item-rating">
                 
              </p>
              <a class="card-item-code link" href="#"> </a>
            </div>
          </div>
          <h3 class="card-title" id="title_1">${product.name}</h3>
         
          <div class="card-item-footer">
            <p class="card-item-price">&#8377;${product.prize}
            <a href='/wishlist1-${product.id}'><button class="button10">Buy This</button></a>
            </p>
          <a href='/wishlist-${product.id}'><button class="card-item-btn card-item-button--favourite btn" type="button">
        
              <img src="https://cdn-icons-png.flaticon.com/512/1216/1216575.png" alt=""> 
             </button></a> 
             
            </div>
        </div>
      </div>
    </div>
    </c:forEach>

    
</div>
</main>

</body>
</html>