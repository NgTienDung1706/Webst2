<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên Mật Khẩu</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<style type="text/css">
form {
	border: 3px solid #f1f1f1;
	border-radius: 5px;
	max-width: 500px;
	margin: auto;
	padding: 16px;
	background-color: #fff;
}

input[type=text], input[type=password], input[type=email] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	border-radius: 5px;
	font-size: 16px;
}

button:hover {
	opacity: 0.8;
}

.alert {
	color: red;
	font-weight: bold;
	margin-bottom: 15px;
}

.input-group {
	display: flex;
	align-items: center;
}

.input-group-addon {
	background: #ccc;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	margin-right: 5px;
}

.form-control {
	border: 1px solid #ccc;
	border-radius: 4px;
	padding: 10px;
	font-size: 16px;
}

.container {
	padding: 16px;
}

section {
	margin-bottom: 15px;
}

@media screen and (max-width: 300px) {
	button {
		width: 100%;
	}
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/forgotpassword"
		method="post">
		<h2>Quên Mật Khẩu</h2>

		<c:if test="${not empty alert}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<!-- Trường email -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
					<input type="email" placeholder="Nhập email của bạn" name="email"
						class="form-control" required>
				</div>
			</label>
		</section>

		<button type="submit" class="btn btn-primary">Gửi</button>
	</form>
</body>
</html>