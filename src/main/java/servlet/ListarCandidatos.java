package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;
import negocio.Candidato;
import biblioteca.CandidatoDAO;

/**
 * Servlet implementation class ListarCandidatos
 */
public class ListarCandidatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CandidatoDAO cdao = new CandidatoDAO();
		List<Candidato> candidatos = cdao.listar();
		
		request.setAttribute("candidatos", candidatos);
		RequestDispatcher rd = request.getRequestDispatcher("listarCandidatos.jsp");
		rd.forward(request, response);
		
	}

}
