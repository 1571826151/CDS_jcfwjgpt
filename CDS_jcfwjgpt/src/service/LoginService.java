package service;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DBAdmin;
import net.sf.json.JSONObject;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoginService() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//String admin_phone = request.getParameter("admin_phone");
		//String admin_password = request.getParameter("admin_password");
		String login = request.getParameter("data");
		JSONObject json = JSONObject.fromObject(login);
		String admin_phone = (String) json.get("name");
		String admin_password = (String) json.get("pwd");
		String session_name = " ";
		DBAdmin dba = new DBAdmin();
		
		boolean isOk = false;
		try {
			if(dba.doLogin(admin_phone, admin_password)){
				isOk = true;
				session_name  = dba.QueryName(admin_phone);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isOk){
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print("222");
			HttpSession session = request.getSession();
			session.setAttribute("session_name",session_name); 
		}else{
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print("111");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
