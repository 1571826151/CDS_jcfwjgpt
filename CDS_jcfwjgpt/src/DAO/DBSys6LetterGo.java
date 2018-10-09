package DAO;

import java.util.ArrayList;
import java.util.List;

import com.Sys6Lettergo;
import com.databaase.DBjdbc;

public class DBSys6LetterGo extends DBjdbc{
	public List<Sys6Lettergo> QueryAllById(String lettergo_id) throws Exception{
		List<Sys6Lettergo> list = new ArrayList<Sys6Lettergo>();
		String sql = "select * from sys6_lettergo where lettergo_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, lettergo_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys6Lettergo slg = new Sys6Lettergo();
				slg.setLettergo_title(rs.getString("lettergo_title"));
				slg.setLettergo_time(rs.getString("lettergo_time"));
				slg.setLettergo_name(rs.getString("lettergo_name"));
				slg.setLettergo_phone(rs.getString("lettergo_phone"));
				slg.setLettergo_addressee(rs.getString("lettergo_addressee"));
				slg.setLettergo_text(rs.getString("lettergo_text"));
				list.add(slg);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys6Lettergo> QueryByName(String lettergo_name) throws Exception{
		List<Sys6Lettergo> list = new ArrayList<Sys6Lettergo>();
		String sql = "select * from sys6_lettergo where lettergo_name = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, lettergo_name);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys6Lettergo slg = new Sys6Lettergo();
				slg.setLettergo_id(rs.getInt("lettergo_id"));
				slg.setLettergo_title(rs.getString("lettergo_title"));
				slg.setLettergo_time(rs.getString("lettergo_time"));
				list.add(slg);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys6Lettergo> QueryByTime(String lettergo_time1 , String lettergo_time2) {
		List<Sys6Lettergo> list = new ArrayList<Sys6Lettergo>();
		String sql = "select * from sys6_lettergo where lettergo_time >= ? && lettergo_time <= ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, lettergo_time1);
			ps.setString(2, lettergo_time2);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys6Lettergo slg = new Sys6Lettergo();
				slg.setLettergo_id(rs.getInt("lettergo_id"));
				slg.setLettergo_title(rs.getString("lettergo_title"));
				slg.setLettergo_time(rs.getString("lettergo_time"));
				list.add(slg);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
