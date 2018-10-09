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
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

@WebServlet("/Sys_user_selectall")
public class Sys_user_selectall extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public Sys_user_selectall() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		DBUser dbu = new DBUser();
		
		try {
			list = dbu.QueryAll();
			dbu.clean();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonString = JSONSerializer.toJSON(list).toString();
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().print(jsonString);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
