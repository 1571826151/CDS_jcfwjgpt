package DAO;

import java.util.ArrayList;
import java.util.List;

import com.Sys6Pinyi;
import com.Sys6Pinyiitem;
import com.databaase.DBjdbc;

public class DBSys6PinyiItem extends DBjdbc{
	public boolean InsertAll(Sys6Pinyiitem spi) {
		int a = 0;
		String sql = "insert into sys6_pinyiitem(pinyi_id,pinyiItem_name) values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, spi.getPinyi_id());
			ps.setString(2, spi.getPinyiItem_name());
			a = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(a>0){
			return true;
		}else{
			return false;
		}
	}
	
	public List<Sys6Pinyiitem> SelectAllById(int pinyi_id) throws Exception{
		List<Sys6Pinyiitem> list = new ArrayList<Sys6Pinyiitem>();
		String sql = "select * from sys6_pinyiitem where pinyi_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pinyi_id);
			rs = ps.executeQuery();
			while(rs.next()){
				Sys6Pinyiitem spyi = new Sys6Pinyiitem();
				spyi.setPinyi_id(rs.getInt("pinyi_id"));
				spyi.setPinyiItem_name(rs.getString("pinyiItem_name"));
				list.add(spyi);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
