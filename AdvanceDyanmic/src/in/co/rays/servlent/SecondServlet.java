package in.co.rays.servlent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		 String address = req.getParameter("Address");
		System.out.println("SecondServlet  doGet");

		System.out.println(fname);
		System.out.println(lname);
      System.out.println(address);
      
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fName = req.getParameter("fname");
		String lName = req.getParameter("lname");
		 String address = req.getParameter("Address");
		System.out.println("SecondServlet dopost");

		System.out.println(fName);
		System.out.println(lName);
System.out.println(address);
	}

}
