package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		System.out.println("id =====> " + id);

		if (id != null) {

			model = new UserModel();

			try {
				bean = model.findbypk(Integer.parseInt(id));
				req.setAttribute("bean", bean);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		String id = req.getParameter("id");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String login = req.getParameter("loginId");	
		String pass = req.getParameter("password");
		String address = req.getParameter("address");
		

		UserBean bean = new UserBean();
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setLoginid(login);
		bean.setAddress(address);
		bean.setPassword(pass);
		UserModel model = new UserModel();

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "User added Successfully..!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (op.equals("update")) {
			
			try {
				bean.setId(Integer.parseInt(id));
				model.update(bean);
				bean = model.findbypk(bean.getId());
				req.setAttribute("msg", "User updated Successfully..!!");
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);


	}

}
