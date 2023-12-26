package in.co.rays.ctl;


import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   String op = req.getParameter("operation");
   
   if(op != null) {
		HttpSession session = req.getSession();
		session.invalidate();
   
   resp.sendRedirect("Login.jsp");
	}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		
         UserBean bean = null ;
		UserModel model = new UserModel();

		try {
			 bean = model.authenticate(login, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (bean != null) {
			HttpSession session = req.getSession();
			session.setAttribute("users", bean);
			  resp.sendRedirect("WelcomeCtl");
//		RequestDispatcher rd = req.getRequestDispatcher("WelcomeCtl");
//		rd.forward(req, resp);
		} else {
			req.setAttribute("msg", "LoginId & Password is invalid...!!!");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}


	}

}

