<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<meta charset="UTF-8">
<title>방명록 목록</title>
</head>
<body>
<div class ="container w-75 mt-5 mx-auto">
<h2>${news.title }</h2>
<hr>
<div class="card w-75 mx-auto">
<div class="card-body">
<h4 class="card-title">Date: ${guest.date }</h4>
<p class="card-text">Title: ${guest.title }</p>
</div>
</div>
<hr>
<a href="javascript:history.back()" class="btn btn-primary"> << Back </a>
</div>

</body>
</html>
