package Contronller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Province;
import Bean.Student;
import DAO.HomeDAO;
import DB.DBConnection;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DBConnection.createConection();
		String name = request.getParameter("student");
		String provincename = request.getParameter("provincelist");
		int idprovince = Integer.parseInt(provincename);
		Province province = new Province(idprovince, provincename);
		Student student = new Student(name,province);
		boolean kt = HomeDAO.insertStudent(student);
		if(kt) {
			
			try {
				request.setAttribute("messinsert", "Success");
				
				List<Province> listprovince =  HomeDAO.Displayprovince();
				request.setAttribute("listprovince", listprovince);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
				rd.forward(request, response);

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				request.setAttribute("messinsert", "Not Success");
				List<Province> listprovince =  HomeDAO.Displayprovince();
				request.setAttribute("listprovince", listprovince);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
				rd.forward(request, response);

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
