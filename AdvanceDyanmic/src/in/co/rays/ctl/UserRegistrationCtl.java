package in.co.rays.ctl;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("Fname");
		String lname = req.getParameter("Lname");
		String loginid = req.getParameter("loginId");
		String pass= req.getParameter("password");
		String add = req.getParameter("Address");
		

		System.out.println(fname);
		System.out.println(lname);
		System.out.println(loginid);
		System.out.println(pass);
		System.out.println(add);
		

		UserBean bean = new UserBean();
		
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setLoginid(loginid);
		bean.setPassword(pass);
		bean.setAddress(add);

		UserModel model = new UserModel();

		try {
			model.add(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

req.setAttribute("msg", "User registered successfully");
		resp.sendRedirect("UserRegistrationView.jsp");
	}

	


	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("Fname");
		String lname = req.getParameter("Lname");
		String loginid = req.getParameter("loginId");
		String pass= req.getParameter("password");
		String add = req.getParameter("Address");
		

		System.out.println(fname);
		System.out.println(lname);
		System.out.println(loginid);
		System.out.println(pass);
		System.out.println(add);
		

		UserBean bean = new UserBean();
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setLoginid(loginid);
		bean.setPassword(pass);
		bean.setAddress(add);

		UserModel model = new UserModel();

		try {
			model.add(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.sendRedirect("UserRegistrationView.jsp");

	}

}

