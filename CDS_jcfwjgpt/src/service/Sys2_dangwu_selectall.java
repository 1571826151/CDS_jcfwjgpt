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
import com.User;

import DAO.DBSys2GongkaiJiedao;
import DAO.DBSys2GongkaiQu;
import DAO.DBUser;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys2_dangwu_selectall
 */
@WebServlet("/Sys2_dangwu_selectall")
public class Sys2_dangwu_selectall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys2_dangwu_selectall() {
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
		String str = json.getString("str");
		String num = json.getString("num");
		if(num.equals("1")){
			List<Sys2GongkaiQu> list = new ArrayList<Sys2GongkaiQu>();
			DBSys2GongkaiQu dbgq = new DBSys2GongkaiQu();
			try {
				list = dbgq.QueryAll(str);
				dbgq.clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String jsonString = JSONSerializer.toJSON(list).toString();
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print(jsonString);
		}else if(num.equals("2")){
			List<Sys2GongkaiJiedao> list = new ArrayList<Sys2GongkaiJiedao>();
			DBSys2GongkaiJiedao dbgj = new DBSys2GongkaiJiedao();
			try {
				list = dbgj.QueryAll(str);
				dbgj.clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String jsonString = JSONSerializer.toJSON(list).toString();
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
