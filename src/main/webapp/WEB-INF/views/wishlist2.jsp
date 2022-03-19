<%@page import="com.service.WishServiceimpl"%>
<%@page import="com.entity.Wish"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="	https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="	https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<link href="/CSS/wishlist2.css"  rel="stylesheet">
</head>
<body>


<div class="card">
    <div class="row">
        <div class="col-md-8 cart">
            <div class="title">
                <div class="row">
                    <div class="col">
                        <h4><b>Shopping Cart</b></h4>
                    </div>
                    <div class="col align-self-center text-right text-muted">3 items</div>
                </div>
            </div>
            <div class="row border-top border-bottom">
                <div class="row main align-items-center">
                    <div class="col-2"></div>
                    <div class="col">
                        
                        <div class="row">Products</div>
                    </div>
                    <div class="col"><a href="#" class="border">Quantity</a> </div>
                    <div class="col"> Total Amount <span class="close"></span></div>
                </div>
            </div> 
             
            <div class="row">
             <c:forEach items="${wishlist}" var="wishlist">
            
                <div class="row main align-items-center">
                    <div class="col-2"><img class="img-fluid" src="data:image/jpeg;base64,${wishlist.myimageobj}"></div>
                    <div class="col">
                        <div class="row text-muted">Shirt</div>
                        <div class="row">${wishlist.name}</div>
                    </div>
                    <div class="col"> <a href="#" class="border">${wishlist.productcount}</a> </div>
                    <div class="col">&#8377; ${wishlist.total} <a href="/deletewishlist-${wishlist.id}"><span class="close">&#10005;</span></a></div>
                </div>
                 </c:forEach>
                
            </div>
             
         
            <div class="back-to-shop"><a href="#"></a><span class="text-muted"></span></div>
        </div>
        <div class="col-md-4 summary">
            <div>
                <h5><b>Summary</b></h5>
            </div>
            <hr>
            <div class="row">
           
                <div class="col" style="padding-left:0;"></div>
                <div class="col text-right"> </div>
                 
            </div>
            <form>
                <p>SHIPPING Amount </p> <select>
                    <option class="text-muted">Standard-Delivery- &#8377;50</option>
                </select>
                <p>GST Value</p> <input id="code" placeholder="5%">
            </form>
            <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
               TOTAL PRICE
                 
                &#8377;
                <input type="number" name="total" value='${requestScope.netamount}' disabled/>
                
                </div>
                
            <div class="row">
             <form method="post" action="/submitPaymentDetail">
             <a  href="/submitPaymentDetail"><button class="btn">online payment</button></a></form></div>
           <div class="row">  <a  href="/pdf"><button class="btn">cash on delivery</button></a></div>
        </div>
    </div>
</div>

</body>
</html>