package in.co.rays.util;

import java.beans.PropertyVetoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDatasource {

	private static JDBCDatasource jds = null;

	private ComboPooledDataSource cpds = null;
	
	
	 private static  ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");
	
	 
	private JDBCDatasource() {
		
		
		  
		  
		try {
			cpds = new ComboPooledDataSource();

			cpds.setDriverClass(rb.getString("Driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("user"));
			cpds.setPassword(rb.getString("passward"));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("InitialPoolSize")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("MaxPoolSize")));

		} catch (PropertyVetoException e) {

			e.printStackTrace();

		}
	}

	public static JDBCDatasource getInstance() {
		if (jds == null)
			;
		{
			jds = new JDBCDatasource();

		}

		return jds;

	}

	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();

		} catch (SQLException e) {

			return null;
		}
	}

}
