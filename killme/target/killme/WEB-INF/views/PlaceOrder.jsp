<%@include file="header2.jsp"%>
<h3>Your Request is Under Processing. Please Check Your Shipping Address and Mobile Before Clicking Confirm Order.</h3>
<table class="table table-striped">
	<tr>
		<th>Shipping Address:</th>
		<th>Phone Number:</th>
		<th>Total Price:</th>
	</tr>
	<tr>
		<td>${shippingAddress}<br><a href="toEditShipping?id=${customerId}"><span class="glyphicon glyphicon-edit"></span> Edit</a></td>
		<td>${phoneNumber}<br><a href="toEditShipping?id=${customerId}"><span class="glyphicon glyphicon-edit"></span> Edit</a></td>
		<td>${grandTotal}</td>
	</tr>
</table>
<div align="left">
    <a href="toConfirmOrder" class="btn btn-default center">Confirm Order</a>
    </div>
<%@include file="footer.jsp"%>