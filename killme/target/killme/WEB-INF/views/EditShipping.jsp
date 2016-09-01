<%@include file="header2.jsp"%>
<h1>Congrats ! Your order has been placed</h1>
<table class="table table-striped">
	<tr>
		<th>Shipping Address:</th>
		<th>Phone Number:</th>
	</tr>
	<tr>
		<form action="toSuccessShipping?id=${CustomerObj.id}" method="post">
		<td><input name="address" style="width: 200px" value="${CustomerObj.address}" /></td>
		<td><input name="mobile" style="width: 200px" value="${CustomerObj.mobile}" /></td>
		<td><input type="submit" value="Update" /></td>
		</form>
	</tr>
</table>
<%@include file="footer.jsp"%>