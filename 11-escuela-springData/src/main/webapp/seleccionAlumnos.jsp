<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="buscarAlumnos" method="get">
			Seleccione curso: <select name="idCurso">
				<c:forEach var="curso" items="${requestScope.cursos}">
					<option value="${curso.idCurso}">${curso.denominacion}</option>
				</c:forEach>
				<br>
				<input type="submit" value="Buscar">
			<br>
			<br>
				<table border="1">
					<tr>
						<th>Nombre</th>
						<th>Email</th>
						<th>Edad</th>
					</tr>
					<c:forEach var="con" items="${requestScope.alumnos}">
						<tr>
							<td>${con.nombre}</td>
							<td>${con.email}</td>
							<td>${con.edad}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
			<br>
				<a href="toInicio">Volver</a>
		</form>
</body>
</html>