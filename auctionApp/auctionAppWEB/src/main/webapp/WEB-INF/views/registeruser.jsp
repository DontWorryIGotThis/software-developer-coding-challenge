<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<h1>Please enter the user details</h1>
	</head>
	<body>
		<form:form action="/auctionator/app/registeruser" method="post" modelAttribute="registerModel">
			<table>
				<tr><td>Name:</td><td><form:input name="name" type="text" path="name"/></td></tr>
				<tr><td>Email:</td><td><form:input name="email" type="email" path="email"/></td></tr>
				<tr><td><input type="submit" /></td></tr>
			</table>
		</form:form>
	</body>
</html>