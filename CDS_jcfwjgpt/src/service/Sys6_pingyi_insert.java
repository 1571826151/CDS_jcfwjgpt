package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sys6Pinyi;
import com.Sys6Pinyiitem;

import DAO.DBSys6Pinyi;
import DAO.DBSys6PinyiItem;
import DAO.DBSys6ToupiaoItem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Sys6_pingyi_insert
 */
@WebServlet("/Sys6_pingyi_insert")
public class Sys6_pingyi_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_pingyi_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String data = request.getParameter("data");
		JSONObject json1 = JSONObject.fromObject(data);
		
		Sys6Pinyi spy = new Sys6Pinyi();
		
		DBSys6Pinyi dbpy = new DBSys6Pinyi();
		DBSys6PinyiItem dbpi = new DBSys6PinyiItem();
		
		String pinyi_choose = json1.getString("pinyi_choose");
		
		
		if(pinyi_choose.equals("文字评议")){
			String pinyi_title = json1.getString("wenzi_inp1");
			String pinyi_dept = json1.getString("wenzi_inp2");
			String oOption = json1.getString("oOption");
			String pinyi_begin = json1.getString("startTime");
			String pinyi_end = json1.getString("endTime");
			String o_type = json1.getString("o_type");
			String pinyi_text = json1.getString("wenzi_otextarea");
			int choose = 111;
			spy.setPinyi_title(pinyi_title);
			spy.setPinyi_text(pinyi_text);
			spy.setPinyi_begin(pinyi_begin);
			spy.setPinyi_end(pinyi_end);
			spy.setPinyi_choose(choose);
			spy.setPinyi_dept(pinyi_dept);
			
			boolean isOk = false;
			if(o_type.equals("qu")){
				spy.setQu_id(oOption);
				try {
					if (dbpy.InsertByQu(spy)) {
						isOk = dbpy.SelectByPinyi_title(pinyi_title);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}else if(o_type.equals("jie")){
				spy.setJiedao_id(oOption);
				try {
					if (dbpy.InsertByJie(spy)) {
						isOk = dbpy.SelectByPinyi_title(pinyi_title);
					} 
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			response.setContentType("text/html;charset=utf-8"); 
			if(isOk){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}else if(pinyi_choose.equals("选项评议")){
			String pinyi_title = json1.getString("xuanxiang_inp1");
			String pinyi_dept = json1.getString("xuanxiang_inp2");
			String oOption = json1.getString("oOption");
			String pinyi_begin = json1.getString("startTime");
			String pinyi_end = json1.getString("endTime");
			String o_type = json1.getString("o_type");
			String pinyi_text = json1.getString("otextarea");
			
			JSONArray jsonarr = json1.getJSONArray("arr");
			String[] strArr = new String[jsonarr.size()];
			for (int i = 0; i < strArr.length; i++) {
				strArr[i] = jsonarr.getString(i);
			}
			int choose = 222;
			
			spy.setPinyi_title(pinyi_title);
			spy.setPinyi_text(pinyi_text);
			spy.setPinyi_begin(pinyi_begin);
			spy.setPinyi_end(pinyi_end);
			spy.setPinyi_choose(choose);
			spy.setPinyi_dept(pinyi_dept);
			boolean isOk1 = false;
			boolean isOk2 = false;
			if(o_type.equals("qu")){
				spy.setQu_id(oOption);
				try {
					if (dbpy.InsertByQu(spy)) {
						int pinyi_id = dbpy.SelectToId(pinyi_title);
						for (int j = 0; j < strArr.length; j++) {
							Sys6Pinyiitem spi = new Sys6Pinyiitem();
							spi.setPinyi_id(pinyi_id);
							spi.setPinyiItem_name(strArr[j]);
							isOk2 = dbpi.InsertAll(spi);
						}
						isOk1 = dbpy.SelectByPinyi_title(pinyi_title);
					} 
				} catch (Exception e) {
					// TODO: handle exception
				}
			}else if(o_type.equals("jie")){
				spy.setJiedao_id(oOption);;
				try {
					if (dbpy.InsertByJie(spy)) {
						int pinyi_id = dbpy.SelectToId(pinyi_title);
						for (int j = 0; j < strArr.length; j++) {
							Sys6Pinyiitem spi = new Sys6Pinyiitem();
							spi.setPinyi_id(pinyi_id);
							spi.setPinyiItem_name(strArr[j]);
							isOk2 = dbpi.InsertAll(spi);
						}
						isOk1 = dbpy.SelectByPinyi_title(pinyi_title);
					} 
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if(isOk1 && isOk2){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
