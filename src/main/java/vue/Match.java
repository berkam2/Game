package vue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ContestDao;
import controller.GameDao;
import controller.PlayerDao;
import modele.Contest;
import modele.Game;

/**
 * Servlet implementation class Match
 */
@WebServlet("/Match")
public class Match extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContestDao cDao = new ContestDao();
	GameDao gDao = new GameDao();
	PlayerDao pDao = new PlayerDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Match() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("games",gDao.read());
		request.getRequestDispatcher("Contest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idGame = Integer.parseInt(request.getParameter("game"));
		String time = request.getParameter("date");
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date startDate = null;
		try {
			startDate = df.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Game g = new Game();
		g.setIdGame(idGame);
		Contest c = new Contest();
		c.setGame(g);
		c.setStartDate(startDate);
		
		cDao.create(c);
		
		
		response.sendRedirect("Acceuil");
	}

}
