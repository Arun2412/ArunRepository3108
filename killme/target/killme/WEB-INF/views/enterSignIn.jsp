<%@include file="header.jsp"%>
<hr></hr>
<div class="form" align="center">
<h1>Enter Your Credentials Here</h1>
	<form name='loginForm'
		action="<c:url value='j_spring_security_check'/>" method='POST'>
		<table>
			<tr>
				<td style="">Enter UserName:</td>
				<td><input type='text' name='j_username'
					style="width: 300px; height: 40px;" placeholder="username" required /></td>
			</tr>
			<br>
			<br>
			<tr>
				<td style="">Enter Password:</td>
				<td><input type='password' name='j_password'
					style="width: 300px; height: 40px;" placeholder="password" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</div>
<%@include file="footer.jsp"%>