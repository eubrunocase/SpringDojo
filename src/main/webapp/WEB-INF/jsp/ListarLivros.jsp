<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.u2.web.SpringDojo.model.LivroModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Livros</title>
</head>
<body>
<h2>Lista de Livros</h2>
<table border="1">
	<tr>
		<th>Título</th>
		<th>Editora</th>
	</tr>
	<% 
		List<LivroModel> livros = (List<LivroModel>) request.getAttribute("livros");
		if (livros != null) {
			for (LivroModel livro : livros) {
	%>
	<tr>
		<td><%= livro.getTitulo() %></td>
		<td><%= livro.getEditora() %></td>
	</tr>
	<% 
			}
		} else {
	%>
	<tr>
		<td colspan="2">Nenhum livro encontrado.</td>
	</tr>
	<% } %>
</table>
<a href="/homeLivro">Voltar ao Cadastro</a>
</body>
</html>