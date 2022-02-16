<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="negocio.Candidato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="stylesLista.css">
	<meta charset="ISO-8859-1">
	<title>Listar candidatos</title>
	
	<%
		List<Candidato> listaCandidatos = (ArrayList<Candidato>) request.getAttribute("candidatos");
	%>
	
</head>
<body>
	<div class="headerContainer">
		<h2>Candidatos cadastrados</h2>
	</div>
	
	<div class="bodyContainer">
		<table class="styledTable">
			<tr>
				<th>CÓDIGO</th>
				<th>NOME</th>
				<th>SEXO</th>
				<th>DATA NASCIMENTO</th>
				<th>CARGO PRETENDIDO</th>
				<th>TEXTO CURRÍCULO</th>
				<th>-</th>
			</tr>
			
			<%
			for(Candidato c : listaCandidatos){
			%>
				<tr>
					<td><%=c.getCodigo() %></td>
					<td><%=c.getNome() %></td>
					<td><%=c.getSexoDescricao() %></td>
					<td><%=c.getData_nasc() %></td>
					<td><%=c.getCargo_pretendido() %></td>
					<td><%=c.getTexto_curriculo() %></td>
					<td>
						<a href="excluir?codigo=<%=c.getCodigo() %>">
							<img alt="ExcluirCandidato" src="imagens/img_216917.png" width="25px" height="30px">
						</a>
						<a href="alterar?codigoParaAlterar=<%=c.getCodigo() %>">
							<img alt="AlterarCandidato" src="imagens/alterarImg.png" width="30px" height="30px">
						</a>
					</td>
				</tr>
			<%
			}
			%>
		</table>
		
		<div class="backButton">
			<a class="link" href="index.html">VOLTAR PARA O MENU PRINCIPAL</a>
		</div>
	</div>
	
	
</body>
</html>