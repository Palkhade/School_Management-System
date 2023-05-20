package schoolmanagment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import schoolmanagment.dto.Teacher;

@WebServlet("/ValidateTeacher")
public class ValidateTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vp");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select a from Teacher a where a.email=?1 and a.pswd=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<Teacher>t=q.getResultList();
		
		if(t.size()>0)
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("Teacher", t.get(0));
			RequestDispatcher rd=req.getRequestDispatcher("TeacherLogin.html");
			rd.forward(req, resp);
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("invalid info");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}	
	}

}
