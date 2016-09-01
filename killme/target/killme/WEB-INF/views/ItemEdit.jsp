<%@include file="header1.jsp"%>
<script>
	document.write('<base href="' + document.location + '" />');
</script>
<div class="container">
	<hr></hr>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Category</th>
			<th>Price</th>
		</tr>
		<tr>
			<form action="toUpdateItem" method="post">
				<td><input value="${editItemKey.id}" name="id" type="hidden" /></td>
				<td><input value="${editItemKey.name}" name="name" /></td>
				<td><input value="${editItemKey.description}" name="description" /></td>
				<td><input value="${editItemKey.category}" name="category" /></td>
				<td><input value="${editItemKey.price}" name="price" /></td>
				<td><img src="resources/images/${editItemKey.id}.jpg" style="width: 100px; height: 100px"></td>
				<td><input type="submit" value="update"></td>
			</form>
		</tr>
	</table>
</div>
<%@include file="footer.jsp"%>