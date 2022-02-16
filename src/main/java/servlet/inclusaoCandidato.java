package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.Date;

import biblioteca.CandidatoDAO;
import negocio.Candidato;

/**
 * Servlet implementation class inclusaoCandidato
 */
public class inclusaoCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		Date dataNascimento = java.sql.Date.valueOf(request.getParameter("dataNascimento"));
		String cargoPretendido = request.getParameter("cargoPretendido");
		String textoCurriculo = request.getParameter("textoCurriculo");
		
		Candidato novo = new Candidato(codigo,nome,sexo,dataNascimento,cargoPretendido,textoCurriculo);
		CandidatoDAO cdao = new CandidatoDAO();
		cdao.criar(novo);

		response.sendRedirect("listar");
	}

}
