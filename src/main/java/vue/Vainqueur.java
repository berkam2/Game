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

/**
 * Servlet implementation class Vainqueur
 */
@WebServlet("/Vainqueur")
public class Vainqueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContestDao cDao = new ContestDao();
    PlayerContestDao pcDao = new PlayerContestDao();
    PlayerDao pDao = new PlayerDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vainqueur() {
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
		int idContest = Integer.parseInt(request.getParameter("contest"));
		Contest c = new Contest();
		c.setIdContest(idContest);
		
		int idPlayer = Integer.parseInt(request.getParameter("gagnant"));
		
		Player p = new Player();
		p.setIdPlayer(idPlayer);
		c.setJoueur(p);
		cDao.update(c);
		
		
		response.sendRedirect("Details");
	}

}
