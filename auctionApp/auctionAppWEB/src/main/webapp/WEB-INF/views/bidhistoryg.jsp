<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bid History</title>
</head>
<body>
<h3>Please enter the vehicle Id below to get the bidHistory</h3>
<form:form action="/auctionator/app/bidhistory" method="post" modelAttribute="bidHistoryModel">
	<table>
		<tr><th>Vehicle Id:</th><th><form:input name="desiredVehicleId" type="text" path="desiredVehicleId" maxlength="6"/></th></tr>
		<tr><th><input type="submit" /></th></tr>
	</table>
</form:form>
<p>
<a href="http://localhost:8080/auctionator/app/allvehicleg">Record a bid</a><br>
<a href="http://localhost:8080/auctionator/app/">Back</a><br>
</p>
</body>
</html>