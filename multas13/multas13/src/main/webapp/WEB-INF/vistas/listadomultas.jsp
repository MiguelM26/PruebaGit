<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Multas</title>
	</head>
	<body>
		<h2>Listado de multas</h2>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre del agente</th>
					<th>Matricula</th>
					<th>Fecha y hora</th>
					<th>Importe</th>
					<th>Infracción</th>
					<th>Lugar</th>
					<th>Observaciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="multa" items="${multas}">
					<tr>
						<td>${multa.codigo}</td>
						<td>${multa.agente.nombre}</td>
						<td>${multa.matricula}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${multa.fechaHora}" /></td>
						<td>${multa.importe}</td>
						<td>${multa.infraccion}</td>
						<td>${multa.lugar}</td>
						<td>${multa.observaciones}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>