package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User;

import DAO.DBUser;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys_user_select
 */
@WebServlet("/Sys_user_select")
public class Sys_user_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys_user_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		DBUser dbu = new DBUser();
		List<User> list = new ArrayList<User>();
		String data = request.getParameter("data");
		JSONObject json=JSONObject.fromObject(data); 
		String str = json.getString("str");
		String user_str = json.getString("inp");
		if(str.equals("1")){
			try {
				list = dbu.QueryName(user_str);
				request.setAttribute("list", list);
				dbu.clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(str.equals("2")){
			try {
				list = dbu.QueryPhone(user_str);
				request.setAttribute("list", list);
				dbu.clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(str.equals("3")){
			try {
				list = dbu.QueryEmail(user_str);
				request.setAttribute("list", list);
				dbu.clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String reault = JSONSerializer.toJSON(list).toString();
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().print(reault);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
