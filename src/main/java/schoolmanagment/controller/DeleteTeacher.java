package schoolmanagment.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schoolmanagment.dto.Teacher;

@WebServlet("/removet")
public class DeleteTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vp");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t=em.find(Teacher.class, Integer.parseInt(id));
		et.begin();
		em.remove(t);
		et.commit();
		RequestDispatcher rd=req.getRequestDispatcher("ManagementLogin.html");
		rd.forward(req, resp);
	}
	

}
