package DAO;

import java.util.ArrayList;
import java.util.List;

import com.User;
import com.databaase.DBjdbc;

public class DBUser extends DBjdbc{
	
	public List<User> QueryAll() throws Exception{
		List<User> list = new ArrayList<User>();
		String sql = "select * from sys_user;";
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_birthday(rs.getString("user_birthday"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_place_qu(rs.getString("user_place_qu"));
				user.setUser_place_jiedao(rs.getString("user_place_jiedao"));
				list.add(user);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public List<User> QueryName(String user_name) throws Exception {
		List<User> list = new ArrayList<User>();
		String sql = "select * from sys_user where user_name = ?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_name);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_birthday(rs.getString("user_birthday"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_place_qu(rs.getString("user_place_qu"));
				user.setUser_place_jiedao(rs.getString("user_place_jiedao"));
				list.add(user);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<User> QueryPhone(String user_phone) throws Exception {
		List<User> list = new ArrayList<User>();
		String sql = "select * from sys_user where user_phone = ?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_phone);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_birthday(rs.getString("user_birthday"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_place_qu(rs.getString("user_place_qu"));
				user.setUser_place_jiedao(rs.getString("user_place_jiedao"));
				list.add(user);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<User> QueryEmail(String user_email) throws Exception{
		List<User> list = new ArrayList<User>();
		String sql = "select * from sys_user where user_email = ?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_email);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_birthday(rs.getString("user_birthday"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_place_qu(rs.getString("user_place_qu"));
				user.setUser_place_jiedao(rs.getString("user_place_jiedao"));
				list.add(user);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
}
