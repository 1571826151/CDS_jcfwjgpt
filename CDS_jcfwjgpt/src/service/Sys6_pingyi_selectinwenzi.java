package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sys6Pinyi;

import DAO.DBSys6Pinyi;
import DAO.DBSys6PinyiItem;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys6_pingyi_selectinwenzi
 */
@WebServlet("/Sys6_pingyi_selectinwenzi")
public class Sys6_pingyi_selectinwenzi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_pingyi_selectinwenzi() {
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
		
		String pinyi_title = json1.getString("title");
		
		DBSys6Pinyi dbsp = new DBSys6Pinyi();
		
		List<Sys6Pinyi> list = new ArrayList<Sys6Pinyi>();
		try {
			list = dbsp.SelectAllByTitleMore(pinyi_title);
			dbsp.clean();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String jsonString = JSONSerializer.toJSON(list).toString();
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().print(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
