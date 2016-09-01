<%@include file="header.jsp" %>
<center>
<h1>Enter your Details Here</h1>
<form:form action="toSuccess" commandName="CusKey" method="POST"><br>
<table>
<tr>
<td style="font-size:20px; padding:20px;">Name:</td>
<td><form:input path="name" style="width:300px; height:40px;" placeholder="name"/><form:errors path="name" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Email:</td>
<td><form:input path="email" style="width:300px; height:40px;" placeholder="email"/><form:errors path="email" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Password:</td>
<td><form:input path="password" style="width:300px; height:40px;" placeholder="password"/><form:errors path="password" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Mobileno:</td>
<td><form:input path="mobile" style="width:300px; height:40px;" placeholder="mobile number"/><form:errors path="mobile" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Address:</td>
<td><form:input path="address" style="width:300px; height:40px;" placeholder="address"/><form:errors path="address" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="padding:50px;"><input type="submit" value="Register" style="font-size:20px;"/></td>
</tr>
</table>
</form:form><br><br><br><br>
</center>
<%@include file="footer.jsp" %>