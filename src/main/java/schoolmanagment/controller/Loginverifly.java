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

import schoolmanagment.dto.Management;

@WebServlet("/verify")
public class Loginverifly  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vp");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		if(role.equals("Management"))
		{
			Query q=em.createQuery("select a from Management a where a.email=?1 and a.pwd=?2");
			q.setParameter(1, email);
			q.setParameter(2, password);
			List<Management>m=q.getResultList();
			if(m.size()>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("ManagementLogin.html");
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
		else if(role.equals("Teacher"))
		{
			
				RequestDispatcher rd=req.getRequestDispatcher("ValidateTeacher");
				rd.forward(req, resp);
			
			
		}
		else if(role.equals("Student"))
		{
			
				RequestDispatcher rd=req.getRequestDispatcher("ValidationStudent");
				rd.forward(req, resp);
			
		}
		
	}

}
