package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sys6Toupiao;
import com.Sys6Toupiaoitem;

import DAO.DBSys6LetterGo;
import DAO.DBSys6Toupiao;
import DAO.DBSys6ToupiaoItem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Sys6_toupiao_insert
 */
@WebServlet("/Sys6_toupiao_insert")
public class Sys6_toupiao_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_toupiao_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		DBSys6Toupiao dbst = new DBSys6Toupiao();
		DBSys6ToupiaoItem dbstpi = new DBSys6ToupiaoItem();
		
		String data = request.getParameter("data");
		JSONObject json1 = JSONObject.fromObject(data);
		String o_type = json1.getString("o_type"); 
		JSONArray arrList = json1.getJSONArray("xxarr");
		String [] strArray = new String [arrList.size()];
		
		for (int i = 0; i < arrList.size(); i++) {
			strArray[i] = (String) arrList.get(i);
		}
		String id = json1.getString("oOption"); //区或者街道ID
		String toupiao_name = json1.getString("inp1"); //投票主题
		String toupiao_dept = json1.getString("inp2"); //投票部门
		String toupiao_text = json1.getString("otextarea"); //投票内容
		String toupiao_begin = json1.getString("startDate"); //开始时间
		String toupiao_end = json1.getString("endDate");  //结束时间
		
		Sys6Toupiao stp = new Sys6Toupiao();
		stp.setToupiao_name(toupiao_name);
		stp.setToupiao_dept(toupiao_dept);
		stp.setToupiao_text(toupiao_text);
		stp.setToupiao_begin(toupiao_begin);
		stp.setToupiao_end(toupiao_end);
		
		boolean isOk1 = false;
		boolean isOk2 = false;
		if(o_type.equals("qu")){
			stp.setQu_id(id);
			try {
				if (dbst.InsertByQu(stp)){
					int toupiao_id = dbst.SelectToId(toupiao_name);
					for (int j = 0; j < strArray.length; j++) {
						Sys6Toupiaoitem stpi = new Sys6Toupiaoitem();
						stpi.setToupiao_id(toupiao_id);
						stpi.setToupiaoItem_name(strArray[j]);
						isOk2 =  dbstpi.InsertByToupiao_id(stpi);
					}
					isOk1 = dbst.SelectBytoupiao_name(toupiao_name);
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setContentType("text/html;charset=utf-8"); 
			if(isOk1 && isOk2){
				response.getWriter().print("true");
			}else{
				response.getWriter().print("false");
			}
		}else if(o_type.equals("jie")){
			stp.setJiedao_id(id);
			try {
				if (dbst.InsertByJie(stp)){
					int toupiao_id = dbst.SelectToId(toupiao_name);
					for (int j = 0; j < strArray.length; j++) {
						Sys6Toupiaoitem stpi = new Sys6Toupiaoitem();
						stpi.setToupiao_id(toupiao_id);
						stpi.setToupiaoItem_name(strArray[j]);
						isOk2 =  dbstpi.InsertByToupiao_id(stpi);
					}
					isOk1 = dbst.SelectBytoupiao_name(toupiao_name);
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setContentType("text/html;charset=utf-8"); 
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
