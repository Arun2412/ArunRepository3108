<%@ include file="header1.jsp" %>
<table align="center">
<form:form action="toSuccessAdd" commandName="addItemKey" method="POST" enctype="multipart/form-data">
<tr>
<td style="font-size:20px; padding:20px;">Item Name:</td>
<td><form:input path="name" style="width:300px; height:40px;" placeholder="name"></form:input><form:errors path="name" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Item Description:</td>
<td><form:input path="description" style="width:300px; height:40px;" placeholder="description"></form:input><form:errors path="description" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Item Price:</td>
<td><form:input path="price" style="width:300px; height:40px;" placeholder="price"></form:input></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Categories:</td>
<td><form:select path="category" style="width:300px; height:40px;" placeholder="category"><form:errors path="category" style="color:red;"></form:errors>
<form:option value="Drawing">Drawing</form:option>
<form:option value="Portrait">Portrait</form:option>
<form:option value="performance">Performance</form:option>
<form:option value="MixedMedia">MixedMedia</form:option>
</form:select></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Item Image:</td>
<td><input name="file" type="file" value="Choosefile" style="width:300px; height:40px;" required/></td>
</tr>
<tr>
<td><input type="submit" value="Add Product" style="width:200px; height:40px; margin-left:3opx;"></input></td>
</tr>
</form:form>
</table>
<%@ include file="footer.jsp"%>