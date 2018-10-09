package com.databaase;

import java.sql.*;

public class DBjdbc {
	String url = "jdbc:mysql://47.94.92.109:3306/cds_jcfwjgpt";
	String username = "root";
	String password = "123456";
	
	protected Connection conn = null;
	protected Statement stat = null;
	protected ResultSet rs = null;
	protected PreparedStatement ps=null;
	
	public DBjdbc(){
		try {
			conn = getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clean(){
		try {
			rs.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			if(ps!=null)
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(stat!=null)
			stat.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			conn.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
