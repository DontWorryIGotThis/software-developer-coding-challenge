<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title>Vehicle Registration</title>
		<h1>Please enter the vehicle details</h1>
	</head>
	<body>
		<form:form action="/auctionator/app/registervehicle" method="post" modelAttribute="registerVehicle">
			<table>
				<tr><td>Make:</td><td><form:input name="make" type="text" path="make"/></td></tr>
				<tr><td>Model:</td><td><form:input name="model" type="text" path="model"/></td></tr>
				<tr><td>Miles Driven:</td><td><form:input name="milesDriven" type="text" path="milesDriven"/></td></tr>
				<tr><td><input type="submit" /></td></tr>
			</table>
		</form:form>
	</body>
</html>