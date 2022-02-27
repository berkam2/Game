package vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.GameDao;
import modele.Game;

/**
 * Servlet implementation class Jeux
 */
@WebServlet("/Jeux")
public class Jeux extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GameDao gDao = new GameDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jeux() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jeux.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int minPlayer = Integer.parseInt(request.getParameter("minPlayer"));
		int maxPlayer = Integer.parseInt(request.getParameter("maxPlayer"));
		String title = request.getParameter("jeux");
		
		Game g = new Game();
		g.setMaxPlayers(maxPlayer);
		g.setMinPlayers(minPlayer);
		g.setTitle(title);
		
		gDao.create(g);
		
		doGet(request, response);
	}

}
