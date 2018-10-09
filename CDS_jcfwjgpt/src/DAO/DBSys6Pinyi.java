package DAO;

import java.util.ArrayList;
import java.util.List;

import com.Sys6Pinyi;
import com.Sys6Toupiao;
import com.databaase.DBjdbc;

public class DBSys6Pinyi extends DBjdbc{
	public boolean InsertByQu(Sys6Pinyi spy) throws Exception{
		int a = 0;
		String sql = "insert into sys6_pinyi(qu_id,pinyi_title,pinyi_text,pinyi_begin,pinyi_end,pinyi_choose,pinyi_dept) values(?,?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, spy.getQu_id());
		ps.setString(2, spy.getPinyi_title());
		ps.setString(3, spy.getPinyi_text());
		ps.setString(4, spy.getPinyi_begin());
		ps.setString(5, spy.getPinyi_end());
		ps.setInt(6, spy.getPinyi_choose());
		ps.setString(7, spy.getPinyi_dept());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean InsertByJie(Sys6Pinyi spy) throws Exception{
		int a = 0;
		String sql = "insert into sys6_pinyi(jiedao_id,pinyi_title,pinyi_text,pinyi_begin,pinyi_end,pinyi_choose,pinyi_dept) values(?,?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, spy.getJiedao_id());
		ps.setString(2, spy.getPinyi_title());
		ps.setString(3, spy.getPinyi_text());
		ps.setString(4, spy.getPinyi_begin());
		ps.setString(5, spy.getPinyi_end());
		ps.setInt(6, spy.getPinyi_choose());
		ps.setString(7, spy.getPinyi_dept());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean SelectByPinyi_title(String pinyi_title) throws Exception{
		boolean isOk = false;
		String sql = "select * from sys6_pinyi where pinyi_title = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pinyi_title);
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(rs.next()){
			isOk = true;
		}
		return isOk;
	}
	
	public int SelectToId(String pinyi_title) throws Exception{
		int pinyi_id = 0;
		String sql = "select pinyi_id from sys6_pinyi where pinyi_title = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pinyi_title);
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		while(rs.next()){
			pinyi_id = rs.getInt("pinyi_id");
		}
		return pinyi_id;
	}
	
	public List<Sys6Pinyi> SelectAllByTitle(String opinyi_title) throws Exception{
		List<Sys6Pinyi> list = new ArrayList<Sys6Pinyi>();
		String sql = "select * from sys6_pinyi where pinyi_title LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+opinyi_title+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Sys6Pinyi spy = new Sys6Pinyi();
				spy.setPinyi_id(rs.getInt("pinyi_id"));
				spy.setPinyi_title(rs.getString("pinyi_title"));
				spy.setPinyi_begin(rs.getString("pinyi_begin"));
				spy.setPinyi_end(rs.getString("pinyi_end"));
				spy.setPinyi_choose(rs.getInt("pinyi_choose"));
				list.add(spy);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys6Pinyi> SelectAllByTime(String pinyi_begin1 , String pinyi_begin2) throws Exception{
		List<Sys6Pinyi> list = new ArrayList<Sys6Pinyi>();
		String sql = "select * from sys6_pinyi where pinyi_begin >= ? && pinyi_begin <= ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pinyi_begin1);
			ps.setString(2, pinyi_begin2);
			rs = ps.executeQuery();
			while(rs.next()){
				Sys6Pinyi spy = new Sys6Pinyi();
				spy.setPinyi_id(rs.getInt("pinyi_id"));
				spy.setPinyi_title(rs.getString("pinyi_title"));
				spy.setPinyi_begin(rs.getString("pinyi_begin"));
				spy.setPinyi_end(rs.getString("pinyi_end"));
				spy.setPinyi_choose(rs.getInt("pinyi_choose"));
				list.add(spy);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys6Pinyi> SelectAllByTitleMore(String opinyi_title) throws Exception{
		List<Sys6Pinyi> list = new ArrayList<Sys6Pinyi>();
		String sql = "select * from sys6_pinyi where pinyi_title = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, opinyi_title);
			rs = ps.executeQuery();
			while(rs.next()){
				Sys6Pinyi spy = new Sys6Pinyi();
				spy.setPinyi_id(rs.getInt("pinyi_id"));
				spy.setJiedao_id(rs.getString("jiedao_id"));
				spy.setQu_id(rs.getString("qu_id"));
				spy.setPinyi_title(rs.getString("pinyi_title"));
				spy.setPinyi_text(rs.getString("pinyi_text"));
				spy.setPinyi_begin(rs.getString("pinyi_begin"));
				spy.setPinyi_end(rs.getString("pinyi_end"));
				spy.setPinyi_choose(rs.getInt("pinyi_choose"));
				spy.setPinyi_dept(rs.getString("pinyi_dept"));
				list.add(spy);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
