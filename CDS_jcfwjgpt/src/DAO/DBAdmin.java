package DAO;

import com.databaase.DBjdbc;

public class DBAdmin extends DBjdbc {
	
	
	public boolean doLogin(String admin_phone , String admin_password) throws Exception {
		boolean isOk = false;
		String sql = "select * from sys_admin where admin_phone=? and admin_password =?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin_phone);
			ps.setString(2, admin_password);
			rs = ps.executeQuery();
			if (rs.next()) {
				isOk = true;
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isOk;
	}
	
	public String  QueryName(String admin_phone) throws Exception {
		String session_name = " ";
		String sql = "select admin_name from sys_admin where admin_phone = ?;";
		
		try {
			ps.getConnection().prepareStatement(sql);
			ps.setString(1, admin_phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				session_name = rs.getString("admin_name");
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return session_name;
	}
	
}
