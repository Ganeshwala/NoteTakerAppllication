<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Note</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-0 m-0 ">
		<%@include file="navbar.jsp"%>
	</div>
	</br>
	<div class="container">
		
		<form action="saveContentServelt" method="post">
		<h1>This is page for add notes</h1>
			<div class="form-group">
				<label for="title" class="form-label">Title</label> 
				<input
					type="text" name="title" class="form-control" id="title"
					aria-describedby="emailHelp" required>
			</div>
			<div class="form-group">
				<label for="note-content" class="form-label">Contents</label>
				<textarea class="form-control" name="noteContent" id="note-content" style="height: 200px" required></textarea>
			</div>
			<br/>
			<div clas="container">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>
			
		</form>
	</div>

</body>
</html>