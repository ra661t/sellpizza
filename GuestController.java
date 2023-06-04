package ch11;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import ch09.Student;
import ch09.StudentDAO;

/**
 * Servlet implementation class GuestController
 */
@WebServlet("/guestControl")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentDAO dao;
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	dao = new GuestDAO();
    }
    
    public GuestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String view = "";
		if(action == null) {
			getServletContext().getRequestDispatcher("/guesttControl?action=list").forward(request, response);
				}else {
					switch(action) {
					case "list": view = list(request, response); break;
					case "insert": view  = insert(request,response); break;
					}
					getServletContext().getRequestDispatcher("/ch11/"+view).forward(request, response);
				}
		}
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("guest", dao.getAll());
		return "guestList.jsp";
	}
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Guest g = new Guest();
		try {
			BeanUtils.populate(g, request.getParameterMap());
		}catch (Exception e) {e.printStackTrace();}
		dao.insert(g);
		return list(request, response);
	}
}
