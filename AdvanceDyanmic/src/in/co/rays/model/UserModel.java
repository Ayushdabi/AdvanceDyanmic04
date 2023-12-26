package in.co.rays.model;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDatasource;

public class UserModel {

	public int nextpk() throws Exception {

		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		PreparedStatement ps = conn1.prepareStatement("select max(id)from users ");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			pk = rs.getInt(1);

		}

		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		PreparedStatement ps = conn1.prepareStatement("insert into users values(?,?,?,?,?,?)");

		ps.setInt(1, nextpk());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setString(4, bean.getLoginid());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getAddress());

		int i = ps.executeUpdate();

		System.out.println("Data inserted =" + 1);

	}

	public static UserBean authenticate(String login_id, String password) throws Exception {
		Connection conn = JDBCDatasource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from users where login_id =? and password =?");
		ps.setString(1, login_id);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getShort(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

		}

		return bean;

	}

		
	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		PreparedStatement ps = conn
				.prepareStatement("update users set fname =?,lname=?,login_id=?,address=?,password=? where id=?");

		ps.setString(1, bean.getFname());
		ps.setString(2, bean.getLname());
		ps.setString(3, bean.getLoginid());
		ps.setString(5, bean.getAddress());
		ps.setString(4, bean.getPassword());
        ps.setInt(6, bean.getId());
		int i = ps.executeUpdate();

		System.out.println("Data UPDATE" + i);
	}



	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from  users where id =?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println("Data inserted =" + i);
	}

	public UserBean findbypk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select *from users where id =?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

		}
		return bean;

	}
	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDatasource.getConnection();
		StringBuffer sql = new StringBuffer("select * from users where 1=1");

		if (bean != null) {

			if (bean.getFname() != null && bean.getFname().length() > 0) {
				sql.append(" and fname like '" + bean.getFname() + "%' ");
			}

		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		System.out.println("sql query.......>>" + sql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			list.add(bean);
		}
		return list;

	}
}