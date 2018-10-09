package DAO;

import java.util.ArrayList;
import java.util.List;

import com.Sys2GongkaiQu;
import com.databaase.DBjdbc;

public class DBSys2GongkaiQu extends DBjdbc{

	public boolean QueryGongkaiQu(Sys2GongkaiQu sgq) throws Exception{
		int a = 0;
		String sql = "insert into sys2_gongkai_qu(gongkai_qu_id,qu_id,gongkai_qu_time,gongkai_qu_type,gongkai_qu_name,gongkai_qu_text) values(?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, sgq.getGongkai_qu_id());
		ps.setString(2, sgq.getQu_id());
		ps.setString(3, sgq.getGongkai_qu_time());
		ps.setString(4, sgq.getGongkai_qu_type());
		ps.setString(5, sgq.getGongkai_qu_name());
		ps.setString(6, sgq.getGongkai_qu_text());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean SelectByGongkai_qu_id(String gongkai_qu_id) {
		String sql = "select * from sys2_gongkai_qu where gongkai_qu_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_qu_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	
	public List<Sys2GongkaiQu> QueryAll(String gongkai_qu_type) throws Exception{
		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		String sql = "select * from sys2_gongkai_qu where gongkai_qu_type = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_qu_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiQu sgq = new Sys2GongkaiQu();
				sgq.setGongkai_qu_id(rs.getString("gongkai_qu_id"));
				sgq.setQu_id(rs.getString("qu_id"));
				sgq.setGongkai_qu_time(rs.getString("gongkai_qu_time"));
				sgq.setGongkai_qu_name(rs.getString("gongkai_qu_name"));
				list.add(sgq);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys2GongkaiQu> QueryById(String gongkai_qu_id,String gongkai_qu_type ) throws Exception{
		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		String sql = "select * from sys2_gongkai_qu where gongkai_qu_id = ? AND gongkai_qu_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_qu_id);
			ps.setString(2, gongkai_qu_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiQu sgq = new Sys2GongkaiQu();
				sgq.setGongkai_qu_id(rs.getString("gongkai_qu_id"));
				sgq.setQu_id(rs.getString("qu_id"));
				sgq.setGongkai_qu_time(rs.getString("gongkai_qu_time"));
				sgq.setGongkai_qu_name(rs.getString("gongkai_qu_name"));
				list.add(sgq);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<Sys2GongkaiQu> QueryByTime(String gongkai_qu_time1 , String gongkai_qu_time2 , String gongkai_qu_type) throws Exception{
		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		String sql = "select * from sys2_gongkai_qu where gongkai_qu_time > ? && gongkai_qu_time < ? AND gongkai_qu_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_qu_time1);
			ps.setString(2, gongkai_qu_time2);
			ps.setString(3, gongkai_qu_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiQu sgq = new Sys2GongkaiQu();
				sgq.setGongkai_qu_id(rs.getString("gongkai_qu_id"));
				sgq.setQu_id(rs.getString("qu_id"));
				sgq.setGongkai_qu_time(rs.getString("gongkai_qu_time"));
				sgq.setGongkai_qu_name(rs.getString("gongkai_qu_name"));
				list.add(sgq);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<Sys2GongkaiQu> QueryByQu(String qu_id , String gongkai_qu_type) throws Exception{
		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		String sql = "select * from sys2_gongkai_qu where qu_id = ? AND gongkai_qu_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, qu_id);
			ps.setString(2, gongkai_qu_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiQu sgq = new Sys2GongkaiQu();
				sgq.setGongkai_qu_id(rs.getString("gongkai_qu_id"));
				sgq.setQu_id(rs.getString("qu_id"));
				sgq.setGongkai_qu_time(rs.getString("gongkai_qu_time"));
				sgq.setGongkai_qu_name(rs.getString("gongkai_qu_name"));
				list.add(sgq);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<Sys2GongkaiQu> QueryByName(String gongkai_qu_name , String gongkai_qu_type) throws Exception{
		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		String sql = "select * from sys2_gongkai_qu where gongkai_qu_name = ? AND gongkai_qu_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_qu_name);
			ps.setString(2, gongkai_qu_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiQu sgq = new Sys2GongkaiQu();
				sgq.setGongkai_qu_id(rs.getString("gongkai_qu_id"));
				sgq.setQu_id(rs.getString("qu_id"));
				sgq.setGongkai_qu_time(rs.getString("gongkai_qu_time"));
				sgq.setGongkai_qu_name(rs.getString("gongkai_qu_name"));
				list.add(sgq);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys2GongkaiQu> QueryMoreById(String gongkai_qu_id , String gongkai_qu_type) {
		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		String sql = "select * from sys2_gongkai_qu where gongkai_qu_id = ? AND gongkai_qu_type = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_qu_id);
			ps.setString(2, gongkai_qu_type);
			rs = ps.executeQuery();
			while(rs.next()){
				Sys2GongkaiQu sgq = new Sys2GongkaiQu();
				sgq.setGongkai_qu_id(rs.getString("gongkai_qu_id"));
				sgq.setQu_id(rs.getString("qu_id"));
				sgq.setGongkai_qu_time(rs.getString("gongkai_qu_time"));
				sgq.setGongkai_qu_type(rs.getString("gongkai_qu_type"));
				sgq.setGongkai_qu_name(rs.getString("gongkai_qu_name"));
				sgq.setGongkai_qu_text(rs.getString("gongkai_qu_text"));
				list.add(sgq);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
