<%@page import="java.util.List"%>
<%@page import="com.entity.Wishlist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="	https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">
 <link rel="stylesheet" href="	https://use.fontawesome.com/releases/v5.7.2/css/all.css">
 <link rel="stylesheet" href="	https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
<link href="/CSS/wishlist.css"  rel="stylesheet">
</head>
<body>
<div class="wrapper">

    <div class="d-flex align-items-center justify-content-between">
        <div class="d-flex flex-column">
            <div class="h3">My lists</div>
          
        </div>
        <div class="ml-auto btn"><span class="fas fa-cog"></span></div>
       
    </div>
    <div class="notification alert alert-dismissible fade show text-white d-flex align-items-center my-3 text-justify" role="alert"> <span class="far fa-bell pr-2"></span>  <button type="button" class="close text-white ml-auto" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true"> Ok, Thanks </span> </button> </div>
    <div id="table" class="bg-white rounded">
        <div class="d-md-flex align-items-md-center px-3 pt-3">
            <div class="d-flex flex-column">
                <div class="h4 font-weight-bold">Kabsha Shopping</div>
               
            </div>
            <div class="ml-auto d-flex align-items-center">
         
            </div>
        </div>
        <hr>
        <div class="table-responsive">
            <table class="table activitites">
                <thead>
                    <tr>
                        <th scope="col" class="text-uppercase header">item</th>
                        <th scope="col" class="text-uppercase">Quantity</th>
                        <th scope="col" class="text-uppercase">price each</th>
                        <th scope="col" class="text-uppercase">total</th>
                    </tr>
                </thead>
                <tbody>
<%--                 <%long netAmount =0; %> --%>
                 <c:forEach items="${wishlist}" var="wishlist">
                    <tr>
                    
                        <td class="item">
                         
                                <div class="pl-2">${wishlist.name} <div class="text-uppercase new"><span class="fas fa-star"></span>new</div>
                                    <div class="d-flex flex-column justify-content-center">
                                        <div class="text-muted">Blue</div>
                                        <div><a href="#"><span class="red text-uppercase"><span class="fas fa-comment pr-1"></span>add a comment</span></a> </div>
                                    </div>
                                </div>  
                        </td>
                        <td>${wishlist.productcount}</td>
                        <td class="d-flex flex-column"><span class="red">${wishlist.buyingprize} RS</span>  </td>

                        <td class="font-weight-bold"> ${wishlist.total} RS <div class="red text-uppercase"></div><a href="/pdf"> <button class="d-flex justify-content-end btn border">PAY THIS</button></a> </td>
                        
                        
                    </tr>
                     </c:forEach>
                          
                    
                </tbody>
            </table>
            
                
        </div>
      
       
    </div>
   
              
               
            </div>
          
        </div>
    </div>
   
</div>
 
</body>
</html>
