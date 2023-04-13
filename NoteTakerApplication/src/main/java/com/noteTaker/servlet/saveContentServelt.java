package com.noteTaker.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.noteTaker.entities.Note;
import com.noteTaker.helper.FactoryProvider;


public class saveContentServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public saveContentServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			System.out.println(noteId);
			String title = request.getParameter("title");
			System.out.println(title);
			String content = request.getParameter("noteContent");
			System.out.println(content);
			Note noteDetails = new Note();
			SessionFactory factory = FactoryProvider.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println(1);
			// Hibernate -> Persistent state as now we will saving the object to DB so hibernate session and DB both have object.
			if(noteId>0) {
				System.out.println(0);
				Note tempNote = session.get(Note.class, noteId);
				tempNote.setNoteTitle(title);
				tempNote.setNoteContent(content);
				tempNote.setNoteUpdateDate(new Date());
				System.out.println(2);
				session.update(tempNote);
				System.out.println(3);
			}else {
				// Hibernate -> Transient state as we just initialized the object to it in hibernate session object but not in DB.
				System.out.println(4);
				noteDetails.setNoteId(0);
				noteDetails.setNoteTitle(title);
				noteDetails.setNoteContent(content);
				noteDetails.setNoteCreateDate(new Date());
				noteDetails.setNoteUpdateDate(new Date());
				System.out.println(5);
				session.save(noteDetails);
				System.out.println(6);
			}
			System.out.println(7);
			tx.commit();
			session.close();
			System.out.println(8);
			//FactoryProvider.closeSessionFactory();
			response.sendRedirect(request.getContextPath() + "/viewNotes.jsp");
			System.out.println(9);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
