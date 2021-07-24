<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is hello2.jsp</h1>
<a href="<%=request.getContextPath()%>/test">go to test.jsp</a>
<img alt="..." src="<%=request.getContextPath()%>/resources/shoes2.jpg">

<form action="<%=request.getContextPath()%>/addproduct" enctype="multipart/form-data" method="post">
<div class="mb-3">
Upload Product Image (Optional)
<input type="file" name="imagefile" class="form-control">
<button type="submit">submit</button>
</div>


</form>

</body>
</html>