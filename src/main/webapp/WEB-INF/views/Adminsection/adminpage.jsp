<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button1 {
  background-color: black;
  border: none;
  padding: 20px 50px;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 10px;
  cursor: pointer;
}

.button {
  background-color: grey;
  border: none;
  color: white;
  padding: 60px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 10px;
  cursor: pointer;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;

}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

</style>
 
 <script>
 function myFunction() {
   var x = document.getElementById("myDIV");
   if (x.style.display === "none") {
     x.style.display = "block";
   } else {
     x.style.display = "none";
   }
 }
 
 function myFunction1() {
	   var x = document.getElementById("myDIV1");
	   if (x.style.display === "none") {
	     x.style.display = "block";
	   } else {
	     x.style.display = "none";
	   }
	 }

</script> 
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/headline.jsp" %> 

<h1>Welcome Admin</h1>

<h3>upload products</h3>
<a href="/adddresses" class="button">Add Dresses</a>
<a href="/addshoes" class="button">Add Shoes</a>
<a href="/addwatches" class="button">Add Watches</a>


<h2>List Of Products</h2>
<a href="/admindress" class="button">Dresses</a>
<a href="/adminfootwear" class="button">Shoes</a>
<a href="/adminwatches" class="button">watches</a>

<h2> Customer List</h2>
<button class="button" onclick="myFunction()">Customers</button>

<div id="myDIV">
 <table>
  <tr>
  <th>NO.</th>
    <th>Customber Name</th>
    <th>Phone number </th>
    <th>Gmail</th>
     <th>Door No</th>
      <th>Area</th>
      <th>city</th>
      <th>pincode</th>
       
      
      
  </tr>
  <c:forEach items="${users}" var="users">
  <tr>
    <td>${users.id}</td>
    <td>${users.username}</td>
    <td> ${users.phonenumber}</td> 
      <td> ${users.gmail}</td> 
    <td> ${users.doorno}</td>
    <td> ${users.street}</td>
    <td> ${users.city}</td>
    <td> ${users.pincode}</td>
    
    
  
  </tr>
</c:forEach>

</table></div>


  <h3> order list</h3>
   <button class="button" onclick="myFunction1()">Orders</button>

<div id="myDIV1">
 <table>
  <tr>
  <th>NO.</th>
  
    <th>Customber Name</th>
    <th>Phone number </th>
    <th>Addresses </th>
    <th>No of Products</th>
     <th>Amount</th>
      <th>Payment</th>
      <th>Delivery</th>
      <th>Verification</th>
       
      
      
  </tr>
  <c:forEach items="${admin}" var="admin">
  <tr>
    <td>${admin.id}</td>
    <td>${admin.username}</td>
    <td> ${admin.phonenumber}</td> 
      <td> ${admin.address}</td> 
    <td> ${admin.count}</td>
    <td> ${admin.total}</td>
    <td> ${admin.payment}</td>
    <td><a href="/confirm-${admin.id}"   class="button1" >${admin.delivery}</a> </td>
   
     <td><a href="/confirm-${admin.id}"   class="button1" >Verify Product</a></td>
    
  
  </tr>
</c:forEach>

</table></div>
 
  
            
              
                
                

</body>
</html>