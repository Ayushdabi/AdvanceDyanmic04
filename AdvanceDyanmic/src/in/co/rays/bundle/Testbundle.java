package in.co.rays.bundle;

import java.util.ResourceBundle;

public class Testbundle {
	
	 public static void main(String[] args) {
		 
		 
		  ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.hello_hi");
		 System.out.println(rb.getString("hell"));
		  
	}

}
