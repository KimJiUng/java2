package chatting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;

/**
 * Servlet implementation class dice
 */
@WebServlet("/chatting/dice")
public class dice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dice1 = Integer.parseInt(request.getParameter("dice1"));
		int sumdice = Integer.parseInt(request.getParameter("sumdice"));
		String player = request.getParameter("player");
		sumdice += dice1;
		System.out.println(sumdice);
		User user = new User(player, sumdice , 0);
		request.getSession().setAttribute("dice",user );
		System.out.println("userservelet : "+user.toString() );
		
		response.getWriter().print(sumdice);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
