<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>procs</title>
</head>
<body>
	<center>
		<h1>Gestion Contact</h1>
		<h2>

			<form method="post" action="show-contact">
				<a href="./ListContact.jsp">
					<button type="submit">List All Contacts</button>
				</a>
			</form>

		</h2>
	</center>
	<div align="center">
		<c:if test="${contact != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${contact == null}">
			<form action="addContact" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${contact != null}">
               Edit Contact
              </c:if>
					<c:if test="${contact == null}">
               Add New Contact
              </c:if>
				</h2>
			</caption>
			<c:if test="${contact != null}">
				<input type="hidden" id="id" name="id"
					value="" />
			</c:if>
			<tr>
				<th>LastName :</th>
				<td><input type="text" id="lastname" name="LASTNAME" size="45"
					value="" /></td>
			</tr>
			<tr>
				<th>FirstName :</th>
				<td><input type="text" id="firstname" name="FIRSTNAME"
					size="45" value="" /></td>
			</tr>
			<tr>
				<th>Email :</th>
				<td><input type="text" id="email" name="EMAIL" size="15"
					value="" /></td>
			</tr>
			<tr>
				<th>Country :</th>
				<td><input type="text" id="country" name="COUNTRY" size="15"
					value="" /></td>
			</tr>
			<tr>
				<th>City :</th>
				<td><input type="text" id="city" name="CITY" size="15"
					value="" /></td>
			</tr>
			<tr>
				<th>Street :</th>
				<td><input type="text" id="street" name="STREET" size="15"
					value="" /></td>
			</tr>
			<tr>
				<th>Zip :</th>
				<td><input type="text" id="zip" name="ZIP" size="15"
					value="" /></td>
			</tr>
			<tr>
				<th>PhoneKind :</th>
				<td><input type="text" id="zip" name="PHONEKIND" size="15"
					value="<c:out value='${contact.phonekind}' />" /></td>
			</tr>
			<tr>
				<th>PhoneNumber :</th>
				<td><input type="text" id="zip" name="PHONENUMBER" size="15"
					value="" /></td>
			</tr>
			<tr>
				<th>Groupe :</th>
				<td><input type="text" id="groupname" name="GROUPNAME"
					size="15" value="" /></td>
			</tr>
			
			<tr>
				<th>numSiret : </th>
				<td><input type="text" id="numSiret" name="NUMSIRET"
					size="15" value="" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>