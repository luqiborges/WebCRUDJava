package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import negocio.Candidato;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import biblioteca.CandidatoDAO;

/**
 * Servlet implementation class AlterarCandidato
 */
public class AlterarCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigoParaAlterar = Integer.parseInt(request.getParameter("codigoParaAlterar"));
		
		CandidatoDAO cdao = new CandidatoDAO();
		Candidato candidatoParaAlterar = cdao.buscar(codigoParaAlterar);
		
		request.setAttribute("candidatoParaAlterar", candidatoParaAlterar);
		RequestDispatcher rd = request.getRequestDispatcher("alterarCandidato.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigoParaAlterar = Integer.parseInt(request.getParameter("codigoParaAlterar"));
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		Date dataNascimento = java.sql.Date.valueOf(request.getParameter("dataNascimento"));
		String cargoPretendido = request.getParameter("cargoPretendido");
		String textoCurriculo = request.getParameter("textoCurriculo");
		
		Candidato alterado = new Candidato(codigo,nome,sexo,dataNascimento,cargoPretendido,textoCurriculo);
		CandidatoDAO cdao = new CandidatoDAO();
		cdao.alterar(alterado, codigoParaAlterar);

		response.sendRedirect("listar");
	}

}
