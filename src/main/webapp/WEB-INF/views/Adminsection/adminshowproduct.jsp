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
<title>Insert title here</title>
<style>
.button1 {
  background-color: red;
  border: none;
  color: white;
  padding: 10px 40px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 10px;
  cursor: pointer;
}
</style>
</head>
<body>
 <%@include file="/WEB-INF/views/headline.jsp" %> 
 

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
                 <b>SIZE</b>
              </p>
              <a class="card-item-code link" href="#">${product.size} </a>
            </div>
          </div>
          <h3 class="card-title" id="title_1">${product.name}</h3>
          <div class="card-item-footer">
            <p class="card-item-price">${product.prize}</p>
          <a href='/dressdelete-${product.id}'><button class="button1" type="button">Delete
        
              
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