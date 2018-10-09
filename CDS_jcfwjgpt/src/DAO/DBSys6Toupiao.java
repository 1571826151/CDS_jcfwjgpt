package DAO;

import com.Sys6Toupiao;
import com.databaase.DBjdbc;

public class DBSys6Toupiao extends DBjdbc{
	public boolean InsertByQu(Sys6Toupiao stp) throws Exception{
		int a = 0;
		String sql = "insert into sys6_toupiao(qu_id,toupiao_name,toupiao_dept,toupiao_text,toupiao_begin,toupiao_end) values(?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, stp.getQu_id());
		ps.setString(2, stp.getToupiao_name());
		ps.setString(3, stp.getToupiao_dept());
		ps.setString(4, stp.getToupiao_text());
		ps.setString(5, stp.getToupiao_begin());
		ps.setString(6, stp.getToupiao_end());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean InsertByJie(Sys6Toupiao stp) throws Exception{
		int a = 0;
		String sql = "insert into sys6_toupiao(jiedao_id,toupiao_name,toupiao_dept,toupiao_text,toupiao_begin,toupiao_end) values(?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, stp.getJiedao_id());
		ps.setString(2, stp.getToupiao_name());
		ps.setString(3, stp.getToupiao_dept());
		ps.setString(4, stp.getToupiao_text());
		ps.setString(5, stp.getToupiao_begin());
		ps.setString(6, stp.getToupiao_end());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean SelectBytoupiao_name(String toupiao_name) throws Exception{
		boolean isOk = false;
		String sql = "select * from sys6_toupiao where toupiao_name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, toupiao_name);
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(rs.next()){
			isOk = true;
		}
		return isOk;
	}
	
	public int SelectToId(String toupiao_name) throws Exception{
		int toupiao_id = 0;
		String sql = "select toupiao_id from sys6_toupiao where toupiao_name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, toupiao_name);
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		while(rs.next()){
			toupiao_id = rs.getInt("toupiao_id");
		}
		return toupiao_id;
	}
}
