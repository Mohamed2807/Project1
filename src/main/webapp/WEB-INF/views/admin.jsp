<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
function myFunction() {
  alert("You Successfully logged out");
}
</script>
 
  <link href="/CSS/admin.css"  rel="stylesheet">

</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
 
  <button class="dropdown-btn">Shirts 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/formalshirt">Formal Shirts</a>
    <a href="/plainshirt">Plain Shirts</a>
    <a href="/checkedShirts">Checked Shirts</a>
     <a href="/printedshirts">Printed Shirts</a>
  </div>
   <button class="dropdown-btn">Pants 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/formalpants">Formal Pants</a>
    <a href="/shorts"> Shorts</a>
    <a href="/jeanpants">Jeans Pants</a>
     <a href="/checkedpants">Checked Pants</a>
  </div>
   <button class="dropdown-btn">SHOES 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/formalshoes">Formal Shoes</a>
    <a href="/sportshoes"> Sports Shoes</a>
    <a href="/chapal">Chapal</a>
    
  </div>
  <button class="dropdown-btn">Watches
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/analogwatch">Analog Watches</a>
    <a href="/digitalwatch"> Digital Watches</a>
    <a href="/smartwatch">Smart Watches</a>
    
  </div>
  
  <a href="/logout"><button onclick="myFunction()">Sign Out</button></a>
   
   <a href="/about">About</a>
<!--   <button class="dropdown-btn">Dropdown  -->
<!--     <i class="fa fa-caret-down"></i> -->
<!--   </button> -->
<!--   <div class="dropdown-container"> -->
<!--     <a href="#">Link 1</a> -->
<!--     <a href="#">Link 2</a> -->
<!--     <a href="#">Link 3</a> -->
<!--   </div> -->
  
</div>

<div class="topnav">

<span style="font-size:30px;cursor:pointer;color:#f2f2f2" onclick="openNav()">&#9776; KABSHA E-SHOPPING</span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
   document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft = "0";
}

var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
  this.classList.toggle("active");
  var dropdownContent = this.nextElementSibling;
  if (dropdownContent.style.display === "block") {
  dropdownContent.style.display = "none";
  } else {
  dropdownContent.style.display = "block";
  }
  });
}
</script>
  
  <div class="topnav-right">
   <a class="active" href="/home">Home</a> 
    <a href="/contact">Contact</a>
   <a href="/register">Sign Up</a>
   <a href="/login">Sign In</a>
  
  
   
   <a href="/wishlist">WishList</a>
   
  
  </div>
</div>
<div id="main">
<div style="padding-left:16px">



  
</div>



   
</body>
</html> 
