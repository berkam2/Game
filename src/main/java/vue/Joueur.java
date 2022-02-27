package vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PlayerDao;
import modele.Player;

/**
 * Servlet implementation class Joueur
 */
@WebServlet("/Joueur")
public class Joueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PlayerDao pDao = new PlayerDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Joueur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Joueur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("joueur");
		String mail = request.getParameter("mail");
		Player pl = new Player();
		pl.setEmail(mail);
		pl.setNickname(name);
		
		pDao.create(pl);
		
		doGet(request, response);
	}

}
