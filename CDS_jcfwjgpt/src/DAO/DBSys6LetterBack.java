package DAO;

import java.util.ArrayList;
import java.util.List;

import com.Sys2GongkaiJiedao;
import com.Sys6Letterback;
import com.databaase.DBjdbc;

public class DBSys6LetterBack extends DBjdbc{
	
	public boolean QueryById(String lettergo_id) throws Exception{
		boolean isOk = false;
		String sql = "select * from sys6_letterback where lettergo_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, lettergo_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				isOk = true;
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isOk;
	}
	
	public List<Sys6Letterback> QueryAllById(String lettergo_id) throws Exception{
		List<Sys6Letterback> list = new ArrayList<Sys6Letterback>();
		String sql = "select * from sys6_letterback where lettergo_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, lettergo_id);
			rs = ps.executeQuery();
			while(rs.next()){
				Sys6Letterback slb = new Sys6Letterback();
				slb.setLetterback_dept(rs.getString("letterback_dept"));
				slb.setLetterback_time(rs.getString("letterback_time"));
				slb.setLetterback_title(rs.getString("letterback_title"));
				slb.setLetterback_text(rs.getString("letterback_text"));
				list.add(slb);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public boolean InsertAll(Sys6Letterback slb) throws Exception{
		int a = 0;
		String sql = "insert into sys6_letterback(lettergo_id,letterback_dept,letterback_title,letterback_text,letterback_time) values(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, slb.getLettergo_id());
		ps.setString(2, slb.getLetterback_dept());
		ps.setString(3, slb.getLetterback_title());
		ps.setString(4, slb.getLetterback_text());
		ps.setString(5, slb.getLetterback_time());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
}
