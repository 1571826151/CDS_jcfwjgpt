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
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys6_pingyi_select
 */
@WebServlet("/Sys6_pingyi_select")
public class Sys6_pingyi_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_pingyi_select() {
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
		int num = json1.getInt("num");

		List<Sys6Pinyi> list1 = new ArrayList<Sys6Pinyi>();
		DBSys6Pinyi dbsp = new DBSys6Pinyi();
		
		if(num == 111){
			String oinp = json1.getString("oinp");
			try {
				list1 = dbsp.SelectAllByTitle(oinp);
				dbsp.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num == 222){
			String doDate = json1.getString("doDate");
			String doDate1 = json1.getString("doDate1");
			try {
				list1 = dbsp.SelectAllByTime(doDate, doDate1);
				dbsp.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		String jsonString = JSONSerializer.toJSON(list1).toString();
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
