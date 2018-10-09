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
import com.mysql.jdbc.PreparedStatement.ParseInfo;

import DAO.DBSys6LetterBack;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Sys6_letter_selectOrinsert
 */
@WebServlet("/Sys6_letter_selectOrinsert")
public class Sys6_letter_selectOrinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys6_letter_selectOrinsert() {
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
		if(num.equals("111")){
			String id = json1.getString("id");
			DBSys6LetterBack dbslb = new DBSys6LetterBack();
			List<Sys6Letterback> list = new ArrayList<Sys6Letterback>();
			
			try {
				list = dbslb.QueryAllById(id);
				dbslb.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
			String jsonString = JSONSerializer.toJSON(list).toString();
			response.setContentType("text/html;charset=utf-8"); 
			response.getWriter().print(jsonString);
		}else if(num.equals("222")){
			Sys6Letterback slb = new Sys6Letterback();
			slb.setLettergo_id(Integer.parseInt(json1.getString("id")));
			slb.setLetterback_dept(json1.getString("inp1"));
			slb.setLetterback_title(json1.getString("inp3"));
			slb.setLetterback_text(json1.getString("otextarea"));
			slb.setLetterback_time(json1.getString("inp2"));
			boolean isOk = false;
			
			DBSys6LetterBack dbslb = new DBSys6LetterBack();
			try {
				if (dbslb.InsertAll(slb)) {
					isOk = dbslb.QueryById(json1.getString("id"));
				} 
				dbslb.clean();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(isOk){
				response.setContentType("text/html;charset=utf-8"); 
				response.getWriter().print("回复成功");
			}else{
				response.setContentType("text/html;charset=utf-8"); 
				response.getWriter().print("回复失败");
			}
			
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
