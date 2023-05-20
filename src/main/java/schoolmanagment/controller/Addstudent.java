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

import schoolmanagment.dto.Student;

@WebServlet("/student")
public class Addstudent extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		String cono=req.getParameter("cono");
		String password=req.getParameter("pswd");
		String dob=req.getParameter("dob");
		
		
		Student st=new Student();
		st.setId(Integer.parseInt(id));
		st.setEmail(email);
		st.setPswd(password);
		st.setName(name);
		st.setCono(Long.parseLong(cono));
		st.setDob(dob);
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vp");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(st);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("ManagementLogin.html");
		rd.forward(req, resp);
	}


}
