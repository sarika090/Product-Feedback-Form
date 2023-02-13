package product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.bo.AddFeedback_bo;
import product.dao.Product_dao;

/**
 * Servlet implementation class AddFeedbackController
 */
@WebServlet("/AddFeedbackController")
public class AddFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String yourfeedback=request.getParameter("comment");
		String number=request.getParameter("rating");
		
		
		//pw.print(name+" "+email+" "+phone+" "+yourfeedback+" "+number);
		
		AddFeedback_bo fd=new AddFeedback_bo(name ,email, phone,yourfeedback,number);
		int status=Product_dao.AddFeedback(fd);
		
		if(status>0) {
			//pw.print("Your data has been successfully added");
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("AddFeedbackController");
			rd.include(request, response);
			//pw.print("Something went wrong");
		}

		
	}

}
