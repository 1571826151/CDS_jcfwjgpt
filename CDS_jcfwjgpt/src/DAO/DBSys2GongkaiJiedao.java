package DAO;

import java.util.ArrayList;
import java.util.List;

import com.Sys2GongkaiJiedao;
import com.databaase.DBjdbc;

public class DBSys2GongkaiJiedao extends DBjdbc{
	
	public boolean QueryGongkaiJiedao(Sys2GongkaiJiedao sgj) throws Exception{
		int a = 0;
		String sql = "insert into sys2_gongkai_jiedao(gongkai_jie_id,jiedao_id,gongkai_jie_time,gongkai_jie_type,gongkai_jie_name,gongkai_jie_text) values(?,?,?,?,?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, sgj.getGongkai_jie_id());
		ps.setString(2, sgj.getJiedao_id());
		ps.setString(3, sgj.getGongkai_jie_time());
		ps.setString(4, sgj.getGongkai_jie_type());
		ps.setString(5, sgj.getGongkai_jie_name());
		ps.setString(6, sgj.getGongkai_jie_text());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean SelectByGongkai_jie_id(String gongkai_jie_id) {
		String sql = "select * from sys2_gongkai_jiedao where gongkai_jie_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_jie_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	
	public List<Sys2GongkaiJiedao> QueryAll(String gongkai_jie_type) throws Exception{
		List<Sys2GongkaiJiedao> list = new ArrayList<Sys2GongkaiJiedao>();
		String sql = "select * from sys2_gongkai_jiedao where gongkai_jie_type = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_jie_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiJiedao sgj = new Sys2GongkaiJiedao();
				sgj.setGongkai_jie_id(rs.getString("gongkai_jie_id"));
				sgj.setJiedao_id(rs.getString("jiedao_id"));
				sgj.setGongkai_jie_time(rs.getString("gongkai_jie_time"));
				sgj.setGongkai_jie_name(rs.getString("gongkai_jie_name"));
				list.add(sgj);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys2GongkaiJiedao> QueryById(String gongkai_jie_id , String gongkai_jie_type) throws Exception{
		List<Sys2GongkaiJiedao> list = new ArrayList<Sys2GongkaiJiedao>();
		String sql = "select * from sys2_gongkai_jiedao where gongkai_jie_id = ? AND gongkai_jie_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_jie_id);
			ps.setString(2, gongkai_jie_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiJiedao sgj = new Sys2GongkaiJiedao();
				sgj.setGongkai_jie_id(rs.getString("gongkai_jie_id"));
				sgj.setJiedao_id(rs.getString("jiedao_id"));
				sgj.setGongkai_jie_time(rs.getString("gongkai_jie_time"));
				sgj.setGongkai_jie_name(rs.getString("gongkai_jie_name"));
				list.add(sgj);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys2GongkaiJiedao> QueryByTime(String gongkai_jie_time1 , String gongkai_jie_time2 , String gongkai_qu_type) throws Exception{
		List<Sys2GongkaiJiedao> list = new ArrayList<Sys2GongkaiJiedao>();
		String sql = "select * from sys2_gongkai_jiedao where gongkai_jie_time > ? && gongkai_jie_time < ? AND gongkai_jie_type = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_jie_time1);
			ps.setString(2, gongkai_jie_time2);
			ps.setString(3, gongkai_qu_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiJiedao sgj = new Sys2GongkaiJiedao();
				sgj.setGongkai_jie_id(rs.getString("gongkai_jie_id"));
				sgj.setJiedao_id(rs.getString("jiedao_id"));
				sgj.setGongkai_jie_time(rs.getString("gongkai_jie_time"));
				sgj.setGongkai_jie_name(rs.getString("gongkai_jie_name"));
				list.add(sgj);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys2GongkaiJiedao> QueryByJie(String jiedao_id , String gongkai_jie_type) throws Exception{
		List<Sys2GongkaiJiedao> list = new ArrayList<Sys2GongkaiJiedao>();
		String sql = "select * from sys2_gongkai_jiedao where jiedao_id = ? AND gongkai_jie_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, jiedao_id);
			ps.setString(2, gongkai_jie_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiJiedao sgj = new Sys2GongkaiJiedao();
				sgj.setGongkai_jie_id(rs.getString("gongkai_jie_id"));
				sgj.setJiedao_id(rs.getString("jiedao_id"));
				sgj.setGongkai_jie_time(rs.getString("gongkai_jie_time"));
				sgj.setGongkai_jie_name(rs.getString("gongkai_jie_name"));
				list.add(sgj);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys2GongkaiJiedao> QueryByName(String gongkai_jie_name , String gongkai_jie_type) throws Exception{
		List<Sys2GongkaiJiedao> list = new ArrayList<Sys2GongkaiJiedao>();
		String sql = "select * from sys2_gongkai_jiedao where gongkai_jie_name = ? AND gongkai_jie_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_jie_name);
			ps.setString(2, gongkai_jie_type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sys2GongkaiJiedao sgj = new Sys2GongkaiJiedao();
				sgj.setGongkai_jie_id(rs.getString("gongkai_jie_id"));
				sgj.setJiedao_id(rs.getString("jiedao_id"));
				sgj.setGongkai_jie_time(rs.getString("gongkai_jie_time"));
				sgj.setGongkai_jie_name(rs.getString("gongkai_jie_name"));
				list.add(sgj);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Sys2GongkaiJiedao> QueryMoreById(String gongkai_jie_id , String gongkai_jie_type) {
		List<Sys2GongkaiJiedao> list = new ArrayList<Sys2GongkaiJiedao>();
		String sql = "select * from sys2_gongkai_jiedao where gongkai_jie_id = ? AND gongkai_jie_type = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gongkai_jie_id);
			ps.setString(2, gongkai_jie_type);
			rs = ps.executeQuery();
			while(rs.next()){
				Sys2GongkaiJiedao sgj = new Sys2GongkaiJiedao();
				sgj.setGongkai_jie_id(rs.getString("gongkai_jie_id"));
				sgj.setJiedao_id(rs.getString("jiedao_id"));
				sgj.setGongkai_jie_time(rs.getString("gongkai_jie_time"));
				sgj.setGongkai_jie_type(rs.getString("gongkai_jie_type"));
				sgj.setGongkai_jie_name(rs.getString("gongkai_jie_name"));
				sgj.setGongkai_jie_text(rs.getString("gongkai_jie_text"));
				list.add(sgj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
