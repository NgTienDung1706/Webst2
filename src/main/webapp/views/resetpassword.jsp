<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt Lại Mật Khẩu</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/resetpassword.css">
<style type="text/css">
/* Reset CSS cho các form */
form {
	border: 3px solid #f1f1f1;
	padding: 20px;
	border-radius: 5px;
	max-width: 500px;
	margin: auto;
	background-color: #f9f9f9;
}

/* Full-width inputs */
input[type=text], input[type=password], input[type=email] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Style for buttons */
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	border-radius: 5px;
}

/* Hover effect for buttons */
button:hover {
	opacity: 0.8;
}

/* Extra style for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
	width: 40%;
	border-radius: 50%;
}

/* Add padding to containers */
.container {
	padding: 16px;
}

/* The "Forgot password" text */
span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

/* Alert message styling */
.alert {
	color: red;
	font-size: 1.2em;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/resetpassword"
		method="post">
		<h2>Đặt Lại Mật Khẩu</h2>

		<c:if test="${not empty alert}">
			<h3 class="alert">${alert}</h3>
		</c:if>

		<!-- Trường mật khẩu mới -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" placeholder="Mật khẩu mới" name="newpassword"
						class="form-control" required>
				</div>
			</label>
		</section>

		<!-- Trường xác nhận mật khẩu -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" placeholder="Xác nhận mật khẩu mới"
						name="confirmpassword" class="form-control" required>
				</div>
			</label>
		</section>

		<button type="submit" class="btn btn-primary">Đặt lại mật
			khẩu</button>
	</form>
</body>
</html>
