package com.noteTaker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.noteTaker.entities.Note;
import com.noteTaker.helper.FactoryProvider;

/**
 * Servlet implementation class deleteNoteServlet
 */
public class deleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int noteId =Integer.parseInt(request.getParameter("note_Id"));
			//Note note = new Note();
			//note.setNoteId(noteId);
			SessionFactory factory = FactoryProvider.getSessionFactory();
			Session session = factory.openSession();
			
			//eager loading 
		 	Note noteDetails = session.get(Note.class, noteId);
			
			Transaction tx = session.beginTransaction();
			session.delete(noteDetails);
			tx.commit();
			session.close();
			response.sendRedirect(request.getContextPath() + "/viewNotes.jsp");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
