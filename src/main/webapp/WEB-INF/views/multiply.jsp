<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Witaj w widoku</h1>
	<table>
	<c:forEach begin="0" end="${size}" varStatus="row">
		<tr>
			<c:forEach begin="0" end="${size}" varStatus="col">
				<c:choose>
					<c:when test="${row.current == 0 && col.current == 0}">
						<td>
							x
						</td>
					</c:when>
					<c:when test="${row.current == 0}">
						<td>
							${col.current}
						</td>
					</c:when>
					<c:when test="${col.current == 0}">
						<td>
								${row.current}
						</td>
					</c:when>
					<c:otherwise>
						<td>
								${row.current * col.current}
						</td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
</body>
</html>