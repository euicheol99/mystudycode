<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="outer">
			<br>
			<h1 align="center">마이페이지</h1>
			<br>
                                                               
			<form action="" method="post">
				<table align="center">
					<tr>
						<td>* ID</td>
						<td><input type="text" name="userId" required value="흐에"></td>
					</tr>
					<tr>
						<td>* PWD</td>
						<td><input type="password" name="userPwd" required value="${loginUser.userPwd}"></td>
					</tr>
					<tr>
						<td>* NAME</td>
						<td><input type="text" name="userName" required value="${loginUser.userName}"></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;EMAIL</td>
						<td><input type="email" name="email" value = "${loginUser.email }"></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;BIRTHDAY</td>
						<td><input type="text" name="birthday" placeholder="생년월일(6자리)" value="${loginUser.birthday}"></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;GENDER</td>
						<td>
							${loginUser.gender}
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;PHONE</td>
						<td><input type="text" name="phone" placeholder="-포함" value="${loginUser.phone}"></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;ADDRESS</td>
						<td><input type="text" name="address" value = "${loginUser.address }"></td>
					</tr>
				</table>

				<br>
			</form>
			<div align="center">
					<button type="button" onclick="window.location.href='https://localhost:8888/my/update.me';">수정하기</button>
					<button type="submit">삭제하기</button>
			</div>
		</div>
</body>
</html>