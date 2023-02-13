package product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.bo.AddFeedback_bo;
import product.dao.Product_dao;

/**
 * Servlet implementation class Editservlet
 */
@WebServlet("/Editservlet")
public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<link rel='stylesheet' href='css/edit.css'>");
		
				 
		String id=request.getParameter("id");
		
		int fid=Integer.parseInt(id);
		
		AddFeedback_bo fb= Product_dao.getMemberById(fid);
		
		pw.print("<html>");
		
		
		pw.print("<body>");
		
		pw.print("<form action='UpdateController' method='Get'>");
		
		pw.print("<table>");
		
		pw.print("<tr><td></td><input type='hidden' name='id' value='"+fb.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' id='na' value='"+fb.getName()+" '/></td></tr>");
	   	pw.print("<tr ><td>Email: </td> <td><input type='text' name='email' id='na' value='"+fb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' id='na' value='"+fb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>comment : </td> <td><input type='text' name='comment' id='na' value='"+fb.getComment()+"'/></td></tr>");
	   	pw.print("<tr><td>rating: </td> <td><input type='text' name='rating' id='na' value='"+fb.getRating()+"'/></td></tr>");	    
	   
		 pw.print("<tr><td><input type='submit' id='btn' value='Update'/></td></tr>"); 

	   	pw.print("</table>");
		
		pw.print("</form>");

		
		pw.print("</body>");
		
		pw.print("</html>");


	}

}
