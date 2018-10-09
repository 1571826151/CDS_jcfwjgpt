package DAO;

import java.util.ArrayList;
import java.util.List;

import com.SysJiedao;
import com.databaase.DBjdbc;

public class DBSysJiedao extends DBjdbc{

	public List<SysJiedao> QueryName(String qu_id) {
		List<SysJiedao> list = new ArrayList<SysJiedao>();
		String sql = "select jiedao_id,jiedao_name from sys0_jiedao where qu_id = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, qu_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				SysJiedao sysJiedao = new SysJiedao();
				sysJiedao.setJiedao_id(rs.getString("jiedao_id"));
				sysJiedao.setJiedao_name(rs.getString("jiedao_name"));
				list.add(sysJiedao);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;	
	}
}
