package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sys2GongkaiJiedao;
import com.Sys2GongkaiQu;

import DAO.DBSys2GongkaiJiedao;
import DAO.DBSys2GongkaiQu;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys2_zhengwu_select
 */
@WebServlet("/Sys2_zhengwu_select")
public class Sys2_zhengwu_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys2_zhengwu_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String str = null;
		String str1 = null;
		String str2 = null;
		String data = request.getParameter("data");
		JSONObject json = JSONObject.fromObject(data);
		String num = json.getString("str");
		if(num.equals("1")||num.equals("3")||num.equals("4")||num.equals("5")||num.equals("7")||num.equals("8")){
			str = json.getString("inp");
		}else if(num.equals("2")||num.equals("6")){
			str1 = json.getString("inp_1");
			str2 = json.getString("inp_2");
		}

		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		List<Sys2GongkaiJiedao> list1 = new ArrayList<Sys2GongkaiJiedao>();
		DBSys2GongkaiQu dbgq = new DBSys2GongkaiQu();
		DBSys2GongkaiJiedao dbgj = new DBSys2GongkaiJiedao();
		
		if(num.equals("1")){
			try {
				list = dbgq.QueryById(str , "政务公开");
				dbgq.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("2")){
			try {
				list = dbgq.QueryByTime(str1, str2, "政务公开");
				dbgq.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("3")){
			try {
				list = dbgq.QueryByQu(str , "政务公开");
				dbgq.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("4")){
			try {
				list = dbgq.QueryByName(str , "政务公开");
				dbgq.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("5")){
			try {
				list1 = dbgj.QueryById(str , "政务公开");
				dbgj.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("6")){
			try {
				list1 = dbgj.QueryByTime(str1, str2, "政务公开");
				dbgj.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("7")){
			try {
				list1 = dbgj.QueryByJie(str , "政务公开");
				dbgj.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("8")){
			try {
				list1 = dbgj.QueryByName(str , "政务公开");
				dbgj.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(num.equals("1")||num.equals("2")||num.equals("3")||num.equals("4")){
			String reault = JSONSerializer.toJSON(list).toString();
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print(reault);
		}else if(num.equals("5")||num.equals("6")||num.equals("7")||num.equals("8")){
			String reault = JSONSerializer.toJSON(list1).toString();
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print(reault);
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
