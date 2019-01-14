<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Vehicle Bid History</title>
</head>
<body>

<table >
	<tr><td><b>User Name</b></td><td><b>bid ID</b></td><td><b>Make</b></td><td><b>Model</b></td><td><b>Vehicle ID</b></td></tr>
  <c:forEach items="${bidHistoryModel.bidHistoryDetailList}" var="item">
    <tr>
      <td><c:out value="${item.userName}"/></td>
      <td><c:out value="${item.bid.bidId}" /></td>
      <td><c:out value="${bidHistoryModel.vehicle.make}"/></td>
      <td><c:out value="${bidHistoryModel.vehicle.model}"/></td>
      <td><c:out value="${bidHistoryModel.vehicle.vehicleId}"/></td>
    </tr>
  </c:forEach>
</table>

<p>What would you like to do next?</p>
<a href="http://localhost:8080/auctionator/app/registeruserg">Register User</a><br>
<a href="http://localhost:8080/auctionator/app/registervehicleg">Register Vehicle</a><br>
<a href="http://localhost:8080/auctionator/app/allvehicleg">Record a bid</a><br>
<a href="http://localhost:8080/auctionator/app/bidhistoryg">Bid History of a Vehicle</a><br>
</body>
</html>