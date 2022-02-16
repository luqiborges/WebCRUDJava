package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import biblioteca.CandidatoDAO;

/**
 * Servlet implementation class ExcluirCandidato
 */
public class ExcluirCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigoCandidato = Integer.parseInt(request.getParameter("codigo"));
		
		CandidatoDAO cdao = new CandidatoDAO();
		cdao.excluir(codigoCandidato);
		
		response.sendRedirect("listar");
		
	}


}
