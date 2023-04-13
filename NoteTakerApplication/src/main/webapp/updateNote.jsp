<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@ page isELIgnored="false" %>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-0 m-0 ">
		<%@include file="navbar.jsp"%>
	</div>
	</br>
	<div class="container">

		<form action="saveContentServelt" method="post">
			<h1>This is page for update notes</h1>
			<div class="form-group">
				<input type="text" name="noteId" value="${noteId} "
					class="form-control" id="noteId" aria-describedby="emailHelp" hidden>
			</div>
			<div class="form-group">
				<label for="title" class="form-label">Title</label> <input
					type="text" name="title" value="${title}" class="form-control"
					id="title" aria-describedby="emailHelp" required>
			</div>
			<div class="form-group">
				<label for="note-content" class="form-label">Contents</label>
				<textarea class="form-control" name="noteContent"
					id="note-content" style="height: 200px" required>${content}</textarea>
			</div>
			<br />
			<div clas="container">
				<button type="submit" class="btn btn-primary">Update</button>
			</div>

		</form>
	</div>
</body>
</html>