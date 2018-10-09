package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sys6Letterback;
import com.Sys6Lettergo;

import DAO.DBSys6LetterBack;
import DAO.DBSys6LetterGo;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys6_letter_back
 */
@WebServlet("/Sys6_letter_back")
public class Sys6_letter_back extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_letter_back() {
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
		String id = json1.getString("id");
		
		List<Sys6Lettergo> list = new ArrayList<Sys6Lettergo>();
		DBSys6LetterGo dblg = new DBSys6LetterGo();
		
		DBSys6LetterBack dblb = new DBSys6LetterBack();
		
		boolean isOk = false;
		String display = "";
		try {
			list = dblg.QueryAllById(id);
			if(dblb.QueryById(id)){
				isOk = true;
			}
			dblg.clean();
			dblb.clean();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(isOk){
			display = "block";
		}else{
			display = "none";
		}
		String jsonString = JSONSerializer.toJSON(list).toString();
		
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().print(jsonString + "+" + display);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
