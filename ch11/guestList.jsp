<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<title>방명록 목록</title>
</head>
<body>
<div class="container w-75 mt-5 mx-auto">

<hr>
<ul class="list-group">
<c:forEach var="guest" items="$(guestlist)" varStatus="status">
<li class="list-group-item-action d-flex justify-content-between align-items-center">

</li>
</c:forEach>
</ul>
<hr>
<c:if test="${error != null }">
<div class="alert alert-danger alert-dismissible fade show mt-3">
에러발생: ${error }
<button type = "button" class="btn-close" data-bs-dismiss="alert"></button>
</div>
</c:if>
<button class="btn btn-outline-info mb-3" type="button" data-bs-toggle="collapse" data-bs-target ="#addForm" aria-expanded="false" aria-controls="addForm">방명록 등록</button>
<div class="collapse" id="addForm">
<div class="card card-body">
<form method = "post" action="/jwbook/news.nhn?action=addNews" enctype="multipart/form-data">
<label class = "form-label">작성자label>
<input type="text" name="username" class = "form-control">
<label class = "form-label">이메일label>
<input type="text" name="email" class = "form-control">
<label class = "form-label">제목label>
<input type="text" name="title" class = "form-control">
<button type="submit" class="btn btn-success mt-3">등록</button>
</form>
</div>
</div>

</body>
</html>
