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

@WebServlet("/Updateteacher")
public class UpadateTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String email=req.getParameter("email");
		String pswd=req.getParameter("pswd");
		String age=req.getParameter("age");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vp");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
//		Teacher t= em.find(Teacher.class, 1);
		Teacher t=new Teacher();
		t.setId(Integer.parseInt(id));
		t.setEmail(email);
		t.setAge(Integer.parseInt(age));
		t.setName(name);
		t.setPswd(pswd);
		t.setSubject(subject);
		
		Teacher t2=em.merge(t);
		et.begin();
		em.persist(t2);
		et.commit();
		RequestDispatcher rd=req.getRequestDispatcher("ManagementLogin.html");
		rd.forward(req, resp);
	
		
		
	}

}
