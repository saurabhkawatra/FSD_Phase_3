<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sportyshoes.MODELS.Product"%>
<%@page import="java.util.List"%>
<%@page import="sportyshoes.SERVICE.ProductSERVICE"%>
<%@page import="sportyshoes.MODELS.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>SportyShoes Admin Dashboard</title>
</head>
<body style="background-color:dodgerblue;">

	<%User u1=(User)request.getSession(false).getAttribute("user_admin");
		if(u1==null){
			response.sendRedirect(request.getContextPath()+"/login");
		}else if(!u1.getUser_type().equals("admin")) {
			response.sendRedirect(request.getContextPath()+"/login");
		}
	%>



    <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
        <div class="container-fluid">
            <img class="navbar-brand" src="<%=request.getContextPath()%>/Resources/logo2.png" style="height:3%;width:3%;"/>
            <img class="navbar-brand" src="<%=request.getContextPath()%>/Resources/logotext.gif" style="height:15%;width:15%;"/>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/admin/admin-home" style="font-family: 'Lucida Bright';font-weight:bolder;">Home</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-family: 'Copperplate Gothic';font-weight:bold;">
                            Products
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#addproduct">Add Product</a></li>
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#removeproduct">Remove Product</a></li>
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#updateexistingproduct">Update Existing Product</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#showallproducts">Show All Products</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-family: 'Copperplate Gothic';font-weight:bold;">
                            Customers
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#searchcustomer">Search Customer</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#showallcustomers">Show All Customers</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-family: 'Copperplate Gothic';font-weight:bold;">
                            Purchase Reports
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Search Purchases</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Show All Purchases</a></li>
                        </ul>
                    </li>

                    

                    <li class="nav-item">
                        
                    </li>
                </ul>
                <form action="<%=request.getContextPath()%>/logout" method="post" class="d-flex">
                
                	<a class="nav-link text-primary" href="#" style="font-family:'Copperplate Gothic';font-weight:bolder;">Change Login Password</a>
                    <button class="btn btn-outline-danger" type="submit">Logout</button>
                    
                </form>
            </div>
        </div>
    </nav>
    
    
    <div class="modal fade" id="addproduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog">
									    <div class="modal-content">
									      <div class="modal-header bg-secondary">
									        <h5 class="modal-title text-light" id="exampleModalLabel">Add New Product</h5>
									        <button type="button" class="btn-close btn-outline-light" data-bs-dismiss="modal" aria-label="Close"></button>
									      </div>
							      <form action="<%=request.getContextPath()%>/admin/addproduct" enctype="multipart/form-data" method="post">
									      <div class="modal-body">
												        
												        	<div class="mb-3">
															Product Name
															<input name="product_name" type="text" placeholder="Enter Product Name" class="form-control" required="required">
															</div>
															<div class="mb-3">
															Select Product Type
															<select name="product_type" class="form-select" required="required">
															<option value="">Select</option>
															<option value="Casual">Casual</option>
															<option value="Sports">Sports</option>
															<option value="Trendy">Trendy</option>
															<option value="Traditional">Traditional</option>
															<option value="Office Wear">Office Wear</option>
															</select>
															</div>
															<div class="mb-3">
															Select Product For
															<select name="product_for" class="form-select" required="required">
															<option value="">Select</option>
															<option value="Men">Men</option>
															<option value="Women">Women</option>
															<option value="Children">Children</option>
															</select>
															</div>
															<div class="mb-3">
															Upload Product Image (Optional)
															<input type="file" name="imagefile" class="form-control">
															</div>
															<div class="mb-3">
															Product Price
															<input name="product_price" type="number" min="0" max="2147483647" class="form-control" required="required">
															</div>
															
									      </div>
								      <div class="modal-footer bg-secondary">
									       <button type="submit" class="btn btn-primary">Add Product</button>
									       <button type="button" class="btn btn-light" data-bs-dismiss="modal">Cancel</button>
								      </div>
						      </form>
								    </div>
								  </div>
								</div>
								
								
								
								
	<div class="modal fade" id="removeproduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-xl">
		    <div class="modal-content">
		      <div class="modal-header bg-danger sticky-top">
		        <h5 class="modal-title text-light" id="exampleModalLabel" style="font-weight: bold;">Remove Product</h5>
		        <button type="button" class="btn-close btn-outline-light" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
      <form action="<%=request.getContextPath()%>/admin/removeproduct" method="post">
		      <div class="modal-body">
					        
					        	<table class="table table-danger table-striped" style="text-align: center;">
					        		<thead class="sticky-top table-dark" style="top:62px"><tr><th>Select here</th><th>Product Id</th><th>Product Name</th><th>Product Type</th><th>Product For</th><th>Product Image</th><th>Product Price</th></tr></thead>
					        		
					        		<tbody>
					        											
					        											<%
					        					List<Product> productlist=new ArrayList<>();
					        					productlist=(List<Product>)request.getAttribute("productlist");
					        							for(Product p:productlist){
					        											%>
					        				<tr style="vertical-align: middle;"><td><input class="form-check-input" type="checkbox"></td><td><%=p.getProduct_id()%></td><td><%=p.getProduct_name()%></td><td><%=p.getProduct_type()%></td><td><%=p.getProduct_for()%></td><td><img src="<%=request.getContextPath()%>/Resources/uploads/<%=p.getProduct_image_name()%>" width="200px" height="100px"><p><%=p.getProduct_image_name()%></p></td><td><%=p.getProduct_price()%></td></tr>
					        				  <%}%>
					        		</tbody>
					        	
					        	
					        	
					        	</table>
								
		      </div>
	      <div class="modal-footer bg-light">
	      		<div class="container" align="center">
		       <button type="submit" class="btn btn-outline-danger">Remove Selected Products</button>
		       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
		       </div>
	      </div>
     </form>
	    </div>
	  </div>
	</div>
	
	
	
	
	
	
	<div class="modal fade" id="updateexistingproduct" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-xl">
		    <div class="modal-content">
		      <div class="modal-header bg-success sticky-top">
		      	<div align="center" class="container">
		        <h5 class="modal-title text-light" id="exampleModalLabel" style="font-weight: bold;">Update A Product</h5>
		        </div>
		        <button type="button" class="btn-close btn-outline-light" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
					        
					        	<table class="table table-success table-striped" style="text-align: center;">
					        		<thead class="sticky-top table-dark" style="top:62px"><tr><th>Product Id</th><th>Product Name</th><th>Product Type</th><th>Product For</th><th>Product Image</th><th>Product Price</th><th></th></tr></thead>
					        		
					        		<tbody>
					        		
					        											<%
					        							for(Product p:productlist){
					        											%>
					        											
					        				<tr style="vertical-align: middle;"><td><%=p.getProduct_id()%></td><td><%=p.getProduct_name()%></td><td><%=p.getProduct_type()%></td><td><%=p.getProduct_for()%></td><td><img src="<%=request.getContextPath()%>/Resources/uploads/<%=p.getProduct_image_name()%>" width="200px" height="100px"><p><%=p.getProduct_image_name()%></p></td><td><%=p.getProduct_price()%></td><td><a class="btn btn-outline-success" href="<%=request.getContextPath()%>/updateproduct/<%=p.getProduct_id()%>">Update</a></td></tr>                                                                                                
					        						
					        				 							 <%}%>
					        		</tbody>
					        	
					        	
					        	
					        	</table>
								
		      </div>
	      <div class="modal-footer bg-light">
	      		<div class="container" align="center">
		       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">OK</button>
		       </div>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	
	<div class="modal fade" id="showallproducts" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-xl">
		    <div class="modal-content">
		      <div class="modal-header bg-secondary sticky-top">
		      	<div align="center" class="container">
		        <h5 class="modal-title text-light" id="exampleModalLabel" style="font-weight: bold;">List of all Products</h5>
		        </div>
		        <button type="button" class="btn-close btn-outline-light" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
					        
					        	<table class="table table-success table-striped" style="text-align: center;">
					        		<thead class="sticky-top table-dark" style="top:62px"><tr><th>Product Id</th><th>Product Name</th><th>Product Type</th><th>Product For</th><th>Product Image</th><th>Product Price</th></tr></thead>
					        		
					        		<tbody>
					        											
					        											<%
					        							for(Product p:productlist){
					        											%>
					        				<tr style="vertical-align: middle;"><td><%=p.getProduct_id()%></td><td><%=p.getProduct_name()%></td><td><%=p.getProduct_type()%></td><td><%=p.getProduct_for()%></td><td><img src="<%=request.getContextPath()%>/Resources/uploads/<%=p.getProduct_image_name()%>" width="200px" height="100px"><p><%=p.getProduct_image_name()%></p></td><td><%=p.getProduct_price()%></td></tr>
					        				  <%}%>
					        		</tbody>
					        	
					        	
					        	
					        	</table>
								
		      </div>
	      <div class="modal-footer bg-light">
	      		<div class="container" align="center">
		       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">OK</button>
		       </div>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	


    <h1></h1>
    <br />
    <br />
    <br />
    <br />
    
    <div class="container" style="width:700px;">
    <div class="shadow-lg p-3 mb-5 bg-dark rounded" align="center">
    <img src="<%=request.getContextPath()%>/Resources/logo2.png" style="height:20%;width:20%;" />
    <img src="<%=request.getContextPath()%>/Resources/logotext.gif" style="height:30%;width:30%;" />
    </div>
    </div>

    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    
	


	<br />
    <br />
    <br />

    <h6 style="text-align:center;color:cornsilk;font-weight:bold">&#64;Project By Saurabh Kawatra</h6>

    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />













    <!-- Optional JavaScript; choose one of the two! -->
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>