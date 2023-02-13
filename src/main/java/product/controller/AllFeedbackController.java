package product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.bo.AddFeedback_bo;
import product.dao.Product_dao;

/**
 * Servlet implementation class AllFeedbackController
 */
@WebServlet("/AllFeedbackController")
public class AllFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllFeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String cssTag="<link rel='stylesheet' type='text/css' href='css/table.css'>";
		
       pw.print("<html>");
		
		pw.println("<head><title>Title Name</title>"+cssTag+"</head>");
		
		pw.print("<body>");
		
		
		
		pw.print("<a href='home.html'>Back</a>");
		
		pw.print("<table border='1px' width='100%'>");
		
		pw.print("<tr> <th>Id</th> <th>Name</th> <th>Email</th> <th>Phone</th> <th>Comment</th> <th>Review</th><th>Actions</th><th>Delete</th></tr>");
		
		List<AddFeedback_bo> list=Product_dao.getAllEmployee();
		
		for(AddFeedback_bo fb:list) {
			
			pw.print("<tr><td>"+fb.getId()+"</td><td>"+fb.getName()+"</td><td>"+fb.getEmail()+"</td><td>"+fb.getPhone()+"</td><td>"+fb.getComment()+"</td><td>"+fb.getRating()+"</td><td>"+"<a href='Editservlet?id="+fb.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+fb.getId()+"'>delete</a></td></tr>");
		
		}
		 pw.print("</table>");
		 pw.print("</body>");
			
			pw.print("</html>");
	}

}