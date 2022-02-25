package vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ContestDao;
import controller.PlayerContestDao;
import controller.PlayerDao;
import modele.PlayerContest;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContestDao cDao = new ContestDao();
    PlayerContestDao pcDao = new PlayerContestDao();
    PlayerDao pDao = new PlayerDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		// TODO Auto-generated method stub
		int idPlayerContest = Integer.parseInt(request.getParameter("idPlayerContest"));
		PlayerContest pc = new PlayerContest();
		pc.setIdPlayerContest(idPlayerContest);
		pcDao.delete(pc);
		response.sendRedirect("Details");
	}

}
