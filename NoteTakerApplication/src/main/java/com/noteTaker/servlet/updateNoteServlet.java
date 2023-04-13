package com.noteTaker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.noteTaker.entities.Note;
import com.noteTaker.helper.FactoryProvider;

/**
 * Servlet implementation class updateNoteServlet
 */
public class updateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int noteId = Integer.parseInt(request.getParameter("id").trim());
		//eager loading
		Session session = FactoryProvider.getSessionFactory().openSession();
		Note note = (Note)session.get(Note.class, noteId);
		request.setAttribute("noteId", note.getNoteId());
		request.setAttribute("title", note.getNoteTitle());
		request.setAttribute("content", note.getNoteContent());
		request.getRequestDispatcher("updateNote.jsp").forward(request, response);
	}

	

}
