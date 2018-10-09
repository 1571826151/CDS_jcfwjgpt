package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sys6Lettergo;

import DAO.DBSys6LetterGo;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys6_letter_select
 */
@WebServlet("/Sys6_letter_select")
public class Sys6_letter_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_letter_select() {
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
		String num = json1.getString("num");
		
		List<Sys6Lettergo> list = new ArrayList<Sys6Lettergo>();
		DBSys6LetterGo dblg = new DBSys6LetterGo();
		if(num.equals("1")){
			String inp = json1.getString("inp");
			 try {
				list = dblg.QueryByName(inp);
				dblg.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(num.equals("2")){
			String odateStart = json1.getString("odateStart");
			String odateEnd = json1.getString("odateEnd");
			 try {
				list = dblg.QueryByTime(odateStart , odateEnd);
				dblg.clean();
				} catch (Exception e) {
					// TODO: handle exception
				}
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
