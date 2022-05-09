import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import IoTBay.OrderDAO;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response)
			           throws ServletException, java.io.IOException {

try
{
     Order order = new Order();
     order.setOrderID(request.getParameter("OrderID"));
     order.setDate(request.getParameter("Date"));

     order = OrderDAO.findOrder(order);

     if (order.isValid())
     {

          HttpSession session = request.getSession(true);
          session.setAttribute("currentSessionUser",user);
          response.sendRedirect("OrderFound.jsp"); //logged-in page
     }

     else
          response.sendRedirect("invalidOrder.jsp"); //error page
}


catch (Throwable theException)
{
     System.out.println(theException);
}
       }
	}