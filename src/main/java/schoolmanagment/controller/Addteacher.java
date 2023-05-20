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

@WebServlet("/teacher")
public class Addteacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		String suject=req.getParameter("subject");
		String password=req.getParameter("pswd");
		String age=req.getParameter("age");
		
		
		Teacher t=new Teacher();
		t.setId(Integer.parseInt(id));
		t.setEmail(email);
		t.setPswd(password);
		t.setName(name);
		t.setSubject(suject);
		t.setAge(Integer.parseInt(age));
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vp");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(t);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("ManagementLogin.html");
		rd.forward(req, resp);
	}

}
