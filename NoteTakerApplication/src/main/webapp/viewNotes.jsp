<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.noteTaker.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="com.noteTaker.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-0 m-0 ">
		<%@include file="navbar.jsp"%>
	</div>
	<div class="container p-3">
	<h3><center>View Notes</center></h3>
		<%
		 SessionFactory factory = FactoryProvider.getSessionFactory();
		Session se = factory.openSession();
		Query query = se.createQuery("from Note");
		List<Note> noteList = query.getResultList();
		for (Note note : noteList) {
		%>
		<div class="raw">
			<div class="col-12">
				<div class="card mt-3" >
					<img src="images/notes.png" style="max-width: 100px" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title"><%= note.getNoteTitle() %></h5>
						<p class="card-text"><%= note.getNoteContent() %></p>
						<a onclick="deleteNote(<%= note.getNoteId() %>)" class="btn btn-danger">Delete</a>
						<a href="updateNoteServlet?id=<%= note.getNoteId() %>" class="btn btn-primary">Update</a>
					</div>
				</div>
			</div>
		</div>
		<%
		}
		se.close();
		%>

	</div>
	<script type="text/javascript">
		function deleteNote(noteId){
			 $.ajax({
		            url:'deleteNoteServlet',
		            data:{note_Id:noteId},
		            type:'post',
		            cache:false,
		            success:function(data){
		               window.location.reload();
		            },
		            error:function(){
		              alert('error');
		            }
		         }
		    );
		}
	
	</script>
</body>
</html>