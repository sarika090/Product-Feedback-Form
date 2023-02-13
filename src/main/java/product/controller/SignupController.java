package product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.bo.Product_bo;
import product.dao.Product_dao;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
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
		String pwd=request.getParameter("pass");

		//pw.print(name+" "+email+" "+phone+" "+pwd);
		
	    Product_bo pr=new Product_bo();
	    
	    pr.setName(name);
	    pr.setEmail(email);
	    pr.setPhone(phone);
	    pr.setPass(pwd);
	    
	    int status = Product_dao.signup(pr);
	    
	    if(status>0) {
	    	RequestDispatcher rd=request.getRequestDispatcher("login.html");
	    	rd.forward(request, response);
	    	//pw.print("You are done with signup, kindly login with your username");
	    }
	    else {
	    	RequestDispatcher rd=request.getRequestDispatcher("signup.html");
            rd.include(request, response);
	    	//pw.print("Something went wrong");
	    }
		
	}

}
