<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<!-- Link Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
	<section style="margin: 10px 50px">
		<h3>Book List</h3>
		<a href="bookCreate" class="btn btn-primary">Create Book</a>
		<p>${errorString}</p>
		<table class="table table-bordered table-striped border-dark">
			<thead class="bg-success">
				<tr>
					<th>BookId</th>
					<th>Title</th>
					<th>Author</th>
					<th>Release</th>
					<th>Price</th>
					<th>Actions</th>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.getBookId()}</td>
						<td>${book.getTitle()}</td>
						<td>${book.getAuthor()}</td>
						<td>${book.getRelease()}</td>
						<td>${book.getPrice()}</td>
						<td>
							<a class="btn btn-primary" href="bookEdit?BookId=${book.bookId}"><i class="fa-solid fa-pen-to-square"></i></a>
							<a class="btn btn-danger" href="bookDelete?BookId=${book.bookId}"><i class="fa-solid fa-trash"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</section>
</body>
</html>
