package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sys2GongkaiJiedao;
import com.Sys2GongkaiQu;

import DAO.DBSys2GongkaiJiedao;
import DAO.DBSys2GongkaiQu;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Sys2_zhengwu_insert
 */
@WebServlet("/Sys2_zhengwu_insert")
public class Sys2_zhengwu_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sys2_zhengwu_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		DBSys2GongkaiQu dbgq = new DBSys2GongkaiQu();
		DBSys2GongkaiJiedao dbgj = new DBSys2GongkaiJiedao();
		
		Sys2GongkaiQu sgq = new Sys2GongkaiQu();
		Sys2GongkaiJiedao sgj = new Sys2GongkaiJiedao();
		
		String data = request.getParameter("data");
		JSONObject json=JSONObject.fromObject(data);
		String inp1_id = json.getString("inp1_id");
		String inp2_time = json.getString("inp2_time");
		String inp3_type = json.getString("inp3_type");
		String inp4_name = json.getString("inp4_name");
		String inp5_text = json.getString("inp5_text");
		String inp6_oOption = json.getString("inp6_oOption");
		int number = json.getInt("number");
		
		if(number == 1){
			sgq.setGongkai_qu_id(inp1_id);
			sgq.setGongkai_qu_time(inp2_time);
			sgq.setGongkai_qu_type(inp3_type);
			sgq.setGongkai_qu_name(inp4_name);
			sgq.setGongkai_qu_text(inp5_text);
			sgq.setQu_id(inp6_oOption);

			boolean isOk = false;
			
			try {
				if(dbgq.QueryGongkaiQu(sgq)){
					isOk = dbgq.SelectByGongkai_qu_id(inp6_oOption);
				}
				dbgq.clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isOk){
				response.setContentType("text/html;charset=utf-8"); 
				response.getWriter().print("222");
			}else{
				response.getWriter().print("111");
			}
		}else if(number == 2){
			sgj.setGongkai_jie_id(inp1_id);
			sgj.setGongkai_jie_time(inp2_time);
			sgj.setGongkai_jie_type(inp3_type);
			sgj.setGongkai_jie_name(inp4_name);
			sgj.setGongkai_jie_text(inp5_text);
			sgj.setJiedao_id(inp6_oOption);
			
			boolean isOk = false;
			
			try {
				if(dbgj.QueryGongkaiJiedao(sgj)){
					isOk = dbgj.SelectByGongkai_jie_id(inp6_oOption);
				}
				dbgj.clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isOk){
				response.setContentType("text/html;charset=utf-8"); 
				response.getWriter().print("222");
			}else{
				response.setContentType("text/html;charset=utf-8"); 
				response.getWriter().print("111");
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
