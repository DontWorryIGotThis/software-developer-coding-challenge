<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record your Bid</title>
<style>
td { padding: 5px; }
</style>
</head>
<body>
<h3>The details of the vehicles are as follows</h3>
<table >
	<tr><td><b>VehicleId</b></td><td><b>Make</b></td><td><b>Model</b></td><td><b>Miles Driven</b></td><td><b>Winning Bid</b></td></tr>
  <c:forEach items="${allVehicle.vehicleList}" var="item">
    <tr>
      <td><c:out value="${item.vehicleId}"/></td>
      <td><c:out value="${item.make}" /></td>
      <td><c:out value="${item.model}"/></td>
      <td><c:out value="${item.milesDriven}"/></td>
      <td><c:out value="${item.winningBid}"/></td>
    </tr>
  </c:forEach>
</table>

<h3>Please place your bid below by mentioning the user id and vehicle id</h3>
<form:form action="/auctionator/app/recordbid" method="post" modelAttribute="recordBidModel">
	<table>
		<tr><th>User Id:</th><th><form:input name="userId" type="text" path="userId"/></th></tr>
		<tr><th>Vehicle Id:</th><th><form:input name="vehicleId" type="text" path="vehicleId"/></th></tr>
		<tr><th>Bid Amount:</th><th><form:input name="bidAmount" type="number" path="bidAmount"/></th></tr>
		<tr><th><input type="submit" /></th></tr>
	</table>
</form:form>

</body>
</html>