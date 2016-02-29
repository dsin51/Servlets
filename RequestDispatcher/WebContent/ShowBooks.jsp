
<%@ page import="java.util.*,com.training.entity.*"  language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="Styles/Styles.css" />
<title>Insert title here</title>
</head>
<body>



	<%
		Book book=null;
		ArrayList<Book> bookList = (ArrayList<Book>) request.getAttribute("foundBooks");

	%>
	<table align="center" border="2">
		<thead>
			<tr>
				<td>Book Number</td>
				<td>Book Name</td>
				<td>Author</td>
				<td>Price</td>
			</tr>
		</thead>
	
		<tbody>
			<%
			for(Iterator<Book> itr = bookList.iterator();itr.hasNext();)
			{
				book = (Book)itr.next();
			%>
			<tr>
				<td>
					<%=book.getBookNumber() %>
				</td>
				<td>
					<%=book.getBookName() %>
				</td>
				<td>
					<%=book.getAuthor() %>
				</td>
				<td>
					<%=book.getPrice() %>
				</td>
			</tr>
		
			<%
			}
			%>
		</tbody>
	
	</table>
	
	
	
	
	
	
	<%--
		for(Iterator<Book> itr = bookList.iterator();itr.hasNext();)
		{
			book = (Book)itr.next();
			out.println(book.toString());
			out.println("<br>");
		}
	--%>

</body>
</html>