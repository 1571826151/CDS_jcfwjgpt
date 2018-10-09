package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.SysJiedao;

import DAO.DBSysJiedao;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Query_AllJiedaoName
 */
@WebServlet("/Query_AllJiedaoName")
public class Query_AllJiedaoName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query_AllJiedaoName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<SysJiedao> list = new ArrayList<SysJiedao>();
		DBSysJiedao dbsj = new DBSysJiedao();
		
		String value = request.getParameter("value");
		try {
			list = dbsj.QueryName(value);
			dbsj.clean();
		} catch (Exception e) {
			// TODO: handle exception
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
