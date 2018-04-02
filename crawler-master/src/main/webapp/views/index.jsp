<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.css"
	rel="stylesheet">
<link href="/css/app.css" rel="stylesheet"></link>
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet">


</head>
<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					<form action="/login" method="post" class="form-horizontal">
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username"></label> <input
								type="text" class="form-control" id="username" name="ssoId"
								placeholder="用户名" required>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password"></label> <input
								type="password" class="form-control" id="password"
								name="password" placeholder="密码" required>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-actions">
							<input type="submit"
								class="btn btn-block btn-primary btn-default" value="Log in">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>