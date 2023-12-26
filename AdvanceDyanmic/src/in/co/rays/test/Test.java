package in.co.rays.test;

import java.util.Iterator;


import java.util.List;

import org.apache.catalina.User;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class Test {
	public static void main(String[] args) throws Exception {
		testSearch();
		//testDelete();
	}

private static void testFindbypk()  throws Exception{
		
		
		UserModel model = new UserModel();
		
		      UserBean bean =  model.findbypk(2);
		      
		      if(bean!=null) {
		    	  System.out.print("\t"+bean.getId());
					 
					 System.out.print("\t"+bean.getFname());
					 
					 System.out.print("\t"+bean.getLname());
					 
					 System.out.print("\t"+bean.getLoginid());
					 
					 System.out.print("\t"+bean.getPassword());
					 
					 System.out.print(bean.getAddress());
				  
		      }
}
		
public static void testDelete() throws Exception {
		
		
		UserModel model = new UserModel();
		
		model.delete(6);
	}

	public static void testSearch() throws Exception  {
		
		
		
		UserModel model =new UserModel();
		
		
		UserBean bean =new UserBean();
		
		bean.setFname("m");
		
		List list=model.search(bean,1,5);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			bean=(UserBean) it.next();
		System.out.print(bean.getId());
		System.out.print("\t"+bean.getFname());
		System.out.print("\t"+bean.getLname());
		System.out.print("\t"+bean.getLoginid());
		System.out.print("\t"+bean.getPassword());
		System.out.println("\t"+bean.getAddress());
		}
		
		
	}
    
}
