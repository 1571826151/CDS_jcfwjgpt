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
 * Servlet implementation class Sys2_selectmore
 */
@WebServlet("/Sys2_selectmore")
public class Sys2_selectmore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys2_selectmore() {
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
		JSONObject json = JSONObject.fromObject(data);
		String ospan_id = json.getString("ospan_id");
		int num = json.getInt("num");
		String type = json.getString("type");
		if(type.equals("zhengwu")){
			type = "政务公开";
		}else if(type.equals("dangwu")){
			type = "党务公开";
		}
		List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
		DBSys2GongkaiQu dbgq = new DBSys2GongkaiQu();
		
		List<Sys2GongkaiJiedao> list1 = new ArrayList<Sys2GongkaiJiedao>();
		DBSys2GongkaiJiedao dbgj = new DBSys2GongkaiJiedao();
		if(num == 1){
			try {
				list = dbgq.QueryMoreById(ospan_id, type);
				dbgq.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
			String jsonString = JSONSerializer.toJSON(list).toString();
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print(jsonString);
		}else if(num == 2){
			try {
				list1 = dbgj.QueryMoreById(ospan_id, type);
				dbgj.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
			String jsonString = JSONSerializer.toJSON(list1).toString();
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print(jsonString);
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
