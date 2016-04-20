<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html5>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="30">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<title>Cryptocurrencies Page</title>
<style>
@media ( min-width : 768px) {
	table.t1 {
		display: table;
	}
	table.t2 {
		display: none;
	}
}

@media ( max-width : 767px) {
	table.t1 {
		display: none;
	}
	table.t2 {
		display: table;
	}
}

table {
	vertical-align: middle;
}

table, th, td {
	border: 1px solid gainsboro;
	border-collapse: collapse;
	text-align: center;
}

th {
	background-color: black;
	color: white;
}

table {
	width: 100%;
}
</style>
</head>
<body>
	<c:if test="${!empty listCryptocurrencies}">
		<table class="t1">
			<caption style="text-align: center; font-size: 2em">Cryptocurrencies
				List</caption>
			<thead>
				<tr>
					<th>&#x266F; Cryptocurrency ID</th>
					<th>Cryptocurrency Name</th>
					<th>Targeted FIAT Currency</th>
					<th>Weighted Price</th>
					<th>Total Trade Volume(24Hr)</th>
					<th>Past Hour Price Change</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCryptocurrencies}" var="cryptocurrency">
					<tr>
						<td>${cryptocurrency.cryptocurrencyID}</td>
						<td><img src="resources/img/${cryptocurrency.base}.png" />&nbsp;${cryptocurrency.base}</td>
						<td>${cryptocurrency.target}</td>
						<td>${cryptocurrency.price}</td>
						<td>${cryptocurrency.volume}</td>
						<td>${cryptocurrency.change}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:forEach items="${listCryptocurrencies}" var="cryptocurrency">
		<table class="t2">
			<tr>
				<th>&#x266F; Cryptocurrency ID</th>
				<td>${cryptocurrency.cryptocurrencyID}</td>
			</tr>
			<tr>
				<th>Cryptocurrency Name</th>
				<td><img src="resources/img/${cryptocurrency.base}.png" />&nbsp;${cryptocurrency.base}</td>
			</tr>
			<tr>
				<th>Targeted FIAT Currency</th>
				<td>${cryptocurrency.target}</td>
			</tr>
			<tr>
				<th>Weighted Price</th>
				<td>${cryptocurrency.price}</td>
			</tr>
			<tr>
				<th>Total Trade Volume(24Hr)</th>
				<td>${cryptocurrency.volume}</td>
			</tr>
			<tr>
				<th>Past Hour Price Change</th>
				<td>${cryptocurrency.change}</td>
			</tr>
		</table>
		<br />
	</c:forEach>
</body>
</html>
