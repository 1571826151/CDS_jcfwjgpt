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
import com.Sys6Pinyiitem;

import DAO.DBSys6Pinyi;
import DAO.DBSys6PinyiItem;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys6_pingyi_selectinxuanxiang
 */
@WebServlet("/Sys6_pingyi_selectinxuanxiang")
public class Sys6_pingyi_selectinxuanxiang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_pingyi_selectinxuanxiang() {
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
		DBSys6PinyiItem dbspi = new DBSys6PinyiItem();
		
		List<Sys6Pinyi> list1 = new ArrayList<Sys6Pinyi>();
		List<Sys6Pinyiitem> list2 = new ArrayList<Sys6Pinyiitem>();
		try {
			int pinyi_id = dbsp.SelectToId(pinyi_title);
			list1 = dbsp.SelectAllByTitleMore(pinyi_title);
			list2 = dbspi.SelectAllById(pinyi_id);
			dbsp.clean();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String jsonString1 = JSONSerializer.toJSON(list1).toString();
		String jsonString2 = JSONSerializer.toJSON(list2).toString();
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().print(jsonString1 + "+" + jsonString2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
