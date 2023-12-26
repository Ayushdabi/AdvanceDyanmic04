package in.co.rays.servlent;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("Fname");
		String lname = req.getParameter("Lname");
         String[] address = req.getParameterValues("Address");
         
		System.out.println(" firstServlet doget");

		System.out.println(fname);
		System.out.println(lname);
        for (String string : address) {
        	System.out.println(string);
			
		}
resp.sendRedirect("SecondServlent");



//		 RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
//			rd.forward(req, resp);


	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		String fname = req.getParameter("Fname");
//		String lname = req.getParameter("Lname");
//		 String address = req.getParameter("Address");
//	        
////		System.out.println("SecondServlet doPost");
//
//		System.out.println(fname);
//		System.out.println(lname);
//      System.out.println(address);
//
//	//resp.sendRedirect("SecondServlent");
//
////		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
////		rd.forward(req, resp);
//
//	}

}

