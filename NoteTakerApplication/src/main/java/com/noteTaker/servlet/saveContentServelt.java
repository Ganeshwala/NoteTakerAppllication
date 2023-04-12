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
			String title = request.getParameter("title");
			String content = request.getParameter("noteContent");
			
			// Hibernate -> Transient state as we just initialized the object to it in hibernate session object but not in DB.
			Note noteDetails = new Note(0,title, content, new Date(), new Date());
			
			SessionFactory factory = FactoryProvider.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			// Hibernate -> Persistent state as now we will saving the object to DB so hibernate session and DB both have object.
			session.save(noteDetails);
			tx.commit();
			session.close();
			//FactoryProvider.closeSessionFactory();
			response.sendRedirect(request.getContextPath() + "/viewNotes.jsp");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
