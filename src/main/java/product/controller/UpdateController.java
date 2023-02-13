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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String comment=request.getParameter("comment");
		String rating=request.getParameter("rating");
		
		AddFeedback_bo fb=new AddFeedback_bo();
		fb.setId(id);
		fb.setName(name);
		fb.setEmail(email);
		fb.setPhone(phone);
		fb.setComment(comment);
		fb.setRating(rating);
		
		int status=Product_dao.Update(fb);
		
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("AllFeedbackController");
			rd.forward(request, response);
		}
		
		
	}      
}
