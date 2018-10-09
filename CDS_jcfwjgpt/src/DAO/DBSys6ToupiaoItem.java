package DAO;

import com.Sys6Toupiao;
import com.Sys6Toupiaoitem;
import com.databaase.DBjdbc;

public class DBSys6ToupiaoItem extends DBjdbc{
	public boolean InsertByToupiao_id(Sys6Toupiaoitem stpi) throws Exception{
		int a = 0;
		String sql = "insert into sys6_toupiaoitem(toupiao_id,toupiaoItem_name) values(?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, stpi.getToupiao_id());
		ps.setString(2, stpi.getToupiaoItem_name());
		a = ps.executeUpdate();
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
}
