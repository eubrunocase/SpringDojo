<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
<form name="form1" method="post" action="/cadastrar">
<table>
	<tr>
		<td><font color="red" size="14"><%= request.getSession().getAttribute("mensagem") != null ? request.getSession().getAttribute("mensagem") : "" %></font>
	</tr>
	<tr>
		<td>Digite os dados do livro</td>
	</tr>
	<tr>
		<td>Título</td>
		<td><input type="text" name="titulo"></td>
	</tr>
	<tr>
		<td>Editora</td>
		<td><input type="text" name="editora"></td>
	</tr>
	<tr>
		<td><button type="submit">Enviar</button></td>
		<td><input type="reset" value="Limpar"></td>
	</tr>
</table>
</form>

<form name="form2" method="get" action="/buscar">
	<table>
		<tr>
			<td>Buscar Livro por Título</td>
		</tr>
		<tr>
			<td>Título</td>
			<td><input type="text" name="titulo"></td>
		</tr>
		<tr>
			<td><button type="submit">Buscar</button></td>
		</tr>
	</table>
</form>

<form name="form3" method="post" action="/atualizar">
	<table>
		<tr>
			<td>Atualizar Livro</td>
		</tr>
		<tr>
			<td>Título Atual</td>
			<td><input type="text" name="titulo"></td>
		</tr>
		<tr>
			<td>Novo Título</td>
			<td><input type="text" name="novoTitulo"></td>
		</tr>
		<tr>
			<td>Nova Editora</td>
			<td><input type="text" name="novaEditora"></td>
		</tr>
		<tr>
			<td><button type="submit">Atualizar</button></td>
		</tr>
	</table>
</form>

<form name="form4" method="post" action="/remover">
	<table>
		<tr>
			<td>Remover Livro por Título</td>
		</tr>
		<tr>
			<td>Título</td>
			<td><input type="text" name="titulo"></td>
		</tr>
		<tr>
			<td><button type="submit">Remover</button></td>
		</tr>
	</table>
</form>

<a href="/listar">Listar Todos os Livros</a>

<% request.getSession().removeAttribute("mensagem"); %>
</body>
</html>