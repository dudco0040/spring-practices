<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
	<div id="container">
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="${pageContext.request.contextPath}/user?a=login">
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="${email }">
					<label class="block-label" >패스워드</label>
					<input name="password" type="password" value="">
						<p>
							로그인이 실패 했습니다.
						</p>
					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
	</div>
</body>
</html>