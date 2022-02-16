<%@ page import="negocio.Candidato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="stylesIncluirCandidato.css">
	<meta charset="ISO-8859-1">
	<title>Alterar Candidato</title>
	
</head>
<body>
	<%
		Candidato candidatoParaAlterar = (Candidato) request.getAttribute("candidatoParaAlterar");
	%>

	<section class="container">
		<div class="header">
			<h1>ALTERAR CANDIDATO</h1>
		</div>
		
		<form method="post" action="alterar">
			<div class="formContainer">
				<input type="hidden" name="codigoParaAlterar" value="<%=candidatoParaAlterar.getCodigo() %>"/>
				
				<label>
					CÓDIGO
					<br/>
					<input type="text" name="codigo" value="<%=candidatoParaAlterar.getCodigo() %>"/>
				</label>
				
				<label>
					NOME
					<br/>
					<input type="text" name="nome" value="<%=candidatoParaAlterar.getNome() %>"/>
				</label>
				
				<label>
					SEXO
					<br/>
					<select name="sexo">
						<%if(candidatoParaAlterar.getSexo().equals("M")){ %>
							<option value="M" selected>Masculino</option>
							<option value="F">Feminino</option>
						<%} else{ %>
							<option value="M">Masculino</option>
							<option value="F" selected>Feminino</option>
						<%} %>
					</select>
				</label>
				
				<label>
					DATA DE NASCIMENTO
					<br/>
					<input type="date" name="dataNascimento" value="<%=candidatoParaAlterar.getData_nasc() %>"/>
				</label>
				
				<label>
					CARGO PRETENDIDO
					<br/>
					<input type="text" name="cargoPretendido" value="<%=candidatoParaAlterar.getCargo_pretendido() %>"/>
				</label>
				
				<label>
					TEXTO CURRÍCULO
					<br/>
					<textarea name="textoCurriculo"><%=candidatoParaAlterar.getTexto_curriculo() %></textarea>
				</label>
				
				<button type="submit">ALTERAR CANDIDATO</button>
			</div>
		</form>
		
		<div class="backButton">
			<a class="link" href="listar">VOLTAR AOS CANDIDATOS</a>
		</div>
		
	</section>

</body>
</html>