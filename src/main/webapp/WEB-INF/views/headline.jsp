<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <header> 
 
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">KABSHA SHOPPING</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="#navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="#navbarText">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/contact">CONTACT</a>
                  </li>
                   <li class="nav-item">
                    <a class="nav-link" href="/about">ABOUT</a>
                  </li>
<%--                     <c:if test="${signin == true }"> --%>
                  
                    
                   <li class="nav-item dropdown">
                   <a class="nav-link dropdown-toggle" href="/product" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Add product
                    </a>
                    </li>
                    
                
                </ul>
               
              </div>
            </div>
          </nav>
    </header>
</body>
</html>