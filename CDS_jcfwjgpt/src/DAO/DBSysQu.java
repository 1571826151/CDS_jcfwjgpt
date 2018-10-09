package DAO;

import java.util.ArrayList;
import java.util.List;

import com.SysQu;
import com.databaase.DBjdbc;

public class DBSysQu extends DBjdbc{
	
	public List<SysQu> QueryName() {
		List<SysQu> list = new ArrayList<SysQu>();
		String sql = "select qu_name,qu_id from sys0_qu;";
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				SysQu sysQu = new SysQu();
				sysQu.setQu_name(rs.getString("qu_name"));
				sysQu.setQu_id(rs.getString("qu_id"));
				list.add(sysQu);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
