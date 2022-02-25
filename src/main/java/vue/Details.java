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
import modele.Contest;
import modele.Player;
import modele.PlayerContest;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		ContestDao cDao = new ContestDao();
       PlayerContestDao pcDao = new PlayerContestDao();
       PlayerDao pDao = new PlayerDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idContest = Integer.parseInt(request.getParameter("idContest"));
		request.setAttribute("playerContest",cDao.findById(idContest));
		request.setAttribute("playerBanc", pDao.readPlayerBanc(idContest));
		request.setAttribute("listeJoueur", pcDao.readPlayerContest(idContest));
		request.setAttribute("nContest", pcDao.readPlayerContest(idContest).size());
		
		request.getRequestDispatcher("match.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idPC = Integer.parseInt(request.getParameter("playerContest"));
		int idPlayer = Integer.parseInt(request.getParameter("newPlayer"));
		
		PlayerContest pC = new PlayerContest();
		Player p = new Player();
		Contest c = new Contest();
		p.setIdPlayer(idPlayer);
		c.setIdContest(idPC);
		pC.setContest(c);
		pC.setPlayer(p);
		pcDao.create(pC);
		
		
		doGet(request, response);
	}

}
