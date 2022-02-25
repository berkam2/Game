package vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ContestDao;
import controller.GameDao;
import controller.PlayerContestDao;
import controller.PlayerDao;

/**
 * Servlet implementation class Acceuil
 */
@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ContestDao cDao = new ContestDao();
	GameDao gDao = new GameDao();
	PlayerDao pDao = new PlayerDao();
	PlayerContestDao pcDao = new PlayerContestDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listeJoueur", pDao.read());
		request.setAttribute("listeContest", cDao.read());
		request.setAttribute("listeJeux", gDao.read());
		//request.setAttribute("nombreJoueur", pcDao.readJoueur());
		request.getRequestDispatcher("acceuil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
